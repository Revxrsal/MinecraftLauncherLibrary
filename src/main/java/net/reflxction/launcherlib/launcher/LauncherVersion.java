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

/**
 * Represents the current launcher version information
 */
public class LauncherVersion {

    /**
     * The name of the current version
     */
    private String name;

    /**
     * The launcher format
     */
    private int format;

    /**
     * The profiles format (???)
     */
    private int profilesFormat;

    public LauncherVersion(String name, int format, int profilesFormat) {
        this.name = name;
        this.format = format;
        this.profilesFormat = profilesFormat;
    }

    /**
     * Returns the name of the version
     *
     * @return The version name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the launcher format (???)
     *
     * @return The launcher format
     */
    public int getFormat() {
        return format;
    }

    /**
     * Returns the profiles format (???)
     *
     * @return The profile format
     */
    public int getProfilesFormat() {
        return profilesFormat;
    }
}
