package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rental.dao.CustomerDao;

@WebServlet(urlPatterns = "/rentcarform")
public class RentCarForm extends HttpServlet{

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
		out.println("<title>Rent Car Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navcust.html").include(req, resp);
		out.println("<div class='container'>");
		out.print("<div class='row'>");
		HttpSession session = req.getSession(false);
		int id = (int) session.getAttribute("custid");
		String carno = req.getParameter("id");
		String custname = CustomerDao.getNameById(id);
		
		out.print("<div class='col-md-6' style='border: 2px solid black; border-radius: 20px; padding: 20px;'>");
		out.print("<h3>Add Renter</h3>");
		out.print("<form action='addRentedCar' method='post'>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='carno'>Car Number</label>");
		out.print("<input type='text' class='form-control' id='carno' name='carno' value='"+carno+"'/>");
		out.println("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='cid'>ID</label>");
		out.print("<input type='Number' class='form-control' id='cid' name='cid' value='"+id+"'/>");
		out.println("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='cname'>Name</label>");
		out.print("<input type='text' class='form-control' id='cname' name='cname'  value='"+custname +"'/>");
		out.println("</div>");
		
		out.print("<button type='submit' class='btn btn-dark'>RENT</button>");
		out.print("</form>");
		
		out.print("</div");
		out.print("</div");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
