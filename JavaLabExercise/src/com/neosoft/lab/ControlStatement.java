package com.neosoft.lab;

public class ControlStatement {

	public static void main(String[] args) {
		int x = 10, y = 14;
		//if statement
		System.out.println("if Example");
		if((x+y)>20) { // (24>20) => true
			System.out.println((x+y)+" is greater than 20");
		}
		
		//if-else statement
		System.out.println("=====================");
		System.out.println("if-else Example");
		if(x>y) {
			System.out.println("x: "+x+" is greater than y: "+y);
		}
		else {
			System.out.println("y: "+y+" is greater than x: "+x);
		}
		
		// Nested-if and if-else-if
		System.out.println("=====================");
		System.out.println("Nested-if and if-else-if Example");
		int z = 12;
		if(x>y) {
			if(x>z) {
				System.out.println("x is greater than y and z");
			}
			else if(z>x) {
				System.out.println("z is greater than y and x");
			}
		}
		else if(y>z) {
			System.out.println("y is greater than z and x");
		}
		
		//Switch Statement
		System.out.println("=====================");
		System.out.println("Switch Statement Example");
		String day = "Thrusday";
		
		switch(day) {
		case "Monday":
			System.out.println("Today is Monday");
			break;
		case "Tuesday":
			System.out.println("Today is Tuesday");
			break;
		case "Wednesday":
			System.out.println("Today is Wednesday");
			break;
		case "Thrusday":
			System.out.println("Today is Thrusday");
			break;
		case "Friday":
			System.out.println("Today is Friday");
			break;
		case "Saturday":
			System.out.println("Today is Saturday");
			break;
		case "Sunday":
			System.out.println("Today is Sunday");
			break;
		default:
			System.out.println("Not a day name");
			break;
		}
		
		//for loop
		System.out.println("=====================");
		System.out.println("For loop Example");
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("Sum: "+sum);
		
		//for-each loop
		System.out.println("=====================");
		System.out.println("For-Each loop Example");
		String[] arr = {"Java","C","CPP","JS","PYTHON"};
		for(String s:arr) {
			System.out.println(s);
		}
		
		//While loop
		System.out.println("=====================");
		System.out.println("While loop Example");
		int i = 0;
		while(i<10) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		
		//do-While loop
		System.out.println("=====================");
		System.out.println("do-While loop Example");
		int j = 0;
		do {
			if(j%2 != 0) {
				System.out.println(j);
			}
			j++;
		}while(j<10);
	}

}
