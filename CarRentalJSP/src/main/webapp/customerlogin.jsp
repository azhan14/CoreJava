<%@page import="com.neosoft.dao.CustomerDao"%>
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
<title>Customer Login</title>
</head>
<body>
	<% String email = request.getParameter("cemail");
	String password = request.getParameter("cpassword");
	
	if(CustomerDao.auth(email,password)) {
		HttpSession session2
		=request.getSession();
		session2.setAttribute("email",email);
		
		int id = CustomerDao.getId(email);
		if(id > 0) {
			session2.setAttribute("custid", id);
		}
	%>
		<jsp:include page="navcust.html"></jsp:include> 
		<jsp:include page="custhome.html"></jsp:include> 
	<% } else { %>
		<jsp:include page="navhome.html"></jsp:include> 
		<div class="container">
			<h3>Username or password error</h3>
			<jsp:include page="custloginform.html"></jsp:include> 
		</div>
		<% } %>
	<script src="bootstrap.min.js"></script>
</body>
</html>