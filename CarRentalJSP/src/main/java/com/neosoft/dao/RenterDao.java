package com.neosoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.beans.RenterBeans;

public class RenterDao {
	
	public static int add(RenterBeans renter) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			String insertQuery = "INSERT INTO RENTER(NAME,EMAIL,PASSWORD,CONTACT) VALUES(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(insertQuery);
			pst.setString(1, renter.getName());
			pst.setString(2, renter.getEmail());
			pst.setString(3, renter.getPassword());
			pst.setString(4, renter.getContact());
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<RenterBeans> getAll(){
		List<RenterBeans> beans = new ArrayList<RenterBeans>();
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT * FROM RENTER";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				RenterBeans bean = new RenterBeans();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setContact(rs.getString(5));
				beans.add(bean);
			}
			rs.close();
			pst.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return beans;
	}
	
	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			String deleteQuery = "DELETE FROM RENTER WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			pst.setInt(1, id);
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static RenterBeans getById(int id) {
		RenterBeans bean = new RenterBeans();
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT * FROM RENTER WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setContact(rs.getString(5));
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public static int update(RenterBeans bean) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			String deleteQuery = "UPDATE RENTER SET name = ?, email = ?, password = ?, contact = ? WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			pst.setString(1, bean.getName());
			pst.setString(2, bean.getEmail());
			pst.setString(3, bean.getPassword());
			pst.setString(4, bean.getContact());
			pst.setInt(5, bean.getId());
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean auth(String email, String password) {
		boolean flag = false;
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT * FROM RENTER WHERE email = ? AND password = ?";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setString(1, email);
			pst.setString(2, password);
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
}
