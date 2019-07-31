<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/main.css">

<title>Login</title>
</head>

<body>

	<div class="login_container">
		<div class="login_top">

			<h2 class="login_title">
				Iniciar<span>Sesión</span>
			</h2>
		</div>

		<form method="post" action="iniciar" class="login_form">
			<input name="correo" type="text" placeholder="&#128100; correo"
				required> <input name="password" type="password"
				placeholder="&#X1F512; password" required> <a
				class="form_recover" href="">¿Olvidaste la contraseña?</a> <br>
			<div>

				<h5>Tipo:</h5>
			</div>

			<div class="combo_box">
				<select name="combo">
					<option value="Artesano">Artesano</option>
					<option value="Empleador">Empleador</option>
					<option value="Funcionario">Funcionario</option>
				</select>
			</div>

			<input class="btn_submit" type="submit" value="Ingresar"
				style="font-size: 25px">


		</form>

		<form method="post" action="../index.jsp" class="login_form">
			<input class="btn_invitado" type="submit"
				value="Ingresar como invitado"
				style="font-size: 25px; text-align: center">

		</form>
		
		<form action="registroDeDatos.jsp">
			<input type="hidden" name="i_opc" id="i_opc" value="Registrar">
			<input class="btn_invitado" type="submit"
				value="Registrarse"
				style="font-size: 25px; text-align: center">
		</form>


	</div>



</body>
</html>