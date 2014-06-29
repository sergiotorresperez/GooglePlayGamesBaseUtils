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

public abstract class RemindfulGameActivity extends BaseGameActivity {

    public RemindfulGameActivity() {
        super();
    }

    public RemindfulGameActivity(int requestedClients) {
        super(requestedClients);
    }

    public GameHelper getGameHelper() {
        if (mHelper == null) {
            mHelper = new RemindfulGameHelper(this, mRequestedClients, getDefaultConnectOnStart());
            mHelper.enableDebugLog(mDebugLog);
        }
        return mHelper;
    }

    /**
     * @return whether or not the Activity should try to connect on start the
     *         first time the app is launched
     */
    protected abstract boolean getDefaultConnectOnStart();

}
