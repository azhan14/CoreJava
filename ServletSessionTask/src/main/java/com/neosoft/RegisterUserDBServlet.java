package com.neosoft;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.UserController;
import com.neosoft.model.User;

@WebServlet(urlPatterns = "/registeruserDBservlet")
public class RegisterUserDBServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int uid = Integer.parseInt(req.getParameter("uid"));
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String uname = req.getParameter("txtusr");
		String upass = req.getParameter("txtpass");
		int i = 0;
		try {
			i = UserController.insertUser(uid, email, mobile, uname, upass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i == 1) {
			req.getRequestDispatcher("successregisterServlet").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("UNsuccessregisterServlet").forward(req, resp);
		}
		
	}

}
