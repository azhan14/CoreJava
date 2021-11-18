package com.rental.beans;

public class CarBean {
	
	private int year;
	private String number,name,mf,status;
	public CarBean() {
		super();
	}
	public CarBean(int year, String number, String name, String mf, String status) {
		super();
		this.year = year;
		this.number = number;
		this.name = name;
		this.mf = mf;
		this.status = status;
	}
	
	public CarBean(int year, String number, String name, String mf) {
		super();
		this.year = year;
		this.number = number;
		this.name = name;
		this.mf = mf;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMf() {
		return mf;
	}
	public void setMf(String mf) {
		this.mf = mf;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
