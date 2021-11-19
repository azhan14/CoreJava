package com.rental.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.beans.CustomerBean;
import com.rental.dao.CustomerDao;

@WebServlet(urlPatterns = "/editcust")
public class EditCust extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("custid"));
		String name = req.getParameter("custname");
		String email = req.getParameter("custemail");
		String password = req.getParameter("custpass");
		String contact = req.getParameter("custcontact");
		
		CustomerBean bean = new CustomerBean(id, name, email, password, contact);
		CustomerDao.update(bean);
		resp.sendRedirect("showprofile");
	}
}
