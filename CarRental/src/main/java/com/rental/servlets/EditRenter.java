package com.rental.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.beans.RenterBeans;
import com.rental.dao.RenterDao;

@WebServlet(urlPatterns = "/editrenter")
public class EditRenter extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("rid"));
		String name = req.getParameter("rname");
		String email=req.getParameter("remail");
		String password=req.getParameter("rpassword");
		String mobile=req.getParameter("rcontact");
		
		RenterBeans bean = new RenterBeans(id,name, email, password, mobile);
		RenterDao.update(bean);
		
		resp.sendRedirect("viewrenter");
		
	}
}
