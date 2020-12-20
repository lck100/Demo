package com.example.administrator.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2020/6/24.
 */

public class Utils {
    private static String name="app";

    public static void putBoolean(Context context, String key, boolean value){
        SharedPreferences activityPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static Boolean getBoolean(Context context, String key) {
        SharedPreferences setPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return setPreferences.getBoolean(key, false);
    }

    public static void clear(Context context){
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
