package com.neosoft.bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegisterUser {
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
	SimpleDateFormat tformatter = new SimpleDateFormat("HH:mm:ss");
	static Scanner sc = new Scanner(System.in);
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	List<RegisterV2> registered = new ArrayList<RegisterV2>();
	List<TransactionV2> transactioned = new ArrayList<TransactionV2>();
	String userFile = "BankFiles/users.db";
	String transFile = "BankFiles/transaction.db";
	
	void register() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			ois = new ObjectInputStream(new FileInputStream(userFile));
			while(true) {
				registered.add((RegisterV2) ois.readObject());
			}
		}catch(EOFException e) {
			System.out.println();
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
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter address: ");
		String address = sc.nextLine();
		int flag = 0;
		System.out.println("Enter contact number(only numbers): ");
		String phone = "";
		while(flag != 1) {
			flag = 0;
			String contact = sc.nextLine();
			if(Pattern.matches("[0-9]{10}", contact)) {
				for(RegisterV2 reg: registered) {
					if(reg.getPhone().equals(contact)) {
						System.out.println("Phone number already exist. Set again: ");
						flag = 2;
					}
				}
				if(flag == 0) {
					phone = contact;
					flag = 1;
				}
			}
			else {
				System.out.println("Please enter only 10 integers. Set again:");
			}
		}
		System.out.println("Set Username: ");
		String username = "";
		flag = 0;
		while(flag != 1) {
			flag = 0;
			String uname = sc.nextLine();
			for(RegisterV2 reg: registered) {
				if(reg.getUname().equals(uname)) {
					System.out.println("Username already in use. Set again: ");
					flag = 2;
				}
			}
			if(flag == 0) {
				username = uname;
				flag = 1;
			}	
		}
		String pass = "";
		System.out.println("Set password (minimum 8 chars(max 20): minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) : ");
		flag = 0;
		while(flag != 1) {
			flag = 0;
			String passw = sc.nextLine();
			if(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", passw)) {
				pass = passw;
				flag = 1;
			}
			else {
				System.out.println("Invalid Password. Set again: ");
			}
		}
		System.out.println("Enter Initial deposit: ");
		double amt = sc.nextDouble();
		String DStat = "Initial Deposit - Rs. "+amt+" on "+formatter.format(new Date())+" at "+tformatter.format(new Date());
		PrintWriter pw = new PrintWriter(userFile);
		pw.close();
		initialTransaction(username, DStat);
		registered.add(new RegisterV2(name,address,username,pass,phone,amt));
		System.out.println(registered);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(userFile));
			for(RegisterV2 reg: registered) {
				oos.writeObject(reg);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		oos.close();
		registered.clear();
	}
	
	void initialTransaction(String uname, String transaction) throws IOException {
		try {
			ois = new ObjectInputStream(new FileInputStream(transFile));
			while(true) {
				transactioned.add((TransactionV2) ois.readObject());
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
		ArrayList<String> newUser = new ArrayList<String>();
		newUser.add(transaction);
		transactioned.add(new TransactionV2(uname, newUser));
		try {
			oos = new ObjectOutputStream(new FileOutputStream(transFile));
			for(TransactionV2 tr: transactioned) {
				oos.writeObject(tr);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		oos.close();
		transactioned.clear();
	}
}
