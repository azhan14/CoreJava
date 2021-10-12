package com.neosoft.lab;

public class InheritExercise {

	public static void main(String[] args) {
		Inherit obj = new Inherit(); // object of the last child in inheritance.
		System.out.println(obj.in);		// can access all the variables from parent class
		System.out.println(obj.b);
		System.out.println(obj.a);
	}

}
//Parent class
class A{
	int a = 10;
}
// Child class of A
class B extends A{
	int b = 20;
}
// Child class of B
class Inherit extends B{
	int in = 30;
}