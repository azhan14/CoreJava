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

public class Transfer {
	TransactionProcess tpObj = new TransactionProcess();
	
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
	SimpleDateFormat tformatter = new SimpleDateFormat("HH:mm:ss");
	static Scanner sc = new Scanner(System.in);
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	List<RegisterV2> registered = new ArrayList<RegisterV2>();
	List<TransactionV2> transactioned = new ArrayList<TransactionV2>();
	String userFile = "BankFiles/users.db";
	String transFile = "BankFiles/transaction.db";
	
	void transfer(String uname) throws IOException{
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
//		int userPos = -1;
//		for(TransactionV2 tr: transactioned) {
//			if(tr.getUname().equals(uname)) {
//				userPos = transactioned.indexOf(tr);
//			}
//		}
		System.out.println("Enter payee username: ");
		String payeeName = sc.nextLine();
		
		
		int payeePos = -1;
		for(TransactionV2 tr: transactioned) {
			if(tr.getUname().equals(payeeName)) {
				payeePos = transactioned.indexOf(tr);
			}
		}
		if(payeePos == -1) {
			System.out.println("Username doesn't exist.");
			transactioned.clear();
			return;
		}
		
		System.out.println("Enter amount: ");
		double amt = sc.nextDouble();
		
		if(amt > tpObj.getAmt(uname)) {
			System.out.println("You don't have that much money. Try again.");
			return;
		}
		double res = 0.0;
		if(payeePos >= 0) {
			res = tpObj.getAmt(uname) - amt;
			userAmt(uname,res);
			String Payer = "Transferred money Rs. "+amt+" to "+payeeName+" on "+formatter.format(new Date())+" at "+tformatter.format(new Date())+". Balance: Rs. "+tpObj.getAmt(uname);
			tpObj.addTransaction(uname, Payer);
			res = tpObj.getAmt(payeeName) + amt;
			payeeAmt(payeeName, res);
			String Payee = "Credited Money Rs. "+amt+" from "+uname+" on "+formatter.format(new Date())+" at "+tformatter.format(new Date())+". Balance: Rs. "+tpObj.getAmt(payeeName);
			tpObj.addTransaction(payeeName, Payee);
		}
		transactioned.clear();
	}
	
	void userAmt(String uname, double amt) throws IOException {
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
		int index = -1;
		int pos = 0;
		for(RegisterV2 reg:registered) {
			if(reg.getUname().equals(uname)) {
				name = reg.getName();
				address = reg.getAddress();
				phone = reg.getPhone();
				uname_reg = reg.getUname();
				pass = reg.getPass();
				index = pos;
			}
			pos++;
		}
		
		if(index >= 0) {
			double new_amt = amt;
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
	
	void payeeAmt(String uname, double amt) throws IOException {
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
		int index = -1;
		int pos = 0;
		for(RegisterV2 reg:registered) {
			if(reg.getUname().equals(uname)) {
				name = reg.getName();
				address = reg.getAddress();
				phone = reg.getPhone();
				uname_reg = reg.getUname();
				pass = reg.getPass();
				index = pos;
			}
			pos++;
		}
		
		if(index >= 0) {
			double new_amt = amt;
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
}
