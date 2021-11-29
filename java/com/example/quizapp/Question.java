package com.example.quizapp;

public class Question {
    private int answerResId;


    private boolean answerTrue;

    public Question(int answerResId, boolean answerTrue) {
        // arvojen asettaminen
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    // palauttaa kysymyksen
    public int getAnswerResId() {
        return answerResId;
    }

    //
    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    // palauttaa oikean vastauksen
    public boolean isAnswerTrue() {
        return answerTrue;
    }

    //
    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}

