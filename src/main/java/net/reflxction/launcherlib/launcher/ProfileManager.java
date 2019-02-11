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

import net.reflxction.simplejson.configuration.DirectConfiguration;
import net.reflxction.simplejson.json.JsonFile;

import java.io.File;
import java.util.Map;

/**
 * Profile manager with multiple helping methods for controlling profiles
 */
public class ProfileManager {

    /**
     * The configuration
     */
    private DirectConfiguration configuration;

    /**
     * Minecraft's directory name
     */
    private static final String WORKING_DIRECTORY_NAME = "minecraft";

    /**
     * The launcher profile's file name
     */
    public static final String FILE_NAME = "launcher_profiles.json";

    /**
     * A default instance of the profile manager. Useful if no new initiation is required.
     */
    private static final ProfileManager INSTANCE = new ProfileManager();

    /**
     * Initiates a new ProfileManager from the given path
     *
     * @param path Path to the launcher profiles json file.
     */
    public ProfileManager(String path) {
        this.configuration = DirectConfiguration.of(JsonFile.of(path));
    }

    /**
     * Initiates a new ProfileManager with Minecraft's expected working directory.
     */
    public ProfileManager() {
        this(getExpectedMinecraftDirectory().getAbsolutePath() + File.separator + FILE_NAME);
    }

    /**
     * Creates the given launcher, and adds all the properties appropriately
     *
     * @param profile Profile to create
     */
    public void addProfile(LauncherProfile profile) {
        Map<String, Object> profilesMap = configuration.getMap("profiles");
        profilesMap.put(profile.getName(), profile.getJson());
        configuration.set("profiles", profilesMap);
    }

    /**
     * Removes the given launcher, using the name.
     *
     * @param profile Profile to remove
     */
    public void removeProfile(String profile) {
        Map<String, Object> profilesMap = configuration.getMap("profiles");
        profilesMap.remove(profile);
        configuration.set("profiles", profilesMap);
    }

    /**
     * Applies the changes to the file. This should be called after we're done removing or creating a
     * launcher.
     */
    public void apply() {
        configuration.save(Throwable::printStackTrace);
    }

    /**
     * Returns the directory which is expected to contain Minecraft's data directory (".minecraft"). This will
     * vary depends on the user OS and will give the most appropriate directory as it uses the same pattern
     * the Minecraft launchers use.
     * <p>
     * This will create the directory if it doesn't exist already.
     *
     * @return Minecraft's working directory
     * @author Mojang
     */
    public static File getExpectedMinecraftDirectory() {
        final String property = System.getProperty("user.home", ".");
        File file;
        switch (getPlatform()) {
            case LINUX:
            case SOLARIS: {
                file = new File(property, '.' + WORKING_DIRECTORY_NAME + '/');
                break;
            }
            case WINDOWS: {
                final String getenv = System.getenv("APPDATA");
                file = new File((getenv != null) ? getenv : property, '.' + WORKING_DIRECTORY_NAME + '/');
                break;
            }
            case MACOS: {
                file = new File(property, "Library/Application Support/" + WORKING_DIRECTORY_NAME);
                break;
            }
            default: {
                file = new File(property, WORKING_DIRECTORY_NAME + '/');
                break;
            }
        }
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("The working directory could not be created: " + file);
        }
        return file;
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

    /**
     * Returns the OS that the user is currently uses
     *
     * @return The operating system
     * @author Mojang
     */
    private static Platform getPlatform() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return Platform.WINDOWS;
        }
        if (osName.contains("mac")) {
            return Platform.MACOS;
        }
        if (osName.contains("solaris")) {
            return Platform.SOLARIS;
        }
        if (osName.contains("sunos")) {
            return Platform.SOLARIS;
        }
        if (osName.contains("linux")) {
            return Platform.LINUX;
        }
        if (osName.contains("unix")) {
            return Platform.LINUX;
        }
        return Platform.UNKNOWN;
    }

    /**
     * Represents a running user platform
     *
     * @author Mojang
     */
    private enum Platform {

        /**
         * Linux OS
         */
        LINUX,

        /**
         * Solaris OS
         */
        SOLARIS,

        /**
         * Windows OS
         */
        WINDOWS,

        /**
         * Mac OS
         */
        MACOS,

        /**
         * An undefined operating system
         */
        UNKNOWN
    }
}
