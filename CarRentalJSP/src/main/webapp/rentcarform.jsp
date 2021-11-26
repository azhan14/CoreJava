<%@page import="com.neosoft.dao.CarDao"%>
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
<title>Rent Car Form</title>
</head>
<body>
	<jsp:include page="navcust.html"></jsp:include> 
	<div class="container">
		<div class="row">
			<% HttpSession session2 = request.getSession(false);
			int id = (int) session2.getAttribute("custid");
			String carno = request.getParameter("id");
			String custname = CustomerDao.getNameById(id); 
			int carPrice = CarDao.getPriceByCarNo(carno);%>
			
			<div class="col-md-6" style="border: 2px solid black; border-radius: 20px; padding: 20px;">
				<h3>Rent Car</h3>
				<form action="addRentedCar.jsp" method="post">
					
					<div class="form-group">
						<label for="carno">Car Number</label>
						<input type="text" class="form-control" id="carno" name="carno" value="<%= carno %>" required/>
					</div>
					
					<div class="form-group">
						<label for="cid">ID</label>
						<input type="text" class="form-control" id="cid" name="cid" value="<%= id %>" required/>
					</div>
					
					<div class="form-group">
						<label for="cname">Name</label>
						<input type="text" class="form-control" id="cname" name="cname" value="<%= custname %>" required/>
					</div>
					
					<div class="form-group">
						<label for="carprice">Price</label>
						<input type="text" class="form-control" id="carprice" name="carprice" value="<%= carPrice %>" required/>
					</div>
					
					<button type="submit" class="btn btn-dark">RENT</button>
				</form>
			</div>
		</div>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>