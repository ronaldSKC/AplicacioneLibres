<%@page import="jdk.internal.org.objectweb.asm.tree.analysis.Value"%>
<%@page import="administraccion.ControladorAdm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String estaCreado = request.getParameter("i_opc") != null ? request.getParameter("i_opc") : "Registrar";
	String actualizado = estaCreado;
	if (actualizado.equals("Registrar")) {
		actualizado = "Crear";
	}
	String codigoPersona = request.getParameter("f_opc");
	String CEDULA = "", APELLIDOS = "", NOMBRES = "", DIRECCION = "", numTelefonoD = "", numTelefonoO = "",
			numTelefonoC = "", nombreUsuario = "", clave = "", IDPARROQUIA = "0", IDCANTON = "0",
			IDPROVINCIA = "0";
	String nombreProvincia = "", nombreCanton = "", nombreParroquia = "";
	if (estaCreado.equals("Actualizar")) {
		ArrayList persona = ControladorAdm.verPersona(codigoPersona);
		for (int i = 0; i < persona.size(); i++) {
			Vector personas = (Vector) persona.get(i);
			CEDULA = personas.get(0).toString().trim();
			APELLIDOS = personas.get(1).toString().trim();
			NOMBRES = personas.get(2).toString().trim();
			DIRECCION = personas.get(3).toString().trim();
			nombreUsuario = personas.get(4).toString().trim();
			numTelefonoD = personas.get(5).toString().trim();
			numTelefonoO = personas.get(6).toString().trim();
			numTelefonoC = personas.get(7).toString().trim();
			IDPARROQUIA = personas.get(8).toString().trim();
			IDCANTON = personas.get(9).toString().trim();
			IDPROVINCIA = personas.get(10).toString().trim();
			nombreParroquia = personas.get(11).toString().trim();
			nombreCanton = personas.get(12).toString().trim();
			nombreProvincia = personas.get(13).toString().trim();
		}
	} else {

		CEDULA = "";
		APELLIDOS = "";
		NOMBRES = "";
		DIRECCION = "";
		numTelefonoD = "";
		numTelefonoO = "";
		numTelefonoC = "";
		nombreUsuario = "";
		IDPARROQUIA = "0";
		IDCANTON = "0";
		IDPROVINCIA = "0";
		nombreProvincia = "----Escoja una opción----";
		nombreCanton = "----Escoja una opción----";
		nombreParroquia = "----Escoja una opción----";

	}
	ArrayList provincia = ControladorAdm.listarProvincias();
	ArrayList grupo = ControladorAdm.listaGrupos();
%>


<html>
<head>

