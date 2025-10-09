/*
 * ***** BEGIN LICENSE BLOCK *****
 * Z-Push port to Java
 * Copyright (C) 2025 BTACTIC, S.C.C.L.
 *
 * Z-Push - WBXMLDecoder (01.10.2007)
 * Copyright 2007 - 2016 Zarafa Deutschland GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Consult AGPL-3.0.txt file for details
 * ***** END LICENSE BLOCK *****
 */
package com.btactic.activesync.zpush.lib.wbxml;

import com.btactic.activesync.zpush.lib.core.ZLog;
import com.btactic.activesync.zpush.lib.exceptions.WBXMLException;
import com.btactic.activesync.zpush.lib.exceptions.HTTPReturnCodeException;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * WBXMLDecoder handles decoding of ActiveSync WBXML streams
 */
public class WBXMLDecoder extends WBXMLDefs {

    private InputStream in;
    private boolean logEnabled;
    private int tagcp = 0;
    private Map<String, Object> ungetBuffer = null;
    private Deque<String> logStack = new ArrayDeque<>();
    private StringBuilder inputBuffer = new StringBuilder();
    private boolean isWBXML = true;

    private static final int MAXLOOP = 5000;
    private static final int VERSION = 0x03;

    private static final Map<String, Integer> loopCounter = new HashMap<>();

    /**
     * Counts the amount of times a code part has been executed.
     */
    public static boolean inWhile(String name) throws WBXMLException {
        if (!loopCounter.containsKey(name)) {
            loopCounter.put(name, 0);
        } else {
            loopCounter.put(name, loopCounter.get(name) + 1);
        }

        if (loopCounter.get(name) > MAXLOOP) {
            throw new WBXMLException("Loop count in while too high, code '" + name + "' exceeded max permitted loops");
        }
        return true;
    }

    /**
     * Resets the inWhile counter.
     */
    public static boolean resetInWhile(String name) {
        loopCounter.remove(name);
        return true;
    }

    /**
     * WBXML Decode Constructor
     */
    public WBXMLDecoder(InputStream input) throws IOException, WBXMLException {
        this.logEnabled = ZLog.isWbxmlDebugEnabled();
        this.in = input;

        int version = getByte();
        if (version != VERSION) {
            inputBuffer.append((char) version);
            isWBXML = false;
            return;
        }

        int publicId = getMBUInt();
        if (publicId != 1)
            throw new WBXMLException("Wrong publicid: " + publicId);

        int charsetId = getMBUInt();
        if (charsetId != 106)
            throw new WBXMLException("Wrong charset: " + charsetId);

        int stringTableSize = getMBUInt();
        if (stringTableSize != 0)
            throw new WBXMLException("Wrong string table size: " + stringTableSize);
    }

    /**
     * Returns either start, content or end, and auto-concatenates successive content
     */
    public Map<String, Object> getElement() throws IOException, WBXMLException {
        Map<String, Object> element = getToken();
        if (element == null) return null;

        Integer type = (Integer) element.get(EN_TYPE);
        if (type == null) return null;

        switch (type) {
            case EN_TYPE_STARTTAG:
            case EN_TYPE_ENDTAG:
                return element;
            case EN_TYPE_CONTENT:
                resetInWhile("decoderGetElement");
                while (inWhile("decoderGetElement")) {
                    Map<String, Object> next = getToken();
                    if (next == null) return null;
                    Integer nextType = (Integer) next.get(EN_TYPE);
                    if (nextType != null && nextType == EN_TYPE_CONTENT) {
                        element.put(EN_CONTENT,
                                ((String) element.get(EN_CONTENT)) + ((String) next.get(EN_CONTENT)));
                    } else {
                        ungetElement(next);
                        break;
                    }
                }
                return element;
            default:
                return null;
        }
    }

    /**
     * Peek at next element without consuming it
     */
    public Map<String, Object> peek() throws IOException, WBXMLException {
        Map<String, Object> element = getElement();
        ungetElement(element);
        return element;
    }

    /**
     * Get the element of a StartTag
     */
    public Map<String, Object> getElementStartTag(String tag) throws IOException, WBXMLException {
        Map<String, Object> element = getToken();
        if (element == null) return null;

        if (EN_TYPE_STARTTAG == (Integer) element.get(EN_TYPE) &&
                tag.equals(element.get(EN_TAG))) {
            return element;
        } else {
            ZLog.write(LOGLEVEL_WBXMLSTACK, String.format(
                    "WBXMLDecoder->getElementStartTag(): unmatched WBXML tag: '%s' matching '%s' type '%s' flags '%s'",
                    tag, element.get(EN_TAG), element.get(EN_TYPE), element.get(EN_FLAGS)));
            ungetElement(element);
        }
        return null;
    }

