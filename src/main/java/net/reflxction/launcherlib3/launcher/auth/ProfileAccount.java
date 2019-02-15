/*
 * * Copyright 2018-2019 github.com/ReflxctionDev
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
package net.reflxction.launcherlib3.launcher.auth;

import com.google.gson.annotations.SerializedName;
import net.reflxction.launcherlib3.launcher.LauncherSection;

import java.util.Map;

/**
 * Represents an account which is logged-in to the profile.
 */
@LauncherSection("authenticationDatabase -> x")
public class ProfileAccount {

    /**
     * The profile session access token
     */
    private String accessToken;

    /**
     * The logged-in email
     */
    @SerializedName("username")
    private String email;

    /**
     * A map which contains all the logged-in emails. The {@link String} parameter is the UUID (no dashes), and the
     * assigned {@link SessionAccount} is the profile information which contains the player IGN display name.
     */
    private Map<String, SessionAccount> profiles;

    /**
     * The profile session access token
     *
     * @return The profile session access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * The logged-in email
     *
     * @return The logged-in email
     */
    public String getEmail() {
        return email;
    }

    /**
     * A map which contains all the logged-in emails. The {@link String} parameter is the UUID (no dashes), and the
     * assigned {@link SessionAccount} is the profile information which contains the player IGN display name.
     *
     * @return The profiles map
     */
    public Map<String, SessionAccount> getProfiles() {
        return profiles;
    }
}
