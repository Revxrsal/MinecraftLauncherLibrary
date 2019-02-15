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
package net.reflxction.launcherlib3.launcher.auth;

import net.reflxction.launcherlib3.launcher.LauncherSection;

/**
 * Represents a logged-in account which is inside a {@link ProfileAccount}.
 */
@LauncherSection("authenticationDatabase -> y -> profiles -> x")
public class SessionAccount {

    /**
     * The player's display name (IGN)
     */
    private String displayName;

    /**
     * Returns the player's display name
     *
     * @return The player name
     */
    public String getDisplayName() {
        return displayName;
    }

}
