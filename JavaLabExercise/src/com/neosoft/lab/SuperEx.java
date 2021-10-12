package com.neosoft.lab;

public class SuperEx {

	public static void main(String[] args) {
		OP op = new OP();
		op.Category();

	}

}

class Anime{
	String hr = "===========";
	Anime(){
		System.out.println("Anime..");
	}
	
	void Category() {
		System.out.println("Category..");
	}
}

class OP extends Anime {
	OP(){
		super(); // calling parent contructor.
		System.out.println("One Piece..");
		System.out.println(super.hr);	// using parent variable
	}
	
	void Category() {
		super.Category(); //calling parent method
		System.out.println("Adventure..");
	}
}