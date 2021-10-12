package com.neosoft.lab;

public class DisplayMessage {

	public static void main(String[] args) {
		System.out.println("This is a main method message");
		
		DisplayMessage dm = new DisplayMessage();
		dm.display();
		dm.displayParam("This is a parameterized display method message");
	}
	
	public void display() {
		System.out.println("This is a display method message");
	}
	
	public void displayParam(String msg) {
		System.out.println(msg);
	}
}
