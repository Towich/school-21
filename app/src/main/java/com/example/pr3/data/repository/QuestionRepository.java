package com.example.pr3.data.repository;

import android.app.Application;
import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.pr3.data.databases.dao.QuestionDao;
import com.example.pr3.data.databases.entity.QuestionEntity;
import com.example.pr3.data.databases.roomDatabase.QuestionDatabase;
import com.example.pr3.data.resources.QuestionModel;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionRepository {
    private QuestionDao questionDao;

    private LiveData<List<QuestionModel>> mAllQuestions;

    public QuestionRepository(Application application){
        QuestionDatabase db = QuestionDatabase.getDatabase(application);
        QuestionDao mDao = db.questionDao();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mAllQuestions = Transformations.map(mDao.getAllQuestions(), entities -> entities.stream()
                    .map(QuestionEntity::toModel).collect(Collectors.toList()));
        }
    }

    public LiveData<List<QuestionModel>> getAllQuestions() { return mAllQuestions; }

    public void insert(QuestionEntity newEntity){
        QuestionDatabase.databaseWriteExecutor.execute(() -> {
            questionDao.insert(newEntity);
        });

    }
}
