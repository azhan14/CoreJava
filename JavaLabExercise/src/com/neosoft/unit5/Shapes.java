package com.neosoft.unit5;

class Shape {
	void draw() {
		System.out.println("draw shapes");
	}
	void erase() {
		System.out.println("erase shapes");
	}
}

class Circle extends Shape{
	void draw() {
		System.out.println("draw Circle");
	}
	void erase() {
		System.out.println("erase Circle");
	}
}

class Triangle extends Shape{
	void draw() {
		System.out.println("draw Triangle");
	}
	void erase() {
		System.out.println("erase Triangle");
	}
}

class Square extends Shape{
	void draw() {
		System.out.println("draw Square");
	}
	void erase() {
		System.out.println("erase Square");
	}
}
public class Shapes {
	
	public static Shape randshape() {
		switch((int)(Math.random()*3)) {
		case 0: return new Circle();
		case 1: return new Triangle();
		case 2: return new Square();
		default: System.out.println("default");
		return new Shape();
		}
	}

	public static void main(String[] args) {
		Shape s[] = new Shape[9];
		for(int i = 0; i < s.length; i++) {
			s[i] = randshape();
		}
		for(int i = 0; i < s.length; i++) {
			s[i].draw();
			s[i].erase();
		}

	}

}
