package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rental.beans.RentedCarBeans;
import com.rental.dao.CarDao;

@WebServlet(urlPatterns = "/rentedcar")
public class RentedCar extends HttpServlet{

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
		out.println("<title>View Car</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navcust.html").include(req, resp);
		out.println("<div class='container'>");
		
		HttpSession session = req.getSession(false);
		int id = (int) session.getAttribute("custid");
		List<RentedCarBeans> beans = CarDao.getRentedCar(id);
		
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<thead class='thead-dark'><tr><th scope='col'>NO.</th><th scope='col'>ID</th><th scope='col'>NAME</th><th scope='col'>RETURN STATUS</th><th scope='col'>RETURN</th></tr></thead>");
		out.print("<tbody>");
		
		for(RentedCarBeans bean: beans) {
			out.print("<tr><td>"+bean.getCarno()+"</td><td>"+bean.getCustid()+"</td><td>"+bean.getCustname()+"</td><td>"+bean.getReturnstatus()+"</td><td><a href='returncar?id="+bean.getCarno()+"'>RETURN</a></td></tr>");
		}
		
		
		out.print("</tbody>");
		out.print("</table");
		
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
