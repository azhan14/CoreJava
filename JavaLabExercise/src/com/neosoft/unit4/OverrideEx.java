package com.neosoft.unit4;

public class OverrideEx {

	public static void main(String[] args) {
		SC s = new SC();
		HDFC h = new HDFC();
		System.out.println("ROI of SC: "+s.ROI());
		System.out.println("ROI of HDFC: "+h.ROI());
	}

}

//Parent class
class Bank{
	int ROI() {
		return 0;
	}
}

//Child class
class SC extends Bank{
	//method overriden
	int ROI() {
		return 7;
	}
}

//Child class
class HDFC extends Bank{
	//method overriden
	int ROI() {
		return 5;
	}
}