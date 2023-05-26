package com.example.pr3.ui.Fragment;

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

import com.example.pr3.R;


public class NewQuestionFragment extends Fragment {

    public static final String REPLY_NEW_QUESTION_FRAGMENT = "REPLY_NEW_QUESTION";

    public static final String REPLY_QUESTION = "REPLY_QUESTION";

    private EditText mEditTextQuestion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditTextQuestion = view.findViewById(R.id.edit_text_new_question);

        final Button button = view.findViewById(R.id.button_save_question);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();

                String resultQuestion = mEditTextQuestion.getText().toString();

                result.putString(REPLY_QUESTION, resultQuestion);

                getParentFragmentManager().setFragmentResult(REPLY_NEW_QUESTION_FRAGMENT, result);
                Navigation.findNavController(view).navigate(R.id.action_newQuestionFragment_to_questionsFragment);
            }
        });

    }
}