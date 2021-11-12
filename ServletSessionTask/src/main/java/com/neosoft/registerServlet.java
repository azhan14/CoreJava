package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/registerservlet")
public class registerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("txtname");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile"); 
		String qualify = req.getParameter("qualify");
		String course = req.getParameter("course");
		
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>Name</th>");
		out.print("<td>"+name+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>Age</th>");
		out.print("<td>"+age+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>Email</th>");
		out.print("<td>"+email+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>Mobile</th>");
		out.print("<td>"+mobile+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>Qualify</th>");
		out.print("<td>"+qualify+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>Course</th>");
		out.print("<td>"+course+"</td>");
		out.print("</tr>");
		out.print("</table>");
		out.close();
	}

}
