<%@page import = "bdd.BDD" %>
<%@page import = "java.sql.*" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="./main.css">
		<title>Login</title>
	</head>
	<body>
	
		<%
         Connection con = BDD.con();
         Statement p = con.createStatement();
         ResultSet rs = p.executeQuery("Select idGrupoUsuario, nombreGrupoUsuario from grupousuario order by nombreGrupoUsuario asc");
         %>
	
		<div class="login_container">
			<div class="login_top">
				 
				<h2 class="login_title">Iniciar<span>Sesión</span></h2>
			</div>
			
			<form method="post" action="log-in/iniciar" class="login_form">
				<input name="correo" type="text" placeholder="&#128100; correo" required>
				<input name="password" type="password" placeholder="&#X1F512; password" required>
				<a class = "form_recover" href="">¿Olvidaste la contraseña?</a>
				<br>
				<div>
				
					<h5>Tipo de Usuario: </h5>
				</div>
			
				<div class="combo_box" >
			  		<select name="combogrupousuario">
          			
						<%
          				while(rs.next()){%>
          					<option value="<%=rs.getString("nombreGrupoUsuario")%>"><%=rs.getString("nombreGrupoUsuario") %> </option>
          					
          				<% } %>
          				
          				
          				
					</select>
				</div>
				
				<input class="btn_submit" type="submit" value="Ingresar" style ="font-size:25px">
				
				
			</form >
			
			<form method="post" action="/paginaInicial.jsp" class="login_form">
				<input class="btn_invitado" type="submit" value="Ingresar como invitado" style ="font-size:25px; text-align:center">
			
			</form>
			<div>
				<a class= "form_registro" href="RegistroPrueba.jsp" >Registrarse</a>
			
			</div>
				
			
		</div>
		
		
		

	
	</body>
</html>