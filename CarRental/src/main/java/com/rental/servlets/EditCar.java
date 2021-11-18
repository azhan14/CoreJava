package com.rental.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.beans.CarBean;
import com.rental.dao.CarDao;

@WebServlet(urlPatterns = "/editcar")
public class EditCar extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carno = req.getParameter("carno");
		String carname = req.getParameter("carname");
		String carmf = req.getParameter("carmf");
		int caryear = Integer.parseInt(req.getParameter("caryear"));
		String carstatus = req.getParameter("carstatus");
		
		CarBean bean = new CarBean(caryear, carno, carname, carmf, carstatus);
		CarDao.update(bean);
		resp.sendRedirect("viewcar");
	}
}
