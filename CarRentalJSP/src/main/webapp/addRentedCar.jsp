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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navcust.html"></jsp:include> 
	<div class="container">
		<% String carno = request.getParameter("carno");
		int custid = Integer.parseInt(request.getParameter("cid"));
		String custname = request.getParameter("cname");
		int carprice = Integer.parseInt(request.getParameter("carprice"));
		int status = CustomerDao.rentCar(carno, custid, custname,carprice);
		if(status > 0) { %>
			<h1>Car Rented Successfully!!</h1>
			<a href="rentedcar.jsp">CLICK HERE TO SEE RENTED CARS</a>
		<% } else { %>
			<h1>Something went wrong.</h1>
			<a href="rentcar.jsp">CLICK HERE TO SEE OTHER AVAILABLE CARS</a>
		<% } %>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>