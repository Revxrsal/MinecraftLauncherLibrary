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
package net.reflxction.launcherlib.game;

/**
 * Represents the launcher visibility
 */
public enum LauncherVisibility {

    /**
     * Completely the launcher when the game starts
     */
    CLOSE_LAUNCHER_ON_START("close launcher when game starts"),

    /**
     * Keeps the launcher open while the game is running.
     * <p>
     * This mode is useful for debugging
     */
    KEEP_LAUNCHER_OPEN("keep the launcher open"),

    /**
     * Hides the launcher when the game starts, and reopens the launcher when the game
     * is closed.
     */
    HIDE_AND_OPEN_ON_GAME_CLOSE("hide launcher and re-open when game closes");

    private String launcherValue;

    LauncherVisibility(String launcherValue) {
        this.launcherValue = launcherValue;
    }

    /**
     * The value which is saved in the profiles file
     *
     * @return The launcher value
     */
    public String getLauncherValue() {
        return launcherValue;
    }
}
