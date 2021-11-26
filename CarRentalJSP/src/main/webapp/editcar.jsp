<%@page import="com.neosoft.dao.CarDao"%>
<%@page import="com.neosoft.beans.CarBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Car</title>
</head>
<body>
	<% String carno = request.getParameter("carno");
	String carname = request.getParameter("carname");
	String carmf = request.getParameter("carmf");
	int caryear = Integer.parseInt(request.getParameter("caryear"));
	int carprice = Integer.parseInt(request.getParameter("carprice"));
	String carstatus = request.getParameter("carstatus");
	
	CarBean bean = new CarBean(caryear, carno, carname, carmf, carprice, carstatus);
	CarDao.update(bean);
	response.sendRedirect("viewcar.jsp"); %>
</body>
</html>