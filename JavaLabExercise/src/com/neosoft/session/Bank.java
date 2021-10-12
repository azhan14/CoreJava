package com.neosoft.session;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Bank {
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> address = new ArrayList<String>();
	ArrayList<String> phone = new ArrayList<String>();
	ArrayList<String> uname = new ArrayList<String>();
	ArrayList<String> pass = new ArrayList<String>();
	ArrayList<Double> amount = new ArrayList<Double>();
	ArrayList<ArrayList<String>> transaction = new ArrayList<ArrayList<String>>();
	static Scanner sc = new Scanner(System.in);
	void register() {
		System.out.println("Enter name: ");
		name.add(sc.nextLine());
		System.out.println("Enter address: ");
		address.add(sc.nextLine());
		int flag = 0;
		System.out.println("Enter contact number(only numbers): ");
		while(flag != 1) {
			flag = 0;
			String contact = sc.nextLine();
			if(Pattern.matches("[0-9]{10}", contact)) {
				if(phone.indexOf(contact) < 0) {
					phone.add(contact);
					flag = 1;
				}
				else {
					System.out.println("Phone number already exist. Set again: ");
				}
			}
			else {
				System.out.println("Please enter only 10 integers. Set again:");
			}
		}
		System.out.println("Set Username: ");
		String u = "";
		flag = 0;
		while(flag != 1) {
			flag = 0;
			u = sc.nextLine();
			if(uname.indexOf(u) < 0) {
				uname.add(u);
				flag = 1;
			}
			else {
				System.out.println("Username already in use. Set again: ");
			}	
		}
		
		System.out.println("Set password (minimum 8 chars(max 20): minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) : ");
		flag = 0;
		while(flag != 1) {
			flag = 0;
			String passw = sc.nextLine();
			if(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", passw)) {
				pass.add(passw);
				flag = 1;
			}
			else {
				System.out.println("Invalid Password. Set again: ");
			}
		}
		System.out.println("Enter Initial deposit: ");
		Double amt = sc.nextDouble();
		amount.add(amt);
		String DStat = "Initial Deposit - Rs. "+amt;
		transaction.add(new ArrayList<String>());
		transaction.get(uname.indexOf(u)).add(DStat);
	}
	
	void Deposit(int i, double amt) {
		String DStat = "Rs. "+amt+" Credited to your account. Balance: ";
		amt += amount.get(i);
		DStat += amt;
		amount.set(i,amt);
		transaction.get(i).add(DStat);
//		System.out.println(transaction);
	}
	
	void Transfer(int i) {
		System.out.println("Enter payee username: ");
		String payeeName = sc.nextLine();
		System.out.println("Enter amount: ");
		double amt = sc.nextDouble();
		if(amt > amount.get(i)) {
			System.out.println("You don't have that much money. Try again.");
			return;
		}
		double res = 0.0;
		if(uname.indexOf(payeeName) > 0) {
			res = amount.get(i) - amt;
			amount.set(i, res);
			String Payer = "Transferred money Rs. "+amt+" to "+payeeName+". Balance: Rs. "+amount.get(i);
			transaction.get(i).add(Payer);
			int j = uname.indexOf(payeeName);
			res = amount.get(j)+amt;
			amount.set(j, res);
			String Payee = "Credited Money Rs. "+amt+" from "+uname.get(i)+". Balance: Rs. "+amount.get(j);
			transaction.get(j).add(Payee);
			System.out.println(transaction);
		}
		else {
			System.out.println("Username doesn't exist.");
		}
	}
	
	void UserInfo(int i) {
		System.out.println("Accountholder Name: "+name.get(i));
		System.out.println("Accountholder Address: "+address.get(i));
		System.out.println("Accountholder contact: "+phone.get(i));
	}
	
	void LoginOption(String u, String p) {
		int choice = 0;
		while(choice != 5) {
			System.out.println("-------------------");
			System.out.println("W  E  L  C  O  M  E");
			System.out.println("-------------------");
			System.out.println("");
			System.out.println("1. Deposit.");
			System.out.println("2. Transfer.");
			System.out.println("3. Last 5 Transactions.");
			System.out.println("4. User Information.");
			System.out.println("5. Log out");
			System.out.println("");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1: 
				System.out.println("Enter amount: ");
				double amt = sc.nextDouble();
				Deposit(uname.indexOf(u),amt);
				break;
			case 2:
				Transfer(uname.indexOf(u));
				break;
			case 3:
				transactionData(uname.indexOf(u));
				break;
			case 4:
				UserInfo(uname.indexOf(u));
				break;
			case 5:
				return;
			}
		}
	}
	
	void transactionData(int i) {
		for(int j = 0; j < transaction.get(i).size(); j++) {
			System.out.println(transaction.get(i).get(j));
		}
	}
	
	void login() {
		System.out.println("Enter Username: ");
		String username = sc.nextLine();
		System.out.println("Enter Password: ");
		String password = sc.nextLine();
		int flag = 0;
		for(int i = 0; i < uname.size(); i++) {
			if((username.equals(uname.get(i))) && (password.equals(pass.get(i)))) {
				System.out.println("Successfully logged in.");
				LoginOption(username,password);
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			System.out.println("Invalid username and password");
		}
	}
	
	void UpdateAcc() {
		System.out.println("Enter username: ");
		String u = sc.nextLine();
		int i = uname.indexOf(u);
		if(i >= 0) {
			System.out.println("Enter password: ");
			String p = sc.nextLine();
			if(pass.get(i).equals(p)) {
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
					if(choice == 6) {
						return;
					}
					update(choice,i);
				}
			}
			else {
				System.out.println("Password Incorrect. Sorry.");
				return;
			}
		}
	}
	
	void update(int c,int i) {
		int flag = 0;
		if(c == 1) {
			System.out.println("Enter name to be updated: ");
			String n = sc.nextLine();
			name.set(i, n);
		}
		else if(c == 2) {
			System.out.println("Enter address to be updated: ");
			String a = sc.nextLine();
			address.set(i, a);
		}
		else if(c == 3) {
			String cn = phone.get(i);
			phone.set(i, "");
			System.out.println("Enter contact number to be updated: ");
			while(flag != 1) {
				flag = 0;
				String contact = sc.nextLine();
				if(Pattern.matches("[0-9]{10}", contact)) {
					if(phone.indexOf(contact) < 0) {
						phone.set(i,contact);
						flag = 1;
						return;
					}
					else {
						System.out.println("Phone number already exist.");
						System.out.println("Do you want to change or not ? Enter Y/N: ");
						String option = sc.nextLine();
						if(option.equals("N")) {
							phone.set(i, cn);
							break;
						}
						else {
							System.out.println("Set again: ");
						}
					}
				}
				else {
					System.out.println("Please enter only 10 integers. Set again:");
				}
			}
		}
		else if(c == 4) {
			String un = uname.get(i);
			uname.set(i, "");
			System.out.println("Enter username to be updated: ");
			while(flag != 1) {
				flag = 0;
				String u = sc.nextLine();
				if(uname.indexOf(u) < 0) {
					uname.set(i,u);
					flag = 1;
				}
				else {
					System.out.println("Username already in use.");
					System.out.println("Do you want to change or not ? Y/N: ");
					String option = sc.nextLine();
					if(option.equals("N")) {
						phone.set(i, un);
						break;
					}
					else {
						System.out.println("Set again: ");
					}
				}	
			}
		}
		else if(c == 5) {
			String pw = pass.get(i);
			pass.set(i, "");
			System.out.println("Enter password (minimum 8 chars(max 20): minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) to be updated: ");
			while(flag != 1) {
				flag = 0;
				String passw = sc.nextLine();
				if(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", passw)) {
					pass.set(i,passw);
					flag = 1;
				}
				else {
					System.out.println("Invalid Password.");
					System.out.println("Do you want to change or not ? Y/N: ");
					String option = sc.nextLine();
					if(option.equals("N")) {
						phone.set(i, pw);
						break;
					}
					else {
						System.out.println("Set again: ");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Bank bankObj = new Bank();
		int choice = 0;
		
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
			sc.nextLine();
			switch(choice){
			case 1:
				bankObj.register();
				break;
			case 2:
				bankObj.login();
				break;
			case 3:
				bankObj.UpdateAcc();
				break;
			case 4:
				break;
			}
		}
		sc.close();
	}
}
