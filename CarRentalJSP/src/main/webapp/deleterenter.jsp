<%@page import="com.neosoft.dao.RenterDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Renter</title>
</head>
<body>	
	<% int id = Integer.parseInt(request.getParameter("id"));
	RenterDao.delete(id);
	response.sendRedirect("viewrenter.jsp");%>
</body>
</html>