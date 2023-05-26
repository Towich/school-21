package com.example.pr3.ui.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pr3.data.databases.entity.QuestionEntity;
import com.example.pr3.data.repository.QuestionRepository;
import com.example.pr3.data.resources.QuestionModel;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {
    private QuestionRepository mQuestionRepository;
    private final LiveData<List<QuestionModel>> mAllQuestions;

    public QuestionViewModel(Application application){
        super(application);
        mQuestionRepository = new QuestionRepository(application);
        mAllQuestions = mQuestionRepository.getAllQuestions();
    }

    public LiveData<List<QuestionModel>> getAllQuestions() { return mAllQuestions; }
    public void insert(QuestionEntity questionEntity){
        mQuestionRepository.insert(questionEntity);
    }

}
