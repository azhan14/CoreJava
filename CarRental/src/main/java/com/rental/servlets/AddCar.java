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

@WebServlet(urlPatterns = "/addcar")
public class AddCar extends HttpServlet{

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
		
		req.getRequestDispatcher("navrenter.html").include(req, resp);
		out.println("<div class='container'>");
		
		String carno = req.getParameter("carno");
		String carname = req.getParameter("carname");
		String carmf = req.getParameter("carmf");
		int caryear = Integer.parseInt(req.getParameter("caryear"));
		
		CarBean bean = new CarBean(caryear, carno, carname, carmf, carmf);
		int status = CarDao.add(bean);
		
		if(status > 0) {
			out.print("<h3>Car Added Successfully!!!</h3>");
			req.getRequestDispatcher("addcarform.html").include(req, resp);
		}
		else {
			out.print("<h3>Something went wrong (maybe same car number. check View Car). Try again.</h3>");
			req.getRequestDispatcher("addcarform.html").include(req, resp);
		}
		
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
