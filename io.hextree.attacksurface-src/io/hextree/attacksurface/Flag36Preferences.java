package io.hextree.attacksurface;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class Flag36Preferences {
    private static final String PREFS_NAME = "Flag36Preferences";
    private static SharedPreferences.Editor editor;
    private static SharedPreferences sharedPreferences;

    public static void initialize(Context context) {
        if (sharedPreferences == null) {
            SharedPreferences sharedPreferences2 = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
            sharedPreferences = sharedPreferences2;
            editor = sharedPreferences2.edit();
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        return sharedPreferences2.getBoolean(str, z);
    }

    public static void putBoolean(String str, boolean z) {
        if (sharedPreferences == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        editor.putBoolean(str, z);
        editor.apply();
    }

    public static int getInt(String str) {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        return sharedPreferences2.getInt(str, -1);
    }

    public static void putInt(String str, int i) {
        if (sharedPreferences == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        editor.putInt(str, i);
        editor.apply();
    }

    public static String getString(String str) {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        return sharedPreferences2.getString(str, null);
    }

    public static void putString(String str, String str2) {
        if (sharedPreferences == null) {
            throw new IllegalStateException("SharedPreferencesHelper is not initialized, call initialize() method first.");
        }
        editor.putString(str, str2);
        editor.apply();
    }
}
