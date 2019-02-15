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
 * Contains all settings that are saved inside the "launcher_profiles.json" file.
 */
@LauncherSection("settings")
public class LauncherSettings {

    /**
     * Whether or not include version IDs of game snapshots when browsing profiles
     */
    private boolean enableSnapshots;

    /**
     * Whether or not enable changing advanced Java settings when adding new launch arguments
     */
    private boolean enableAdvanced;

    /**
     * Whether or not enable the usage of historical versions
     */
    private boolean enableHistorical;

    /**
     * Whether or not enable analyzing the user session or not. This is usually not maintainable/cannot be
     * controlled from the launcher
     */
    private boolean enableAnalytics;

    /**
     * Whether or not keep the launcher open while the game is running
     */
    private boolean keepLauncherOpen;

    /**
     * Whether or not create a separate window which contains all the game logs
     */
    private boolean showGameLog;

    /**
     * The selected language for the launcher. Default value is en-us.
     */
    private String locale;

    /**
     * Whether or not show the sliding menu under the Minecraft logo (which contains News, Skins,
     * Settings and Launch options).
     */
    private boolean showMenu;

    /**
     * The way profiles are sorted in the profiles menu. There are 2 sorting types: byName and byLastPlayed.
     * <p>
     * {@code byName}       sorts them on the alphabetical order
     * {@code byLastPlayed} sorts them based on the latest profiles you used.
     */
    private ProfileSorting profileSorting;

    /**
     * Whether or not contact Mojang when a crash occurs
     */
    private boolean crashAssistance;

    /**
     * Whether or not include version IDs of game snapshots when browsing profiles
     *
     * @return Whether or not include version IDs of game snapshots when browsing profiles
     */
    public boolean isEnableSnapshots() {
        return enableSnapshots;
    }

    /**
     * Whether or not enable changing advanced Java settings when adding new launch arguments
     *
     * @return Whether or not enable changing advanced Java settings when adding new launch arguments
     */
    public boolean isEnableAdvanced() {
        return enableAdvanced;
    }

    /**
     * Whether or not enable the usage of historical versions
     *
     * @return Whether or not enable the usage of historical versions
     */
    public boolean isEnableHistorical() {
        return enableHistorical;
    }

    /**
     * Whether or not enable analyzing the user session or not.
     * <p>
     * This is usually not maintainable/cannot be controlled from the launcher  Whether or not enable analyzing the user session or not. This is usually not maintainable/cannot be controlled from the launcher
     *
     * @return Whether or not enable analyzing the user session or not. This is usually not maintainable/cannot be controlled from the launcher
     */
    public boolean isEnableAnalytics() {
        return enableAnalytics;
    }

    /**
     * Whether or not keep the launcher open while the game is running
     *
     * @return Whether or not keep the launcher open while the game is running
     */
    public boolean isKeepLauncherOpen() {
        return keepLauncherOpen;
    }

    /**
     * Whether or not create a separate window which contains all the game logs
     *
     * @return Whether or not create a separate window which contains all the game logs
     */
    public boolean isShowGameLog() {
        return showGameLog;
    }

    /**
     * The selected language for the launcher.
     *
     * @return The selected language for the launcher. Default value is {@code en-us}
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Whether or not show the sliding menu under the Minecraft logo (which contains News,
     * Skins, Settings and Launch options).
     *
     * @return Whether or not show the sliding menu under the logo.
     */
    public boolean isShowMenu() {
        return showMenu;
    }

    /**
     * Returns the way profiles are sorted in the profiles menu. There are 2 sorting types: byName and byLastPlayed.
     * <p>
     * {@code byName}       sorts them on the alphabetical order
     * {@code byLastPlayed} sorts them based on the latest profiles you used.
     *
     * @return The profile sorting method
     */
    public ProfileSorting getProfileSorting() {
        return profileSorting;
    }

    /**
     * Whether or not contact Mojang when a crash occurs
     *
     * @return Whether or not contact Mojang when a crash occurs
     */
    public boolean isCrashAssistance() {
        return crashAssistance;
    }
}
