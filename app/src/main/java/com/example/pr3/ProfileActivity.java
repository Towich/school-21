package com.example.pr3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_manager);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.branded_blue)));
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.project_list, ProjectListFragment.class, null)
                    .commit();
        }
    }
}