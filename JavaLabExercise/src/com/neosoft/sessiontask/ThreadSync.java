package com.neosoft.sessiontask;

public class ThreadSync extends Thread{

	public static void main(String[] args) {
		Printer s = new Printer();
		s.doPrint(2, 5);
		System.out.println(" ");
		s.doPrint(3, 7);
	}

}

class Printer{
	synchronized void doPrint(int s, int e) {
		System.out.print(s);
		for(int i = 0; i < e; i++) {
			s++;
			System.out.print(" "+s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}