package com.example.pr3.data.repository;

import android.content.Context;

import com.example.pr3.data.source.AppSpecificDataSource;
import com.example.pr3.data.source.ExternalStorageDataSource;
import com.example.pr3.data.source.SharedPreferencesDataSource;

public class LoginRepository {
    private final AppSpecificDataSource appSpecificDataSource;
    private final ExternalStorageDataSource externalStorageDataSource;
    private final SharedPreferencesDataSource sharedPreferencesDataSource;

    public LoginRepository(){
        appSpecificDataSource = new AppSpecificDataSource();
        externalStorageDataSource = new ExternalStorageDataSource();
        sharedPreferencesDataSource = new SharedPreferencesDataSource();
    }

    // #1 App-specific storage
    public void createFileAppSpecific(Context context) { appSpecificDataSource.createFile(context); }
    public void saveAppSpecific(String toSave){
        appSpecificDataSource.save(toSave);
    }
    public String loadAppSpecific(){
        return appSpecificDataSource.load();
    }

    // #2 SharedStorage
    public void createFileSharedStorage(Context context) {
        externalStorageDataSource.createFile(context);
    }
    public void saveSharedStorage(String dataToSave) {
        externalStorageDataSource.save(dataToSave);
    }
    public String loadSharedStorage() {
        return externalStorageDataSource.load();
    }

    // #3 SharedPreferences
    public void createSharedPreferences(Context context) {
        sharedPreferencesDataSource.createFile(context);
    }
    public void saveSharedPreferences(String key, String dataToSave) {
        sharedPreferencesDataSource.save(key, dataToSave);
    }
    public String loadSharedPreferences(String key) {
        return sharedPreferencesDataSource.load(key);
    }
}
