package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.beans.CarBean;
import com.rental.dao.CarDao;

@WebServlet(urlPatterns = "/editcarform")
public class EditCarForm extends HttpServlet{

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
		out.println("<title>Edit Car</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navrenter.html").include(req, resp);
		out.println("<div class='container'>");
		out.print("<div class='row'>");
		
		String carno = req.getParameter("id");
		
		CarBean bean = CarDao.getByCarNo(carno);
		
		out.print("<div class='col-md-6' style='border: 2px solid black; border-radius: 20px; padding: 20px;'>");
		out.print("<h3>Add Renter</h3>");
		out.print("<form action='editcar' method='post'>");
		out.print("<input type='hidden' name='carno' value='"+bean.getNumber()+"'/>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='carname'>Name</label>");
		out.print("<input type='text' class='form-control' id='carname' name='carname' value='"+bean.getName()+"' required/>");
		out.println("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='carmf'>Manufacturer</label>");
		out.print("<input type='text' class='form-control' id='carmf' name='carmf' value='"+bean.getMf()+"' required/>");
		out.println("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='caryear'>Year of Buy</label>");
		out.print("<input type='number' class='form-control' id='caryear' name='caryear' value='"+bean.getYear()+"' required/>");
		out.println("</div>");
		
		out.print("<div class='form-group'>");
		out.print("<label for='carstatus'>Available</label>");
		out.print("<select class='form-control' id='carstatus' name='carstatus'>");
		if(bean.getStatus().equals("YES")) {
			out.print("<option value='YES' selected>YES</option>");
			out.print("<option value='NO'>NO</option>");
		}
		else {
			out.print("<option value='YES'>YES</option>");
			out.print("<option value='NO' selected>NO</option>");
		}
		out.print("</select>");
		out.println("</div>");
		
		out.print("<button type='submit' class='btn btn-dark'>Submit</button>");
		out.print("</form>");
		
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
