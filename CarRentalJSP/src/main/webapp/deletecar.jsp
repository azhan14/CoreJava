<%@page import="com.neosoft.dao.CarDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
	background-color: #85FFBD;
	background-image: linear-gradient(45deg, #85FFBD 0%, #FFFB7D 100%);
}
</style>
<link rel="stylesheet" href="bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Delete Car</title>
</head>
<body>
	<% String Carno = request.getParameter("id");
	CarDao.delete(Carno);
	response.sendRedirect("viewcar.jsp"); %>
	<script src="bootstrap.min.js"></script>
</body>
</html>