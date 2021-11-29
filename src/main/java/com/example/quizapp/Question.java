package com.example.quizapp;

public class Question {
    private int answerResId;


    private boolean answerTrue;

    public Question(int answerResId, boolean answerTrue) {
        // setting the values through
        // arguments passed in constructor
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    // returning the question passed
    public int getAnswerResId() {
        return answerResId;
    }

    // setting the question passed
    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    // returning the correct answer
    // of question
    public boolean isAnswerTrue() {
        return answerTrue;
    }

    // setting the correct
    // answer of question
    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}

