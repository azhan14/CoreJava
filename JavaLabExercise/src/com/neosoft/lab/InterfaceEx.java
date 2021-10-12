package com.neosoft.lab;

public class InterfaceEx {

	public static void main(String[] args) {
		MyClass obj = new MyClass();
		System.out.println(obj.meth1());
		System.out.println(obj.meth2());
	}

}

interface A1{
	String meth1();
	String meth2();
}

class MyClass implements A1{

	@Override
	public String meth1() {
		return "This is a method 1 output";
	}

	@Override
	public String meth2() {
		return "This is a method 2 output";
	}
	
}