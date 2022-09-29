package com.omsk.test0927.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {

    public static void save(Context context , String key , String token){
        SharedPreferences sharedPreferences = context.getSharedPreferences("omsk" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key , token);
        editor.apply();
    }

    public static String get(Context context , String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences("omsk" , Context.MODE_PRIVATE);
        return sharedPreferences.getString(key ,"");
    }

}
