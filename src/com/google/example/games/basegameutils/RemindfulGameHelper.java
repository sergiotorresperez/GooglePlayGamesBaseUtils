/*
 * Copyright (C) 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.example.games.basegameutils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * Subclass of {@link GameHelper} that remembers if the user cancelled the
 * connection, so we won't try to connect on start again if they cancelled. It
 * also allows to set whether we should try to connect on start of not if it is
 * the first time the app runs.
 */
public class RemindfulGameHelper extends GameHelper {

    private static final String KEY_CONNECT_ON_START = "connect_on_start";

    public RemindfulGameHelper(Activity activity, int clientsToUse, boolean defaultConnectOnStart) {
        super(activity, clientsToUse);
        final boolean connectOnStart = loadConnectOnStart(defaultConnectOnStart);
        super.setConnectOnStart(connectOnStart);
    }

    @Override
    public void setConnectOnStart(boolean value) {
        super.setConnectOnStart(value);
        saveConnectOnStart(value);
    }

    private boolean loadConnectOnStart(boolean defaultValue) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(mActivity);
        return sharedPref.getBoolean(KEY_CONNECT_ON_START, defaultValue);
    }

    private void saveConnectOnStart(boolean value) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(mActivity);
        Editor editor = sharedPref.edit();
        editor.putBoolean(KEY_CONNECT_ON_START, value);
        editor.commit();
    }

}