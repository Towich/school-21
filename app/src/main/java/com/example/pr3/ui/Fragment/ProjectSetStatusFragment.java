package com.example.pr3.ui.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pr3.R;

public class ProjectSetStatusFragment extends Fragment {
    Button failBtn;
    Button successBtn;
    Button inProgressBtn;
    Button notStartedBtn;
    public ProjectSetStatusFragment() {
        super(R.layout.fragment_project_set_status);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        failBtn = getView().findViewById(R.id.failed_state_btn);
        successBtn = getView().findViewById(R.id.success_state_btn);
        inProgressBtn = getView().findViewById(R.id.in_progress_state_btn);
        notStartedBtn = getView().findViewById(R.id.not_started_state_btn);
        failBtn.setOnClickListener(v -> {
            Bundle result = new Bundle();
            result.putInt("bundleKey", 0);
            getParentFragmentManager().setFragmentResult("requestKey", result);
            getParentFragmentManager().beginTransaction().remove(ProjectSetStatusFragment.this).commit();
        });
        successBtn.setOnClickListener(v -> {
            Bundle result = new Bundle();
            result.putInt("bundleKey", 1);
            getParentFragmentManager().setFragmentResult("requestKey", result);
            getParentFragmentManager().beginTransaction().remove(ProjectSetStatusFragment.this).commit();
        });
        inProgressBtn.setOnClickListener(v -> {
            Bundle result = new Bundle();
            result.putInt("bundleKey", 2);
            getParentFragmentManager().setFragmentResult("requestKey", result);
            getParentFragmentManager().beginTransaction().remove(ProjectSetStatusFragment.this).commit();
        });
        notStartedBtn.setOnClickListener(v -> {
            Bundle result = new Bundle();
            result.putInt("bundleKey", 3);
            getParentFragmentManager().setFragmentResult("requestKey", result);
            getParentFragmentManager().beginTransaction().remove(ProjectSetStatusFragment.this).commit();
        });
    }
}
