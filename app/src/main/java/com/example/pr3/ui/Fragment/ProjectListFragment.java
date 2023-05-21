package com.example.pr3.ui.Fragment;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pr3.R;

public class ProjectListFragment extends Fragment {
    boolean project_change_status_window_opened;
    public ProjectListFragment() {
        super(R.layout.fragment_project_list);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        project_change_status_window_opened = false;
        LinearLayout linearLayout = view.findViewById(R.id.linear_layout_for_scroll_view);
        String[] project_names = new String[]{
                "s21_string+", "s21_math", "SimpleBashUtils",
                "s21_decimal", "s21_matrix", "Linux",
                "SmartCalc_v1.0", "SmartCalc_v2.0"};
        for(String project_name : project_names) {
            Button btn = new Button(getActivity());
            btn.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
            btn.setText(project_name);
            btn.getBackground().setColorFilter(getResources().getColor(R.color.dark_gray), PorterDuff.Mode.DARKEN);
            btn.setTextColor(getResources().getColor(R.color.white));
            linearLayout.addView(btn);
            btn.setOnClickListener(v -> {
                if (savedInstanceState == null && !project_change_status_window_opened) {
                    btn.getBackground().setColorFilter(getResources().getColor(R.color.dark_gray), PorterDuff.Mode.LIGHTEN);
                    btn.setTextColor(getResources().getColor(R.color.black));
                    getParentFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.project_change_status, ProjectSetStatusFragment.class, null)
                            .commit();
                    getParentFragmentManager().setFragmentResultListener("requestKey", this, (requestKey, bundle) -> {
                        switch (bundle.getInt("bundleKey")) {
                            case 0:
                                btn.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.DARKEN);
                                break;
                            case 1:
                                btn.getBackground().setColorFilter(getResources().getColor(R.color.green), PorterDuff.Mode.DARKEN);
                                break;
                            case 2:
                                btn.getBackground().setColorFilter(getResources().getColor(R.color.light_gray), PorterDuff.Mode.DARKEN);
                                break;
                            case 3:
                                btn.getBackground().setColorFilter(getResources().getColor(R.color.dark_gray), PorterDuff.Mode.DARKEN);
                                break;
                            default:
                                Toast.makeText(getActivity(), "unknown project state", Toast.LENGTH_LONG).show();
                                break;
                        }
                        btn.setTextColor(getResources().getColor(R.color.white));
                        project_change_status_window_opened = false;
                    });
                    project_change_status_window_opened = true;
                }
            });
        }
    }
}
