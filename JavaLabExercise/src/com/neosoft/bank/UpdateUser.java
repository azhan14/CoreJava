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
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UpdateUser {
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
	SimpleDateFormat tformatter = new SimpleDateFormat("HH:mm:ss");
	static Scanner sc = new Scanner(System.in);
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	List<RegisterV2> registered = new ArrayList<RegisterV2>();
	List<TransactionV2> transactioned = new ArrayList<TransactionV2>();
	String userFile = "BankFiles/users.db";
	String transFile = "BankFiles/transaction.db";
	
	void updateAcc() throws IOException {
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
		System.out.println("Enter username: ");
		String uname_reg = sc.nextLine();
		
		String name = null;
		String address = null;
		String phone = null;
		String uname = null;
		String pass = null;
		double amt = 0.0;
		int index = -1;
		int pos = 0;
		for(RegisterV2 reg:registered) {
			if(reg.getUname().equals(uname_reg)) {
				name = reg.getName();
				address = reg.getAddress();
				phone = reg.getPhone();
				uname = reg.getUname();
				pass = reg.getPass();
				amt = reg.getAmount();
				index = pos;
			}
			pos++;
		}

		if(index >= 0) {
			System.out.println("Enter password: ");
			String p = sc.nextLine();
			if(pass.equals(p)) {
				int choice = 0;
				while(choice != 6) {
					System.out.println("-------------------");
					System.out.println("UPDATE   VALUE   OF");
					System.out.println("-------------------");
					System.out.println("1. Name.");
					System.out.println("2. Address.");
					System.out.println("3. Phone number.");
					System.out.println("4. Username.");
					System.out.println("5. Password.");
					System.out.println("6. Go Back");
					choice = sc.nextInt();
					sc.nextLine();
					switch(choice) {
					case 1:
						System.out.println("Enter name to be updated: ");
						name = sc.nextLine();
						break;
					case 2:
						System.out.println("Enter address to be updated: ");
						address = sc.nextLine();
						break;
					case 3:
						String cn = phone;
						int flag = 0;
						System.out.println("Enter contact number to be updated: ");
						while(flag != 1) {
							flag = 0;
							String contact = sc.nextLine();
							if(Pattern.matches("[0-9]{10}", contact)) {
								for(RegisterV2 reg: registered) {
									if(reg.getPhone().equals(contact)) {
										System.out.println("Phone number already exist.");
										System.out.println("Do you want to change or not ? Enter Y/N: ");
										String option = sc.nextLine();
										if(option.equals("N")) {
											phone = cn;
											break;
										}
										else {
											System.out.println("Set again: ");
										}
									}
									else {
										phone = contact;
										flag = 1;
										break;
									}
								}	
							}
							else {
								System.out.println("Please enter only 10 integers. Set again:");
							}
						}
						break;
					case 4:
						String un = uname;
						flag = 0;
						System.out.println("Enter username to be updated: ");
						while(flag != 1) {
							flag = 0;
							String u = sc.nextLine();
							for(RegisterV2 reg: registered) {
								if(reg.getUname().equals(u)) {
									System.out.println("Username already in use.");
									System.out.println("Do you want to change or not ? Enter Y/N: ");
									String option = sc.nextLine();
									if(option.equals("N")) {
										uname = un;
										break;
									}
									else {
										System.out.println("Set again: ");
									}
									flag = 2;
								}
							}
							if(flag == 0) {
								uname = u;
								flag = 1;
							}
						}
						break;
					case 5:
						String pw = pass;
						flag = 0;
						System.out.println("Enter password (minimum 8 chars(max 20): minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) to be updated: ");
						while(flag != 1) {
							flag = 0;
							String passw = sc.nextLine();
							if(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", passw)) {
								pass = passw;
								flag = 1;
							}
							else {
								System.out.println("Invalid Password.");
								System.out.println("Do you want to change or not ? Y/N: ");
								String option = sc.nextLine();
								if(option.equals("N")) {
									phone = pw;
									break;
								}
								else {
									System.out.println("Set again: ");
								}
							}
						}
						break;
					case 6:
						return;
					default:
						System.out.println("Enter Number Between 1 - 6 only. Please.");
						break;
					}
					System.out.println(index);
					if(index >= 0) {
						registered.remove(index);
						registered.add(index,new RegisterV2(name,address,uname,pass,phone,amt));
						PrintWriter pw = new PrintWriter(userFile);
						pw.close();
					}
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
			}
			else {
				System.out.println("Password Incorrect. Sorry.");
				registered.clear();
				return;
			}
		}
		else {
			System.out.println("Username does not exists.");
			registered.clear();
			return;
		}
	}
}
