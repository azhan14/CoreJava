
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.neosoft.*" errorPage="MyErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int amount = Integer.parseInt(request.getParameter("amount"));
		Account.withdraw(amount);
		out.print(Account.showBalance());
	%>
	<br>
	<a href="index.html">Withdraw</a>
</body>
</html>