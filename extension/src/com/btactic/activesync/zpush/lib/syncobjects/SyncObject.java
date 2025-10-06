/*
 * ***** BEGIN LICENSE BLOCK *****
 * Z-Push port to Java
 * Copyright (C) 2025 BTACTIC, S.C.C.L.
 *
 * Z-Push - syncobjects (01.10.2007)
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
package com.btactic.activesync.zpush.lib.syncobjects;

import java.util.*;
import com.btactic.activesync.zpush.lib.utils.Utils;
import com.btactic.activesync.zpush.lib.core.ZLog;

public abstract class SyncObject extends Streamer {

    public static final int STREAMER_CHECKS = 6;
    public static final int STREAMER_CHECK_REQUIRED = 7;
    public static final int STREAMER_CHECK_ZEROORONE = 8;
    public static final int STREAMER_CHECK_NOTALLOWED = 9;
    public static final int STREAMER_CHECK_ONEVALUEOF = 10;
    public static final String STREAMER_CHECK_SETZERO = "setToValue0";
    public static final String STREAMER_CHECK_SETONE = "setToValue1";
    public static final String STREAMER_CHECK_SETTWO = "setToValue2";
    public static final String STREAMER_CHECK_SETEMPTY = "setToValueEmpty";
    public static final int STREAMER_CHECK_CMPLOWER = 13;
    public static final int STREAMER_CHECK_CMPHIGHER = 14;
    public static final int STREAMER_CHECK_LENGTHMAX = 15;
    public static final int STREAMER_CHECK_EMAIL = 16;

    protected List<String> unsetVars;
    protected boolean supportsPrivateStripping;
    protected int checkedParameters;

    public SyncObject(Map<String, Map<String, Object>> mapping) {
        super(mapping);
        this.unsetVars = new ArrayList<>();
        this.supportsPrivateStripping = false;
        this.checkedParameters = 0;
    }

    public boolean emptySupported(List<String> supportedFields) {
        if (supportedFields == null || supportedFields.isEmpty()) {
            return false; // simplified: ignore special SyncContact/SyncAppointment cases
        }

        for (String field : supportedFields) {
            if (!mapping.containsKey(field)) {
                ZLog.Write(ZLog.LOGLEVEL_WARN, "Field '" + field + "' is supposed to be emptied but is not defined for '" + this.getClass().getSimpleName() + "'");
                continue;
            }
            String var = (String) mapping.get(field).get(STREAMER_VAR);
            if (!properties.containsKey(var))
                unsetVars.add(var);
        }
        ZLog.Write(ZLog.LOGLEVEL_DEBUG, "Supported variables to be unset: " + String.join(",", unsetVars));
        return true;
    }

    /**
    * Compares this SyncObject to another.
    * Returns true if all mapped fields are equal (with optional strict type comparison).
    */
    public boolean equals(SyncObject other, boolean log, boolean strictTypeCompare) {
        if (other == null) return false;

        if (!this.getClass().equals(other.getClass())) {
            ZLog.Write(ZLog.LOGLEVEL_DEBUG, "SyncObject->equals() target object is not same type");
            return false;
        }

        for (Map<String, Object> v : mapping.values()) {
            String var = (String) v.get(STREAMER_VAR);

            Object val1 = properties.get(var);
            Object val2 = other.properties.get(var);

            // Array comparison
            if (v.containsKey(STREAMER_ARRAY)) {
                List<?> list1 = val1 instanceof List ? (List<?>) val1 : null;
                List<?> list2 = val2 instanceof List ? (List<?>) val2 : null;

                if (list1 == null && list2 == null) continue;
                if (list1 == null || list2 == null) return false;
                if (!list1.equals(list2)) return false;
            } else {
                // Regular value comparison
                if (val1 != null && val2 != null) {
                    if (strictTypeCompare) {
                        if (!val1.equals(val2)) return false;
                    } else {
                        if (!val1.toString().equals(val2.toString())) return false;
                    }
                } else if (val1 == null && val2 == null) continue;
                else return false;
            }
        }

        return true;
    }

    /**
    * Compares this SyncObject to another and prints differences.
    * Returns a map where keys are property names and values describe the difference.
    */
    public Map<String, String> EvaluateAndCompare(SyncObject other, List<String> supportedFields, String odoName, String keyPrefix, int recCount) {
        Map<String, String> out = new HashMap<>();

        if (other == null || !this.getClass().equals(other.getClass())) {
            ZLog.Write(ZLog.LOGLEVEL_DEBUG, "SyncObject->EvaluateAndCompare(): target object is null or different type");
            return out;
        }

        if (supportedFields == null) supportedFields = new ArrayList<>();

        if (keyPrefix == null) keyPrefix = "";
        String prefix = keyPrefix + recCount;

        for (Map.Entry<String, Map<String, Object>> entry : mapping.entrySet()) {
            String k = entry.getKey();
            Map<String, Object> v = entry.getValue();
            String var = (String) v.get(STREAMER_VAR);

            Object val1 = properties.get(var);
            Object val2 = other.properties.get(var);

            if ((val1 == null && val2 == null) || (!supportedFields.contains(k))) continue;

            // Sub-object recursion
            if (val1 instanceof SyncObject && val2 instanceof SyncObject) {
                out.putAll(((SyncObject) val1).EvaluateAndCompare((SyncObject) val2, supportedFields, odoName, prefix + "_", recCount + 1));
                continue;
            }

            // Array comparison
            if (v.containsKey(STREAMER_ARRAY)) {
                List<?> list1 = val1 instanceof List ? (List<?>) val1 : null;
                List<?> list2 = val2 instanceof List ? (List<?>) val2 : null;

                if (!Objects.equals(list1, list2)) {
                    out.put(prefix + var, (list1 != null ? list1.toString() : "null") + " - " + odoName + ": " + (list2 != null ? list2.toString() : "null"));
                }
                continue;
            }

            // Value comparison
            String str1 = val1 != null ? val1.toString() : "undefined";
            String str2 = val2 != null ? val2.toString() : "undefined";
            if (!str1.equals(str2)) {
                out.put(prefix + var, str1 + " - " + odoName + ": " + str2);
            }
        }

        return out;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" (\n");

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            String strV = mapping.containsKey(k) ? "(S) " : "";

            if (v instanceof List<?> list) {
                sb.append("\t").append(strV).append(k).append("(Array) size: ").append(list.size()).append("\n");
                for (Object item : list) {
                    sb.append("\t\t").append(Utils.PrintAsString(item)).append("\n");
                }
            } else if (v instanceof SyncObject syncObj) {
                sb.append("\t").append(strV).append(k).append(" => ")
                  .append(syncObj.toString().replace("\n", "\n\t\t\t")).append("\n");
            } else {
                sb.append("\t").append(strV).append(k).append(" => ")
                  .append(v != null ? Utils.PrintAsString(v) : "null").append("\n");
            }
        }

        sb.append(")");
        return sb.toString();
    }

    public List<String> getUnsetVars() {
        return unsetVars;
    }

    /**
    * Removes not necessary data from the object
    *
    * @param flags optional flags (default 0)
    * @return boolean
    */
    public boolean stripData(int flags) {
        if (flags == 0 && unsetVars != null) {
            unsetVars.clear();  // remove all entries
        }
        return super.stripData(flags);
    }

    /**
    * Convenience overload to mimic PHP default parameter
    */
    public boolean stripData() {
        return stripData(0);
    }

    /**
    * Indicates if a SyncObject supports the private flag and stripping of private data.
    * If an object does not support it, it will not be sent to the client but permanently be excluded from the sync.
    *
    * @return boolean - default false defined in constructor - overwritten by implementation
    */
    public boolean supportsPrivateStripping() {
        return this.supportsPrivateStripping;
    }

    /**
    * Indicates the amount of parameters that were set before Checks were executed and potentially set other parameters.
    *
    * @return int - returns -1 if Check() was not executed (since Java doesn't return false/int mixed)
    */
    public int getCheckedParameters() {
        return this.checkedParameters != null ? this.checkedParameters : -1;
    }

    public boolean Check(boolean logAsDebug) {
        int defaultLogLevel = logAsDebug ? ZLog.LOGLEVEL_DEBUG : ZLog.LOGLEVEL_WARN;
        checkedParameters = 0;

        for (Map.Entry<String, Map<String, Object>> entry : mapping.entrySet()) {
            Map<String, Object> fieldMap = entry.getValue();
            String varName = (String) fieldMap.get(STREAMER_VAR);

            // count parameter if set
            if (properties.containsKey(varName)) {
                checkedParameters++;
            }

            if (fieldMap.containsKey(STREAMER_CHECKS)) {
                Map<Integer, Object> checks = (Map<Integer, Object>) fieldMap.get(STREAMER_CHECKS);
                for (Map.Entry<Integer, Object> ruleEntry : checks.entrySet()) {
                    int rule = ruleEntry.getKey();
                    Object condition = ruleEntry.getValue();
                    Object value = properties.get(varName);

                    switch (rule) {
                        case STREAMER_CHECK_REQUIRED:
                            if (value == null || "".equals(value)) {
                                if (condition.equals(STREAMER_CHECK_SETZERO)) value = 0;
                                else if (condition.equals(STREAMER_CHECK_SETONE)) value = 1;
                                else if (condition.equals(STREAMER_CHECK_SETTWO)) value = 2;
                                else if (condition.equals(STREAMER_CHECK_SETEMPTY)) value = "";
                                else if (condition != null && condition != Boolean.FALSE) value = condition;
                                else return false;

                                properties.put(varName, value);
                                ZLog.Write(defaultLogLevel, "SyncObject->Check(): Fixed " + varName + " to " + value);
                            }
                            break;

                        case STREAMER_CHECK_ZEROORONE:
                            if (value != null && !(value.equals(0) || value.equals(1))) {
                                properties.put(varName, condition.equals(STREAMER_CHECK_SETZERO) ? 0 : 1);
                                ZLog.Write(defaultLogLevel, "SyncObject->Check(): Fixed " + varName + " to " + properties.get(varName));
                            }
                            break;

                        case STREAMER_CHECK_CMPHIGHER:
                        case STREAMER_CHECK_CMPLOWER:
                            if (value != null && condition instanceof Integer) {
                                int cmp = (Integer) condition;
                                int val = ((Number) value).intValue();
                                if ((rule == STREAMER_CHECK_CMPHIGHER && val < cmp) || (rule == STREAMER_CHECK_CMPLOWER && val > cmp)) {
                                    ZLog.Write(ZLog.LOGLEVEL_WARN, "Check failed for " + varName);
                                    return false;
                                }
                            }
                            break;

                        case STREAMER_CHECK_LENGTHMAX:
                            if (value != null) {
                                String s = value.toString();
                                if (s.length() > ((Integer) condition)) return false;
                            }
                            break;

                        case STREAMER_CHECK_EMAIL:
                            if (value != null) {
                                List<String> emails = value instanceof List ? (List<String>) value : Collections.singletonList(value.toString());
                                List<String> valid = new ArrayList<>();
                                for (String mail : emails) {
                                    if (Utils.CheckEmail(mail)) valid.add(mail);
                                    else ZLog.Write(ZLog.LOGLEVEL_WARN, "Invalid email: " + mail);
                                }
                                if (value instanceof List) properties.put(varName, valid);
                                else properties.put(varName, valid.isEmpty() ? condition : valid.get(0));
                            }
                            break;
                    }
                }
            }
        }
        return true;
    }

    public Object GetNameFromPropertyValue(Map<String, Object> v, Object val) {
        Map<Object, Object> map = (Map<Object, Object>) v.get(STREAMER_VALUEMAP);
        if (map != null && map.containsKey(val)) return map.get(val);
        return val;
    }

}
