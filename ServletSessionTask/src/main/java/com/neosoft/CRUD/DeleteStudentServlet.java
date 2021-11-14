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

@WebServlet(urlPatterns = "/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("stid"));
		try {
			out.print(StudentController.deleteStudentById(id) == 1 ? "<h1> Deleted Student With ID: "+id : "<h2>Could not find Student with ID: "+id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}
}
