<%@page import="administraccion.ControladorAdm"%>
<%@page import="administraccion.mensaje"%>
<%@page import="administraccion.EnvioCorreo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!DOCTYPE html>
<%
String nombreServicio= request.getParameter("nombreServicio") != null? request.getParameter("nombreServicio") : "0";
String nombres=request.getParameter("nombres") != null? request.getParameter("nombres") : "0";;
String apellidos=request.getParameter("apellidos") != null? request.getParameter("apellidos") : "0";;
String idsolicitante=request.getParameter("idsolicitante") != null? request.getParameter("idsolicitante") : "0";
String parroquia=request.getParameter("nombreParroquia") != null? request.getParameter("nombreParroquia") : "0";
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Envio de mensajes</title>
</head>
<body>

     <%ArrayList perUsuario = ControladorAdm.DatosPerUsr(idsolicitante);
		System.out.println(idsolicitante);    
	String msj= mensaje.DatosPerUsuario(perUsuario,nombres,apellidos,nombreServicio, parroquia);
	String correo= "abigailpachacama95@gmail.com";
            
            boolean resultado = EnvioCorreo.enviarCorreo(correo, msj);
            
            if(resultado){ %>
                <h1>El mensaje se ha enviado con exito</h1>
            <% }else{%>
            	<h1>El mensaje no se ha enviado</h1>
           <%  }
            
        %>
	
	<a href="Requerimientos.jsp"><button>Regresar</button></a>
</body>
</html>