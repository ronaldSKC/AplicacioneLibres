<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar personas</title>
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
							class="dropdown-item" href="buscadorpersona.jsp">VER DATOS PERSONALES</a> <a
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
		<!-- Inicio BuscadorImagen -->
		
		<!-- Fin Imagen -->
		<form action="tablallena.jsp" method="post">
			<div class="row">
				<div class="col-lg-4"></div>
				<div class="col-lg-4">
					<h2>Criterios de Búsqueda</h2>
				</div>
				<div class="col-lg-4"></div>

			</div>
			<div class="row">
				<div class="col-lg-4">
					<div class="input-group mb-4">
						<div class="input-group-prepend">

							<label class="input-group-text" for="BrowCedula">Cédula</label>
						</div>
						<input class="custom-select" id="BrowCedula" name="BrowCedula"
							autocomplete="off" #/>
					</div>
				</div>
				<div class="col-lg-4">

					<div class="input-group mb-4">
						<div class="input-group-prepend">

							<label class="input-group-text" for="BrowNombre">Nombre</label>
						</div>
						<input class="custom-select" id="BrowNombre" name="BrowNombre"
							autocomplete="off" />

					</div>
				</div>
				<div class="col-lg-4">
					<div class="input-group mb-4">
						<div class="input-group-prepend">
							<label class="input-group-text" for="BrowApellido">Apellido</label>
						</div>
						<input class="custom-select" id="BrowApellido" name="BrowApellido"
							autocomplete="off" />
					</div>
				</div>

			</div>
			<div class="row">
				<div class="col-lg-4"></div>
				<div class="col-lg-4">
					<button class="btn btn-primary">Buscar</button>
				</div>
				<div class="col-lg-4"></div>
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
</body>
</html>