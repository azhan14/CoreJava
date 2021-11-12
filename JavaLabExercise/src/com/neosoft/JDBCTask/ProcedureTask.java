package com.neosoft.JDBCTask;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class ProcedureTask {

	public static void main(String[] args) {
		final String DB_url = "jdbc:mysql://localhost:3306/mydb3";
		final String DB_user = "root";
		final String DB_pass = "Zainpatel@14";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		CallableStatement cst = null;
		
		try {
			// Register the driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			// Creating a connection
			
			conn = DriverManager.getConnection(DB_url,DB_user,DB_pass);
			System.out.println("Connection Established");
			
			
			// Use statement object to perform queries
			
			st = conn.createStatement();
			
			System.out.println("----------------------");
			System.out.println("Employee Level Procedure");
			System.out.println("----------------------");
			
			// Calling Stored Procedure
			String prepareCallQuery = "CALL mydb3.GetEmpLevel(?,?)";
			cst = conn.prepareCall(prepareCallQuery);
//			cst.setInt(1, 8092);
			cst.setInt(1, 7369);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.execute();
			System.out.println("LEVEL");
			System.out.println(cst.getString(2));
			cst.close();
			
			System.out.println("----------------------");
			System.out.println("Salary Increment Function");
			System.out.println("----------------------");
			
			String selectQuery1 = "SELECT mydb3.salIncrement(2000,10) AS salLevel;";
			rs = st.executeQuery(selectQuery1);
			System.out.println("salLevel");
			while(rs.next()) {
				System.out.println(rs.getInt("salLevel"));
			}
			rs.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// closing resources and connection
				if(rs!= null) {
					rs.close();
				}
				if(st != null) {
					st.close();
				}
				if(conn != null) {
					conn.close();
				}
				if(cst != null) {
					cst.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
