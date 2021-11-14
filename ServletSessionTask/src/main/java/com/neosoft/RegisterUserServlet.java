package com.neosoft;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.model.User;

@WebServlet(urlPatterns = "/registeruserservlet")
public class RegisterUserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int uid = Integer.parseInt(req.getParameter("uid"));
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String uname = req.getParameter("txtusr");
		String upass = req.getParameter("txtpass");
		
		User user = new User(uid,email,mobile,uname,upass);
		
		req.setAttribute("uname", user.getUname());
		req.setAttribute("upass", user.getPass());
		req.getRequestDispatcher("successregisterServlet").forward(req, resp);
	}
	
}
