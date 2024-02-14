package com.GradeCalculator;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
		int numberOfSubject, i;
		int TotalSumOfMarks = 0;
		double percentage;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the No of Subject .");
		numberOfSubject = sc.nextInt();

		int marks[] = new int[numberOfSubject];
		for (i = 0; i < numberOfSubject; i++) {
			System.out.println("Enter marks for Subject " + (i + 1));
			marks[i] = sc.nextInt();
			TotalSumOfMarks = TotalSumOfMarks + marks[i];
		}

		percentage = TotalSumOfMarks / numberOfSubject;

		if (percentage < 0) {
			System.out.println("Error: Total Percentage cannot be negative.");
			return;
		}

		System.out.println("Sum of all subjects Marks is : " + TotalSumOfMarks);
		System.out.println("Average Percentage of All Subject is : " + percentage);

		if (percentage < 40) {
			System.out.println("Student Grade: Failed");
		} else if (percentage >= 40 && percentage < 60) {
			System.out.println("Student Grade: C");
		} else if (percentage >= 60 && percentage < 80) {
			System.out.println("Student Grade: B");
		} else if (percentage >= 80 && percentage <= 100) {
			System.out.println("Student Grade: A");
		} else {
			System.out.println("Invalid Marks. Please enter valid marks.");
		}
	}

}
