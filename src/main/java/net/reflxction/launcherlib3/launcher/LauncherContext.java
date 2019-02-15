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
package net.reflxction.launcherlib3.launcher;

import com.google.gson.annotations.SerializedName;
import net.reflxction.launcherlib3.MinecraftLauncher;
import net.reflxction.launcherlib3.launcher.auth.ProfileAccount;
import net.reflxction.launcherlib3.profile.ProfileUser;

import java.util.Map;

/**
 * A representation of all the launcher data. This is accessible through {@link MinecraftLauncher#getInstance()}.
 *
 * @see MinecraftLauncher
 */
@LauncherSection("{}")
public class LauncherContext {

    /**
     * Represents the currently logged in client token
     */
    private String clientToken;

    /**
     * Represents the authentication database
     */
    private Map<String, ProfileAccount> authenticationDatabase;

    /**
     * Represents the exposed launcher version information
     */
    private LauncherVersion launcherVersion;

    /**
     * Represents the exposed launcher settings
     */
    private LauncherSettings settings;

    /**
     * Represents the latest token for tracking analysts. Those are used locally by the launcher for
     * managing and tracking sessions
     */
    private String analyticsToken;

    /**
     * Represents the fail count for analytics
     */
    @SerializedName("analyticsFailcount")
    private int analyticsFailCount;

    /**
     * Represents the name of the selected profile. A {@link net.reflxction.launcherlib3.profile.LauncherProfile} can
     * can be retrieved using {@link net.reflxction.launcherlib3.profile.ProfileManager#getProfile(String)}.
     */
    private String selectedProfile;

    /**
     * Represents the selected profile user
     */
    private ProfileUser selectedUser;

    /**
     * Returns the currently logged in client token
     *
     * @return The currently logged in client token
     */
    public String getClientToken() {
        return clientToken;
    }

    /**
     * Returns the authentication database. All the logged in accounts. Every account in this key contains
     * a UUID-hashed map (which is used to save the selected user) which in turn includes the access
     * token, e-mail, and a profile (which contains the account display name)
     *
     * @return The authentication database
     */
    public Map<String, ProfileAccount> getAuthenticationDatabase() {
        return authenticationDatabase;
    }

    /**
     * Returns the exposed launcher version information
     *
     * @return The launcher version information
     */
    public LauncherVersion getLauncherVersion() {
        return launcherVersion;
    }

    /**
     * Returns the exposed launcher settings
     *
     * @return The launcher settings
     */
    public LauncherSettings getSettings() {
        return settings;
    }

    /**
     * Returns the latest token for tracking analysts. Those are used locally by the launcher for
     * managing and tracking sessions
     *
     * @return The token for tracking analysts.
     */
    public String getAnalyticsToken() {
        return analyticsToken;
    }

    /**
     * Returns the fail count for analytics
     *
     * @return The fail count for analytics
     */
    public int getAnalyticsFailCount() {
        return analyticsFailCount;
    }

    /**
     * Returns the name of the selected profile. A {@link net.reflxction.launcherlib3.profile.LauncherProfile} can
     * can be retrieved using {@link net.reflxction.launcherlib3.profile.ProfileManager#getProfile(String)}.
     *
     * @return The selected profile name.
     */
    public String getSelectedProfile() {
        return selectedProfile;
    }

    /**
     * Returns the selected user
     *
     * @return The selected profile
     */
    public ProfileUser getSelectedUser() {
        return selectedUser;
    }
}
