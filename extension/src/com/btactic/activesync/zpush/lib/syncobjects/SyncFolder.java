/*
 * ***** BEGIN LICENSE BLOCK *****
 * Z-Push port to Java
 * Copyright (C) 2025 BTACTIC, S.C.C.L.
 *
 * Z-Push - syncfolder (05.09.2011)
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

import java.util.HashMap;
import java.util.Map;
import com.btactic.activesync.zpush.lib.core.ZPushDefs;

public class SyncFolder extends SyncObject {

    public String serverid;
    public String parentid;
    public String displayname;
    public int type;
    public Object Store;
    public Object NoBackendFolder;
    public Object BackendId;
    public Object Flags;
    public Object TypeReal;

    public SyncFolder() {
        Map<String, Map<String, Object>> mapping = new HashMap<>();

        // Mapping for serverid
        Map<String, Object> serverIdMap = new HashMap<>();
        serverIdMap.put(STREAMER_VAR, "serverid");
        Map<String, Object> serverIdChecks = new HashMap<>();
        serverIdChecks.put(STREAMER_CHECK_REQUIRED, false);
        serverIdMap.put(STREAMER_CHECKS, serverIdChecks);
        mapping.put(ZPushDefs.SYNC_FOLDERHIERARCHY_SERVERENTRYID, serverIdMap);

        // Mapping for parentid
        Map<String, Object> parentIdMap = new HashMap<>();
        parentIdMap.put(STREAMER_VAR, "parentid");
        Map<String, Object> parentIdChecks = new HashMap<>();
        parentIdChecks.put(STREAMER_CHECK_REQUIRED, STREAMER_CHECK_SETZERO);
        parentIdMap.put(STREAMER_CHECKS, parentIdChecks);
        mapping.put(ZPushDefs.SYNC_FOLDERHIERARCHY_PARENTID, parentIdMap);

        // Mapping for displayname
        Map<String, Object> displayNameMap = new HashMap<>();
        displayNameMap.put(STREAMER_VAR, "displayname");
        Map<String, Object> displayNameChecks = new HashMap<>();
        displayNameChecks.put(STREAMER_CHECK_REQUIRED, "Unknown");
        displayNameMap.put(STREAMER_CHECKS, displayNameChecks);
        mapping.put(ZPushDefs.SYNC_FOLDERHIERARCHY_DISPLAYNAME, displayNameMap);

        // Mapping for type
        Map<String, Object> typeMap = new HashMap<>();
        typeMap.put(STREAMER_VAR, "type");
        Map<String, Object> typeChecks = new HashMap<>();
        typeChecks.put(STREAMER_CHECK_REQUIRED, 18);
        typeChecks.put(STREAMER_CHECK_CMPHIGHER, 0);
        typeChecks.put(STREAMER_CHECK_CMPLOWER, 20);
        typeMap.put(STREAMER_CHECKS, typeChecks);
        mapping.put(ZPushDefs.SYNC_FOLDERHIERARCHY_TYPE, typeMap);

        // Mappings for ignored fields (explicit, no helper)
        Map<String, Object> storeMap = new HashMap<>();
        storeMap.put(STREAMER_VAR, "Store");
        storeMap.put(STREAMER_TYPE, STREAMER_TYPE_IGNORE);
        mapping.put(ZPushDefs.SYNC_FOLDERHIERARCHY_IGNORE_STORE, storeMap);

        Map<String, Object> noBackendMap = new HashMap<>();
        noBackendMap.put(STREAMER_VAR, "NoBackendFolder");
        noBackendMap.put(STREAMER_TYPE, STREAMER_TYPE_IGNORE);
        mapping.put(ZPushDefs.SYNC_FOLDERHIERARCHY_IGNORE_NOBCKENDFLD, noBackendMap);

        Map<String, Object> backendIdMap = new HashMap<>();
        backendIdMap.put(STREAMER_VAR, "BackendId");
        backendIdMap.put(STREAMER_TYPE, STREAMER_TYPE_IGNORE);
        mapping.put(ZPushDefs.SYNC_FOLDERHIERARCHY_IGNORE_BACKENDID, backendIdMap);

        Map<String, Object> flagsMap = new HashMap<>();
        flagsMap.put(STREAMER_VAR, "Flags");
        flagsMap.put(STREAMER_TYPE, STREAMER_TYPE_IGNORE);
        mapping.put(ZPushDefs.SYNC_FOLDERHIERARCHY_IGNORE_FLAGS, flagsMap);

        Map<String, Object> typeRealMap = new HashMap<>();
        typeRealMap.put(STREAMER_VAR, "TypeReal");
        typeRealMap.put(STREAMER_TYPE, STREAMER_TYPE_IGNORE);
        mapping.put(ZPushDefs.SYNC_FOLDERHIERARCHY_IGNORE_TYPEREAL, typeRealMap);

        // Call parent constructor
        super(mapping);
    }

    /**
     * Returns a SyncFolder object with the serverid and optional parentid set.
     *
     * @param serverid the server id
     * @param parentid the parent id (optional)
     * @return SyncFolder object
     */
    public static SyncFolder GetObject(String serverid, String parentid) {
        SyncFolder folder = new SyncFolder();
        folder.serverid = serverid;
        folder.parentid = parentid;
        return folder;
    }
}
