<%@page import="administraccion.ControladorAdm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<%
	String servicio = request.getParameter("idServicio") != null ? request.getParameter("idServicio") : "0";
	String idparroquia = request.getParameter("idparroquia") != null ? request.getParameter("idparroquia")
			: "0";
	String idsolicitante = request.getParameter("idSolicitante") != null ? request.getParameter("idSolicitante")
			: "0";
	String nombreParroquia = request.getParameter("parroquia") != null ? request.getParameter("parroquia")
			: "0";
	;
%>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
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
							class="dropdown-item" href="../log-in/buscadorpersona.jsp">VER DATOS PERSONALES</a> <a
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
	<section class="contenedor">
		<div class="container" style="width: 70%">
			<br>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">NOMBRE</th>
						<th scope="col">APELLIDO</th>
						<th scope="col">SERVICIO</th>
						<th scope="col">DIRECCIÓN</th>
						<th scope="col">EMAIL</th>
						<th scope="col">PARROQUIA</th>
						<th scope="col">SELECCIONAR</th>
					</tr>
				</thead>
				<tbody>
					</tr>
					<%
						ArrayList perServicios = ControladorAdm.listarPersonasServParr(servicio, idparroquia);
					%>

					<%
						for (int i = 0; i < perServicios.size(); i++) {
							Vector perServicio = (Vector) perServicios.get(i);
							String id = perServicio.get(0).toString();
							String nombres = perServicio.get(1).toString();
							String apellidos = perServicio.get(2).toString();
							String nombreServicio = perServicio.get(3).toString();
							String direccion = perServicio.get(4).toString();
							String parroquia = perServicio.get(5).toString();
							String email = perServicio.get(6).toString();
					%>


					<tr>
						<td><%=nombres%></td>
						<td><%=apellidos%></td>
						<td><%=nombreServicio%></td>
						<td><%=direccion%></td>
						<td><%=email %></td>
						<td><%=parroquia%></td>
						<td>
							<form action="Envio.jsp" method="post">
								<input type="hidden" name="idsolicitante" value="<%=idsolicitante%>"> 
								<input type="hidden" name="nombres" value="<%=nombres%>">
								<input type="hidden" name="apellidos" value="<%=apellidos%>">
								<input type="hidden" name="nombreServicio" value="<%=nombreServicio%>">
								<input type="hidden" name="nombreParroquia" value="<%=nombreParroquia%>"> 
								<input type="submit" value="Enviar">
							</form>

						</td>
					</tr>

				</tbody>
				<%
					}
				%>
			</table>
		</div>
	</section>

</body>
</html>