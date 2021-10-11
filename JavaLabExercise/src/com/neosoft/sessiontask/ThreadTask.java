package com.neosoft.sessiontask;

public class ThreadTask {

	public static void main(String[] args) {
		ThreadReverse tr = new ThreadReverse();
		tr.start();
		try {
			tr.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" ");
		ThreadAlternate ta = new ThreadAlternate();
		ta.start();
	}

}

class ThreadReverse extends Thread{
	@Override
	public void run() {
		String str = "Java is nice";
		int len = str.length();
		for(int i = len -1; i >= 0; i--) {
			System.out.print(str.charAt(i));
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadAlternate extends Thread{
	@Override
	public void run() {
		String str = "Java is nice";
		int len = str.length();
		for(int i = 0; i < len; i++) {
			if(i%2 == 0) {
				System.out.print(str.charAt(i));
			}
			else {
				System.out.print(" ");
			}
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
