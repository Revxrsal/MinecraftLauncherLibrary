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

import com.google.gson.annotations.SerializedName;
import net.reflxction.launcherlib3.launcher.LauncherSection;

import java.util.Date;

/**
 * Represents a launcher profile. Launcher profiles specify the game settings which are dependent on the launcher,
 * such as the game directory, game version, game resolution, etc.
 *
 * @apiNote To create a mutable copy of this profile, invoke {@link #asBuilder()} which allows modifications to
 * a new instance of this.
 * @implNote Some fields are package-private to limit access to set them from {@link LauncherProfileBuilder}.
 * @see LauncherProfileBuilder
 * @see ProfileType
 */
@LauncherSection("profiles -> x")
public class LauncherProfile {

    /**
     * Represents an empty launcher profile. All instances built from new {@link LauncherProfileBuilder} are
     * derived from this instance and are updated with chaining setters.
     */
    public static final LauncherProfile EMPTY = new LauncherProfile();

    /**
     * Represents the profile name
     */
    String name;

    /**
     * Represents the type of this profile
     */
    private ProfileType type;

    /**
     * Represents the date this profile was created at
     */
    private Date created;

    /**
     * Represents the date this profile was last used at
     */
    private Date lastUsed;

    /**
     * Represents a <p>Base64</p>-encoded image which appears as a logo for the profile in the profiles menu.
     */
    String icon;

    /**
     * Represents the last launcher version this profile was launched on
     */
    String lastVersionId;

    /**
     * The directory that this profile should use to save its content.
     */
    @SerializedName("gameDir")
    String gameDirectory;

    /**
     * The Java directory that the game will run on. This is by default the system's Java directory.
     */
    @SerializedName("javaDir")
    String javaDirectory;

    /**
     * The start-up arguments for the profile. Those can have tangible experience in the game performance.
     */
    @SerializedName("javaArgs")
    String javaArguments;

    /**
     * The path to the logging configuration for the profile. This can be a XML file if {@link #logConfigIsXML} is true.
     */
    String logConfig;

    /**
     * Whether the logging configuration is a XML file or not.
     */
    boolean logConfigIsXML;

    /**
     * Returns the profile name
     *
     * @return The profile name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of this profile
     *
     * @return The profile type
     */
    public ProfileType getType() {
        return type;
    }

    /**
     * Returns the date this profile was created at
     *
     * @return The creation date of this profile
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Returns the date this profile was last used at
     *
     * @return The date this profile was last used at
     */
    public Date getLastUsed() {
        return lastUsed;
    }

    /**
     * Returns a <p>Base64</p>-encoded image which appears as a logo for the profile in the profiles menu.
     *
     * @return The profile icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Returns the last launcher version this profile was launched on
     *
     * @return The last version ID launched with this profile
     */
    public String getLastVersionId() {
        return lastVersionId;
    }

    /**
     * Returns the directory that this profile should use to save its content.
     *
     * @return The game directory
     */
    public String getGameDirectory() {
        return gameDirectory;
    }

    /**
     * Returns the Java directory that the game will run on. This is by default the system's Java directory.
     *
     * @return The Java directory
     */
    public String getJavaDirectory() {
        return javaDirectory;
    }

    /**
     * Returns the start-up arguments for the profile. Those can have tangible experience in the game performance.
     *
     * @return The start-up Java arguments
     */
    public String getJavaArguments() {
        return javaArguments;
    }

    /**
     * The path to the logging configuration for the profile. This can be a XML file
     * if {@link #logConfigIsXML} is true.
     *
     * @return The logging config
     */
    public String getLogConfig() {
        return logConfig;
    }

    /**
     * Whether the logging configuration is a XML file or not.
     *
     * @return Whether the logging configuration is a XML file or not.
     */
    public boolean isLogConfigXML() {
        return logConfigIsXML;
    }

    /**
     * Derives a new {@link LauncherProfileBuilder} from this launcher profile.
     *
     * @return A new launcher profile builder which contains this launcher profile.
     */
    public LauncherProfileBuilder asBuilder() {
        return new LauncherProfileBuilder(this);
    }

}
