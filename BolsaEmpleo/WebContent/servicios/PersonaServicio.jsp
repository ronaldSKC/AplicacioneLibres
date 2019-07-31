
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>

<%@page import="administraccion.ControladorAdm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="administraccion.Adm"%>

<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css">


<meta charset="ISO-8859-1">
<title>Servicios Registrados</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
<div class ="container">
  <div class="mx-auto" style="width: 400px;">

	<%
	String codigoPersona = request.getParameter("f_opc");
	String nombre = ControladorAdm.listarPersona(codigoPersona);
	%>


	
		
	
	<p class="text-justify">REGISTRO DE:  <%=nombre %></p>
	
	
	
	
	
		


	<p>Usted ha seleccionado los siguientes servicios:</p>

	<%
		String services[] = request.getParameterValues("servicio");
		if (services != null) {
	%>

	<h4>Servicios Registrados:</h4>
	<ul>
		<%
			for (int i = 0; i < services.length; i++) {
		%>
		<%
			String nombreServicio = "" + ControladorAdm.verServicio(services[i].toString().trim());
		%>

		<!-- ><li><%=services[i]%></li> -->
		<li><%=nombreServicio%></li>


		<%
			//Adm.registrarServicioArtesano(services[i].toString().trim(),codigoPersona, "1");
		%>
		<%
			}
		%>

		<%
			
		%>
	</ul>
	<%
		} else {
	%>
	no has seleccionado nada
	<%
		}
	%>
	
	<a class="btn btn-success" href="../index.jsp">ACEPTAR</a>	
</div>
		
		
         
	
	
</body>
</html>