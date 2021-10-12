package com.neosoft.lab;

public class Point {
	
	private int x,y;
	
	public Point() {
		System.out.println("Default Constructor Point");
	}
	
	public Point(int x, int y) {
		System.out.println("Parameterized Constructor Point with x = "+x+" y = "+y);
	}
	
	public void setX(int x) {
		System.out.println("Value of x set to "+x);
	}
	
	public void setY(int y) {
		System.out.println("Value of y set to "+y);
	}
	
	public void setXY(int x,int y) {
		System.out.println("Value of x set to "+x+" value of y set to "+y);
	}
	
	public static void main(String[] args) {
		Point obj = new Point();
		obj.setX(12);
		obj.setY(24);
		Point paraObj = new Point(12,13);
		paraObj.setXY(35, 70);

	}

}
