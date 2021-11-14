package com.neosoft.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.model.Student;

public class StudentController {
	
	public static List<Student> getStudents() throws Exception{
		List<Student> students = new ArrayList<Student>();
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "SELECT * FROM STUDENT";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				students.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return students;
	}
	
	public static Student getStudentById(int id) throws Exception{
		Student student = new Student();
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "SELECT * FROM STUDENT WHERE stid = ? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				student.setStid(rs.getInt(1));
				student.setStname(rs.getString(2));
				student.setStcourse(rs.getString(3));
				student.setMarks(rs.getInt(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		if(student.getStname() == null) {
			return null;
		}
		return student;
	}
	
	public static int insertStudent(Student student) throws SQLException{
		int flag = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "INSERT INTO student(stname,stcourse,marks) VALUES(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, student.getStname());
			pst.setString(2, student.getStcourse());
			pst.setInt(3, student.getMarks());
			flag = pst.executeUpdate();
			pst.close();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null)
				con.close();
		}
		return flag;
	}
	
	public static int updateMarksById(int id, int marks) throws SQLException{
		Connection con = JDBCProperties.getConnection();
		int flag = 0;
		try {
			String query = "UPDATE student SET marks = ? WHERE stid = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, marks);
			pst.setInt(2,id);
			flag = pst.executeUpdate();
			pst.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return flag;
	}
	
	public static int updateCourseById(int id, String course) throws SQLException{
		Connection con = JDBCProperties.getConnection();
		int flag = 0;
		try {
			String query = "UPDATE student SET stcourse = ? WHERE stid = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, course);
			pst.setInt(2,id);
			flag = pst.executeUpdate();
			pst.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return flag;
	}
	
	public static int deleteStudentById(int id) throws SQLException{
		Connection con = JDBCProperties.getConnection();
		int flag = 0;
		try {
			String query = "DELETE FROM student WHERE stid = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			flag = pst.executeUpdate();
			pst.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return flag;
	}
}
