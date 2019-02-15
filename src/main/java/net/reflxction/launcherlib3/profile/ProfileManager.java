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
package net.reflxction.launcherlib3.profile;

import com.google.gson.reflect.TypeToken;
import net.reflxction.launcherlib3.MinecraftLauncher;
import net.reflxction.simplejson.configuration.DirectConfiguration;
import net.reflxction.simplejson.json.JsonFile;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Profile manager with multiple helping methods for controlling profiles
 *
 * @see LauncherProfile
 * @see MinecraftLauncher
 */
public class ProfileManager {

    /**
     * The JSON key for the profiles map in the file
     */
    private static final String PROFILES = "profiles";

    /**
     * A default instance of the profile manager. Useful if no new initiation is required.
     */
    private static final ProfileManager INSTANCE = new ProfileManager();

    /**
     * Map which stores all profiles until they are saved.
     */
    private Map<String, LauncherProfile> profileMap;

    /**
     * The configuration used to retrieve information
     */
    private final DirectConfiguration configuration;

    /**
     * Initiates a new ProfileManager from the given path
     *
     * @param path Path to the launcher profiles json file.
     */
    public ProfileManager(String path) {
        this.configuration = DirectConfiguration.of(JsonFile.of(path));
        Type mapType = new TypeToken<LinkedHashMap<String, LauncherProfile>>() {
        }.getType();
        this.profileMap = configuration.get(PROFILES, mapType, MinecraftLauncher.GSON);
    }

    /**
     * Initiates a new ProfileManager with Minecraft's expected working directory.
     */
    public ProfileManager() {
        this(MinecraftLauncher.DATA_FILE.getAbsolutePath());
    }

    /**
     * Returns a map which contains all the cached profiles.
     * <p>
     * Every profile is assigned to its name, which can be fetched using {@link LauncherProfile#getName()}
     *
     * @return A map of the cached profiles
     */
    public Map<String, LauncherProfile> getProfiles() {
        return profileMap;
    }

    /**
     * Returns a {@link LauncherProfile} object from the given name.
     *
     * @param profileName Name of the launcher
     * @return The launcher profile
     */
    public LauncherProfile getProfile(String profileName) {
        return profileMap.get(profileName);
    }

    /**
     * Creates the given launcher, and adds all the properties appropriately
     *
     * @param profile Profile to create
     * @return This manager instance
     * @see #removeProfile(String)
     * @see #save()
     */
    public ProfileManager addProfile(LauncherProfile profile) {
        profileMap.put(profile.getName(), profile);
        return this;
    }

    /**
     * Removes the given launcher, using the name.
     *
     * @param profile Profile to remove
     * @return This manager instance
     * @see #addProfile(LauncherProfile)
     * @see #save()
     */
    public ProfileManager removeProfile(String profile) {
        profileMap.remove(profile);
        return this;
    }

    /**
     * Updates the cached profiles map.
     *
     * @return The new cached map
     */
    public Map<String, LauncherProfile> updateCache() {
        Type mapType = new TypeToken<LinkedHashMap<String, LauncherProfile>>() {
        }.getType();
        return profileMap = configuration.get("profiles", mapType, MinecraftLauncher.GSON);
    }

    /**
     * Applies the changes to the file. This should be called after we're done removing or creating a
     * launcher.
     */
    public void save() {
        configuration.set(PROFILES, profileMap);
        configuration.save(Throwable::printStackTrace);
        profileMap.clear();
    }

    /**
     * Returns the singleton instance of this manager. Useful if the user
     * doesn't need a new initiation (for a new location for debugging for example).
     *
     * @return The instance of the profile manager
     */
    public static ProfileManager getInstance() {
        return INSTANCE;
    }

}
