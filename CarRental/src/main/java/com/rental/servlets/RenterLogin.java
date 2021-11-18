package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rental.dao.RenterDao;

@WebServlet(urlPatterns = "/renterlogin")
public class RenterLogin extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.print("<style type='text/css'>");
		out.print("body{\r\n"
				+ "	background-color: #85FFBD;\r\n"
				+ "	background-image: linear-gradient(45deg, #85FFBD 0%, #FFFB7D 100%);\r\n"
				+ "}");
		out.print("</style>");
		out.println("<title>Renter Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		String email = req.getParameter("remail");
		String password = req.getParameter("rpassword");
		if(RenterDao.auth(email, password)) {
			HttpSession session=req.getSession();
			session.setAttribute("email",email);
			
			req.getRequestDispatcher("navrenter.html").include(req, resp);
			req.getRequestDispatcher("renterhome.html").include(req, resp);
		}
		else {
			req.getRequestDispatcher("navhome.html").include(req, resp);
			out.println("<div class='container'>");
			out.println("<h3>Username or password error</h3>");
			req.getRequestDispatcher("renterloginform.html").include(req, resp);
			out.println("</div>");
		}
		
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
