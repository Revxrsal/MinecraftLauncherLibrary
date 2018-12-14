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
 * A simple class for game resolution handling
 */
public class GameResolution {

    // The width
    private int width;

    // The height
    private int height;

    /**
     * Initiates a new game resolution
     *
     * @param width  Width of the game
     * @param height Height of the game
     */
    public GameResolution(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * The width
     *
     * @return The width
     */
    public int getWidth() {
        return width;
    }

    /**
     * The height
     *
     * @return The height
     */
    public int getHeight() {
        return height;
    }

}
