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

import java.util.Set;

public class ActiveSyncCommand {
    private final String asVersion;
    private final String requestHandler;
    private final Set<String> flags;

    public ActiveSyncCommand(String asVersion, String requestHandler, String... flags) {
        this.asVersion = asVersion;
        this.requestHandler = requestHandler;
        this.flags = new HashSet<>(Arrays.asList(flags));
    }

    public String getAsVersion() {
        return asVersion;
    }

    public String getRequestHandler() {
        return requestHandler;
    }

    public Set<String> getFlags() {
        return flags;
    }

    public boolean hasFlag(String flag) {
        return flags.contains(flag);
    }
}
