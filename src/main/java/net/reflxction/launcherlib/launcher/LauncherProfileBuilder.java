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

import net.reflxction.launcherlib.game.GameResolution;
import net.reflxction.launcherlib.game.LauncherVisibility;
import net.reflxction.launcherlib.game.ReleaseType;

/**
 * Builder class for {@link LauncherProfile}
 */
public class LauncherProfileBuilder {

    // The launcher launcher object
    private LauncherProfile profile;

    public LauncherProfileBuilder() {
        this.profile = new LauncherProfile();
    }

    /**
     * Sets the launcher name
     *
     * @param name New value to set
     */
    public LauncherProfileBuilder setName(String name) {
        profile.setName(name);
        return this;
    }

    /**
     * Sets the launcher visibility
     *
     * @param launcherVisibility New value to set
     */
    public LauncherProfileBuilder setLauncherVisibility(LauncherVisibility launcherVisibility) {
        profile.setLauncherVisibility(launcherVisibility);
        return this;
    }

    /**
     * Sets the last version ID
     *
     * @param versionID New value to set
     */
    public LauncherProfileBuilder setVersionID(String versionID) {
        profile.setVersionID(versionID);
        return this;
    }

    /**
     * Sets the game directory
     *
     * @param gameDirectory New value to set
     */
    public LauncherProfileBuilder setGameDirectory(String gameDirectory) {
        profile.setGameDirectory(gameDirectory);
        return this;
    }

    /**
     * Sets the Java directory
     *
     * @param javaDirectory New value to set
     */
    public LauncherProfileBuilder setJavaDirectory(String javaDirectory) {
        profile.setJavaDirectory(javaDirectory);
        return this;
    }

    /**
     * Sets the launch arguments
     *
     * @param javaArguments New value to set
     */
    public LauncherProfileBuilder setJavaArguments(String javaArguments) {
        profile.setJavaArguments(javaArguments);
        return this;
    }

    /**
     * Sets the game resolution
     *
     * @param resolution New value to set
     */
    public LauncherProfileBuilder setGameResolution(GameResolution resolution) {
        profile.setResolution(resolution);
        return this;
    }

    /**
     * Sets the allowed release types
     *
     * @param allowedReleaseTypes New value to set
     */
    public LauncherProfileBuilder setAllowedReleaseTypes(ReleaseType... allowedReleaseTypes) {
        profile.setAllowedReleaseTypes(allowedReleaseTypes);
        return this;
    }

    /**
     * Sets whether to send crash reports to Mojang or not
     *
     * @param useHopperCrashService New value to set
     */
    public LauncherProfileBuilder setUseHopperCrashService(boolean useHopperCrashService) {
        profile.setUseHopperCrashService(useHopperCrashService);
        return this;
    }

    /**
     * Returns the built {@link LauncherProfile} object
     *
     * @return The built object
     */
    public LauncherProfile build() {
        return profile;
    }

}
