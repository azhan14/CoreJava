package com.neosoft.CRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.StudentController;
import com.neosoft.model.Student;

@WebServlet(urlPatterns = "/addstudentservlet")
public class AddStudentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		// JDBC Controller Call
		Student student = new Student();
		student.setStname(req.getParameter("stname"));
		student.setStcourse(req.getParameter("stcourse"));
		student.setMarks(Integer.parseInt(req.getParameter("stmarks")));
		
		try {
			out.print(StudentController.insertStudent(student) == 1 ? "<h2>Student Added to DB</h2>" : "<h2>Something went wrong. Try again.</h2>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}
}
