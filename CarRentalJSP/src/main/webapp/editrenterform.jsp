<%@page import="com.neosoft.beans.RenterBeans"%>
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
<link rel="stylesheet" href="bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Edit Renter Form</title>
</head>
<body>
	<jsp:include page="navadmin.html"></jsp:include>
	<div class="container">
		<div class="row">
		<% int id = Integer.parseInt(request.getParameter("id"));
			RenterBeans bean = RenterDao.getById(id);%>
			<div class="col-md-6" style="border: 2px solid black; border-radius: 20px; padding: 20px;">
				<h3>Add Renter</h3>
				<form action="editrenter.jsp" method="post">
					<input type="hidden" name="rid" value="<%= bean.getId() %>"/>
					<div class="form-group">
						<label for="rname">Name</label>
						<input type="text" class="form-control" id="rname" name="rname" value="<%= bean.getName() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="remail">Email</label>
						<input type="text" class="form-control" id="remail" name="remail" value="<%= bean.getEmail() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="rpassword">Password</label>
						<input type="text" class="form-control" id="rpassword" name="rpassword" value="<%= bean.getPassword() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="rcontact">Contact</label>
						<input type="text" class="form-control" id="rcontact" name="rcontact" value="<%= bean.getContact() %>" required/>
					</div>
					<button type="submit" class="btn btn-dark">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>