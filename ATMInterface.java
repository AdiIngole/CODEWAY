package com.ATM;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ATMInterface {

	static BankAccount account = new BankAccount();

	public static void main(String[] args) {

		boolean exitFlag = false;
		Scanner sc = new Scanner(System.in);
		try {
			while (!exitFlag) {
				System.out.println("Please choose below options: ");
				System.out.println("1. Deposite Money in your Bank Account: ");
				System.out.println("2. Withdraw Money From your Bank Account: ");
				System.out.println("3. Check Balance");
				System.out.println("4. Exit");
				int choice = sc.nextInt();

				switch (choice) {
				case 1: {
					System.out.println("Please Enter Ammount to be deposited: ");
					double depositeAmount = sc.nextDouble();
					if (depositeAmount > 0) {
						double updatedAmount = account.deposite(depositeAmount);
						System.out.println("Transaction succesfull! Updated balance is: " + updatedAmount);
					} else {
						System.out.println("Please Enter Valid Amount...You can not Enter Negative Amount");
						System.out.println("Please Try Again...");
					}
					break;
				}
				case 2: {
					System.out.println("Please Enter Ammount to withdraw: ");
					double withDrawAmount = sc.nextDouble();
					account.withdraw(withDrawAmount);
					break;
				}
				case 3: {
					System.out.println("Your account balance is: " + account.checkBalance());
					break;
				}
				case 4: {
					System.out.println("Closing Application. Thank you !!!");
					exitFlag = true;
					System.exit(0);
					break;
				}
				default:
					System.out.println("Please enter values between 1 to 4 to proceed.");
				}
				System.out.println("");
			}
		} catch (NoSuchElementException e) {
			System.out.println("You Terminated The Program...");
		} finally {
			sc.close();
		}
	}

}
