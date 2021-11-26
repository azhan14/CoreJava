<%@page import="com.neosoft.dao.CarDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Car</title>
</head>
<body>
	<% String Carno = request.getParameter("id");
	CarDao.returnCar(Carno);
	response.sendRedirect("rentedcar.jsp"); %>
</body>
</html>