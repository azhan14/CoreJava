<%@page import="com.neosoft.dao.CarDao"%>
<%@page import="java.util.List"%>
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
<title>View Car</title>
</head>
<body>
	<jsp:include page="navrenter.html"></jsp:include> 
	<div class="container">
		<table class="table table-bordered table-striped">
			<thead class='thead-dark'>
				<tr>
					<th scope='col'>NO.</th>
					<th scope='col'>NAME</th>
					<th scope='col'>MANUFACTURER</th>
					<th scope='col'>YEAR</th>
					<th scope='col'>PRICE</th>
					<th scope='col'>AVAILABLE</th>
					<th scope='col'>EDIT</th>
					<th scope='col'>DELETE</th>
				</tr>
			</thead>
			<tbody>
				<% 	List<CarBean> beans = CarDao.getAll();
					for(CarBean bean: beans) {
					out.print("<tr><td>"+bean.getNumber()+"</td><td>"+bean.getName()+"</td><td>"+bean.getMf()+"</td><td>"+bean.getYear()+"</td><td>"+bean.getPrice()+"</td><td>"+bean.getStatus()+"</td><td><a href='editcarform.jsp?id="+bean.getNumber()+"'>EDIT</a></td><td><a href='deletecar.jsp?id="+bean.getNumber()+"'>DELETE</a></td></tr>");
					}%>
			</tbody>
		</table>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>