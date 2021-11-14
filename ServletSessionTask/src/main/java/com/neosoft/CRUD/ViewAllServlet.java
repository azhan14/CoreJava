package com.neosoft.CRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.StudentController;

@WebServlet(urlPatterns = "/viewallservlet")
public class ViewAllServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<table border=1>");
		out.print("<tr><th>ID</th><th>NAME</th><th>COURSE</th><th>MARKS</th></tr>");
		try {
			StudentController.getStudents().stream().forEach(
					student -> out.print("<tr><td>"+student.getStid()+"</td><td>"+student.getStname()+"</td><td>"+student.getStcourse()+"</td><td>"+student.getMarks()+"</td.</tr>"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("</table>");
		out.close();
	}
}
