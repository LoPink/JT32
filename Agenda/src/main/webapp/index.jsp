<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Appuntamento"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda</title>
</head>
<body>


	<%@ include file="form.jsp" %>
	
	
	<ul>
	
	<% ArrayList<Appuntamento> appuntamenti = (ArrayList<Appuntamento>)request.getAttribute("tutti"); %>
	<% for(Appuntamento a: appuntamenti){ 
		
		if(a.getData().isEqual(LocalDate.now())){
			
		%> <li> <%=a%> </li> <%
		
		}	
		
	} %>

	
	</ul>
	













</body>
</html>