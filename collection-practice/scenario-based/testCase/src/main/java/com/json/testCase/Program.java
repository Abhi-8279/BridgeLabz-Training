package com.json.testCase;

public class Program {
	private double balance;
	
	public Program(double initialBalance) {
		this.balance = initialBalance;
	}
	public void deposit(double amount) {
		if(amount <= 0) {
			throw new RuntimeException("Deposit amount cannot be negative");
		}
		balance = balance + amount;
	}
	public void withdraw(double amount) {
		if(amount > balance) {
			throw new RuntimeException("Insufficient funds");
		}else if(amount <= balance) {
			balance = balance - amount;
		}
	}
	public double getBalance() {
		return balance;
	}

}
