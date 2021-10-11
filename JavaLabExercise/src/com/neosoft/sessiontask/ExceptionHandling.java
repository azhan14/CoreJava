package com.neosoft.sessiontask;

public class ExceptionHandling {
	public static void main(String[] args) throws WithdrawException {
		Account ac = new Account(25000);
//		ac.Withdraw(30000);
		ac.Withdraw(20000);
		ac.showBalance();
		ac.Withdraw(10000);
		ac.showBalance();
	}

}

class Account {
	private int acc_balance = 0;

	public Account(int acc_balance) {
		this.acc_balance = acc_balance;
	}
	
	void Withdraw(int amt) throws WithdrawException {
		if(amt > acc_balance) {
			throw new WithdrawException("Exception --> Insufficient Balance.");
		}
		else {
			System.out.println("Amount Withdrawn: "+amt);
			acc_balance -= amt;
		}
	}
	
	void showBalance() {
		System.out.println("Balance: "+acc_balance);
	}
	
}

class WithdrawException extends Exception{
	public WithdrawException(String str) {
		super(str);
	}
}