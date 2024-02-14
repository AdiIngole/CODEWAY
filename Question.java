package com.Quiz;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Question {
	private String questionText;
    private List<String> options;
    private char correctAnswer;
    private int timeLimitSeconds;
    private boolean answered;
    private Timer timer;

    public Question(String questionText, List<String> options, char correctAnswer, int timeLimitSeconds) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.timeLimitSeconds = timeLimitSeconds;
        this.answered = false;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public int getTimeLimitSeconds() {
        return timeLimitSeconds;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! The correct answer is " + correctAnswer);
                timer.cancel();
                answered = true; // Marking question as answered when time's up
            }
        }, timeLimitSeconds * 2000);
    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }
}
