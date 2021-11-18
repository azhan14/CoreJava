package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.beans.CustomerBean;
import com.rental.dao.CustomerDao;

@WebServlet(urlPatterns = "/customerregister")
public class CustomerRegister extends HttpServlet{

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
		out.println("<title>Customer</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navhome.html").include(req, resp);
		out.println("<div class='container'>");
		
		String name = req.getParameter("cname");
		String email = req.getParameter("cremail");
		String password = req.getParameter("crpassword");
		String contact = req.getParameter("ccontact");
		
		CustomerBean bean = new CustomerBean(name, email, password, contact);
		int status = CustomerDao.add(bean);
		
		if(status > 0) {
			out.print("<h3>Customer Added Successfully!!!</h3>");
			req.getRequestDispatcher("custloginform.html").include(req, resp);
		}
		else {
			out.print("<h3>Something went wrong. Try again.</h3>");
			req.getRequestDispatcher("addcustomerform.html").include(req, resp);
		}
		
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
