package com.neosoft.JDBCTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinTask {

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
			
			// Join Query 1
			System.out.println("----------------------");
			System.out.println("Display emp details with 7% increment who belongs to BOSTON location.");
			System.out.println("----------------------");
			
			String selectQuery = "SELECT e.*,(e.sal*1.07) as newsal,d.loc FROM emp as e left join dept as d ON e.deptno = d.deptno WHERE loc = 'BOSTON';";
			rs = st.executeQuery(selectQuery);
			System.out.println("empno \t ename \t job \t mgr \t hiredate \t sal \t deptno  newsal \t loc");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")
				+"\t"+rs.getInt("mgr")+"\t"+rs.getDate("hiredate")+"\t"+rs.getBigDecimal("sal")+"\t  "+
						rs.getInt("deptno")+"\t"+rs.getBigDecimal("newsal")+"\t"+rs.getString("loc"));
			}
			rs.close();
			
			
			// Join Query 2
			System.out.println("----------------------");
			System.out.println("Count the no. of employees works for RESEARCH dept.");
			System.out.println("----------------------");
			
			String selectQuery1 = "SELECT COUNT(*) AS count FROM emp as e LEFT JOIN dept as d ON e.deptno = d.deptno WHERE d.dname = \"RESEARCH\";";
			rs = st.executeQuery(selectQuery1);
			System.out.println("count");
			while(rs.next()) {
				System.out.println(rs.getInt("count"));
			}
			rs.close();
			
			
			// Join Query 3
			System.out.println("----------------------");
			System.out.println("Find out the max salary received in SALES dept.");
			System.out.println("----------------------");
			
			String selectQuery2 = "SELECT MAX(e.sal) as max FROM emp as e LEFT JOIN dept as d ON e.deptno = d.deptno WHERE d.dname = \"SALES\";";
			rs = st.executeQuery(selectQuery2);
			System.out.println("MAX SALARY");
			while(rs.next()) {
				System.out.println(rs.getInt("max"));
			}
			rs.close();
			
			
			// Join Query 4
			System.out.println("----------------------");
			System.out.println("Display date of joining of emp whose dept location is not available.");
			System.out.println("----------------------");
			
			String selectQuery3 = "SELECT e.ename,e.hiredate FROM emp AS e LEFT JOIN dept AS d ON e.deptno = d.deptno WHERE loc IS NULL;";
			rs = st.executeQuery(selectQuery3);
			System.out.println("Ename \t Hiredate");
			while(rs.next()) {
				System.out.println(rs.getString("ename")+"\t"+rs.getDate("hiredate"));
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
