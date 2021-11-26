<%@page import="com.neosoft.dao.CustomerDao"%>
<%@page import="com.neosoft.beans.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="bootstrap.min.css">
<style type="text/css">
body{
	background-color: #85FFBD;
	background-image: linear-gradient(45deg, #85FFBD 0%, #FFFB7D 100%);
}
</style>
<meta charset="ISO-8859-1">
<title>Customer Register</title>
</head>
<body>
	<jsp:include page="navhome.html"></jsp:include>
	<div class="container">
		<% String name = request.getParameter("cname");
		String email = request.getParameter("cremail");
		String password = request.getParameter("crpassword");
		String contact = request.getParameter("ccontact");
		
		CustomerBean bean = new CustomerBean(name, email, password, contact);
		int status = CustomerDao.add(bean); 
		if(status > 0) { %>
			<h3>Customer Added Successfully!!!</h3>
			<jsp:include page="custloginform.html"></jsp:include>
		<% } else { %>
			<h3>Something went wrong. Try again.</h3>
			<jsp:include page="addcustomerform.html"></jsp:include>
		<% } %>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>