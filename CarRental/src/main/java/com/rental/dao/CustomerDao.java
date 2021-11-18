package com.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rental.beans.CustomerBean;

public class CustomerDao {
	
	public static int add(CustomerBean bean) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			String insertQuery = "INSERT INTO CUST(CUSTNAME, CUSTEMAIL, CUSTPASS, CUSTCONTACT) VALUES(?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(insertQuery);
			pst.setString(1, bean.getName());
			pst.setString(2, bean.getEmail());
			pst.setString(3, bean.getPassword());
			pst.setString(4, bean.getContact());
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean auth(String email, String pass) {
		boolean flag = false;
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT * FROM CUST WHERE CUSTEMAIL = ? AND CUSTPASS = ?";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setString(1, email);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int getId(String email) {
		int id = -1;
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT CUSTID FROM CUST WHERE CUSTEMAIL = ?";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static String getNameById(int id) {
		String name = null;
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT CUSTNAME FROM CUST WHERE CUSTID = ?";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				name = rs.getString(1);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public static int rentCar(String carno, int custid,String custname) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			String insertQuery = "INSERT INTO RENTCAR(CARNO,CUSTID,CUSTNAME) VALUES(?,?,?)";
			PreparedStatement pst = con.prepareStatement(insertQuery);
			pst.setString(1, carno);
			pst.setInt(2, custid);
			pst.setString(3, custname);
			status = pst.executeUpdate();
			if(status > 0) {
				String updateQuery = "UPDATE CAR SET CARSTATUS = 'NO' WHERE CARNO = ?";
				PreparedStatement pst2 = con.prepareStatement(updateQuery);
				pst2.setString(1, carno);
				status = pst2.executeUpdate();
				pst2.close();
			}
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
