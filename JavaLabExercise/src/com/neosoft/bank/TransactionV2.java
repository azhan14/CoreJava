package com.neosoft.bank;

import java.io.Serializable;
import java.util.ArrayList;

public class TransactionV2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String uname;
	private ArrayList<String> transaction = new ArrayList<String>();
	
	public TransactionV2(String uname, ArrayList<String> transaction) {
		super();
		this.uname = uname;
		this.transaction = transaction;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public ArrayList<String> getTransaction() {
		return transaction;
	}
	public void setTransaction(ArrayList<String> transaction) {
		this.transaction = transaction;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
