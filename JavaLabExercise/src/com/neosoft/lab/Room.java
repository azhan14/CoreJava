package com.neosoft.lab;

public class Room {
	
	int roomNo;
	String roomType;
	double roomArea;
	boolean ACmachine;
	
	void setData(int No, String Type, double Area, boolean AC) {
		this.roomNo = No;
		this.roomType = Type;
		this.roomArea = Area;
		this.ACmachine = AC;
	}
	
	void displayData() {
		System.out.println("Room No: "+roomNo);
		System.out.println("Room Type: "+roomType);
		System.out.println("Room Area: "+roomArea);
		System.out.println("AC Present: "+ACmachine);
	}

	public static void main(String[] args) {
		Room room1 = new Room();
		room1.setData(1, "Standard", 20.0, false);
		room1.displayData();
		System.out.println("=======================");
		
		Room room2 = new Room();
		room2.setData(2, "Deluxe", 28.9, true);
		room2.displayData();
		System.out.println("=======================");
		
		Room room3 = new Room();
		room3.setData(3, "Suite", 35.9, true);
		room3.displayData();

	}

}
