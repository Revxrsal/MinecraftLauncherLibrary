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
package net.reflxction.launcherlib.launcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.reflxction.launcherlib.game.AuthenticationDatabase;
import net.reflxction.launcherlib.game.ProfileUser;
import net.reflxction.simplejson.configuration.DirectConfiguration;
import net.reflxction.simplejson.json.JsonFile;
import net.reflxction.simplejson.utils.Gsons;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A class which allows full access to the launcher
 */
public class LauncherController {

    private static final Gson SERIALIZE_NULLS = new GsonBuilder().serializeNulls().create();

    /**
     * The configuration
     */
    private DirectConfiguration configuration;

    /**
     * A singleton instance of the controller. Useful is no new initiation is needed.
     */
    private static final LauncherController INSTANCE = new LauncherController();

    /**
     * Initiates a new controller from the given path.
     *
     * @param path Path to initiate from
     */
    public LauncherController(String path) {
        configuration = DirectConfiguration.of(JsonFile.of(path));
    }

    /**
     * Initiates a new controller from the expected Minecraft directory.
     */
    public LauncherController() {
        this(ProfileManager.getExpectedMinecraftDirectory().getAbsolutePath() + File.separator + "launcher_profiles.json");
    }

    /**
     * Returns the name of the currently selected launcher.
     *
     * @return The name of the selected launcher.
     */
    public String getSelectedProfile() {
        return configuration.getString("selectedProfile");
    }

    /**
     * Returns the client token
     *
     * @return The client token.
     */
    public String getClientToken() {
        return configuration.getString("clientToken");
    }

    /**
     * Returns the {@code authenticationDatabase} category in the launcher JSON. This category contains the
     * current logged in session information.
     *
     * @return The authentication database profiles map.
     */
    public AuthenticationDatabase getAuthenticationDatabase() {
        Map<String, ProfileUser> m = SERIALIZE_NULLS.fromJson(configuration.getContent().get("authenticationDatabase").toString(),
                new TypeToken<LinkedHashMap<String, ProfileUser>>() {
                }.getType());
        return new AuthenticationDatabase(m);
    }

    /**
     * Returns the currently selected user's UUID
     *
     * @return The selected user's UUID
     */
    public String getSelectedUser() {
        return configuration.getString("selectedUser");
    }

    /**
     * Returns the currently selected profile user
     *
     * @return The currently selected profile user
     */
    public ProfileUser getSelectedProfileUser() {
        return getAuthenticationDatabase().getProfile(getSelectedUser());
    }

    /**
     * Returns the launcher version, which contains the version build name, the format and the profiles format.
     *
     * @return The launcher version
     */
    public LauncherVersion getLauncherVersion() {
        return Gsons.PRETTY_PRINTING.fromJson(configuration.getContent().get("launcherVersion").toString(), LauncherVersion.class);
    }

    /**
     * Returns the singleton instance of this controller. Useful if no new initiation is required.
     *
     * @return The singleton instance.
     */
    public static LauncherController getInstance() {
        return INSTANCE;
    }
}
