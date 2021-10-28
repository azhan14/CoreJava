package com.neosoft.bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankV2 {
	static Scanner sc = new Scanner(System.in);
	ObjectInputStream ois = null;
	List<RegisterV2> registered = new ArrayList<RegisterV2>();
	String userFile = "BankFiles/users.db";
	
	void showUserInfo(String uname){
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
		
		for(RegisterV2 reg: registered) {
			if(reg.getUname().equals(uname)) {
				System.out.println("Accountholder Name: "+reg.getName());
				System.out.println("Accountholder Address: "+reg.getAddress());
				System.out.println("Accountholder contact: "+reg.getPhone());
			}
		}
		registered.clear();
	}

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
//		BankV2 bankObj = new BankV2();
		int choice = 0;
		RegisterUser regUserObj = new RegisterUser();
		LoginUser logUserObj = new LoginUser();
		UpdateUser updateObj = new UpdateUser();
		
		while(choice != 4) {
			System.out.println("-----------------------");
			System.out.println("BANK    OF    GHATKOPAR");
			System.out.println("-----------------------");
			System.out.println("");
			System.out.println("1. Register Account.");
			System.out.println("2. Login.");
			System.out.println("3. Update Account.");
			System.out.println("4. Exit.");
			System.out.println("");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice){
			case 1:
				regUserObj.register();
				break;
			case 2:
				logUserObj.login();
				break;
			case 3:
				updateObj.updateAcc();
				break;
			case 4:
				break;
			}
		}
		sc.close();
	}
}
