package com.example.pr3.data.source;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesDataSource implements IStorage{

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final String saveKey = "save_key";

    public void createFile(Context context){
        sharedPreferences = context.getSharedPreferences("Test", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void save(String toSave){
        editor.putString(saveKey, toSave);
        editor.apply();
    }

    public String load(){
        return sharedPreferences.getString(saveKey, "null");
    }
}