    /**
     * Get the element of an EndTag
     */
    public Map<String, Object> getElementEndTag() throws IOException, WBXMLException {
        Map<String, Object> element = getToken();
        if (element == null) return null;

        if (EN_TYPE_ENDTAG == (Integer) element.get(EN_TYPE)) {
            return element;
        } else {
            ZLog.write(LOGLEVEL_WBXMLSTACK, String.format(
                    "WBXMLDecoder->getElementEndTag(): unmatched WBXML tag: '%s' type '%s' flags '%s'",
                    element.get(EN_TAG), element.get(EN_TYPE), element.get(EN_FLAGS)));
            ungetElement(element);

            // read remaining elements to clear stream
            while (getElement() != null);
        }
        return null;
    }

    /**
     * Get the content of an element
     */
    public String getElementContent() throws IOException, WBXMLException {
        Map<String, Object> element = getToken();
        if (EN_TYPE_CONTENT == (Integer) element.get(EN_TYPE)) {
            return (String) element.get(EN_CONTENT);
        } else {
            ZLog.write(LOGLEVEL_WBXMLSTACK, String.format(
                    "WBXMLDecoder->getElementContent(): unmatched WBXML content: '%s' type '%s' flags '%s'",
                    element.get(EN_TAG), element.get(EN_TYPE), element.get(EN_FLAGS)));
            ungetElement(element);
        }
        return null;
    }

    /**
     * 'Ungets' an element
     */
    public void ungetElement(Map<String, Object> element) {
        if (ungetBuffer != null) {
            ZLog.write(LOGLEVEL_ERROR, String.format(
                    "WBXMLDecoder->ungetElement(): WBXML double unget on tag: '%s' type '%s' flags '%s'",
                    element.get(EN_TAG), element.get(EN_TYPE), element.get(EN_FLAGS)));
        }
        ungetBuffer = element;
    }

    /**
     * Returns the plain input stream
     */
    public String getPlainInputStream() throws IOException {
        StringBuilder sb = new StringBuilder(inputBuffer);
        int b;
        while ((b = in.read()) != -1) {
            sb.append((char) b);
        }
        return sb.toString();
    }

    /**
     * Returns if the input is WBXML
     */
    public boolean isWBXML() {
        return isWBXML;
    }

    /**
     * Reads the remaining data from the input stream
     */
    public void readRemainingData() throws IOException, WBXMLException {
        ZLog.write(LOGLEVEL_DEBUG, "WBXMLDecoder->readRemainingData() reading remaining data from input stream");
        while (getElement() != null);
    }

    /**
     * Returns the next token
     */
    private Map<String, Object> getToken() throws IOException, WBXMLException {
        if (ungetBuffer != null) {
            Map<String, Object> element = ungetBuffer;
            ungetBuffer = null;
            return element;
        }

        Map<String, Object> el = _getToken();
        if (logEnabled && el != null) logToken(el);
        return el;
    }

    /**
    * Log a token
    */
    private void logToken(Map<String, Object> el) {
        int logStackSize = logStack.size();
        String spaces = " ".repeat(logStackSize);

        switch ((Integer) el.get(EN_TYPE)) {
            case EN_TYPE_STARTTAG:
                if (((Integer) el.get(EN_FLAGS) & EN_FLAGS_CONTENT) != 0) {
                    ZLog.write(LOGLEVEL_WBXML, "I " + spaces + " <" + el.get(EN_TAG) + ">");
                    logStack.push((String) el.get(EN_TAG));
                } else {
                    ZLog.write(LOGLEVEL_WBXML, "I " + spaces + " <" + el.get(EN_TAG) + "/>");
                }
                break;

            case EN_TYPE_ENDTAG:
                String tag = logStack.pop();
                ZLog.write(LOGLEVEL_WBXML, "I " + spaces + " </" + tag + ">");
                break;

            case EN_TYPE_CONTENT:
                // as we concatenate the string here, the entire content is copied.
                // when sending an email with an attachment this single log line (which is never logged in INFO)
                // requires easily additional 20 MB of RAM. See https://jira.z-hub.io/browse/ZP-1159
                String content = (String) el.get(EN_CONTENT);
                int messageSize = content.length();
                if (messageSize > 10240) {
                    content = content.substring(0, 10240) + " <log message with " + messageSize + " bytes truncated>";
                }
                // Log but make sure it's not truncated again (will be slightly bigger than 10KB)
                ZLog.write(LOGLEVEL_WBXML, "I " + spaces + " " + content, false);
                break;
        }
    }

