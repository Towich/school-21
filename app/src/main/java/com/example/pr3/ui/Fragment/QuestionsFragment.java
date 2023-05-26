package com.example.pr3.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pr3.R;
import com.example.pr3.data.databases.entity.QuestionEntity;
import com.example.pr3.ui.Adapter.QuestionRecyclerViewAdapter;
import com.example.pr3.ui.ViewModel.QuestionViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class QuestionsFragment extends Fragment {

    private QuestionViewModel mQuestionViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get result from NewQuestionFragment
        getParentFragmentManager().setFragmentResultListener(NewQuestionFragment.REPLY_NEW_QUESTION_FRAGMENT,
                this, (key, bundle) -> {

                    // Get name & price of new Perfume from NewQuestionFragment
                    String newQuestionString = bundle.getString(NewQuestionFragment.REPLY_QUESTION);

                    // Create new Entity and insert in Database
                    QuestionEntity perfumeEntity = new QuestionEntity(newQuestionString);
                    mQuestionViewModel.insert(perfumeEntity);
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_questions);
        final QuestionRecyclerViewAdapter adapter = new QuestionRecyclerViewAdapter(new QuestionRecyclerViewAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // FloatingActionButton
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(view1 -> {
            // Navigate to NewQuestion
            Navigation.findNavController(view1).navigate(R.id.action_questionsFragment_to_newQuestionFragment);
        });

        mQuestionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        // Update the cached copy of the words in the adapter.
        mQuestionViewModel.getAllQuestions().observe(getActivity(), adapter::submitList);
    }
}