package com.example.pr3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class ChangeThemeFragment extends Fragment {
    SwitchMaterial dark_theme_switch;
    public ChangeThemeFragment() {
        super(R.layout.fragment_layout);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dark_theme_switch = getView().findViewById(R.id.dark_theme_switch);
        dark_theme_switch.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            Bundle result = new Bundle();
            result.putBoolean("bundleKey", isChecked);
            getParentFragmentManager().setFragmentResult("requestKey", result);
        });
    }
}
