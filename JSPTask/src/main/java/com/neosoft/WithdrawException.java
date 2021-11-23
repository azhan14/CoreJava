package com.neosoft;

public class WithdrawException extends Exception{
	String msg;
	public WithdrawException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "My Exception : "+msg;
	}
}