    /**
    * Private _getToken logic
    */
    private Map<String, Object> _getToken() throws IOException, WBXMLException {
        Map<String, Object> element = new HashMap<>();
        resetInWhile("decoderGetToken");

        while (inWhile("decoderGetToken")) {
            int b = getByte();
            if (b == -1) break;

            switch (b) {
                case WBXML_SWITCH_PAGE:
                    tagcp = getByte();
                    break;

                case WBXML_END:
                    element.put(EN_TYPE, EN_TYPE_ENDTAG);
                    return element;

                case WBXML_STR_I:
                    element.put(EN_TYPE, EN_TYPE_CONTENT);
                    element.put(EN_CONTENT, getTermStr());
                    return element;

                case WBXML_OPAQUE:
                    int len = getMBUInt();
                    element.put(EN_TYPE, EN_TYPE_CONTENT);
                    element.put(EN_CONTENT, getOpaque(len));
                    return element;

                // All invalid or unsupported WBXML tokens
                case WBXML_ENTITY:
                case WBXML_LITERAL:
                case WBXML_EXT_I_0:
                case WBXML_EXT_I_1:
                case WBXML_EXT_I_2:
                case WBXML_PI:
                case WBXML_LITERAL_C:
                case WBXML_EXT_T_0:
                case WBXML_EXT_T_1:
                case WBXML_EXT_T_2:
                case WBXML_STR_T:
                case WBXML_LITERAL_A:
                case WBXML_EXT_0:
                case WBXML_EXT_1:
                case WBXML_EXT_2:
                case WBXML_LITERAL_AC:
                    throw new WBXMLException("Invalid token: " + b);

                default:
                    // Check for attributes in the byte
                    if ((b & WBXML_WITH_ATTRIBUTES) != 0) {
                        throw new WBXMLException("Attributes are not allowed: " + b);
                    }
                    // Otherwise, it is a start tag
                    element.put(EN_TYPE, EN_TYPE_STARTTAG);
                    element.put(EN_TAG, getMapping(tagcp, b & 0x3F));
                    element.put(EN_FLAGS, (b & WBXML_WITH_CONTENT) != 0 ? EN_FLAGS_CONTENT : 0);
                    return element;
            }
        }

        return null;
    }

    /**
    * Reads from the InputStream until the terminator or end-of-stream.
    * Equivalent to PHP's stream_get_line with a huge length.
    */
    private String readUntil(InputStream in, byte terminator) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b;
        while ((b = in.read()) != -1 && b != (terminator & 0xFF)) {
            baos.write(b);
        }
        return baos.toString(StandardCharsets.UTF_8);
    }

    /**
    * Reads from the stream until getting a string terminator.
    * Handles WBXML_DEBUGGING mode like in PHP.
    */
    private String getTermStr() throws IOException {
        // If debugging mode is defined, read byte by byte manually
        if (WBXML_DEBUGGING) {
            StringBuilder sb = new StringBuilder();
            int ch;
            while (true) {
                ch = getByte();
                if (ch == -1 || ch == 0) {
                    break;
                }
                sb.append((char) ch);
            }
            return sb.toString();
        }

        // Normal mode: read until null terminator
        return readUntil(in, (byte) 0);
    }

    private String getOpaque(int len) throws IOException {
        byte[] buf = new byte[len];
        int totalRead = 0;

        while (totalRead < len) {
            int read = in.read(buf, totalRead, len - totalRead);
            if (read == -1) {
                throw new HTTPReturnCodeException(
                    "WBXMLDecoder->getOpaque(): stream ended unexpectedly after " + totalRead + " bytes, expected " + len,
                    HTTP_CODE_500, null, LOGLEVEL_WARN);
            }
            totalRead += read;
        }

        return new String(buf, StandardCharsets.UTF_8);
    }

    private int getByte() throws IOException {
        int b = in.read(); // reads a single byte, returns -1 if EOF
        if (b == -1) {
            // Equivalent to PHP returning null on EOF
            return -1;
        }
        return b & 0xFF; // ensure unsigned byte value (0-255)
    }

    private int getMBUInt() throws IOException, WBXMLException {
        int result = 0;

        while (true) {
            int b = getByte();
            if (b == -1) {
                throw new WBXMLException("Unexpected EOF while reading multi-byte integer");
            }

            // Combine current byte (lower 7 bits) with previous result
            result = (result << 7) | (b & 0x7F);

            // If high bit is 0, this is the last byte
            if ((b & 0x80) == 0) {
                break;
            }
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    private String getMapping(int cp, int id) {
        // Check if codes for this codepage exist
        Map<Integer, String> codes = null;
        if (dtd.containsKey("codes")) {
            codes = (Map<Integer, String>) dtd.get("codes"); // top-level map: codepage -> id -> name
        }

        if (codes == null || !codes.containsKey(cp) || !((Map<Integer, String>) codes.get(cp)).containsKey(id)) {
            return null; // equivalent to PHP 'return false'
        } else {
            // check if namespace exists for this codepage
            Map<Integer, String> namespaces = null;
            if (dtd.containsKey("namespaces")) {
                namespaces = (Map<Integer, String>) dtd.get("namespaces");
            }

            String name = ((Map<Integer, String>) codes.get(cp)).get(id);

            if (namespaces != null && namespaces.containsKey(cp)) {
                return namespaces.get(cp) + ":" + name;
            } else {
                return name;
            }
        }
    }

}
