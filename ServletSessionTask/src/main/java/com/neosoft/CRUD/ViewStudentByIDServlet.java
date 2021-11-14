package com.neosoft.CRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.StudentController;
import com.neosoft.model.Student;

@WebServlet(urlPatterns = "/viewstudentbyidservlet")
public class ViewStudentByIDServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			Student student = StudentController.getStudentById(id);
			if(student == null) {
				out.print("<h3> Student with ID "+id+" not found</h3>");
			}
			else {
				out.print("<table border=1>");
				out.print("<tr><th>ID</th><th>NAME</th><th>COURSE</th><th>MARKS</th></tr>");
				out.print("<tr><td>"+student.getStid()+"</td><td>"+student.getStname()+"</td><td>"+student.getStcourse()+"</td><td>"+student.getMarks()+"</td.</tr>");
				out.print("</table>");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
		
	}
}
