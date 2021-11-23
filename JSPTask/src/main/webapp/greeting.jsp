<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Greeting</title>
</head>
<body>
<% String name = request.getParameter("name");
	String gender = request.getParameter("gender");
%>
<%
	Date dt = new Date();
	Calendar c = Calendar.getInstance();
	c.setTime(dt);
	String hour = "";
	int hours = c.get(Calendar.HOUR_OF_DAY);
	if(hours>3 && hours<=12){
	    hour = "Good Morning";
	}else if(hours>12 && hours<=16){
	    hour = "Good Afternoon";
	}else if(hours>16 && hours<=21){
	    hour = "Good Evening";
	}else if(hours>21 && hours<=3){
	    hour = "Good Night";
	}
	
	if(gender.equals("Male")){
		hour = hour + " Sir";
	} else{
		hour = hour + " Madam";
	}
%>
<h3> Hi <%= name %>,</h3>
<h3><%= hour %></h3>

</body>
</html>