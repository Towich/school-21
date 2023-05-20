package com.example.pr3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TasksFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> items = new ArrayList<>();

        for(int i = 1; i < 300; i++){
            items.add("[" + i + "] Task");
        }

        MyCustomListViewAdapter listViewAdapter = new MyCustomListViewAdapter(
                getActivity(), R.layout.list_item, items);

        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(listViewAdapter);
    }
}