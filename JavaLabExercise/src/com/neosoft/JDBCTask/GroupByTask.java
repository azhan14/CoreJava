package com.neosoft.JDBCTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GroupByTask {

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
			System.out.println("Count total no. of emps?");
			System.out.println("----------------------");
			
			String selectQuery = "SELECT COUNT(empno) AS count from emp";
			rs = st.executeQuery(selectQuery);
			while(rs.next())
				System.out.println("Total no. of Employees: "+rs.getInt("count"));
			rs.close();
			
			// Order By Query 2
			System.out.println("----------------------");
			System.out.println("Count dept wise total emps?");
			System.out.println("----------------------");
			
			String selectQuery1 = "SELECT deptno,COUNT(empno) AS count from emp GROUP BY deptno;";
			rs = st.executeQuery(selectQuery1);
			System.out.println("deptno \t count");
			while(rs.next())
				System.out.println(rs.getInt("deptno")+"\t"+rs.getInt("count"));
			rs.close();
			
			
			// Order By Query 3
			System.out.println("----------------------");
			System.out.println("Display min salary of emps?");
			System.out.println("----------------------");
			
			String selectQuery2 = "Select Min(sal) as minsal from emp;";
			rs = st.executeQuery(selectQuery2);
			System.out.println("Minimum Salary");
			while(rs.next())
				System.out.println(rs.getInt("minsal"));
			rs.close();
			
			// Order By Query 4
			System.out.println("----------------------");
			System.out.println("Display the max salary of each dept?");
			System.out.println("----------------------");
			
			String selectQuery3 = "SELECT deptno,max(sal) as maxsal from emp GROUP BY deptno;";
			rs = st.executeQuery(selectQuery3);
			System.out.println("deptno \tMaximum Salary");
			while(rs.next())
				System.out.println(rs.getInt("deptno")+"\t"+rs.getInt("maxsal"));
			rs.close();
			
			// Order By Query 5
			System.out.println("----------------------");
			System.out.println("Count people have salary > 2000?");
			System.out.println("----------------------");
			
			String selectQuery4 = "SELECT COUNT(sal) as count FROM emp WHERE sal > 2000;";
			rs = st.executeQuery(selectQuery4);
			while(rs.next())
				System.out.println("Employees having salary > 2000 : "+rs.getInt("count"));
			rs.close();
			
			// Order By Query 6
			System.out.println("----------------------");
			System.out.println("Count people from each dept have salary < 3000?");
			System.out.println("----------------------");
			
			String selectQuery5 = "SELECT deptno,COUNT(sal) as count FROM emp WHERE sal < 3000 GROUP BY deptno;";
			rs = st.executeQuery(selectQuery5);
			System.out.println("deptno \tcount");
			while(rs.next())
				System.out.println(rs.getInt("deptno")+"\t"+rs.getInt("count"));
			rs.close();
			
			// Order By Query 7
			System.out.println("----------------------");
			System.out.println("Display dept has < 3 people.");
			System.out.println("----------------------");
			
			String selectQuery6 = "SELECT deptno,COUNT(empno) AS count from emp GROUP BY deptno HAVING count < 3;";
			rs = st.executeQuery(selectQuery6);
			if(rs.next())
				System.out.println("Dept that has < 3 people : "+rs.getInt("count"));
			else
				System.out.println("Dept that has < 3 people : NONE");
			rs.close();
			
			// Order By Query 8
			System.out.println("----------------------");
			System.out.println("Display deptno where dept's max(sal) > 3000?");
			System.out.println("----------------------");
			
			String selectQuery7 = "SELECT deptno from emp GROUP BY deptno HAVING MAX(sal) > 3000;";
			rs = st.executeQuery(selectQuery7);
			System.out.println("deptno");
			while(rs.next())
				System.out.println(rs.getInt("deptno"));
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
