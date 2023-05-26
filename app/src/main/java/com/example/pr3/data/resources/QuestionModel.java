package com.example.pr3.data.resources;

public class QuestionModel {

    private int id;
    private String question;

    public QuestionModel(int id, String question) {
        this.id = id;
        this.question = question;
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
}
