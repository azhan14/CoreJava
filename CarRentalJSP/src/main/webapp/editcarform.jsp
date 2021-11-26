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
<link rel="stylesheet" href="bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Edit Car Form</title>
</head>
<body>
	<jsp:include page="navrenter.html"></jsp:include>
	<div class="container">
		<div class="row">
		<% String carno = request.getParameter("id");
			CarBean bean = CarDao.getByCarNo(carno);%>
			<div class="col-md-6" style="border: 2px solid black; border-radius: 20px; padding: 20px;">
				<h3>Add Renter</h3>
				<form action="editcar.jsp" method="post">
					<input type="hidden" name="carno" value="<%= bean.getNumber() %>"/>
					
					<div class="form-group">
						<label for="carname">Name</label>
						<input type="text" class="form-control" id="carname" name="carname" value="<%= bean.getName() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="carmf">Manufacturer</label>
						<input type="text" class="form-control" id="carmf" name="carmf" value="<%= bean.getMf() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="caryear">Year of Buy</label>
						<input type="text" class="form-control" id="caryear" name="caryear" value="<%= bean.getYear() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="carprice">Price</label>
						<input type="text" class="form-control" id="carprice" name="carprice" value="<%= bean.getPrice() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="carstatus">Available</label>
						<select class="form-control" id="carstatus" name="carstatus">
							<% if(bean.getStatus().equals("YES")) { %>
								<option value='YES' selected>YES</option>
								<option value='NO'>NO</option>
							<% } else { %>
								<option value='YES'>YES</option>
								<option value='NO' selected>NO</option>
							<% } %>
						</select>
					</div>
					
					<button type="submit" class="btn btn-dark">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>