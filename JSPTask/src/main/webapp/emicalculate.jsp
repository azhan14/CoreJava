<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emi Calculate</title>
</head>
<body>
	<% int amt = Integer.parseInt(request.getParameter("amount")); 
		int year = Integer.parseInt(request.getParameter("year"));
		double roi = Double.parseDouble(request.getParameter("roi")); %>
		<h3>Hi,</h3>
		<h3>Your monthly EMI will be: <%= findEmi(amt,year,roi) %></h3>
		
	<%! int findEmi(int amt, int year, double roi){
		double r = roi/(12*100);
		year = year*12;
		double pow = Math.pow((1+r), year);
		double numerator = amt*r*pow;
		double denominator = pow - 1;
		double EMI = numerator/denominator;
		return (int)EMI;
	}
	%>
</body>
</html>