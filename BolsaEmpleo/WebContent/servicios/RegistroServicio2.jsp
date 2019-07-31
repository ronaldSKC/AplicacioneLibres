<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="administraccion.ControladorAdm"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="bootstrap/css/estilo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Registrar Servicios 2</title>
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

	<div class="container">
				<div class="mx-auto" style="width: 500px;">


			</br>

			<%	
				String codigoPersona = request.getParameter("f_opc");
				String catalogo = request.getParameter("catalogo") != null ? request.getParameter("catalogo") : "0";
				String nombreCatalogo = ControladorAdm.verCatalogo(catalogo);
				ArrayList servicios = ControladorAdm.listarServicios(catalogo);
			%>


			<%
				if (catalogo.equals("0")) {
			%>
			No ha seleccionado nada
			<%
				} else {
			%>
			<%=nombreCatalogo%>
			<%
				}
			%>

			</br>

			<form name="MostrarServicios" onsubmit="checkBoxValidation()"
				action="PersonaServicio.jsp" method="post">
<input type="hidden" name="f_opc" id="f_opc" value="<%=codigoPersona%>">
				<label for="servicio"> Escoja los Servicios</label>

				<div class="form-row">


					<%
						for (int i = 0; i < servicios.size(); i++) {
							Vector servicio = (Vector) servicios.get(i);
							String idServicio = servicio.get(0).toString().trim();
							String nombreServicio = servicio.get(1).toString().trim();
					%>
					<p class="text-left">
					<div class="col-sm-5">
						<input type="checkbox" id="cbox1" name="servicio"
							value="<%=idServicio%>" style="margin-left: 1rem"><%=nombreServicio%></p>

					</div>
					<%
						}
					%>
				</div>

				<input class="btn btn-primary" type="submit" value="Guardar" onclick="pregunta()">
				<a class="btn btn-primary" href="MostrarCatalogo.jsp">Regresar</a>


			</form>


		</div>

		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
	<script language="JavaScript">
		function pregunta() {
			if (confirm('¿Desea agregar estos servicios?')) {
				document.MostrarServicios.submit()

			}
		}
	</script>
</body>
</html>