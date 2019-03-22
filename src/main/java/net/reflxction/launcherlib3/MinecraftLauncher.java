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
package net.reflxction.launcherlib3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.reflxction.launcherlib3.adapter.DateAdapter;
import net.reflxction.launcherlib3.launcher.LauncherContext;
import net.reflxction.simplejson.configuration.DirectConfiguration;
import net.reflxction.simplejson.json.JsonFile;

import java.io.File;
import java.util.Date;

/**
 * Represents a Java-oriented class which fully wraps the Minecraft launcher
 *
 * @see net.reflxction.launcherlib3.profile.LauncherProfile
 * @see net.reflxction.launcherlib3.profile.ProfileManager
 */
public class MinecraftLauncher {

    /**
     * Minecraft's directory name
     */
    public static final String WORKING_DIRECTORY_NAME = "minecraft";

    /**
     * The launcher profile's file name
     */
    public static final String FILE_NAME = "launcher_profiles.json";

    /**
     * Minecraft's working directory (.minecraft). This should be used instead of invoking {@link #getExpectedMinecraftDirectory()} for
     * caching.
     */
    public static final File WORKING_DIRECTORY = getExpectedMinecraftDirectory();

    /**
     * The launcher_profiles.json file.
     */
    public static final File DATA_FILE = new File(getExpectedMinecraftDirectory() + File.separator + FILE_NAME);

    /**
     * The GSON profile used to serialize and deserialize all the required data for the library to work.
     */
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting()
            .registerTypeAdapter(Date.class, new DateAdapter()).create();

    /**
     * A default instance of the launcher. Useful if no new initiation is required.
     */
    private static final MinecraftLauncher INSTANCE = new MinecraftLauncher();

    /**
     * The configuration used to retrieve data from the file
     */
    private final DirectConfiguration configuration;

    /**
     * A representation of all the launcher data
     */
    private final LauncherContext launcherContext;

    /**
     * Initiates a new {@link MinecraftLauncher} instance from the given path
     *
     * @param path Path to create from. Must be the launcher_profiles.json file!
     */
    public MinecraftLauncher(String path) {
        configuration = DirectConfiguration.of(JsonFile.of(path));
        launcherContext = GSON.fromJson(configuration.getContent(), LauncherContext.class);
    }

    /**
     * Initiates a new instance with Minecraft's expected working directory
     */
    public MinecraftLauncher() {
        this(DATA_FILE.getAbsolutePath());
    }

    /**
     * Returns the exposed launcher data
     *
     * @return The launcher's data
     */
    public LauncherContext getLauncherContext() {
        return launcherContext;
    }

    /**
     * Returns the launcher content as a {@link JsonObject}.
     *
     * @return The launcher content
     */
    public JsonObject getAsJson() {
        return configuration.getContent();
    }

    /**
     * Returns the directory which is expected to contain Minecraft's data directory (".minecraft"). This will
     * vary depends on the user OS and will give the most appropriate directory as it uses the same pattern
     * the Minecraft launchers use.
     * <p>
     * This will create the directory if it doesn't exist already.
     * <p>
     * This method result is to be cached to avoid unnecessary memory.
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
     * Returns the singleton instance of the {@link MinecraftLauncher}.
     *
     * @return The singleton instance
     */
    public static MinecraftLauncher getInstance() {
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
