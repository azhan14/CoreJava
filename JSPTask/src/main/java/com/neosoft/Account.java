package com.neosoft;

public class Account {
	public static int acc_balance = 25000;
	public static void withdraw(int amount) throws WithdrawException{
		if(amount > acc_balance) {
			throw new WithdrawException("cannot withdraw as balance is less : "+acc_balance);
		}
		else {
			acc_balance -= amount;
		}
	}
	public static int showBalance() {
		return acc_balance;
	}
}
