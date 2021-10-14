package com.neosoft.lab;

public class Number {
	private double a;
	
	
	public Number(double a) {
		this.a = a;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public static void main(String[] args) {
		Number obj = new Number(153);
		System.out.println("Number: "+obj.getA());
		System.out.println("Is Zero : "+obj.isZero());
		System.out.println("Is Positive : "+obj.isPositive());
		System.out.println("Is Negative : "+obj.isNegative());
		System.out.println("Is Odd : "+obj.isOdd());
		System.out.println("Is Even : "+obj.isEven());
		System.out.println("Is Prime : "+obj.isPrime());
		System.out.println("Is Armstrong : "+obj.isArmstrong());
		System.out.println("factorial : "+obj.getFactorial());
		System.out.println("Square root : "+obj.getSqrt());
		System.out.println("Square : "+obj.getSqr());
		System.out.println("Sum of Digits : "+obj.sumDigits());
		System.out.println("Reverse of Number : "+obj.getReverse());
		obj.listFactor();
		System.out.println("");
		obj.dispBinary();
//		System.out.println(obj.getFactorial());
	}
	
	public boolean isZero() {
		if(a == 0.0)
			return true;
		return false;
	}
	
	public boolean isPositive() {
		if(a > 0.0) 
			return true;
		return false;
	}
	
	public boolean isNegative() {
		if(a < 0.0) 
			return true;
		return false;
	}
	
	public boolean isOdd() {
		if(a%2 != 0.0) 
			return true;
		return false;
	}
	
	public boolean isEven() {
		if(a%2 == 0.0) 
			return true;
		return false;
	}
	
	public boolean isPrime() {
		for(int j = 2; j < a; j++) {
			if(a%j == 0.0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isArmstrong() {
		int a_copy = (int)a;
		double res = 0;
		while(a_copy != 0) {
			int d = a_copy % 10;
			res += d*d*d;
			a_copy /= 10;
		}
		if(res == a)
			return true;
		return false;
	}
	
	public double getFactorial() {
		double fact = 1;
		for(int i = 1; i <= a; i++) {
			fact = fact*i;
		}
		return fact;
	}
	
	public double getSqrt() {
		double t;
		double sqroot = a / 2;
		do {
			t = sqroot;
			sqroot = (t+(a/t))/2;
		}while((t-sqroot)!=0);
		return sqroot;
	}
	
	public double getSqr() {
		return a*a;
	}
	
	public double sumDigits() {
		double a1 = a;
		double sum = 0;
		while(a1 != 0) {
			int temp = (int) (a1 % 10);
			sum += temp;
			a1 = a1/10;
		}
		return sum;
	}
	
	public double getReverse() {
		int a1 = (int)a;
		int rev = 0;
		while(a1 != 0) {
			int temp = a1 % 10;
			rev = rev*10 + temp;
			a1 = a1/10;
		}
		return rev;
	}
	
	void listFactor() {
		for(int i = 1; i < a; i++) {
			if(a%i == 0) {
				System.out.print(i+" ");
			}
		}
	}
	
	void dispBinary() {
		System.out.println("Binary Value of "+a+" : "+Long.toBinaryString((long) a));
	}
}
