package com.neosoft.bank;

import java.io.EOFException;
import java.io.FileInputStream;
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

public class TransactionProcess {
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
	SimpleDateFormat tformatter = new SimpleDateFormat("HH:mm:ss");
	static Scanner sc = new Scanner(System.in);
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	List<RegisterV2> registered = new ArrayList<RegisterV2>();
	List<TransactionV2> transactioned = new ArrayList<TransactionV2>();
	String userFile = "BankFiles/users.db";
	String transFile = "BankFiles/transaction.db";
	
	void addTransaction(String uname, String transaction) throws IOException {
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
		ArrayList<String> tra = new ArrayList<String>();
		int index = -1;
		int pos = 0;
		String username = null;
		for(TransactionV2 tr: transactioned) {
			if(tr.getUname().equals(uname)) {
				tra = tr.getTransaction();
				username = tr.getUname();
				index = pos;
				break;
			}
			pos++;
		}
		
		if(index >= 0) {
			tra.add(transaction);
			transactioned.remove(index);
			transactioned.add(index,new TransactionV2(username, tra));
			PrintWriter pw = new PrintWriter(transFile);
			pw.close();
		}
		try {
			oos = new ObjectOutputStream(new FileOutputStream(transFile));
			for(TransactionV2 tr: transactioned) {
				oos.writeObject(tr);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		tra.clear();
		oos.close();
		transactioned.clear();
	}
	
	void deposit(String uname, double amt) throws IOException {
		String DStat = "Rs. "+amt+" Credited to your account on "+formatter.format(new Date())+" at "+tformatter.format(new Date())+" .Balance: "+(getAmt(uname)+amt);
		amtUpdate(uname, amt);
		addTransaction(uname, DStat);
	}
	
	double getAmt(String uname) {
		double amount = 0;
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
				amount = reg.getAmount();
			}
		}
		registered.clear();
		return amount;
	}
	
	void amtUpdate(String uname, double amt) throws IOException {
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
		String name = null;
		String address = null;
		String phone = null;
		String uname_reg = null;
		String pass = null;
		double old_amt = 0.0;
		int index = -1;
		int pos = 0;
		for(RegisterV2 reg:registered) {
			if(reg.getUname().equals(uname)) {
				name = reg.getName();
				address = reg.getAddress();
				phone = reg.getPhone();
				uname_reg = reg.getUname();
				pass = reg.getPass();
				old_amt = reg.getAmount();
				index = pos;
			}
			pos++;
		}
		
		if(index >= 0) {
			double new_amt = old_amt + amt;
			registered.remove(index);
			registered.add(index,new RegisterV2(name,address,uname_reg,pass,phone,new_amt));
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
	
	void showBalance(String uname) {
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
				System.out.println("Your Account Balance is: "+reg.getAmount());
			}
		}
		registered.clear();
	}
	
	void transactionData(String uname) {
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
		ArrayList<String> tra = new ArrayList<String>();
		for(TransactionV2 tr: transactioned) {
			if(tr.getUname().equals(uname)) {
				tra = tr.getTransaction();
			}
		}
		if(tra.size() < 5) {
			for(String statement:tra) {
				System.out.println(statement);
			}
		}
		else {
			for(int j = tra.size()-5; j < tra.size(); j++ ) {
				System.out.println(tra.get(j));
			}
		}
		tra.clear();
		transactioned.clear();
	}
}
