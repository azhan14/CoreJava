package com.neosoft.lab;

public class BoxTest {

	public static void main(String[] args) {
		Box3d b = new Box3d(9, 9, 9);
		System.out.println("Area: "+b.area());
		System.out.println("Volume: "+b.volume());
		b.setVal(6, 6, 6);
		System.out.println("After setting new Value");
		System.out.println("Area: "+b.area());
		System.out.println("Volume: "+b.volume());

	}

}

class Box{
	private int length;
	private int breadth;
	public Box(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	
	public void setVal(int x, int y){
		length = x;
		breadth = y;
	}
	
	public int area() {
		return length*breadth;
	}
	
}

class Box3d extends Box{
	private int length;
	private int breadth;
	private int height;
	public Box3d(int length, int breadth, int height) {
		super(length,breadth);
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	
	public void setVal(int x, int y, int z) {
		super.setVal(x,y);
		length = x;
		breadth = y;
		height = z;
	}
	
	public int volume() {
		return (super.area()*height);
	}
}