package com.example.hw1.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hw1.Topten;

public class MySp {
    private static final String DB_FILE = "DB_FILE";
    private SharedPreferences sharedPreferences;
    private static MySp instance = null;
    private Topten topTen;
    private MySp(Context context) {
        sharedPreferences = context.getSharedPreferences(DB_FILE, Context.MODE_PRIVATE);
    }

    public static void init(Context context){
        if (instance == null) {
            instance = new MySp(context);

        }
    }
    public static MySp getInstance()
    {
        return instance;
    }
    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }




}
