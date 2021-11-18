package com.rental.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rental.dao.CarDao;

@WebServlet(urlPatterns = "/deletecar")
public class DeleteCar extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Carno = req.getParameter("id");
		CarDao.delete(Carno);
		resp.sendRedirect("viewcar");
	}
}
