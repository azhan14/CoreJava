package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/loginform")
public class LoginForm extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"ISO-8859-1\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<form action'loginservlet' method = 'POST'>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<td><label>Username:</label></td>");
		out.print("<td><input type='text' name='txtusr'></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label>Password:</label></td>");
		out.print("<td><input type='password' name='txtpass'></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td></td>");
		out.print("<td><input type='submit' value'Login'></td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}
}
