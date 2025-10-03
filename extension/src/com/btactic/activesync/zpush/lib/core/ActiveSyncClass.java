/*
 * ***** BEGIN LICENSE BLOCK *****
 * Z-Push port to Java
 * Copyright (C) 2025 BTACTIC, S.C.C.L.
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

import java.util.List;

public class ActiveSyncClass {

    private final String className;
    private final boolean requiresProtocolVersion;
    private final int defaultType;
    private final List<Integer> otherTypes;

    public ActiveSyncClass(String className, boolean requiresProtocolVersion, int defaultType, List<Integer> otherTypes) {
        this.className = className;
        this.requiresProtocolVersion = requiresProtocolVersion;
        this.defaultType = defaultType;
        this.otherTypes = otherTypes;
    }

    public String getClassName() {
        return className;
    }

    public boolean requiresProtocolVersion() {
        return requiresProtocolVersion;
    }

    public int getDefaultType() {
        return defaultType;
    }

    public List<Integer> getOtherTypes() {
        return otherTypes;
    }
}
