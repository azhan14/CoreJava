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
			
			String selectQuery2 = "SELECT *,sal*1.05 as newsal FROM emp WHERE TIMESTAMPDIFF(YEAR,hiredate,CURDATE()) > 3;";
			rs = st.executeQuery(selectQuery2);
			System.out.println("empno \t ename \t job \t\t sal \t newsal");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")+
						"   \t"+rs.getBigDecimal("sal")+"\t"+rs.getBigDecimal("newsal"));
			}
			rs.close();
			
			// Date Query 3
			System.out.println("----------------------");
			System.out.println("Give 7% increment to employees who are here since last 5 years and salary < 2000?");
			System.out.println("----------------------");
			
			String selectQuery3 = "SELECT *,sal*1.07 as newsal FROM emp WHERE TIMESTAMPDIFF(YEAR,hiredate,CURDATE()) > 5 AND sal < 2000;";
			rs = st.executeQuery(selectQuery3);
			System.out.println("empno \t ename \t job \t\t sal \t newsal");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("job")+
						"   \t"+rs.getBigDecimal("sal")+"\t"+rs.getBigDecimal("newsal"));
			}
			rs.close();
			
			// Date Query 4
			System.out.println("----------------------");
			System.out.println("Display yearly report which shows year wise no. of joinings?");
			System.out.println("----------------------");
			
			String selectQuery4 = "SELECT DATE_FORMAT(hiredate,\"%Y\") AS year,COUNT(*) AS no_of_joining FROM emp GROUP BY year;";
			rs = st.executeQuery(selectQuery4);
			System.out.println("year \tno_of_joining");
			while(rs.next()) {
				System.out.println(rs.getString("year")+"\t"+rs.getInt("no_of_joining"));
			}
			rs.close();
			
			// Date Query 5
			System.out.println("----------------------");
			System.out.println("Display monthly report which shows month wise no. of joinings?");
			System.out.println("----------------------");
			
			String selectQuery5 = "SELECT DATE_FORMAT(hiredate, \"%M\") AS month,COUNT(*) AS no_of_joining FROM emp GROUP BY month;";
			rs = st.executeQuery(selectQuery5);
			System.out.println("no_of_joining \t month");
			while(rs.next()) {
				System.out.println(rs.getInt("no_of_joining")+"\t"+rs.getString("month"));
			}
			rs.close();
			
			// Date Query 6
			System.out.println("----------------------");
			System.out.println("Create a seperate table from existing emp table for emps who have recently joined (i.e. last year).");
			System.out.println("----------------------");
			
//			String createQuery = "CREATE TABLE new_emp SELECT * FROM emp WHERE YEAR(hiredate)>=YEAR('2021-01-01');";
//			System.out.println("Table Creation: "+st.executeUpdate(createQuery));
			
			
			String selectQuery6 = "SELECT * FROM new_emp;";
			rs = st.executeQuery(selectQuery6);
			System.out.println("empno \t ename \t job \t mgr \t hiredate \t sal \t deptno");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename")
				+"\t"+rs.getString("job")+"\t"+rs.getInt("mgr")
				+"\t"+rs.getDate("hiredate")+"\t"+rs.getInt("sal")+"\t"+rs.getInt("deptno"));
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
