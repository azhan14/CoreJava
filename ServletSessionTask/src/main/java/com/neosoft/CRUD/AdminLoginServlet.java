package com.neosoft.CRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/adminloginservlet")
public class AdminLoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String uname = req.getParameter("txtusr");
		String upass = req.getParameter("txtpass");
		
		if(uname.toLowerCase().equals("admin") && upass.equals("admin123")) {
			req.getRequestDispatcher("HomePage.html").forward(req, resp);
		}
		else {
			out.print("<h3><font color = 'red'>Not a valid user. </font></h3><br>");
			out.print("<a href='loginPage.html'>Click here to Login again.</a>");
		}
		
		out.close();
	}
}
