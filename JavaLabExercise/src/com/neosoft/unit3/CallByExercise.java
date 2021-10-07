package com.neosoft.unit3;

public class CallByExercise {
	public int x = 10;
	
	public static void main(String[] args) {
		int a = 10;
		CallByValue cbv = new CallByValue();
		System.out.println("Call By Value Exercise.");
		System.out.println("value of a outside function: "+a);
		cbv.Increment(a);
		System.out.println("Value of a outside function after increment: "+a);
		System.out.println("=================================================");
		
		System.out.println("Call By Reference Exercise.");
		CallByExercise cbe = new CallByExercise();
		System.out.println("value of x outside function: "+cbe.x);
		cbe.RefIncrement(cbe);
		System.out.println("Value of x outside function after increment: "+cbe.x);
		
		
	}
	
	void RefIncrement(CallByExercise cbe) {
		System.out.println("value of x inside function: "+cbe.x);
		cbe.x++;
		System.out.println("Value of x inside function after increment: "+cbe.x);
	}

}

class CallByValue{
	void Increment(int a) {
		System.out.println("value of a inside function: "+a);
		a++;
		System.out.println("Value of a inside function after increment: "+a);
	}
}