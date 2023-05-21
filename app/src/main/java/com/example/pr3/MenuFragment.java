package com.example.pr3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MenuFragment extends Fragment {

    public static final String KEY_TRANSFER_FROM_MENU = "KEY_TRANSFER_FROM_MENU";
    EditText menu_edit_text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menu_edit_text = view.findViewById(R.id.menu_edit_text);

        Button button_to_tasks = view.findViewById(R.id.button_to_tasks);
        button_to_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tasksToShow = Integer.parseInt(menu_edit_text.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putInt(KEY_TRANSFER_FROM_MENU, tasksToShow);
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_tasksFragment, bundle);
            }
        });

        Button button_to_tests = view.findViewById(R.id.button_to_tests);
        button_to_tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int testsToShow = Integer.parseInt(menu_edit_text.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putInt(KEY_TRANSFER_FROM_MENU, testsToShow);
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_testsFragment, bundle);
            }
        });
    }
}