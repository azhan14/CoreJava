<%@page import="com.neosoft.dao.CustomerDao"%>
<%@page import="com.neosoft.beans.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% int id =Integer.parseInt(request.getParameter("custid"));
	String name = request.getParameter("custname");
	String email = request.getParameter("custemail");
	String password = request.getParameter("custpass");
	String contact = request.getParameter("custcontact");
	
	CustomerBean bean = new CustomerBean(id, name, email, password, contact);
	CustomerDao.update(bean);
	response.sendRedirect("showprofile.jsp"); %>
</body>
</html>