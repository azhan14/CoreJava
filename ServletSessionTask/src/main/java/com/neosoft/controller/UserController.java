package com.neosoft.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserController {
	public static int searchUser(String uname,String pass) throws Exception{
		Connection con = JDBCProperties.getConnection();
		PreparedStatement pst = null;
		int i = 0;
		try {
			String query = "SELECT UNAME,PASS FROM user WHERE UNAME = ? AND PASS = ?";
			pst = con.prepareStatement(query);
			pst.setString(1, uname);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				if(uname.equals(rs.getString(1)) && pass.equals(rs.getString(2))) {
					i = 1;
				}
			}
			rs.close();
			pst.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return i;
	}
	
	public static int insertUser(int uid, String email, String mobile, String uname, String pass) throws Exception{
		Connection con = JDBCProperties.getConnection();
		PreparedStatement pst = null;
		int i = 0;
		try {
			String query = "INSERT INTO user VALUES(?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, uid);
			pst.setString(2, email);
			pst.setString(3, mobile);
			pst.setString(4, uname);
			pst.setString(5, pass);
			i = pst.executeUpdate();
			pst.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return i;
	}
}
