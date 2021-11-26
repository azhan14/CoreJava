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
<title>Profile</title>
</head>
<body>
	<jsp:include page="navcust.html"></jsp:include> 
	<div class="container">
		<div class="row">
			<div class="col-md-6" style="border: 2px solid black; border-radius: 20px; padding: 20px;">
				<h3>Profile</h3>
				<% HttpSession session2 = request.getSession(false);
				int id = (int)session2.getAttribute("custid");
				CustomerBean bean = CustomerDao.getCustById(id); %>
				<table class="table">
					<tr>
						<th class = "table-dark">ID</th>
						<td><%= bean.getId() %></td>
					</tr>
					
					<tr>
						<th class = "table-dark">Name</th>
						<td><%= bean.getName() %></td>
					</tr>
					
					<tr>
						<th class = "table-dark">Email</th>
						<td><%= bean.getEmail() %></td>
					</tr>
					
					<tr>
						<th class = "table-dark">Password</th>
						<td><%= bean.getPassword() %></td>
					</tr>
					
					<tr>
						<th class = "table-dark">Contact</th>
						<td><%= bean.getContact() %></td>
					</tr>
					
				</table>
				<form action="editcustform.jsp" method="GET">
					<button type="submit" class="btn btn-dark">Update</button>
				</form>
			</div>
		</div>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>