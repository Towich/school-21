package com.example.pr3.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pr3.ui.Adapter.MyCustomRecyclerViewAdapter;
import com.example.pr3.R;

import java.util.ArrayList;
import java.util.List;

public class TestsFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tests, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int args = getArguments().getInt(MenuFragment.KEY_TRANSFER_FROM_MENU);


        List<String> items = new ArrayList<>();

        for(int i = 1; i <= args; i++){
            items.add("[" + i + "] Test");
        }

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        MyCustomRecyclerViewAdapter myCustomRecyclerViewAdapter = new MyCustomRecyclerViewAdapter(getContext(), items);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myCustomRecyclerViewAdapter);
    }
}