<meta charset="utf-8">
<title>Registro de Persona</title>
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
				<li class="nav-item active"><a class="nav-link" href="#">ADMINISTRACIÓN
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
	<section class="contenedor">
		<div class="container" style="width: 50%">

			<form id="data" action="<%=actualizado%>Persona" method="post">
				<input type="hidden" name="idP" id="idP" value="<%=codigoPersona%>">
				<input type="hidden" name="f_opc" id="i_opc"> <input
					type="hidden" name="f_opc1" id="i_opc1" value="<%=IDCANTON%>">
				<input type="hidden" name="f_opc2" id="i_opc2"
					value="<%=IDPARROQUIA%>">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<h1><%=estaCreado%>
							Persona
						</h1>
					</div>
					<div class="col-sm-3"></div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="email">Correo Electronico</label>
					</div>
					<div class="col-sm-9">
						<div class="form-group">
							<input type="text" class="form-control item" id="email"
								name="email" value="<%=nombreUsuario%>"
								onblur="validarEmail('email','mEmail')" />

							<div style="color: red;" id="mEmail"></div>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="apellido">Apellidos</label>
					</div>
					<div class="col-sm-9">
						<div class="form-group">
							<input type="text" id="apellido" name="apellido"
								class="form-control item" id="apellido" value="<%=APELLIDOS%>"
								onblur="validarText(1,20,'apellido','mensaje')" />
							<div style="color: red;" id="mensaje"></div>
						</div>
					</div>
				</div>
				<div class="row">

					<div class="col-sm-3">
						<label for="name">Nombres</label>

					</div>
					<div class="col-sm-9">
						<div class="form-group">
							<input type="text" id="name" name="name"
								class="form-control item" id="name" value="<%=NOMBRES%>"
								onblur="validarText(1,20,'apellido','mensajeN')" />
							<div style="color: red;" id="mensajeN"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="cedula">Cédula</label>
					</div>
					<div class="col-sm-9">
						<div class="form-group">
							<input type="text" id="cedula" name="cedula"
								class="form-control item" id="cedula" value="<%=CEDULA%>"
								onblur="validarCedula('cedula','mCedula')" />

							<div style="color: red;" id="mCedula"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="telefonoD">Teléfono de Domicilio</label>
					</div>
					<div class="col-sm-9">
						<div class="form-group">
							<input type="text" id="telefonoD" name="telefonoD"
								class="form-control item" id="telefonoD"
								value="<%=numTelefonoD%>"
								onblur="validarTelefono('telefonoD','mtelefonoD')" />
							<div style="color: red;" id="mtelefonoD"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="telefonoO">Teléfono de Oficina</label>
					</div>
					<div class="col-sm-9">
						<div class="form-group">
							<input type="text" id="telefonoO" name="telefonoO"
								class="form-control item" id="telefonoO"
								value="<%=numTelefonoO%>"
								onblur="validarTelefono('telefonoO','mtelefonoO')" />
							<div style="color: red;" id="mtelefonoO"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="telefonoC">Teléfono Celular</label>
					</div>
					<div class="col-sm-9">
						<div class="form-group">
							<input type="text" id="telefonoC" name="telefonoC
								"
								class="form-control item" id="telefonoC"
								value="<%=numTelefonoC%>"
								onblur="validarTelefono('telefonoC','mtelefonoC')" />

							<div style="color: red;" id="mtelefonoC"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<div class="form-group">
							<label for="provincia">Provincia</label> <select
								name="f_provincia" id="i_provincia" class="form-control"
								onchange="combo_provincia()">
								<option value="<%=IDPROVINCIA%>"><%=nombreProvincia%></option>
								<%
									for (int i = 0; i < provincia.size(); i++) {
										Vector provincias = (Vector) provincia.get(i);
										String idProvincia = provincias.get(0).toString().trim();
										String nombreProvincia1 = provincias.get(1).toString().trim();
								%>
								<option value="<%=idProvincia%>"><%=nombreProvincia1%>
								</option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="form-group">
							<label for="canton">Cantón</label> <select name="f_canton"
								id="i_canton" class="form-control" onchange="combo_canton()">
								<option value="<%=IDCANTON%>"><%=nombreCanton%></option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="form-group">
							<label for="parroquia">Parroquia</label> <select
								name="f_parroquia" id="i_parroquia" class="form-control">
								<option value="<%=IDPARROQUIA%>"><%=nombreParroquia%></option>
							</select>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label for="direccion">Dirección</label>
					</div>
					<div class="col-sm-9">
						<div class="form-group">
							<input type="text" name="direccion" id="direccion"
								class="form-control" id="direccion" value="<%=DIRECCION%>"
								onblur="validarText(1,20,'direccion','mDireccion')" />
							<div style="color: red;" id="mDireccion"></div>
						</div>
					</div>
					<div class="col-sm-1"></div>
					<div class="col-sm-12">
						<div class="form-group">
							<label for="grupo">Grupo: </label> <select name="grupo"
								id="grupo" class="form-control">

								<%
									for (int i = 0; i < grupo.size(); i++) {
										Vector grupos = (Vector) grupo.get(i);
										String idgrupo = grupos.get(0).toString().trim();
										String nombregrupo = grupos.get(1).toString().trim();
								%>
								<option value="<%=idgrupo%>"><%=nombregrupo%>
								</option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<div class="col-sm-1"></div>
				</div>

				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<div class="form-group">
							<button class="btn btn-primary btn-block btn-lg" type="submit"
								id="guardar"
								style="color: #fff; background-color: #000000; border-color: #000000; border-radius: 20px;"><%=estaCreado%></button>
						</div>
					</div>

					<div class="col-sm-3"></div>
				</div>
			</form>
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<div class="form-group">
						<a href="../index.jsp">
							<button class="btn btn-primary btn-block btn-lg"
								style="color: #fff; background-color: #000000; border-color: #000000; border-radius: 20px;">Regresar</button>
						</a>
					</div>
				</div>
				<div class="col-sm-3"></div>
			</div>
	</section>
	<!-- Footer -->

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		function combo_provincia() {
			$("#i_opc").val("1");
			$.post("comboProvincia.jsp", $("#data").serialize(),
					function(data) {
						$("#i_canton").html(data);
					});

		}
		function combo_canton() {
			$("#i_opc").val("1");
			$.post("comboCanton.jsp", $("#data").serialize(), function(data) {
				$("#i_parroquia").html(data);
			});

		}
	</script>
	<script src="../log-in/mijs.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>

