<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body{
		background-color: #85FFBD;
		background-image: linear-gradient(45deg, #85FFBD 0%, #FFFB7D 100%);
	}
</style>
<meta charset="ISO-8859-1">
<title>Admin Section</title>
<link rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>
	<% String email=request.getParameter("aemail");
	String password=request.getParameter("apassword");
	if(email.equals("admin@admin.com")&&password.equals("admin123")){
		HttpSession session2=request.getSession();
		session.setAttribute("admin","true"); %>
	<jsp:include page="navadmin.html"></jsp:include> 
	<jsp:include page="adminhome.html"></jsp:include>
	
		<% }else{ %> 
		
		<jsp:include page="navhome.html"></jsp:include> 
		<div class="container">
		<h3>Username or password error</h3>
		<jsp:include page="adminloginform.html"></jsp:include> 
		</div>
		
		<% } %>
	<script src="bootstrap.min.js"></script>
</body>
</html>