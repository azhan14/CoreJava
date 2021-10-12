package com.neosoft.lab;

public class ToTestInt {

	public static void main(String[] args) {
		Arithmetic ar = new Arithmetic(8);
		System.out.println("Square of 8 is: "+ar.square());
	}

}

interface Test{
	int square();
}

class Arithmetic implements Test{
	int x;
	public Arithmetic(int x) {
		this.x = x;
	}
	
	@Override
	public int square() {
		return x*x;
	}
	
}