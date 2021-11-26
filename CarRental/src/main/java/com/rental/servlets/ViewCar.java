package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.beans.CarBean;
import com.rental.dao.CarDao;

@WebServlet(urlPatterns = "/viewcar")
public class ViewCar extends HttpServlet{

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
		
		req.getRequestDispatcher("navrenter.html").include(req, resp);
		out.println("<div class='container'>");
		
		List<CarBean> beans = CarDao.getAll();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<thead class='thead-dark'><tr><th scope='col'>NO.</th><th scope='col'>NAME</th><th scope='col'>MANUFACTURER</th><th scope='col'>YEAR</th><th scope='col'>AVAILABLE</th><th scope='col'>EDIT</th><th scope='col'>DELETE</th></tr></thead>");
		out.print("<tbody>");
		
		for(CarBean bean: beans) {
			out.print("<tr><td>"+bean.getNumber()+"</td><td>"+bean.getName()+"</td><td>"+bean.getMf()+"</td><td>"+bean.getYear()+"</td><td>"+bean.getStatus()+"</td><td><a href='editcarform?id="+bean.getNumber()+"'>EDIT</a></td><td><a href='deletecar?id="+bean.getNumber()+"'>DELETE</a></td></tr>");
		}
		
		out.print("</tbody>");
		out.print("</table");
		
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
