package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rental.beans.CustomerBean;
import com.rental.dao.CustomerDao;

@WebServlet(urlPatterns = "/showprofile")
public class ShowProfile extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		out.println("<title>Profile</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navcust.html").include(req, resp);
		
		out.println("<div class='container'>");
		out.print("<div class='row'>");
		out.print("<div class='col-md-6' style='border: 2px solid black; border-radius: 20px; padding: 20px;'>");
		out.print("<h3>Add Renter</h3>");
		
		HttpSession session = req.getSession(false);
		int id = (int)session.getAttribute("custid");
		CustomerBean bean = CustomerDao.getCustById(id);
		
		out.print("<table class='table'>");
		out.print("<tr>");
		out.print("<th class = 'table-dark'>ID</th>");
		out.print("<td>"+bean.getId()+"</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<th class = 'table-dark'>Name</th>");
		out.print("<td>"+bean.getName()+"</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<th class = 'table-dark'>Email</th>");
		out.print("<td>"+bean.getEmail()+"</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<th class = 'table-dark'>Password</th>");
		out.print("<td>"+bean.getPassword()+"</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<th class = 'table-dark'>Contact</th>");
		out.print("<td>"+bean.getContact()+"</td>");
		out.print("</tr>");
		out.print("</table>");
		
		out.print("<form action='editcustform' method='GET'>");
		out.print("<button type='submit' class='btn btn-dark'>Update</button>");
		out.print("</form>");
		
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}

}
