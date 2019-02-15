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
import net.reflxction.launcherlib3.launcher.auth.ProfileAccount;

/**
 * Represents the selected profile user
 *
 * @see ProfileAccount
 * @see net.reflxction.launcherlib3.MinecraftLauncher
 */
@LauncherSection("selectedUser")
public class ProfileUser {

    /**
     * Represents the session UUID-hashed key of the currently selected user. This can be used
     * to retrieve the selected {@link ProfileAccount} from the {@link ProfileAccount#getProfiles()}
     * map to get the {@link net.reflxction.launcherlib3.launcher.auth.SessionAccount} information.
     */
    private String account;

    /**
     * Represents the UUID of the currently selected user
     */
    @SerializedName("profile")
    private String profileUUID;

    /**
     * Returns the session UUID-hashed key of the currently selected user. This can be used
     * to retrieve the selected {@link ProfileAccount} from the {@link ProfileAccount#getProfiles()}
     * map to get the {@link net.reflxction.launcherlib3.launcher.auth.SessionAccount} information.
     *
     * @return The session UUID-hashed key.
     */
    public String getAccount() {
        return account;
    }

    /**
     * Returns the UUID of the selected player
     *
     * @return The UUID of the selected player
     */
    public String getProfileUUID() {
        return profileUUID;
    }
}
