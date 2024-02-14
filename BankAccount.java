package com.ATM;

public class BankAccount {
	private double currentBalance = 10000;

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double deposite(double amount) {
		double updatedBalance = currentBalance + amount;
		setCurrentBalance(updatedBalance);
		return updatedBalance;
	}

	public void withdraw(double amount) {
		if (currentBalance < amount) {
			System.out.println("Insufficient Funds !!! Your current balance is: " + currentBalance);
		} else {
			double updatedBalance = currentBalance - amount;
			setCurrentBalance(updatedBalance);
			System.out.println("Your account balance is: " + updatedBalance);
		}
	}

	public double checkBalance() {

		return currentBalance;
	}
}
