package com.neosoft.unit2;

import java.util.Scanner;

public class SumDigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		int d = 0;
		int sum = 0;
		while(n!=0) {
			d = n%10;
			sum = sum + d;
			n = n/10;
		}
		System.out.println("Sum of the digits are: "+sum);
		sc.close();

	}

}
