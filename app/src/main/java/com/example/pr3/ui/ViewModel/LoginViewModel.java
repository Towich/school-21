package com.example.pr3.ui.ViewModel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.pr3.data.repository.LoginRepository;
import com.example.pr3.data.source.SharedPreferencesDataSource;

public class LoginViewModel extends ViewModel {
    private final LoginRepository repository;   // Repository

    public LoginViewModel(){
        repository = new LoginRepository();
    }

    // #1 App-specific storage
    public void createAppSpecific(Context context){
        repository.createFileAppSpecific(context);
    }
    public void saveDataAppSpecific(String dataToSave){
        repository.saveAppSpecific(dataToSave);
    }
    public String loadDataAppSpecific(){
        return repository.loadAppSpecific();
    }

    // #2 SharedStorage
    public void createSharedStorage(Context context){
        repository.createFileSharedStorage(context);
    }
    public void saveSharedStorage(String dataToSave){
        repository.saveSharedStorage(dataToSave);
    }
    public String loadSharedStorage(){
        return repository.loadSharedStorage();
    }

    // #3 SharedPreferences
    public void createSharedPreferences(Context context) {
        repository.createSharedPreferences(context);
    }
    public void saveSharedPreferences(String key, String dataToSave) {
        repository.saveSharedPreferences(key, dataToSave);
    }
    public String loadSharedPreferences(String key) {
        return repository.loadSharedPreferences(key);
    }

}
