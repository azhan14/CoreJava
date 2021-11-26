<%@page import="com.neosoft.dao.RenterDao"%>
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
<title>Insert title here</title>
</head>
<body>
	<% String email = request.getParameter("remail");
	String password = request.getParameter("rpassword");
	if(RenterDao.auth(email, password)) { 
		HttpSession session2 = request.getSession();
		session2.setAttribute("email",email);%>
		<jsp:include page="navrenter.html"></jsp:include>
		<jsp:include page="renterhome.html"></jsp:include>
		<% } else { %>
		<jsp:include page="navhome.html"></jsp:include>
		<div class="container">
			<h3>Username or password error</h3>
			<jsp:include page="renterloginform.html"></jsp:include>
		</div>
		<% } %>
	<script src="bootstrap.min.js"></script>
</body>
</html>