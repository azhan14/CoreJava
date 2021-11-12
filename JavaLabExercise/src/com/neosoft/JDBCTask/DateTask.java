package com.neosoft.JDBCTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DateTask {
	public static void main(String[] args) {
		
		final String DB_url = "jdbc:mysql://localhost:3306/mydb3";
		final String DB_user = "root";
		final String DB_pass = "Zainpatel@14";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// Register the driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			// Creating a connection
			
			conn = DriverManager.getConnection(DB_url,DB_user,DB_pass);
			System.out.println("Connection Established");
			
			
			// Use statement object to perform queries
			
			st = conn.createStatement();
			
			// Date Query 1
			System.out.println("----------------------");
			System.out.println("Display the most seniour employees? (Based on days)");
			System.out.println("----------------------");
			
			String selectQuery = "SELECT *,DATEDIFF(CURDATE(),HIREDATE) AS NOD FROM EMP WHERE DATEDIFF(CURDATE(),HIREDATE) = (SELECT MAX(DATEDIFF(CURDATE(),HIREDATE)) FROM EMP);";
			rs = st.executeQuery(selectQuery);
			System.out.println("empno \t ename \t job \t hiredate \t sal \t NOD");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")
				+"\t"+rs.getDate("hiredate")+"\t"+rs.getBigDecimal("sal")+"\t"+rs.getBigDecimal("NOD"));
			}
			rs.close();
			
			// Date Query 2
			System.out.println("----------------------");
			System.out.println("Give 5% increment to employees who are here since last 3 years?");
			System.out.println("----------------------");
			
			String selectQuery2 = "SELECT *,DATEDIFF(CURDATE(),HIREDATE) AS NOD FROM EMP WHERE DATEDIFF(CURDATE(),HIREDATE) = (SELECT MAX(DATEDIFF(CURDATE(),HIREDATE)) FROM EMP);";
			rs = st.executeQuery(selectQuery2);
			System.out.println("empno \t ename \t job \t hiredate \t sal \t NOD");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")
				+"\t"+rs.getDate("hiredate")+"\t"+rs.getBigDecimal("sal")+"\t"+rs.getBigDecimal("NOD"));
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
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
