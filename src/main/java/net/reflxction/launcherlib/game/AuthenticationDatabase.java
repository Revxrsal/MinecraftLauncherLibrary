/*
 * * Copyright 2018 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.reflxction.launcherlib.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Represents an authentication database, which contains all logged in profile users.
 *
 * @see ProfileUser
 */
public class AuthenticationDatabase {

    /**
     * The map which contains all profiles assigned to their UUID
     */
    private Map<String, ProfileUser> profileMap;

    /**
     * The logged in users
     */
    private List<ProfileUser> loggedIn;

    /**
     * Initiates a new authentication database with the logged in users
     *
     * @param profilesMap The profiles map
     */
    public AuthenticationDatabase(Map<String, ProfileUser> profilesMap) {
        this.profileMap = profilesMap;
        this.loggedIn = new LinkedList<>(profilesMap.values());
    }

    /**
     * Returns a {@link LinkedList} of the all the logged in profile users
     *
     * @return All logged in profile users
     */
    public List<ProfileUser> getProfileUsers() {
        return loggedIn;
    }

    /**
     * Returns a profile user from the given UUID
     *
     * @param uuid UUID to fetch from
     * @return The profile user with the given UUID, or {@code null} if
     * doesn't exist.
     */
    public ProfileUser getProfile(String uuid) {
        return profileMap.get(uuid);
    }
}
