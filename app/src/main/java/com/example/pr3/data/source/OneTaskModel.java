package com.example.pr3.data.source;

public class OneTaskModel {
    private final String answer;
    private final boolean correct;

    public OneTaskModel(String answer, boolean correct){
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect(){
        return correct;
    }
}
