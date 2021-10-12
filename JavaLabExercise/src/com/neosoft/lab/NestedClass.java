package com.neosoft.lab;

public class NestedClass {

	public static void main(String[] args) {
		OuterClass obj = new OuterClass();
		obj.display();
		OuterClass.InnerClass OIObj = obj.new InnerClass();
		OIObj.display();
	}

}

class OuterClass{
	void display() {
		System.out.println("This is Outer class.");
	}
	
	class InnerClass{
		void display() {
			System.out.println("This is Inner class");
		}
	}
}