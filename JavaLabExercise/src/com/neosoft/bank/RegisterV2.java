package com.neosoft.bank;

import java.io.Serializable;

public class RegisterV2 implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name,address,uname,pass,phone;
	private double amount;
	public RegisterV2(String name, String address, String uname, String pass, String phone, double amount) {
		this.name = name;
		this.address = address;
		this.uname = uname;
		this.pass = pass;
		this.phone = phone;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
