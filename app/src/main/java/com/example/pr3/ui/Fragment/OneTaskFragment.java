package com.example.pr3.ui.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pr3.R;
import com.example.pr3.ui.ViewModel.OneTaskViewModel;

public class OneTaskFragment extends Fragment {

    public static final String WIN_LOSE_KEY = "WIN_LOSE_KEY";

    private OneTaskViewModel mViewModel;

    public static OneTaskFragment newInstance() {
        return new OneTaskFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(OneTaskViewModel.class);
        mViewModel.answer.observe(getViewLifecycleOwner(), answer -> {
//            Toast.makeText(getContext(), "EVENT!", Toast.LENGTH_SHORT).show();
        });

        // Getting all Buttons with answers
        Button[] answer_buttons = {
                view.findViewById(R.id.button_answer_1),
                view.findViewById(R.id.button_answer_2),
                view.findViewById(R.id.button_answer_3),
                view.findViewById(R.id.button_answer_4),
                view.findViewById(R.id.button_answer_5),
                view.findViewById(R.id.button_answer_6),
        };

        // Setting the answer's text of each button
        for (int i = 0; i < answer_buttons.length; i++){
            answer_buttons[i].setText(mViewModel.getAllAnswers()[i]);
        }

        for (Button btn : answer_buttons) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int currentAnswers = 0;

                    btn.setEnabled(false);

                    // получаем корректность ответа
                    boolean isCorrect = mViewModel.isCorrect(btn.getText().toString());

                    // устанавливаем цвет кнопки в зависимости от корректности ответа
                    btn.getBackground().setColorFilter(btn.getContext().getResources().
                            getColor(isCorrect ? R.color.green : R.color.red), PorterDuff.Mode.MULTIPLY);

                    // если ответ верен - увеличиваем кол-во всех ответов на 1 и получаем данное значение
                    if(isCorrect)
                        currentAnswers = mViewModel.addAndGetCorrectAnswers();

                    // если правильных ответов выбрано == 3 или был выбран один неправильный --> переходим на фрагмент %EndTastFragment%
                    if(currentAnswers == 3 || !isCorrect){
                        mViewModel.resetCorrectAnswers();
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(WIN_LOSE_KEY, isCorrect);
                        Navigation.findNavController(view).navigate(R.id.action_oneTaskFragment_to_endTaskFragment, bundle);
                    }
                }
            });
        }
    }
}