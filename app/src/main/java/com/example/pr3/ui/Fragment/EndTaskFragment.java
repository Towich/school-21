package com.example.pr3.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pr3.R;


public class EndTaskFragment extends Fragment {

    TextView win_text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        win_text = view.findViewById(R.id.text_win_lose);

        boolean isWin = getArguments().getBoolean(OneTaskFragment.WIN_LOSE_KEY);

        if(!isWin){
            win_text.setText("Проигрыш!");
            win_text.setTextColor(getResources().getColor(R.color.red));
        }
    }
}