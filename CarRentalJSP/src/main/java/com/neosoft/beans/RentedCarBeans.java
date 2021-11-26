package com.neosoft.beans;

public class RentedCarBeans {
	
	private int custid, price;
	private String carno,custname,returnstatus;
	
	public RentedCarBeans() { }
	
	public RentedCarBeans(int custid, String carno, String custname, int price, String returnstatus) {
		super();
		this.custid = custid;
		this.carno = carno;
		this.custname = custname;
		this.price = price;
		this.returnstatus = returnstatus;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCarno() {
		return carno;
	}

	public void setCarno(String carno) {
		this.carno = carno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
