package com.neosoft.lab;

abstract class debuggable{
	abstract void dump();
}

class X extends debuggable{
	private int a,b;
	public X(int a, int b) {
		this.a = a;
		this.b = b;
	}

	void dump() {
		System.out.println("a = "+a+" b = "+b);
	};
}

class Y extends debuggable{
	private int i,j;
	public Y(int i, int j) {
		this.i = i;
		this.j = j;
	}

	void dump() {
		System.out.println("i = "+i+" j = "+j);
	};
}
public class Abstdemo {

	public static void main(String[] args) {
		X x = new X(1,2);
		Y y = new Y(3,4);
		x.dump();
		y.dump();
	}

}
