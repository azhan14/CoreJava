package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.beans.RenterBeans;
import com.rental.dao.RenterDao;

@WebServlet(urlPatterns = "/addrenter")
public class AddRenter extends HttpServlet{

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
		out.println("<title>Admin Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");
		
		String name=req.getParameter("rname");
		String email=req.getParameter("remail");
		String password=req.getParameter("rpassword");
		String mobile=req.getParameter("rcontact");
		
		RenterBeans renter = new RenterBeans(name, email, password, mobile);
		int status = RenterDao.add(renter);
		if(status > 0) {
			out.print("<h3>Renter Added Successfully!!!</h3>");
			req.getRequestDispatcher("addrenterform.html").include(req, resp);
		}
		else {
			out.print("<h3>Something went wrong. Try again.</h3>");
			req.getRequestDispatcher("addrenterform.html").include(req, resp);
		}
		out.print("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
