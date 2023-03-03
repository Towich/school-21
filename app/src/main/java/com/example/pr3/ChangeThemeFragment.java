package com.example.pr3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class ChangeThemeFragment extends Fragment {
    private static final String TAG = "MyApp";
    SwitchMaterial dark_theme_switch;
    public ChangeThemeFragment() {
        super(R.layout.fragment_layout);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(), "onCreate!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreate!");
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "onCreateView!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreateView!");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getActivity(), "onViewCreated!", Toast.LENGTH_SHORT).show();
        dark_theme_switch = getView().findViewById(R.id.dark_theme_switch);
        dark_theme_switch.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            Bundle result = new Bundle();
            result.putBoolean("bundleKey", isChecked);
            getParentFragmentManager().setFragmentResult("requestKey", result);
        });
        Log.i(TAG, "onViewCreated!");
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Toast.makeText(getActivity(), "onViewStateRestored!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onViewStateRestored!");
    }
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity(), "onStart!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart!");
    }
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "onResume!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume!");
    }
    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "onPause!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause!");
    }
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "onStop!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStop!");
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getActivity(), "onSaveInstanceState!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSaveInstanceState!");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity(), "onDestroyView!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroyView!");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "onDestroy!", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroy!");
    }
}
