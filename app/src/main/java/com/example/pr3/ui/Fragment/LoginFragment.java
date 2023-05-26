package com.example.pr3.ui.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pr3.R;
import com.example.pr3.data.repository.LoginRepository;
import com.example.pr3.ui.ViewModel.LoginViewModel;

public class LoginFragment extends Fragment {

    LoginViewModel mViewModel;   // ViewModel

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        CreateAppSpecific();
        CreateSharedStorage();

        EditText login_edit_text = view.findViewById(R.id.login_edit_text);
        EditText password_edit_text = view.findViewById(R.id.password_edit_text);

        // App-Specific Storage

        // save button
        Button button_save_app_specific = view.findViewById(R.id.button_save_app_specific);
        button_save_app_specific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.saveDataAppSpecific(login_edit_text.getText().toString());
            }
        });

        // load button
        Button button_load_app_specific = view.findViewById(R.id.button_load_app_specific);
        button_load_app_specific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_edit_text.setText(mViewModel.loadDataAppSpecific());
            }
        });

        // Common Storage

        // save button
        Button button_save_common_storage = view.findViewById(R.id.button_save_common_storage);
        button_save_common_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.saveSharedStorage(password_edit_text.getText().toString());
            }
        });


        // load button
        Button button_load_common_storage = view.findViewById(R.id.button_load_common_storage);
        button_load_common_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password_edit_text.setText(mViewModel.loadSharedStorage());
            }
        });
    }

    private void CreateAppSpecific(){
        // Create App-Specific file
        mViewModel.createAppSpecific(getContext());
    }

    private void CreateSharedStorage(){
        // Gain permission for writing files in storage
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]
                    {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        // Create SharedStorage file
        mViewModel.createSharedStorage(getContext());
    }

    private void InitializeSharedPreferences(){
        mViewModel.createSharedPreferences(getContext());
    }
}
