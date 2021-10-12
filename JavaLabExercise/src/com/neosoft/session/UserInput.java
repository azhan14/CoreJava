package com.neosoft.session;

import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		int n_copy = n;
		int rev = 0;
		while(n_copy != 0) {
			int d = n_copy%10;
			rev = rev*10 + d;
			n_copy /= 10;
		}
		if(n == rev) {
			System.out.println("Pallindrome");
		}
		else {
			System.out.println("Not Pallindrome.");
		}
		
		System.out.println("=====================================================");
		System.out.println("Enter number of rows: ");
		int row = sc.nextInt();
		int val = 1;
		for(int i = 1; i <= row; i++) {
			for(int k = 0; k < row-i;k++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i;j++) {
				System.out.print(val+" ");
				val++;
			}
			System.out.println(" ");
		}
		
		System.out.println("=====================================================");
		System.out.println("Enter 5 numbers: ");
		int[] arr = new int[5];
		for(int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
//		int temp = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = i+1; j < arr.length; j++) {
//				if(arr[i]>arr[j]) {
//					temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
		int max = arr[0];
		int min = arr[0];
		int maxIndex = 0;
		int minIndex = 0;
		for(int i = 1; i < 5; i++) {
			if(arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
			if(arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		arr[minIndex] = max;
		arr[maxIndex] = min;
		System.out.println("\nModified array: ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
