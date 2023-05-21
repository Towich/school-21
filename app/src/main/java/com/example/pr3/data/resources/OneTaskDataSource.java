package com.example.pr3.data.resources;

import androidx.lifecycle.MutableLiveData;

import com.example.pr3.data.source.OneTaskModel;

import java.util.ArrayList;
import java.util.List;

public class OneTaskDataSource {

    static final String[] answers = {"Adapter", "View", "Provider", "Presenter", "Model", "ViewModel"};
    static final boolean allCorrects[] = {false, true, false, false, true, true};

    public static MutableLiveData<OneTaskModel> createAnswer(int index){
        MutableLiveData<OneTaskModel> answer = new MutableLiveData<>();

        ArrayList<OneTaskModel> oneTaskModels = new ArrayList<>();

        for(int i = 0; i < answers.length; i++){
            oneTaskModels.add(new OneTaskModel(answers[i], allCorrects[i]));
        }

        answer.setValue(oneTaskModels.get(index));
        return answer;
    }

    public static String[] getAnswers(){
        return answers;
    }

    public static boolean getAnswerCorrent(int index){
        return allCorrects[index];
    }

}
