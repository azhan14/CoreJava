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

@WebServlet(urlPatterns = "/editcustform")
public class EditCustForm extends HttpServlet{

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
		out.println("<title>Edit Customer</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navcust.html").include(req, resp);
		out.println("<div class='container'>");
		out.print("<div class='row'>");
		
		HttpSession session = req.getSession(false);
		int id = (int)session.getAttribute("custid");
		CustomerBean bean = CustomerDao.getCustById(id);
		
		out.print("<div class='col-md-6' style='border: 2px solid black; border-radius: 20px; padding: 20px;'>");
		out.print("<h3>Add Renter</h3>");
		out.print("<form action='editcust' method='post'>");
		out.print("<input type='hidden' name='custid' value='"+bean.getId()+"'/>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='custname'>Name</label>");
		out.print("<input type='text' class='form-control' id='custname' name='custname' value='"+bean.getName()+"' required/>");
		out.println("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='custemail'>Email</label>");
		out.print("<input type='email' class='form-control' id='custemail' name='custemail' value='"+bean.getEmail()+"' required/>");
		out.println("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='custpass'>Password</label>");
		out.print("<input type='text' class='form-control' id='custpass' name='custpass' value='"+bean.getPassword()+"' required/>");
		out.println("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='custcontact'>Contact</label>");
		out.print("<input type='number' class='form-control' id='custcontact' name='custcontact' value='"+bean.getContact()+"' required/>");
		out.println("</div>");
		
		
		out.print("<button type='submit' class='btn btn-dark'>Submit</button>");
		out.print("</form>");
		
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
