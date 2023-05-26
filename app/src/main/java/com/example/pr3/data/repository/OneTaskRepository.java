package com.example.pr3.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.pr3.data.source.OneTaskDataSource;
import com.example.pr3.data.resources.OneTaskModel;

public class OneTaskRepository {
    public MutableLiveData<OneTaskModel> getAnswer(int index){
        return OneTaskDataSource.createAnswer(index);
    }

    public String[] getAllAnswers(){
        return OneTaskDataSource.getAnswers();
    }

    public boolean getAnswerCorrect(int index){
        return OneTaskDataSource.getAnswerCorrent(index);
    }
}
