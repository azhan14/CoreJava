package com.neosoft.lab;


public class StaticEx {
	static int a;
	static int b;
	//Static block: helps to initialize static data members
	static {
		a = 10;
		b = 20;
	}
	
	public static void main(String[] args) {
		System.out.println("value of static b: "+b);;
		System.out.println("value of static a: "+a);;
		Student s1 = new Student(); // value of b (static variable) increments. a increments to 1
		s1.show();					// a = 1 and b = 1
		Student s2 = new Student();	// value of b (static variable) increments from 1 to 2. a increments from 0 to 1
		s2.show();					// a = 1 and b = 2
		Student.b++;				// accessing static variable with class name.
		s1.show();					// a = 1 and b = 3
	}

}

class Student{
	int a;
	static int b;
	
	Student(){
		b++;
		a++;
	}
	
	void show() {
		System.out.println("value of a: "+a);
		System.out.println("value of b: "+b);
	}
	
	// Below line of code shows error as static method cannot access non-static variable.
//	public static void increment() {
//		a++;
//	}
}