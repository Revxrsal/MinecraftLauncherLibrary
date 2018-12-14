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

import com.google.gson.annotations.SerializedName;

/**
 * Represents a launcher user. This contains the user display name, access token, ID, UUID, and e-mail.
 */
public class ProfileUser {

    /**
     * The display name of the user
     */
    private String displayName;

    /**
     * The user access token
     */
    private String accessToken;

    /**
     * ???
     */
    @SerializedName("userid")
    private String userID;

    /**
     * The player UUID
     */
    private String uuid;

    /**
     * The logged in e-mail
     */
    @SerializedName("username")
    private String mail;

    /**
     * The display name of the player
     *
     * @return The player display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * The user access token, which is saved on sessions
     *
     * @return The access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * ???
     *
     * @return ???
     */
    public String getUserID() {
        return userID;
    }

    /**
     * The player UUID
     *
     * @return The player's UUID
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * The user's logged in email
     *
     * @return The current logged in email
     */
    public String getEmail() {
        return mail;
    }
}
