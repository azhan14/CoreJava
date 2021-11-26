<%@page import="java.util.List"%>
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
<title>View Renter</title>
</head>
<body>
	<jsp:include page="navadmin.html"></jsp:include> 
	<div class="container">
		<table class="table table-bordered table-striped">
			<thead class='thead-dark'>
				<tr>
					<th scope='col'>ID</th>
					<th scope='col'>NAME</th>
					<th scope='col'>EMAIL</th>
					<th scope='col'>PASSWORD</th>
					<th scope='col'>CONTACT</th>
					<th scope='col'>EDIT</th>
					<th scope='col'>DELETE</th>
				</tr>
			</thead>
			<tbody>
				<%	List<RenterBeans> beans = RenterDao.getAll(); 
				for(RenterBeans bean: beans) { 
					out.print("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getContact()+"</td><td><a href='editrenterform.jsp?id="+bean.getId()+"'>EDIT</a></td><td><a href='deleterenter.jsp?id="+bean.getId()+"'>DELETE</a></td></tr>");
					}%>
			</tbody>
		</table>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>