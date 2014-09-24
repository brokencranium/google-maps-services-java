/*
 * Copyright 2014 Google Inc. All rights reserved.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF
 * ANY KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.google.maps.internal;

/**
 * Utility class to join strings.
 */
public class StringJoin {

  /**
   * Marker Interface to enable the URL Value enums in {@link com.google.maps.DirectionsApi} to
   * be string joinable.
   */
  public interface UrlValue {
  }

  private StringJoin() {
  }

  public static String join(char delim, String... parts) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < parts.length; i++) {
      if (i != 0) {
        result.append(delim);
      }
      result.append(parts[i]);
    }
    return result.toString();
  }

  public static String join(char delim, UrlValue... parts) {
    String[] strings = new String[parts.length];
    int i = 0;
    for (UrlValue part : parts) {
      strings[i++] = part.toString();
    }

    return join(delim, strings);
  }
}
