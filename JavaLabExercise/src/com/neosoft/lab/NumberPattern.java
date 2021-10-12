package com.neosoft.lab;

public class NumberPattern {

	public static void main(String[] args) {
		System.out.println("loop 1");
		for(int i = 0; i<5;i++) {
			System.out.print("1");
			for(int j=0;j < (i*2)-1;j++) {
				System.out.print(" 0");
			}
			if(i > 0) {
				System.out.print(" 1");
			}
			System.out.println("");
		}
		System.out.println("====================");
		
		for(int i = 5; i >= 0; i--) {
			for(int j = i; j <= 5; j++ ) {
				System.out.print(j);
				System.out.print(" ");
			}
			System.out.println("");
		}
		
		System.out.println("====================");
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <=i;j++) {
				System.out.print(j);
				System.out.print(" ");
			}
			System.out.println("");
		}	
	}
}
