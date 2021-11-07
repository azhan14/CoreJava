package com.neosoft.JDBCTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderByTaskQuery {

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
			
			// Order By Query 1
			System.out.println("----------------------");
			System.out.println("Increment sal by 7% who is a manager and display records in descending of sal?");
			System.out.println("----------------------");
			
			String selectQuery = "SELECT *,(SAL*1.07) AS newsal FROM emp WHERE JOB IN ('MANAGER') ORDER BY newsal DESC;";
			rs = st.executeQuery(selectQuery);
			System.out.println("empno \t ename \t job \t sal \t newsal");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")
				+"\t"+rs.getBigDecimal("sal")+"\t"+rs.getBigDecimal("newsal"));
			}
			rs.close();
			
			// Order By Query 2
			System.out.println("----------------------");
			System.out.println("Display eno and ename who have sal between 2000 and 3000. Display the records order by empno in ascending?");
			System.out.println("----------------------");
			
			String selectQuery1 = "SELECT empno,ename FROM emp WHERE SAL BETWEEN 2000 AND 3000 ORDER BY empno;";
			rs = st.executeQuery(selectQuery1);
			System.out.println("empno \t ename");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
			}
			rs.close();
			
			
			// Order By Query 3
			System.out.println("----------------------");
			System.out.println("Display unique records of empno and job who are from dept 10 or 20?");
			System.out.println("----------------------");
			
			String selectQuery2 = "SELECT distinct empno,job FROM emp WHERE deptno = 10 OR deptno = 20 ORDER BY job";
			rs = st.executeQuery(selectQuery2);
			System.out.println("empno \t job");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("job"));
			}
			rs.close();
			
			// Order By Query 3
			System.out.println("----------------------");
			System.out.println("Display unique jobs from emp except manager?");
			System.out.println("----------------------");
			
			String selectQuery3 = "SELECT distinct job from emp WHERE job NOT IN ('MANAGER');";
			rs = st.executeQuery(selectQuery3);
			System.out.println(" job");
			while(rs.next()) {
				System.out.println(rs.getString("job"));
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
