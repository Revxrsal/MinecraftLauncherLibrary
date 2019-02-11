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

import com.google.gson.JsonObject;
import net.reflxction.launcherlib.game.GameResolution;
import net.reflxction.launcherlib.game.LauncherVisibility;
import net.reflxction.launcherlib.game.ReleaseType;
import net.reflxction.simplejson.utils.JsonBuilder;

/**
 * Represents a launcher launcher
 */
public class LauncherProfile {

    /**
     * The name of the launcher
     */
    private String name;

    /**
     * The launcher visibility after the game is launched
     */
    private LauncherVisibility launcherVisibility;

    /**
     * The last version ID of the launcher. This is the version that is selected when using the launcher
     */
    private String versionID;

    /**
     * The Java directory
     */
    private String javaDirectory;

    /**
     * The game directory
     */
    private String gameDirectory;

    /**
     * The launch arguments
     */
    private String javaArguments;

    /**
     * The game resolution
     */
    private GameResolution resolution;

    /**
     * The allowed release types for the launcher
     */
    private ReleaseType[] allowedReleaseTypes;

    /**
     * Whether to send crash reports to Mojang or not
     */
    private boolean useHopperCrashService;

    /**
     * The launcher name
     *
     * @return The launcher name
     */
    public String getName() {
        return name;
    }

    /**
     * The launcher visibility after the game is launched
     *
     * @return The launcher visibility after the game is launched
     */
    public LauncherVisibility getLauncherVisibility() {
        return launcherVisibility;
    }

    /**
     * The last version ID of the launcher. This is the version that is selected when using the launcher
     *
     * @return The last version ID of the launcher.
     */
    public String getVersionID() {
        return versionID;
    }

    /**
     * The game directory
     *
     * @return The game directory
     */
    public String getGameDirectory() {
        return gameDirectory;
    }

    /**
     * The Java directory for the game to use
     *
     * @return The Java directory
     */
    public String getJavaDirectory() {
        return javaDirectory;
    }

    /**
     * The launch arguments
     *
     * @return The launch arguments
     */
    public String getJavaArguments() {
        return javaArguments;
    }

    /**
     * The game resolution
     *
     * @return The game resolution
     */
    public GameResolution getResolution() {
        return resolution;
    }

    /**
     * The allowed release types for the launcher
     *
     * @return The allowed release types
     * @see ReleaseType
     */
    public ReleaseType[] getAllowedReleaseTypes() {
        return allowedReleaseTypes;
    }

    /**
     * Whether to send crash reports to Mojang or not
     *
     * @return Whether to send crash reports to Mojang or not
     */
    public boolean isUseHopperCrashService() {
        return useHopperCrashService;
    }

    /**
     * Sets the launcher name
     *
     * @param name New value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the launcher visibility
     *
     * @param launcherVisibility New value to set
     */
    public void setLauncherVisibility(LauncherVisibility launcherVisibility) {
        this.launcherVisibility = launcherVisibility;
    }

    /**
     * Sets the last version ID
     *
     * @param versionID New value to set
     */
    public void setVersionID(String versionID) {
        this.versionID = versionID;
    }

    /**
     * Sets the game directory
     *
     * @param gameDirectory New value to set
     */
    public void setGameDirectory(String gameDirectory) {
        this.gameDirectory = gameDirectory;
    }

    /**
     * Sets the Java directory
     *
     * @param javaDirectory New value to set
     */
    public void setJavaDirectory(String javaDirectory) {
        this.javaDirectory = javaDirectory;
    }

    /**
     * Sets the launch arguments
     *
     * @param javaArguments New value to set
     */
    public void setJavaArguments(String javaArguments) {
        this.javaArguments = javaArguments;
    }

    /**
     * Sets the game resolution
     *
     * @param resolution New value to set
     */
    public void setResolution(GameResolution resolution) {
        this.resolution = resolution;
    }

    /**
     * Sets the allowed release types for the launcher
     *
     * @param allowedReleaseTypes New value to set
     */
    public void setAllowedReleaseTypes(ReleaseType... allowedReleaseTypes) {
        this.allowedReleaseTypes = allowedReleaseTypes;
    }

    /**
     * Sets whether to send crash reports to Mojang or not
     *
     * @param useHopperCrashService New value to set
     */
    public void setUseHopperCrashService(boolean useHopperCrashService) {
        this.useHopperCrashService = useHopperCrashService;
    }

    public JsonObject getJson() {
        return new JsonBuilder()
                .mapIfNotNull("name", name)
                .mapIfNotNull("gameDir", gameDirectory)
                .mapIfNotNull("lastVersionId", versionID)
                .mapIfNotNull("javaDir", javaDirectory)
                .mapIfNotNull("javaArgs", javaArguments)
                .mapIfNotNull("resolution", resolution)
                .mapIfNotNull("allowedReleasesTypes", allowedReleaseTypes)
                .mapIfNotNull("launcherVisibilityOnGameClose", launcherVisibility.getLauncherValue())
                .mapIf(s -> useHopperCrashService, "useHopperCrashService", true)
                .buildJsonObject();
    }

}
