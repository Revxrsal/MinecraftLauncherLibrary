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

/**
 * Contains all information
 */
@LauncherSection("launcherVersion")
public class LauncherVersion {

    /**
     * The name of this build
     */
    private String name;

    /**
     * The launcher format
     */
    private int format;

    /**
     * The profiles format
     */
    private int profilesFormat;

    /**
     * Returns the name of this version build, e.g "2.1.1462".
     *
     * @return The version name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the launcher format
     *
     * @return The launcher format
     */
    public int getFormat() {
        return format;
    }

    /**
     * Returns the profiles format.
     *
     * @return The profiles format
     */
    public int getProfilesFormat() {
        return profilesFormat;
    }
}
