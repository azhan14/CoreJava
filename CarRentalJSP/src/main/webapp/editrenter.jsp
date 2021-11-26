<%@page import="com.neosoft.dao.RenterDao"%>
<%@page import="com.neosoft.beans.RenterBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Renter</title>
</head>
<body>
	<% int id = Integer.parseInt(request.getParameter("rid"));
	String name = request.getParameter("rname");
	String email = request.getParameter("remail");
	String password = request.getParameter("rpassword");
	String mobile = request.getParameter("rcontact");
	RenterBeans bean = new RenterBeans(id,name, email, password, mobile);
	RenterDao.update(bean);
	response.sendRedirect("viewrenter.jsp"); %>
</body>
</html>