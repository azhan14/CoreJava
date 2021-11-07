package com.neosoft.JDBCTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQueryTask {
	
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
			
			// Select Query 1
			System.out.println("----------------------");
			System.out.println("Decrement sal by 5% who is a clerk?");
			System.out.println("----------------------");
			
			String selectQuery = "SELECT *,(SAL*0.95) AS newsal FROM emp WHERE JOB IN ('CLERK');";
			rs = st.executeQuery(selectQuery);
			System.out.println("empno \t ename \t job \t sal \t newsal");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")
				+"\t"+rs.getBigDecimal("sal")+"\t"+rs.getBigDecimal("newsal"));
			}
			rs.close();
			
			// Select Query 2
			
			System.out.println("----------------------");
			System.out.println("Display eno and ename who have sal between 2000 and 3000?");
			System.out.println("----------------------");
			
			String selectQuery2 = "SELECT empno,ename FROM emp WHERE SAL BETWEEN 2000 AND 3000";
			rs = st.executeQuery(selectQuery2);
			System.out.println("empno \t ename");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
			}
			rs.close();
			
			// Select Query 3
			System.out.println("----------------------");
			System.out.println("Display eno and job who are from dept 10 or 20?");
			System.out.println("----------------------");
			
			String selectQuery3 = "SELECT empno,job FROM emp WHERE deptno = 10 OR deptno = 20";
			rs = st.executeQuery(selectQuery3);
			System.out.println("empno \t job");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("job"));
			}
			rs.close();
			
			// Select Query 4
			System.out.println("----------------------");
			System.out.println("Display eno,mgr who have salary > 2000 or deptno > 10 or job is clerk?");
			System.out.println("----------------------");
			
			String selectQuery4 = "SELECT empno,mgr FROM emp WHERE sal > 2000 OR deptno > 10 OR job in ('CLERK');";
			rs = st.executeQuery(selectQuery4);
			System.out.println("empno \t mgr");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getInt("mgr"));
			}
			rs.close();
			
			// Select Query 5
			System.out.println("----------------------");
			System.out.println("Increment sal by 15% who is not reporting to any one?");
			System.out.println("----------------------");
			
			String selectQuery5 = "SELECT *,(SAL*1.15) AS newsal FROM emp WHERE mgr IS NULL";
			rs = st.executeQuery(selectQuery5);
			System.out.println("empno \t ename \t job \t\t mgr \t sal \t newsal");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")
				+"\t"+rs.getInt("mgr")+"\t"+rs.getBigDecimal("sal")+"\t"+rs.getBigDecimal("newsal"));
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
