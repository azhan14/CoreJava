package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/successservlet")
public class SuccessServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h3>Hi, Welcome "+req.getParameter("txtusr")+"</h3> ");
		
		
		Date dt = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(dt);
	    int hours = c.get(Calendar.HOUR_OF_DAY);
	    out.print("<h3>");
	    if(hours>3 && hours<=12){
	        out.print("Good Morning");
	    }else if(hours>12 && hours<=16){
	        out.print("Good Afternoon");
	    }else if(hours>16 && hours<=21){
	        out.print("Good Evening");
	    }else if(hours>21 && hours<=3){
	        out.print("Good Night");
	    }
	    out.print("</h3>");
	    out.close();
	}
}
