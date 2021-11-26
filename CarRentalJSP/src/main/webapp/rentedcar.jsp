<%@page import="com.neosoft.dao.CarDao"%>
<%@page import="com.neosoft.beans.RentedCarBeans"%>
<%@page import="java.util.List"%>
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
<title>Rented Car</title>
</head>
<body>
	<jsp:include page="navcust.html"></jsp:include> 
	<div class="container">
		<% HttpSession session2 = request.getSession(false);
			int id = (int) session2.getAttribute("custid");
			List<RentedCarBeans> beans = CarDao.getRentedCar(id); %>
			
			<table class="table table-bordered table-striped">
				<thead class='thead-dark'>
					<tr>
						<th scope='col'>NO.</th>
						<th scope='col'>ID</th>
						<th scope='col'>NAME</th>
						<th scope='col'>PRICE</th>
						<th scope='col'>RETURN STATUS</th>
						<th scope='col'>RETURN</th>
					</tr>
				</thead>
			<tbody>
				<% for(RentedCarBeans bean: beans) {
					out.print("<tr><td>"+bean.getCarno()+"</td><td>"+bean.getCustid()+"</td><td>"+bean.getCustname()+"</td><td>"+bean.getPrice()+"</td><td>"+bean.getReturnstatus()+"</td><td><a href='returncar.jsp?id="+bean.getCarno()+"'>RETURN</a></td></tr>");
				} %>
			</tbody>
		</table>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>