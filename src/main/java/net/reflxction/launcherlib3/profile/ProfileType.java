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

/**
 * Represents a launcher profile type
 */
@LauncherSection("profiles -> x -> type")
public enum ProfileType {

    /**
     * Represents a profile which holds the latest snapshot released by Mojang. This is automatically created by
     * the launcher and not manually.
     */
    @SerializedName("latest-snapshot")
    LATEST_SNAPSHOT,

    /**
     * Represents a profile which holds the latest release by Mojang. This is automatically created by the launcher
     * and not manually.
     */
    @SerializedName("latest-release")
    LATEST_RELEASE,

    /**
     * Represents a custom launcher profile which was created by the launcher user, and not automatically generated.
     */
    @SerializedName("custom")
    CUSTOM

}
