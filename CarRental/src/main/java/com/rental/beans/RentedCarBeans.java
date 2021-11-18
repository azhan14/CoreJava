package com.rental.beans;

public class RentedCarBeans {
	
	private int custid;
	private String carno,custname,returnstatus;
	
	public RentedCarBeans() { }
	
	public RentedCarBeans(int custid, String carno, String custname, String returnstatus) {
		super();
		this.custid = custid;
		this.carno = carno;
		this.custname = custname;
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
	
}
