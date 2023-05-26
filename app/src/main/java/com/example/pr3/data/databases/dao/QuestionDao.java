package com.example.pr3.data.databases.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pr3.data.databases.entity.QuestionEntity;

import java.util.List;

@Dao
public interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(QuestionEntity questionEntity);

    @Query("DELETE FROM question_table")
    void deleteAll();

    @Query("SELECT * FROM question_table")
    LiveData<List<QuestionEntity>> getAllQuestions();
}
