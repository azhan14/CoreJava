package com.neosoft.lab;

public class StringCompare {

	public static void main(String[] args) {
		String s1 = "Azhan";	// s1 and s2 are equal
		String s2 = "Azhan";
		String s3 = "patel";	//s3 and s4 are not equal since p is capital in s4
		String s4 = "Patel";
		
		StringCompare stcomp = new StringCompare();
		
		//using .equals
		System.out.println("Using equals() method:");
		stcomp.usingEquals(s1, s2);
		stcomp.usingEquals(s3, s4);
		stcomp.usingEquals(s1, s3);
		stcomp.usingEquals(s2, s4);
		
		System.out.println("======================");
		
		//using == operator
		System.out.println("Using == Operator:");
		stcomp.usingEqualToOperator(s1, s2);
		stcomp.usingEqualToOperator(s3, s4);
		stcomp.usingEqualToOperator(s1, s3);
		stcomp.usingEqualToOperator(s2, s4);
		
		System.out.println("======================");
		
		//using compareTo() operator
		System.out.println("Using compareTo() Method:");
		stcomp.usingCompareTo(s1, s2);
		stcomp.usingCompareTo(s3, s4);
		stcomp.usingCompareTo(s1, s3);
		stcomp.usingCompareTo(s2, s4);
		
		System.out.println("======================");
		
	}

	void usingEquals(String s1, String s2) {
		if(s1.equals(s2)) {		//returns true if equal else return false
			System.out.println(s1 +" Equals "+s2);
		}
		else {
			System.out.println(s1 +" Not Equals "+s2);
		}
	}
	
	void usingEqualToOperator(String s1, String s2) {
		if(s1 == s2) {			//returns true if equal else return false
			System.out.println(s1 +" Equals "+s2);
		}
		else {
			System.out.println(s1 +" Not Equals "+s2);
		}
	}
	
	void usingCompareTo(String s1, String s2) {
		if(s1.compareTo(s2) == 0) {			//returns 0 if equal else if s1>s2 return positive else if s1<s2 return negative value
			System.out.println(s1 +" Equals "+s2+" CompareTo value: "+s1.compareTo(s2));
		}
		else {
			System.out.println(s1 +" Not Equals "+s2+" CompareTo value: "+s1.compareTo(s2));
		}
		
	}
}
