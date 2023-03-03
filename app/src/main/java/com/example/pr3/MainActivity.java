package com.example.pr3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView startup_page_text_view;
    Button enter_system_btn;
    ImageView startup_logo;
    EditText login_edit_text;
    boolean dark_theme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dark_theme = false;
        startup_logo = findViewById(R.id.image_view);
        enter_system_btn = findViewById(R.id.button);
        startup_page_text_view = findViewById(R.id.text_view);
        login_edit_text = findViewById(R.id.login_edit_text);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.change_theme_fragment, ChangeThemeFragment.class, null)
                    .commit();
        }
        getSupportFragmentManager().setFragmentResultListener("requestKey",
                this, (requestKey, bundle) -> {
            dark_theme = bundle.getBoolean("bundleKey");
            if (dark_theme) {
                startup_logo.setImageResource(R.drawable.s21_vector_logo);
                enter_system_btn.setBackgroundColor(getResources().getColor(R.color.black));
            } else {
                startup_logo.setImageResource(R.drawable.s21_logo);
                setTheme(R.style.Theme_PR3);
                enter_system_btn.setBackgroundColor(getResources().getColor(R.color.purple_500));
            }
        });
    }
}