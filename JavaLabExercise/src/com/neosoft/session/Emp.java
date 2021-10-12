package com.neosoft.session;

import java.io.Serializable;

public class Emp implements Serializable{

	private static final long serialVersionUID = 1L;
	private int eid;
	private String ename;
	private double esal;
	private int dno;
	
	

	public Emp(int eid, String ename, double esal, int dno) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.dno = dno;
	}



	public int getEid() {
		return eid;
	}



	public void setEid(int eid) {
		this.eid = eid;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public double getEsal() {
		return esal;
	}



	public void setEsal(double esal) {
		this.esal = esal;
	}



	public int getDno() {
		return dno;
	}



	public void setDno(int dno) {
		this.dno = dno;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
