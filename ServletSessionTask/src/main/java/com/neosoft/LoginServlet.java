package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/loginservlet")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String uname = req.getParameter("txtusr");
		String upass = req.getParameter("txtpass");
		
		
		String regUname = (String) req.getAttribute("uname");
		String regUpass = (String) req.getAttribute("upass");
		if(uname.equals(regUname) && upass.equals(regUpass)) {
			req.setAttribute("uname", uname);
			req.getRequestDispatcher("successservlet").forward(req, resp);
		}
		
		if(uname.toLowerCase().equals("admin") && upass.equals("admin123")) {
			req.getRequestDispatcher("successservlet").forward(req, resp);
		}
		else {
			out.print("<h3><font color = 'red'>Not a valid user. </font></h3><br>");
			out.print("<a href='register.html'>Click Here For Registration.</a>");
		}
		
		out.close();
	}
}
