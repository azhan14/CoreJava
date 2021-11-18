package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.dao.CustomerDao;

@WebServlet(urlPatterns = "/addRentedCar")
public class AddRentedCar extends HttpServlet{

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
		
		req.getRequestDispatcher("navcust.html").include(req, resp);
		out.println("<div class='container'>");
		
		String carno = req.getParameter("carno");
		int custid = Integer.parseInt(req.getParameter("cid"));
		String custname = req.getParameter("cname");
		
		int status = CustomerDao.rentCar(carno, custid, custname);
		
		if(status > 0) {
			out.print("<h1>Car Rented Successfully!!</h1>");
			out.print("<a href='rentedcar'>CLICK HERE TO SEE RENTED CARS</a>");
		}
		else {
			out.print("<h1>Something went wrong.</h1>");
			out.print("<a href='rentcar'>CLICK HERE TO SEE OTHER AVAILABLE CARS</a>");
		}
		
		
		
		out.print("</div");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
