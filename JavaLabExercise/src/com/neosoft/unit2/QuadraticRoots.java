package com.neosoft.unit2;

import java.util.Scanner;
import java.lang.Math.*;

public class QuadraticRoots {
	
	static void calculateRoots(int a, int b, int c) {
		if(a == 0) {
			System.out.println("a cannot be zero");
			return;
		}
		double d = b*b - 4.0*a*c;
		if(d > 0.0) {
			double rt1 = ((-b + Math.pow(d, 0.5))/(2.0*a));
			double rt2 = ((-b - Math.pow(d, 0.5))/(2.0*a));
			System.out.println("Roots of Quadratic Equation are: "+rt1+" "+rt2);
		}
		else if(d == 0.0) {
			double rt1 = -b /(2.0*a);
			System.out.println("Root is: "+rt1);
		}
		else {
			System.out.println("Roots are not real");
		}
	}


	public static void main(String[] args) {
		int a,b,c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter values of a,b and c");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		calculateRoots(a, b, c);
	}

}
