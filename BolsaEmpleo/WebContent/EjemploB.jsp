<%@page import="administraccion.ControladorAdm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
 String parroquia =  request.getParameter("parroquia") != null ? request.getParameter("parroquia") : "0";
 ControladorAdm.verParroquia(parroquia); 
 %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>EjemploB</title>
</head>
<body>
	<h1>
	<%if(parroquia.equals("0")){ 
	%>
	No ha seleccionada nada
	<%}else{ %>
	<%=parroquia%>
	<%} %>
	</h1>
	
	
</body>
</html>