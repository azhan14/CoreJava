package com.neosoft.unit5;


public class AbstractEx {

	public static void main(String[] args) {
		Bank b;
		b = new SC();
		System.out.println("ROI of SC: "+b.ROI());
		b = new HDFC();
		System.out.println("ROI of HDFC: "+b.ROI());

	}

}


// Abstract class
abstract class Bank{
	abstract int ROI();
}

// Class extending abstract class
class SC extends Bank{
	// Abstract Method definition
	int ROI() {
		return 7;
	}
}

// Class extending abstract class
class HDFC extends Bank{
	// Abstract Method definition
	int ROI() {
		return 5;
	}
}