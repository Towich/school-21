package com.example.pr3.data.source;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesDataSource{

    public final static String SAVE_KEY_1 = "SAVE_KEY_1";
    public final static String SAVE_KEY_2 = "SAVE_KEY_2";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public void createFile(Context context){
        sharedPreferences = context.getSharedPreferences("Test", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void save(String saveKey, String toSave){
        editor.putString(saveKey, toSave);
        editor.apply();
    }

    public String load(String saveKey){
        return sharedPreferences.getString(saveKey, "null");
    }
}
