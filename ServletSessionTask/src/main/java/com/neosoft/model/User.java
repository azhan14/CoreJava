package com.neosoft.model;

public class User {
	
	private int uid;
	private String email;
	private String mobile;
	private String uname;
	private String pass;
	
	public User() {}

	public User(int uid, String email, String mobile, String uname, String pass) {
		super();
		this.uid = uid;
		this.email = email;
		this.mobile = mobile;
		this.uname = uname;
		this.pass = pass;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	
	
}
