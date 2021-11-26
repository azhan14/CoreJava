<%@page import="com.neosoft.dao.CarDao"%>
<%@page import="com.neosoft.beans.CarBean"%>
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
<title>Add Car</title>
</head>
<body>
	<jsp:include page="navrenter.html"></jsp:include>
	<div class="container">
		<% String carno = request.getParameter("carno");
		String carname = request.getParameter("carname");
		String carmf = request.getParameter("carmf");
		int caryear = Integer.parseInt(request.getParameter("caryear"));
		int carprice = Integer.parseInt(request.getParameter("carprice"));
		CarBean bean = new CarBean(caryear, carno, carname, carmf, carprice, carmf);
		int status = CarDao.add(bean);
		if(status > 0) { %>
			<h3>Car Added Successfully!!!</h3>
			<jsp:include page="addcarform.html"></jsp:include>
		<% } else { %>
			<h3>Something went wrong (maybe same car number. check View Car). Try again.</h3>
			<jsp:include page="addcarform.html"></jsp:include>
		<% } %>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>