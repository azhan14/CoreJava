package com.neosoft.lab;

public class MultipleInherit {

	public static void main(String[] args) {
		Football fb = new Football();
		fb.start();
		fb.play();
		fb.show();
	}
}

class Event{
	public void start() {
		System.out.println("Start Event");
	}
}

interface Sport{
	public void play();
}

class Football extends Event implements Sport{
	public void show() {
		System.out.println("Show Football");
	}
	
	@Override
	public void play() {
		System.out.println("Play Sports");
	}
	
}