package com.example.pr3.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pr3.R;

public class ExternalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        Intent intent = getIntent();

        if(intent.getType().equals("text/plain")){
            String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView text_view_external = findViewById(R.id.text_view_external);
            text_view_external.setText(sharedText);
        }
    }
}