package com.rental.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.beans.RenterBeans;
import com.rental.dao.RenterDao;

@WebServlet("/viewrenter")
public class ViewRenter extends HttpServlet{

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
		out.println("<title>Admin Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");
		
		List<RenterBeans> beans = RenterDao.getAll();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<thead class='thead-dark'><tr><th scope='col'>ID</th><th scope='col'>NAME</th><th scope='col'>EMAIL</th><th scope='col'>PASSWORD</th><th scope='col'>CONTACT</th><th scope='col'>EDIT</th><th scope='col'>DELETE</th></tr></thead>");
		out.print("<tbody>");
		
		for(RenterBeans bean: beans) {
			out.print("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getContact()+"</td><td><a href='editrenterform?id="+bean.getId()+"'>EDIT</a></td><td><a href='deleterenter?id="+bean.getId()+"'>DELETE</a></td></tr>");
		}
		
		out.print("</tbody>");
		out.print("</table>");
		
		out.println("</div>");
		
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
