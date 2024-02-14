package com.NumberGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {

		System.out.println("Welcome to the number guessing game!");
		System.out.println();
		System.out.println("Let's play a Gussing Random Number game.  I'll pick a number between");
		System.out.println("1 and 100, and you try to guess it.");
		System.out.println();

		Scanner sc1 = new Scanner(System.in);
		boolean playAgain;
		do {
			playGame(); // call subroutine to play one game
			System.out.println("Would you like to play again?Y/N");
			String playAgainGame = sc1.next();
			playAgain = playAgainGame.equalsIgnoreCase("Y");
		} while (playAgain);
		System.out.println("Thanks for playing.Goodbye.");

	}

	static void playGame() {

		Random random = new Random();
		int randomNumber = random.nextInt(100) + 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("Guess a number between 1 and 100:");
		int guessCount = 0;
		boolean CorrectGusse = false;

		while (!CorrectGusse) {
			int GusseNumber = sc.nextInt();
			guessCount++;
			if (GusseNumber == randomNumber) {
				System.out.println("Congrtulation You are Won the Game...");
				System.out.println("You guessed the number correctly in " + guessCount + " attempts.");
				System.out.println("Your Gussing Number is Correct " + GusseNumber);
				CorrectGusse = true;
			} else if (GusseNumber > randomNumber) {
				if (GusseNumber - randomNumber >= 30) {
					System.out.println("Your guess is too high.");
				} else if (GusseNumber - randomNumber >= 7) {
					System.out.println("Your guess is quite high");
				} else {
					System.out.println("Your guess is high but very close.");
				}
			} else {
				if (randomNumber - GusseNumber >= 30) {
					System.out.println("Your guess is too low.");
				} else if (randomNumber - GusseNumber >= 7) {
					System.out.println("Your guess is quite low");
				} else {
					System.out.println("Your guess is low but very close.");
				}
			}

			if (guessCount == 10) {
				System.out.println();
				System.out.println("You didn't get the number in 6 guesses.");
				System.out.println("You lose.  My number was " + randomNumber);
				System.out.println();
				break;
			}

		}
	}
}
