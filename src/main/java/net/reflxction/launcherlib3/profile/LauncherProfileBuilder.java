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
package net.reflxction.launcherlib3.profile;

/**
 * A builder class for {@link LauncherProfile}
 *
 * @see LauncherProfile
 * @see LauncherProfile#asBuilder()
 */
public class LauncherProfileBuilder {

    /**
     * The launcher profile to build
     */
    private LauncherProfile profile;

    /**
     * Initiates a new launcher profile builder, derived from an empty {@link LauncherProfile} instance
     */
    public LauncherProfileBuilder() {
        this(LauncherProfile.EMPTY);
    }

    /**
     * Initiates a new launcher profile builder from the given profile instance.
     *
     * @param profile Profile to build for
     */
    public LauncherProfileBuilder(LauncherProfile profile) {
        this.profile = profile;
    }

    /**
     * Sets the launcher profile name
     *
     * @param name New value to set
     * @return This builder instance
     */
    public LauncherProfileBuilder setName(String name) {
        profile.name = name;
        return this;
    }

    /**
     * Sets the launcher's version ID. This determines the version to launch
     *
     * @param versionID Version ID to launch
     * @return This builder instance
     */
    public LauncherProfileBuilder setVersionID(String versionID) {
        profile.lastVersionId = versionID;
        return this;
    }

    /**
     * Sets the directory that this profile should use to save its content
     *
     * @param gameDirectory New value to set
     * @return This builder instance
     */
    public LauncherProfileBuilder setGameDirectory(String gameDirectory) {
        profile.gameDirectory = gameDirectory;
        return this;
    }

    /**
     * Sets the Java directory that the game will run on. This is by default the system's Java directory.
     *
     * @param javaDirectory New value to set
     * @return This builder instance
     */
    public LauncherProfileBuilder setJavaDirectory(String javaDirectory) {
        profile.javaDirectory = javaDirectory;
        return this;
    }

    /**
     * Sets the start-up arguments for the profile. Those can have tangible experience in the game performance.
     *
     * @param javaArguments New value to set
     * @return This builder instance
     */
    public LauncherProfileBuilder setJavaArguments(String javaArguments) {
        profile.javaArguments = javaArguments;
        return this;
    }

    /**
     * Sets the Base64-encoded image which appears as a logo for the profile in the profiles menu.
     *
     * @param icon New value to set (Base64-encoded)
     * @return This builder instance
     */
    public LauncherProfileBuilder setIcon(String icon) {
        profile.icon = icon;
        return this;
    }

    /**
     * Sets the path to the logging configuration for the profile.
     *
     * @param logConfig New value to set
     * @return This builder instance
     */
    public LauncherProfileBuilder setLogConfig(String logConfig) {
        profile.logConfig = logConfig;
        return this;
    }

    /**
     * Sets whether the logging configuration is a XML file or not.
     *
     * @param logConfigIsXML New value to set
     * @return This builder instance
     */
    public LauncherProfileBuilder setLogConfigIsXML(boolean logConfigIsXML) {
        profile.logConfigIsXML = logConfigIsXML;
        return this;
    }

    /**
     * Returns the constructed {@link LauncherProfile}. This should be called to get the built object
     * after calling all the chained methods
     *
     * @return The constructed launcher profile.
     */
    public LauncherProfile build() {
        return profile;
    }
}
