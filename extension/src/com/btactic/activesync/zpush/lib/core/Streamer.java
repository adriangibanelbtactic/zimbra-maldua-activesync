/*
 * ***** BEGIN LICENSE BLOCK *****
 * Z-Push port to Java
 * Copyright (C) 2025 BTACTIC, S.C.C.L.
 *
 * Z-Push - Streamer (01.10.2007)
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
package com.btactic.activesync.zpush.lib.core;

import java.io.Serializable;
import java.util.*;

public class Streamer implements Serializable {

    public static final int STREAMER_VAR = 1;
    public static final int STREAMER_ARRAY = 2;
    public static final int STREAMER_TYPE = 3;
    public static final int STREAMER_PROP = 4;
    public static final int STREAMER_RONOTIFY = 5;
    public static final int STREAMER_VALUEMAP = 20;
    public static final int STREAMER_TYPE_DATE = 1;
    public static final int STREAMER_TYPE_HEX = 2;
    public static final int STREAMER_TYPE_DATE_DASHES = 3;
    public static final int STREAMER_TYPE_STREAM = 4; // deprecated
    public static final int STREAMER_TYPE_IGNORE = 5;
    public static final int STREAMER_TYPE_SEND_EMPTY = 6;
    public static final int STREAMER_TYPE_NO_CONTAINER = 7;
    public static final int STREAMER_TYPE_COMMA_SEPARATED = 8;
    public static final int STREAMER_TYPE_SEMICOLON_SEPARATED = 9;
    public static final int STREAMER_TYPE_MULTIPART = 10;
    public static final int STREAMER_TYPE_STREAM_ASBASE64 = 11;
    public static final int STREAMER_TYPE_STREAM_ASPLAIN = 12;
    public static final int STREAMER_PRIVATE = 13;
    public static final int STRIP_PRIVATE_DATA = 1;
    public static final String STRIP_PRIVATE_SUBSTITUTE = "Private";

    protected Map<String, Map<Integer, Object>> mapping;
    public boolean flags;
    public Object content;

    // Dynamic properties like $this->{$var}
    protected Map<String, Object> properties = new HashMap<>();

    /**
     * Constructor
     *
     * @param mapping internal mapping of variables
     */
    public Streamer(Map<String, Map<Integer, Object>> mapping) {
        this.mapping = mapping;
        this.flags = false;
    }

    /**
     * Return the streamer mapping for this object
     */
    public Map<String, Map<Integer, Object>> GetMapping() {
        return this.mapping;
    }

    /**
     * Decodes the WBXML from a WBXMLdecoder until we reach the same depth level of WBXML.
     * This means that if there are multiple objects at this level, then only the first is
     * decoded. SubObjects are auto-instantiated and decoded using the same functionality
     */
    public boolean Decode(WBXMLDecoder decoder) {
        WBXMLDecoder.ResetInWhile("decodeMain");

        while (WBXMLDecoder.InWhile("decodeMain")) {
            Map<String, Object> entity = decoder.getElement();
            int type = (int) entity.get("EN_TYPE");

            if (type == WBXMLDecoder.EN_TYPE_STARTTAG) {
                if (!decoder.hasContent(entity)) {
                    Map<Integer, Object> map = mapping.get(entity.get("EN_TAG"));
                    if (map.containsKey(STREAMER_ARRAY))
                        properties.put((String) map.get(STREAMER_VAR), new ArrayList<>());
                    else if (map.containsKey(STREAMER_PROP) && (int) map.get(STREAMER_PROP) == STREAMER_TYPE_SEND_EMPTY)
                        properties.put((String) map.get(STREAMER_VAR), "1");
                    else
                        properties.put((String) map.get(STREAMER_VAR), "");

                    continue;
                }

                if (!mapping.containsKey(entity.get("EN_TAG"))) {
                    ZLog.Write(ZLog.LOGLEVEL_WBXMLSTACK,
                            String.format("Tag '%s' unexpected in type XML type '%s'", entity.get("EN_TAG"), this.getClass().getSimpleName()));
                    return false;
                }

                Map<Integer, Object> map = mapping.get(entity.get("EN_TAG"));

                // Handle arrays
                if (map.containsKey(STREAMER_ARRAY)) {
                    WBXMLDecoder.ResetInWhile("decodeArray");

                    while (WBXMLDecoder.InWhile("decodeArray")) {
                        Object decoded;
                        Object streamertype = null;

                        if (!(map.containsKey(STREAMER_PROP) && (int) map.get(STREAMER_PROP) == STREAMER_TYPE_NO_CONTAINER)) {
                            Map<String, Object> encapTagsTypes;
                            if (map.get(STREAMER_ARRAY) instanceof Map)
                                encapTagsTypes = (Map<String, Object>) map.get(STREAMER_ARRAY);
                            else
                                encapTagsTypes = Map.of((String) map.get(STREAMER_ARRAY),
                                        map.containsKey(STREAMER_TYPE) ? map.get(STREAMER_TYPE) : null);

                            for (Map.Entry<String, Object> e : encapTagsTypes.entrySet()) {
                                if (decoder.getElementStartTag(e.getKey())) {
                                    streamertype = e.getValue();
                                }
                            }

                            if (streamertype == null) break;
                        }

                        if (streamertype != null) {
                            try {
                                Streamer s = ((Class<? extends Streamer>) streamertype).getDeclaredConstructor().newInstance();
                                s.Decode(decoder);
                                decoded = s;
                            } catch (Exception ex) {
                                throw new RuntimeException("Failed to instantiate Streamer type", ex);
                            }
                        } else {
                            decoded = decoder.getElementContent();
                        }

                        String varName = (String) map.get(STREAMER_VAR);
                        properties.computeIfAbsent(varName, k -> new ArrayList<>());
                        ((List<Object>) properties.get(varName)).add(decoded);

                        if (!decoder.getElementEndTag()) return false;

                        if (map.containsKey(STREAMER_PROP) && (int) map.get(STREAMER_PROP) == STREAMER_TYPE_NO_CONTAINER) {
                            Map<String, Object> e = decoder.peek();
                            if (e.get("EN_TYPE").equals(WBXMLDecoder.EN_TYPE_STARTTAG)) continue;
                            if (e.get("EN_TYPE").equals(WBXMLDecoder.EN_TYPE_ENDTAG) || e.isEmpty()) break;
                        }
                    }

                    if (!(map.containsKey(STREAMER_PROP) && (int) map.get(STREAMER_PROP) == STREAMER_TYPE_NO_CONTAINER)) {
                        if (!decoder.getElementEndTag()) return false;
                    }
                }
                // Handle single values
                else {
                    Object decoded = decoder.getElementContent();
                    properties.put((String) map.get(STREAMER_VAR), decoded);
                    if (!decoder.getElementEndTag()) return false;
                }

            } else if (type == WBXMLDecoder.EN_TYPE_ENDTAG) {
                decoder.ungetElement(entity);
                break;
            } else {
                ZLog.Write(ZLog.LOGLEVEL_WBXMLSTACK, "Unexpected content in type");
                break;
            }
        }

        return true;
    }

    /**
     * Encodes this object and any subobjects - output is ordered according to mapping
     */
    public boolean Encode(WBXMLEncoder encoder) {
        boolean streamed = false;

        for (Map.Entry<String, Map<Integer, Object>> entry : mapping.entrySet()) {
            String tag = entry.getKey();
            Map<Integer, Object> map = entry.getValue();

            if (!properties.containsKey(map.get(STREAMER_VAR))) continue;

            Object value = properties.get(map.get(STREAMER_VAR));

            if (value instanceof Streamer) {
                encoder.startTag(tag);
                boolean res = ((Streamer) value).Encode(encoder);
                encoder.endTag();
                if (!res && map.containsKey(STREAMER_PROP) && (int) map.get(STREAMER_PROP) == STREAMER_TYPE_SEND_EMPTY)
                    encoder.startTag(tag, false, true);
            } else if (map.containsKey(STREAMER_ARRAY) && value instanceof List) {
                List<Object> list = (List<Object>) value;
                if (list.isEmpty() && map.containsKey(STREAMER_PROP) && (int) map.get(STREAMER_PROP) == STREAMER_TYPE_SEND_EMPTY)
                    encoder.startTag(tag, false, true);
                else {
                    if (!map.containsKey(STREAMER_PROP) || (int) map.get(STREAMER_PROP) != STREAMER_TYPE_NO_CONTAINER)
                        encoder.startTag(tag);

                    for (Object element : list) {
                        if (element instanceof Streamer) {
                            String eltag = map.get(STREAMER_ARRAY) instanceof String ? (String) map.get(STREAMER_ARRAY)
                                    : element.getClass().getSimpleName();
                            encoder.startTag(eltag);
                            ((Streamer) element).Encode(encoder);
                            encoder.endTag();
                        } else if (element instanceof String && !((String) element).isEmpty()) {
                            encoder.startTag((String) map.get(STREAMER_ARRAY));
                            encoder.content((String) element);
                            encoder.endTag();
                            streamed = true;
                        }
                    }

                    if (!map.containsKey(STREAMER_PROP) || (int) map.get(STREAMER_PROP) != STREAMER_TYPE_NO_CONTAINER)
                        encoder.endTag();
                }
            } else {
                encoder.startTag(tag);
                encoder.content(value.toString());
                encoder.endTag();
                streamed = true;
            }
        }

        if (content != null) encoder.content(content);
        return streamed;
    }

    /**
     * Removes not necessary data from the object
     */
    public boolean StripData(int flags) {
        for (Map<Integer, Object> v : mapping.values()) {
            String varName = (String) v.get(STREAMER_VAR);
            if (!properties.containsKey(varName)) continue;

            Object value = properties.get(varName);

            if (value instanceof Streamer) {
                ((Streamer) value).StripData(flags);
            } else if (v.containsKey(STREAMER_ARRAY) && value instanceof List) {
                List<Object> list = (List<Object>) value;
                for (Object element : list) {
                    if (element instanceof Streamer) ((Streamer) element).StripData(flags);
                    else if (flags == STRIP_PRIVATE_DATA && v.containsKey(STREAMER_PRIVATE)) {
                        properties.put(varName, v.get(STREAMER_PRIVATE));
                    }
                }
            } else if (flags == STRIP_PRIVATE_DATA && v.containsKey(STREAMER_PRIVATE)) {
                properties.put(varName, v.get(STREAMER_PRIVATE));
            }
        }

        if (flags == 0) mapping = null;
        return true;
    }

    /**
     * Method to serialize a Streamer and respective SyncObject
     */
    public String serialize() {
        Map<String, String> values = new HashMap<>();
        for (Map<Integer, Object> v : mapping.values()) {
            String varName = (String) v.get(STREAMER_VAR);
            if (properties.containsKey(varName)) {
                values.put(varName, java.util.Base64.getEncoder().encodeToString(Utils.serializeObject(properties.get(varName))));
            }
        }
        return Utils.serializeObject(values);
    }

    /**
     * Method to unserialize a Streamer and respective SyncObject
     */
    public boolean unserialize(String data) {
        Map<String, String> values = (Map<String, String>) Utils.unserializeObject(data);
        properties.clear();
        for (Map.Entry<String, String> e : values.entrySet()) {
            properties.put(e.getKey(), Utils.unserializeObject(e.getValue()));
        }
        return true;
    }

    /**
     * Returns SyncObject's streamer variable names.
     */
    public List<String> GetStreamerVars() {
        List<String> vars = new ArrayList<>();
        for (Map<Integer, Object> v : mapping.values()) {
            vars.add((String) v.get(STREAMER_VAR));
        }
        return vars;
    }

    /**
     * Formats a timestamp
     * Oh yeah, this is beautiful. Exchange outputs date fields differently in calendar items
     * and emails. We could just always send one or the other, but unfortunately nokia's 'Mail for
     *  exchange' depends on this quirk. So we have to send a different date type depending on where
     * it's used. Sigh.
     */
    private String formatDate(Object ts, int type) {
        if (ts == null || "".equals(ts)) return "";
        if (type == STREAMER_TYPE_DATE) return Utils.FormatDateUtc(ts, "yyyyMMdd'T'HHmmSS'Z'");
        else if (type == STREAMER_TYPE_DATE_DASHES)
            return Utils.FormatDateUtc(ts, "yyyy-MM-dd'T'HH:mm:SS'.000Z'");
        return ts.toString();
    }
}
