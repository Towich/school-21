package com.example.pr3.ui.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pr3.data.repository.OneTaskRepository;
import com.example.pr3.data.source.OneTaskModel;

import java.util.List;

public class OneTaskViewModel extends ViewModel {
    private int correct_answers;
    private OneTaskRepository mOneTaskRepository;
    public MutableLiveData<OneTaskModel> answer;
    public OneTaskViewModel(){
        correct_answers = 0;
        mOneTaskRepository = new OneTaskRepository();
        answer = mOneTaskRepository.getAnswer(0);
    }
    public OneTaskModel getTaskModel(){
        return answer.getValue();
    }
    public String getAnswer(){
        return answer.getValue().getAnswer();
    }
    public boolean isCorrect(){
        return answer.getValue().isCorrect();
    }

    public boolean isCorrect(String answer_text){
        String[] allAnswers = mOneTaskRepository.getAllAnswers();

        for (int i = 0; i < allAnswers.length; i++) {
            if(allAnswers[i].equals(answer_text)){
                return mOneTaskRepository.getAnswerCorrect(i);
            }
        }

        return false;
    }
    public String[] getAllAnswers(){
        return mOneTaskRepository.getAllAnswers();
    }
    public int addAndGetCorrectAnswers() {
        return ++correct_answers;
    }
    public void resetCorrectAnswers(){
        correct_answers = 0;
    }
}