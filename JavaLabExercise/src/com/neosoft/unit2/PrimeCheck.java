package com.neosoft.unit2;

import java.util.Scanner;

public class PrimeCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		int flag = 0;
		
		for(int i = n/2;i >= 2;i--) {
			if(n%i == 0) {
				flag = 1;
				break;
			}
		}
		if(flag == 1) {
			System.out.println(n+" is not a prime number");
		}
		else {
			System.out.println(n+" is a prime number");
		}
		sc.close();
	}

}
