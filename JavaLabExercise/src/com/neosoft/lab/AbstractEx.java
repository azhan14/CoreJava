package com.neosoft.lab;


public class AbstractEx {

	public static void main(String[] args) {
		Bank1 b;
		b = new SC1();
		System.out.println("ROI of SC: "+b.ROI());
		b = new HDFC1();
		System.out.println("ROI of HDFC: "+b.ROI());

	}

}


// Abstract class
abstract class Bank1{
	abstract int ROI();
}

// Class extending abstract class
class SC1 extends Bank1{
	// Abstract Method definition
	int ROI() {
		return 7;
	}
}

// Class extending abstract class
class HDFC1 extends Bank1{
	// Abstract Method definition
	int ROI() {
		return 5;
	}
}