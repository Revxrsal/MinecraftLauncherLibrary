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

import com.google.gson.annotations.SerializedName;

/**
 * Represents the method used to sort profiles in launcher
 */
@LauncherSection("settings -> profileSorting")
public enum ProfileSorting {

    /**
     * Represents the sorting method "byName". This method sorts launcher profiles on the alphabetical order
     */
    @SerializedName("byName")
    BY_NAME,

    /**
     * Represents the sorting method "byLastPlayed". This method sorts launcher profiles based on the latest
     * profiles used
     */
    @SerializedName("byLastPlayed")
    BY_LAST_PLAYED

}
