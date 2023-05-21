package com.example.pr3.ui.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.example.pr3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.menuFragment);
//        bottomNav.setOnItemSelectedListener(item -> {
//            Fragment selectedFragment = null;
//            int itemId = item.getItemId();
//            if (itemId == R.id.tasksFragment) {
//                selectedFragment = new TasksFragment();
//            } else if (itemId == R.id.testsFragment) {
//                selectedFragment = new TestsFragment();
//            } else if (itemId == R.id.menuFragment) {
//                selectedFragment = new MenuFragment();
//            }
//            // It will help to replace the
//            // one fragment to other.
//            if (selectedFragment != null) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, selectedFragment).commit();
//            }
//            return true;
//        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

//    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
//        // By using switch we can easily get
//        // the selected fragment
//        // by using there id.
//        Fragment selectedFragment = null;
//        int itemId = item.getItemId();
//        if (itemId == R.id.tasksFragment) {
//            selectedFragment = new TasksFragment();
//        } else if (itemId == R.id.testsFragment) {
//            selectedFragment = new TestsFragment();
//        } else if (itemId == R.id.menuFragment) {
//            selectedFragment = new MenuFragment();
//        }
//        // It will help to replace the
//        // one fragment to other.
//        if (selectedFragment != null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, selectedFragment).commit();
//        }
//        return true;
//    };
}