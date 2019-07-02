<%@page import="administraccion.ControladorAdm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Metodo</title>
</head>
<body>
	<h1>Parroquias</h1>
	<%
		ArrayList parroquias = ControladorAdm.listarParroquias();
	%>
	<form name="formaParroquia" action="EjemploB.jsp" method="post">
		<div class="row">
			<div class="col-sm-9">
				<label for="parroquia"> Escoja una parroquia</label> 
				<select name="parroquia" id="parroquia" >
				<option value="0">Escoja una opción</option>
				<%
					for (int i = 0; i< parroquias.size(); i++){
						Vector parroquia = (Vector)parroquias.get(i);
						String idParroquia= parroquia.get(0).toString().trim();
						String nombreParroquia= parroquia.get(1).toString().trim();
						String idCanton = parroquia.get(2).toString().trim();
						
				%>
				<option value="<%=idParroquia%>"><%=nombreParroquia%>
				</option>
				<%
					}
				%>
			</select>
			</div>
			</div>
			<div> 
			<input type="submit" value="Enviar">
			</div>
			</form>
</body>
</html>