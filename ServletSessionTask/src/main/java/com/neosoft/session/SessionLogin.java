package com.neosoft.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/sessionlogin")
public class SessionLogin extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String uname = req.getParameter("txtusr");
		String upass = req.getParameter("txtpass");
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			String regname = (String)session.getAttribute("uname");
			String regpass = (String)session.getAttribute("upass");
			if(uname.equals(regname) && upass.equals(regpass)) {
				req.getRequestDispatcher("sessionsuccessservlet").forward(req, resp);
			}
		}
		
		if(uname.toLowerCase().equals("admin") && upass.equals("admin123")) {
			req.getRequestDispatcher("sessionsuccessservlet").forward(req, resp);
		}
		else {
			out.print("<h3><font color = 'red'>Not a valid user. </font></h3><br>");
			out.print("<a href='sessionregister.html'>Click Here For Registration.</a>");
		}
	}
}
