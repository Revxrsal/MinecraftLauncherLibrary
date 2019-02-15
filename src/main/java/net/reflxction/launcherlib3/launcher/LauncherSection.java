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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation used to mark the classes which represent sections in "launcher_profiles.json" file.
 * This is in order to clarify any ambiguous JSON keys or class names.
 * <p>
 * If {@link #value()} contains an arrow ("->") it means that this object represents a sub-section.
 * <p>
 * If {@link #value()} contains "x", this means it doesn't have a definite naming, however it will still
 * contain this type of object. Objects with indefinite naming are always sub-sections.
 * <p>
 * If {@link #value()} is "{}", this means it's the entire file. This is only used in {@link LauncherContext}.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface LauncherSection {

    /**
     * The JSON key in which contains the object that this type represents.
     *
     * @return The JSON key
     */
    String value();

}
