package com.neosoft.sessiontask;

public class Shapes {

	public static void main(String[] args) {
		Circle c = new Circle();
		c.area(6);
		c.draw(5,5,6);
		
		Triangle t = new Triangle();
		t.area(12,24);
		t.draw(1,2,2,4,3,2);
		
		Square s = new Square();
		s.area(2);
		s.draw(1, 2, 1, 4, 3, 4, 3, 2);
	}

}

class Shape{
	void area() {
		System.out.println("Area..");
	}
	void draw() {
		System.out.println("Draw..");
	}
}

class Circle extends Shape{
	void area(float r) {
		System.out.println("Area of Circle: "+(3.14*r*r));
	}
	void draw(int x,int y, float r) {
		System.out.println("Circle at center ("+x+","+y+") with radius "+r);
	}
}

class Triangle extends Shape{
	void area(int b, int h) {
		System.out.println("Area of triangle: "+(0.5*b*h));
	}
	void draw(int x1, int y1, int x2, int y2, int x3, int y3) {
		System.out.println("Triangle with co-ordinates ("+x1+","+y1+") , ("+x2+","+y2+") , ("+x3+","+y3+")");
	}
}

class Square extends Shape{
	void area(int s) {
		System.out.println("Area of Square: "+(s*s));
	}
	void draw(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		System.out.println("Triangle with co-ordinates ("+x1+","+y1+") , ("+x2+","+y2+") , ("+x3+","+y3+") , ("+x4+","+y4+")");
	}
}