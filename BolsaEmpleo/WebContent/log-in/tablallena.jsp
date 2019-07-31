 <%@page import="administraccion.EnvioCorreo"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" %>
<%@ page import = "administraccion.Adm"%> 
<%@ page import = "java.util.LinkedList"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personas</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
@media ( min-width : 768px) {
	.navbar-brand.abs {
		position: absolute;
		width: 100%;
		left: 0;
		text-align: center;
	}
}

div.a {
	text-align: center;
}
</style>
</head>
<body>

<!-- Barra de navegación-->
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: #000000;">
		<div
			class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<img src="../images/logo2.png">
			</ul>
		</div>
		<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="../administraccion/administraccion.jsp">ADMINISTRACIÓN
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="#">CURSOS</a></li>
				<li class="nav-item dropdown active"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> SERVICIOS </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">CONSULTAR ARTESANO</a> <a
							class="dropdown-item" href="#">VER DATOS PERSONALES</a> <a
							class="dropdown-item" href="#">INSCRIBIR CONVENIO</a> <a
							class="dropdown-item" href="#">CONSULTAR CAPACITADORES</a>
					</div></li>
				<li class="nav-item active"><a class="nav-link" href="#">CONTACTO</a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
				<li class="nav-item"><a class="nav-link"></a></li>
			</ul>
		</div>
	</nav>
	<!-- Main -->

      <center>
<h1>Consulta a base de datos</h1>
<table class="table">
 <thead>
<tr>
<td>CÉDULA </td>
<td>APELLIDOS</td> 
<td>NOMBRES</td>
<td>DIRECCIÓN</td>
<td>EMAIL</td> 
<td>NÚMERO TELEFONO</td>
<td>PARROQUIA</td>
<td>ACTUALIZAR</td>
<td>REGISTRAR SERVICIO</td>
</tr>
  </thead>
  <tbody>
<%

String imputCedula=(String)request.getParameter("BrowCedula");
String imputNombre=(String)request.getParameter("BrowNombre");
String imputApellido=(String)request.getParameter("BrowApellido");
ArrayList personas = Adm.listarDatosPersonasCNA(imputCedula,imputNombre,imputApellido);
System.out.print(personas);
for (int i=0;i<(personas.size());i++)
{
	
	Vector persona = (Vector) personas.get(i);
	String cedulaPer = persona.get(0).toString().trim();
	String apellidoPer = persona.get(1).toString().trim();
	String nombrePer = persona.get(2).toString().trim();
	String dirrecionPer = persona.get(3).toString().trim();
	String correoPer = persona.get(4).toString().trim();
	String numPerD = persona.get(5).toString().trim();
	String numPerO = persona.get(6).toString().trim();
	String numPerC= persona.get(7).toString().trim();
	
	String nombreCant = persona.get(11).toString().trim();
	String idPersona = persona.get(14).toString().trim();
	
   out.println("<tr>");
   out.println("<td>"+cedulaPer+"</td>");
   out.println("<td>"+apellidoPer+"</td>");
   out.println("<td>"+nombrePer+"</td>");
   out.println("<td>"+dirrecionPer+"</td>");
   out.println("<td>"+correoPer+"</td>");
   out.println("<td>"+numPerD+"<br>"+numPerO+"<br>"+numPerC+"</td>");
   out.println("<td>"+nombreCant+"</td>");
   out.println("<td> <form action= 'registroDeDatos.jsp'> <input type='hidden' name='i_opc' id='i_opc' value='Actualizar'><input type='hidden' name='f_opc' id='f_opc' value='"+idPersona+"'>	 <input type='submit' value='Actualizar'></form> </td>");
   out.println("<td> <form action= '../servicios/MostrarCatalogo.jsp'> <input type='hidden' name='f_opc' id='f_opc' value='"+idPersona+"'> <input type='submit' value='Resgistrar'></form> </td>");  
   out.println("</tr>");
}
EnvioCorreo enviar = new EnvioCorreo();
boolean resultado = enviar.enviarCorreo("paul.cisneros@epn.edu.ec", "Correo Prueba");

%>
 </tbody>
</table>
      
</body>
</html>