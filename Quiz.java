package com.Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quiz {
	private List<Question> questions;
    private Scanner scanner;
    private int score;
    private int correctAnswers;
    private int incorrectAnswers;
    private int currentQuestionIndex;

    public Quiz() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
        score = 0;
        correctAnswers = 0;
        incorrectAnswers = 0;
        currentQuestionIndex = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getScore() {
        return score;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Creating and adding questions
        List<String> options1 = Arrays.asList("A. 6", "B. 7", "C. 8", "D. 9");
        Question question1 = new Question("Question 1: Number of primitive data types in Java are? ", options1, 'C', 10);

        List<String> options2 = Arrays.asList("A. 32 & 64", "B. 32  & 32", "C. 64 & 64", "D. 64 & 32");
        Question question2 = new Question("Question 2: What is the size of float and double in java?", options2, 'A', 10);

        List<String> options3 = Arrays.asList("A. char[] ch=new char(5);", "B.  char[] ch=new char[5];", "C.  char[] ch=new char[];", "D.  char[] ch=new char();");
        Question question3 = new Question("Question 3: Select the valid statement.", options3, 'B', 10); 

        // Adding questions to quiz
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);

        // Displaying and handling questions one by one
        for (Question question : quiz.getQuestions()) {
            System.out.println(question.getQuestionText());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }
            question.startTimer(); // Start timer for the question
            String userAnswer = "";
            while (!question.isAnswered()) {
                System.out.print("Your answer (A, B, C, or D): ");
                userAnswer = quiz.scanner.nextLine().toUpperCase();
                if (userAnswer.length() == 1 && "ABCD".contains(userAnswer)) {
                    break;
                }
                System.out.println("Invalid input. Please select one of the options.");
            }
            question.stopTimer(); // Stop timer for the question
            if (!question.isAnswered()) {
                if (userAnswer.charAt(0) == question.getCorrectAnswer()) {
                    System.out.println("Correct!");
                    quiz.score++; // Increment score for correct answer
                    quiz.correctAnswers++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer());
                    quiz.incorrectAnswers++;
                }
            }
            System.out.println();
        }

        // Displaying result screen
        System.out.println("Quiz finished!");
        System.out.println("Your final score: " + quiz.getScore() + "/" + quiz.getQuestions().size());
        System.out.println("Correct Answers: " + quiz.getCorrectAnswers());
        System.out.println("Incorrect Answers: " + quiz.getIncorrectAnswers());

        quiz.scanner.close();
    }
}
