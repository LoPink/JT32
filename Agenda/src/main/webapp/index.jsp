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


<h1>Benvenuto nella tua Aria Personale</h1>


<%@ include  file="menu.jsp" %>



<% String pagina = "home"; 

	
if(request.getParameter("page")!=null){
	pagina =request.getParameter("page");
}


	switch(pagina){
		case "addAppuntamento": 
			%>
			<%@ include file="addAppuntamento.jsp"%>	
			<% 
			break; 
			
			
		case "listaAppuntamenti": 
			%>
			<%@ include file="listaAppuntamenti.jsp"%>
			<% 
			break; 
			
		default:
			break; 
	}
	


%>

</body>
</html>

