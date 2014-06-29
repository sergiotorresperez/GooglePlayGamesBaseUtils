package com.google.example.games.basegameutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * Class to save whether or not we should try to connect on start.
 */
class ConnectOnStartHelper {

    private static final String KEY_CONNECT_ON_START = "connect_on_start";

    public static boolean shoulConnectOnStart(Context context, boolean defaultValue) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPref.getBoolean(KEY_CONNECT_ON_START, defaultValue);
    }

    public static void setConnectOnStart(Context context, boolean value) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        Editor editor = sharedPref.edit();
        editor.putBoolean(KEY_CONNECT_ON_START, value);
        editor.commit();
    }

}
