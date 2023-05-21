package com.example.pr3.ui.Fragment;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pr3.R;
import com.example.pr3.ui.Fragment.ProjectSetStatusFragment;

public class ProjectsFragment extends Fragment {

    boolean project_change_status_window_opened;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        project_change_status_window_opened = false;

        Button[] project_buttons = new Button[]{
                view.findViewById(R.id.button_set_status_android),
                view.findViewById(R.id.button_set_status_python),
                view.findViewById(R.id.button_set_status_java),
        };

        for (Button b : project_buttons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (savedInstanceState == null && !project_change_status_window_opened) {
                        b.getBackground().setColorFilter(getResources().getColor(R.color.dark_gray), PorterDuff.Mode.LIGHTEN);
                        b.setTextColor(getResources().getColor(R.color.black));
                        getParentFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .add(R.id.project_change_status, ProjectSetStatusFragment.class, null)
                                .commit();
                        getParentFragmentManager().setFragmentResultListener("requestKey", getViewLifecycleOwner(), (requestKey, bundle) -> {
                            switch (bundle.getInt("bundleKey")) {
                                case 0:
                                    b.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.DARKEN);
                                    break;
                                case 1:
                                    b.getBackground().setColorFilter(getResources().getColor(R.color.green), PorterDuff.Mode.DARKEN);
                                    break;
                                case 2:
                                    b.getBackground().setColorFilter(getResources().getColor(R.color.light_gray), PorterDuff.Mode.DARKEN);
                                    break;
                                case 3:
                                    b.getBackground().setColorFilter(getResources().getColor(R.color.dark_gray), PorterDuff.Mode.DARKEN);
                                    break;
                                default:
                                    Toast.makeText(getActivity(), "unknown project state", Toast.LENGTH_LONG).show();
                                    break;
                            }
                            b.setTextColor(getResources().getColor(R.color.white));
                            project_change_status_window_opened = false;
                        });
                        project_change_status_window_opened = true;
                    }
                }
            });
        }
    }
}