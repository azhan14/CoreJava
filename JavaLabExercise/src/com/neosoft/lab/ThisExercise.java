package com.neosoft.lab;

import java.util.Scanner;

public class ThisExercise {
	String name;
	int age;
	
	ThisExercise setValues() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		this.name = name;
		this.age = age;
		return this;
	}
	
	void display() {
		System.out.println("name: "+name);
		System.out.println("age: "+age);
	}
	public static void main(String[] args) {
		ThisExercise obj = new ThisExercise();
		obj = obj.setValues();
		obj.display();
	}

}
