/*
 * ***** BEGIN LICENSE BLOCK *****
 * Z-Push port to Java
 * Copyright (C) 2025 BTACTIC, S.C.C.L.
 *
 * Z-Push - IStateMachine (02.01.2012)
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
package com.btactic.activesync.zpush.lib.interface;

import java.util.List;
import java.util.Map;

public interface IStateMachine {

    // Constants
    String DEFTYPE = "";
    String DEVICEDATA = "devicedata";
    String FOLDERDATA = "fd";
    String FAILSAVE = "fs";
    String HIERARCHY = "hc";
    String BACKENDSTORAGE = "bs";

    String STATEVERSION_01 = "1";    // Z-Push 2.0.x - default value if unset
    String STATEVERSION_02 = "2";    // Z-Push 2.1.0 Milestone 1

    /**
     * Gets a hash value indicating the latest dataset of the named
     * state with a specified key and counter.
     * If the state is changed between two calls of this method
     * the returned hash should be different
     *
     * @param devid    the device id
     * @param type     the state type
     * @param key      (opt)
     * @param counter  (opt)
     * @return String
     * @throws StateNotFoundException
     * @throws StateInvalidException
     * @throws UnavailableException
     */
    String getStateHash(String devid, String type, String key, String counter)
            throws StateNotFoundException, StateInvalidException, UnavailableException;

    /**
     * Gets a state for a specified key and counter.
     * This method should call IStateMachine->CleanStates()
     * to remove older states (same key, previous counters)
     *
     * @param devid        the device id
     * @param type         the state type
     * @param key          (opt)
     * @param counter      (opt)
     * @param cleanstates  (opt)
     * @return Object
     * @throws StateNotFoundException
     * @throws StateInvalidException
     * @throws UnavailableException
     */
    Object getState(String devid, String type, String key, String counter, boolean cleanstates)
            throws StateNotFoundException, StateInvalidException, UnavailableException;

    /**
     * Writes a state for a key and counter
     *
     * @param state    the state object
     * @param devid    the device id
     * @param type     the state type
     * @param key      (opt)
     * @param counter  (opt)
     * @return boolean
     * @throws StateInvalidException
     * @throws UnavailableException
     */
    boolean setState(Object state, String devid, String type, String key, String counter)
            throws StateInvalidException, UnavailableException;

    /**
     * Cleans up all older states.
     * If called with a counter, all states previous state counter can be removed.
     * If additionally the thisCounterOnly flag is true, only that specific counter will be removed.
     * If called without counter, all keys (independently from the counter) can be removed.
     *
     * @param devid            the device id
     * @param type             the state type
     * @param key
     * @param counter          (opt)
     * @param thisCounterOnly  (opt) if provided, the exact counter only will be removed
     * @throws StateInvalidException
     */
    void cleanStates(String devid, String type, String key, String counter, boolean thisCounterOnly)
            throws StateInvalidException;

    /**
     * Links a user to a device
     *
     * @param username
     * @param devid
     * @return boolean indicating if the user was added or not (existed already)
     */
    boolean linkUserDevice(String username, String devid);

    /**
     * Unlinks a device from a user
     *
     * @param username
     * @param devid
     * @return boolean
     */
    boolean unLinkUserDevice(String username, String devid);

    /**
     * Returns a list with all device ids for a user.
     * If no user is set, all device ids should be returned
     *
     * @param username (opt)
     * @return List<String>
     */
    List<String> getAllDevices(String username);

    /**
     * Returns the current version of the state files
     *
     * @return int
     */
    int getStateVersion();

    /**
     * Sets the current version of the state files
     *
     * @param version the new supported version
     * @return boolean
     */
    boolean setStateVersion(int version);

    /**
     * Returns all available states for a device id
     *
     * @param devid the device id
     * @return Map<String,Object>
     */
    Map<String, Object> getAllStatesForDevice(String devid);
}
