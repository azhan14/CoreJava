package com.neosoft.JDBCTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DdlDmlTask {
	
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
			
			// Table creation.
			
//			String createTableQuery = "CREATE TABLE IF NOT EXISTS student_info" + 
//					"(rollno INT AUTO_INCREMENT PRIMARY KEY, "
//					+ "name VARCHAR(50) NOT NULL,"
//					+ "city VARCHAR(50) NOT NULL)";
//			System.out.println("table creation "+st.executeUpdate(createTableQuery));
//			
//			String insertQuery = "INSERT INTO student_info "
//					+ "VALUES(1,'gautam','jalgaon'),"
//					+ "(2,'balaji','parbhani'),"
//					+ "(3,'rushin','jalgaon')";
//			System.out.println("recodrs inseert : "+st.executeUpdate(insertQuery));
//			
//			String createTableQuery2 = "CREATE TABLE IF NOT EXISTS marks" + 
//					"(rollno INT , sub_code INT ,mark INT)";
//			System.out.println("table creation "+st.executeUpdate(createTableQuery2));
//			
//			String insertQuery2 = "INSERT INTO marks "
//					+ "VALUES(1,100,80),"
//					+ "(2,100,null),"
//					+ "(1,101,90),"
//					+ "(2,101,78),"
//					+ "(3,100,30),"
//					+ "(3,101,null)";
//			System.out.println("recodrs inseert : "+st.executeUpdate(insertQuery2));
//			
//			
//			String createTableQuery3 = "CREATE TABLE IF NOT EXISTS subject" + 
//					"(sub_code INT ,sub_name 	VARCHAR(50))";
//			System.out.println("table creation "+st.executeUpdate(createTableQuery3));
//			String insertQuery3 = "INSERT INTO subject "
//					+ "VALUES(100,'dbms'),"
//					+ "(101,'SE')";
//			System.out.println("recodrs inseert : "+st.executeUpdate(insertQuery3));
			
			// Query 1
			System.out.println("----------------------");
			System.out.println("Find out average marks of each student along with roll number of student.");
			System.out.println("----------------------");
			
			String selectquery = " SELECT rollno,round(avg(mark),2) as avgmark FROM marks GROUP BY rollno; ";
			rs=st.executeQuery(selectquery);
			System.out.println("rollno \t avgmark");
			while(rs.next())
				System.out.println(rs.getInt("rollno")+"\t"+rs.getBigDecimal("avgmark"));
			rs.close(); 
			
			// Query 2
			System.out.println("----------------------");
			System.out.println("Find out how many students have failed i.e. obtained less than 40 marks in DBMS.");
			System.out.println("----------------------");
			
			String selectquery2 = "SELECT count(rollno) AS count FROM marks WHERE mark< 40 AND sub_code=(SELECT sub_code FROM subject\r\n"
					+ "WHERE sub_name='dbms');";
			rs=st.executeQuery(selectquery2);
			System.out.println("count");
			while(rs.next())
				System.out.println(rs.getInt("count"));
			rs.close();  
			
			// Query 3
			System.out.println("----------------------");
			System.out.println("Find names of Students who are absent in Exam i.e. students having null marks.");
			System.out.println("----------------------");
			
			String selectquery3 = "SELECT s.name FROM student_info AS s LEFT JOIN marks AS m USING(rollno) WHERE m.mark IS NULL;";
			rs=st.executeQuery(selectquery3);
			System.out.println("Name");
			while(rs.next())
				System.out.println(rs.getString("name"));
			rs.close(); 
			
			// Query 4
			System.out.println("----------------------");
			System.out.println("Find the name of students who live in either ‘pune’ or 'jalgaon’.");
			System.out.println("----------------------");
			
			String selectquery4 = "SELECT name FROM student_info WHERE city IN ('jalgaon','pune');";
			rs=st.executeQuery(selectquery4);
			System.out.println("Name");
			while(rs.next())
				System.out.println(rs.getString("name"));
			rs.close();  
			
			// Query 5
			System.out.println("----------------------");
			System.out.println("Find out roll no and total marks of each student.");
			System.out.println("----------------------");
			
			String selectquery5 = "SELECT sum(mark) as totalmarks,rollno FROM marks GROUP BY rollno;";
			rs=st.executeQuery(selectquery5);
			System.out.println("Total \t rollno");
			while(rs.next())
				System.out.println(rs.getInt("totalmarks")+"\t "+rs.getInt("rollno"));
			rs.close(); 	
			
			
			// Query 6
			System.out.println("----------------------");
			System.out.println("Find those student names which start with 'ba'.");
			System.out.println("----------------------");
			
			String selectquery6 = "SELECT name FROM student_info WHERE name LIKE 'ba%';";
			rs=st.executeQuery(selectquery6);
			System.out.println("Name");
			while(rs.next())
				System.out.println(rs.getString("name"));
			rs.close();

			
			// Query 7
			System.out.println("----------------------");
			System.out.println("Display total no of students having greater than 75 marks in any one subject.");
			System.out.println("----------------------");
			
			String selectquery7 = "SELECT count(*) AS count FROM marks WHERE mark > 75;";
			rs=st.executeQuery(selectquery7);
			System.out.println("Count");
			while(rs.next())
				System.out.println(rs.getInt("count"));
			rs.close();   
			
			
			//Query 8
			System.out.println("----------------------");
			System.out.println("Display marks of all students for DBMS subject.");
			System.out.println("----------------------");
			
			String selectquery8 = "SELECT rollno, mark FROM marks WHERE sub_code = (SELECT sub_code FROM subject WHERE\r\n"
					+ "sub_name='dbms');";
			rs=st.executeQuery(selectquery8);
			System.out.println("rollno \t mark");
			while(rs.next())
				System.out.println(rs.getInt("rollno")+"\t"+rs.getInt("mark"));
			rs.close();   
			
			
			// Query 9
			System.out.println("----------------------");
			System.out.println("Display no of students appeared for the exam.");
			System.out.println("----------------------");
			
			String selectquery9 = "SELECT COUNT(DISTINCT(rollno)) AS count FROM marks WHERE mark IS NOT NULL;";
			rs=st.executeQuery(selectquery9);
			System.out.println("Count");
			while(rs.next())
				System.out.println(rs.getInt("count"));
			rs.close();
			
			
			// Query 10
			System.out.println("----------------------");
			System.out.println("Display all subjects marks of students whose name is gautam.");
			System.out.println("----------------------");
			String selectquery10 = "SELECT mark FROM marks WHERE rollno=(SELECT rollno FROM student_info WHERE name='gautam');";
			rs=st.executeQuery(selectquery10);
			System.out.println("Marks");
			while(rs.next())
				System.out.println(rs.getInt("mark"));
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally { //closing resources and connection
			try {
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
				if(conn != null)
					conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}

