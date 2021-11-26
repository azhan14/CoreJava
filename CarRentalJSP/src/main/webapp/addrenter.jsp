<%@page import="com.neosoft.dao.RenterDao"%>
<%@page import="com.neosoft.beans.RenterBeans"%>
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
<link rel="stylesheet" href="bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Add Renter</title>
</head>
<body>
	<jsp:include page="navadmin.html"></jsp:include> 
	<div class="container">
		<%String name=request.getParameter("rname");
		String email=request.getParameter("remail");
		String password=request.getParameter("rpassword");
		String mobile=request.getParameter("rcontact");
		RenterBeans renter = new RenterBeans(name, email, password, mobile);
		int status = RenterDao.add(renter);
		if(status > 0) { %>
			<h3>Renter Added Successfully!!!</h3>
			<jsp:include page="addrenterform.html"></jsp:include>
		<% } 
		else { %>
			<h3>Something went wrong. Try again.</h3>
			<jsp:include page="addrenterform.html"></jsp:include>
		<% } %>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>