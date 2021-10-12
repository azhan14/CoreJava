package com.neosoft.lab;

public class RoomReuse {

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
		writeMessage("Room No: "+roomNo);
		writeMessage("Room Type: "+roomType);
		writeMessage("Room Area: "+roomArea);
		writeMessage("AC Present: "+ACmachine);
	}
	
	void writeMessage(String msg) {
		System.out.println(msg);
	}
	public static void main(String[] args) {
		RoomReuse room1 = new RoomReuse();
		room1.setData(1, "Standard", 20.0, false);
		room1.displayData();
		System.out.println("=======================");
		
		RoomReuse room2 = new RoomReuse();
		room2.setData(2, "Deluxe", 28.9, true);
		room2.displayData();
		System.out.println("=======================");
		
		RoomReuse room3 = new RoomReuse();
		room3.setData(3, "Suite", 35.9, true);
		room3.displayData();

	}

}
