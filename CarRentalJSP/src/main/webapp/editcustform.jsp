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
<title>Edit Customer Form</title>
</head>
<body>
	<jsp:include page="navcust.html"></jsp:include> 
	<div class="container">
		<div class="row">
			<div class="col-md-6" style="border: 2px solid black; border-radius: 20px; padding: 20px;">
				<% HttpSession session2 = request.getSession(false);
				int id = (int)session2.getAttribute("custid");
				CustomerBean bean = CustomerDao.getCustById(id); %>
				<h3>Add Renter</h3>
				<form action="editcust.jsp" method="post">
					<input type="hidden" name="custid" value="<%= bean.getId() %>"/>
					
					<div class="form-group">
						<label for="custname">Name</label>
						<input type="text" class="form-control" id="custname" name="custname" value="<%= bean.getName() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="custemail">Email</label>
						<input type="email" class="form-control" id="custemail" name="custemail" value="<%= bean.getEmail() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="custpass">Password</label>
						<input type="text" class="form-control" id="custpass" name="custpass" value="<%= bean.getPassword() %>" required/>
					</div>
					
					<div class="form-group">
						<label for="custcontact">Contact</label>
						<input type="number" class="form-control" id="custcontact" name="custcontact" value="<%= bean.getContact() %>" required/>
					</div>
					
					<button type="submit" class="btn btn-dark">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>