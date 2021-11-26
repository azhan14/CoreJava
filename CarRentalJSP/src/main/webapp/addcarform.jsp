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
<title>Add Car Form</title>
</head>
<body>
	<jsp:include page="navrenter.html"></jsp:include>
	<div class="container">
		<jsp:include page="addcarform.html"></jsp:include>
	</div>
	<script src="bootstrap.min.js"></script>
</body>
</html>