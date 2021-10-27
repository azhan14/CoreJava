package com.neosoft.bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginUser {
	BankV2 bankObj = new BankV2();
	TransactionProcess tpObj = new TransactionProcess();
	Transfer trObj = new Transfer();
	
	static Scanner sc = new Scanner(System.in);
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	List<RegisterV2> registered = new ArrayList<RegisterV2>();
	String userFile = "BankFiles/users.db";
	void login() throws IOException{
		try {
			ois = new ObjectInputStream(new FileInputStream(userFile));
			while(true) {
				registered.add((RegisterV2) ois.readObject());
			}
		}catch(EOFException e) {
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Enter Username: ");
		String username = sc.nextLine();
		System.out.println("Enter Password: ");
		String password = sc.nextLine();
		int flag = 0;
		for(RegisterV2 reg:registered) {
			if(reg.getUname().equals(username) && reg.getPass().equals(password)) {
				System.out.println("Successfully logged in.");
				loginOption(username,password);
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			System.out.println("Invalid username and password");
		}
	}
	
	void loginOption(String uname, String pass) throws IOException {
		int choice = 0;
		while(choice != 6) {
			System.out.println("-------------------");
			System.out.println("W  E  L  C  O  M  E");
			System.out.println("-------------------");
			System.out.println("");
			System.out.println("1. Deposit.");
			System.out.println("2. Transfer.");
			System.out.println("3. Last 5 Transactions.");
			System.out.println("4. User Information.");
			System.out.println("5. Show Balance.");;
			System.out.println("6. Log out");
			System.out.println("");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1: 
				System.out.println("Enter amount: ");
				double amt = sc.nextDouble();
				tpObj.deposit(uname, amt);
				break;
			case 2:
				trObj.transfer(uname);
				break;
			case 3:
				tpObj.transactionData(uname);
				break;
			case 4:
				bankObj.showUserInfo(uname);
				break;
			case 5:
				tpObj.showBalance(uname);
				break;
			case 6:
				break;
			}
		}
	}
}
