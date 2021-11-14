package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.UserController;

@WebServlet(urlPatterns = "/loginDBservlet")
public class LoginDBServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String uname = req.getParameter("txtusr");
		String upass = req.getParameter("txtpass");
		
		if(uname.toLowerCase().equals("admin") && upass.equals("admin123")) {
			req.getRequestDispatcher("successservlet").forward(req, resp);
		} else {
			try {
				if(UserController.searchUser(uname, upass) == 1) {
					req.getRequestDispatcher("successservlet").forward(req, resp);
				}
				else {
					out.print("<h3><font color = 'red'>Not a valid user. </font></h3><br>");
					out.print("<a href='registerDB.html'>Click Here For Registration.</a>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		out.close();
	}
}
