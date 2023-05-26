package com.example.pr3.data.databases.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.pr3.data.resources.QuestionModel;

@Entity(tableName = "question_table")
public class QuestionEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String question;

    public QuestionEntity(String question) {
        this.question = question;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionModel toModel(){
        return new QuestionModel(id, question);
    }
}
