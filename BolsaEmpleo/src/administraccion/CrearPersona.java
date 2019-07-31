package administraccion;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.BDD;

@WebServlet("/log-in/CrearPersona")
public class CrearPersona extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cedula = request.getParameter("cedula"),
				apellidos = request.getParameter("apellido"),
				nombres = request.getParameter("name"),
				direccion = request.getParameter("direccion"),
				numTelefonoD = request.getParameter("telefonoD"),
				numTelefonoO = request.getParameter("telefonoO"),
				numTelefonoC = request.getParameter("telefonoC"),
				email = request.getParameter("email"),
				idParroquia = request.getParameter("f_parroquia"),
				grupo = request.getParameter("grupo");
		Date fecha = new Date();
		
		
	try {
		ControladorAdm.ingresar(cedula, apellidos, nombres, direccion, idParroquia, email, numTelefonoD, numTelefonoO, numTelefonoC, grupo);
		String idP = Adm.codpersona();
		String fecha1 = "2019-"+fecha.getMonth()+"-"+fecha.getDay();
		ControladorAdm.ingresarU("4", fecha1, "1234abcd", idP);
		String idPersona2 = Adm.idUsuariop();
		String sentencia2= "INSERT INTO `grupoperusuario`(`idPerUsuario`, `idGrupoUsuario`) VALUES ("+idPersona2+","+grupo+")";
		BDD.ingresar(sentencia2);
		
		EnvioCorreo enviar = new EnvioCorreo();
		boolean resultado = enviar.enviarCorreo(email, "Su contraseña es: 1234abcd");

		if(resultado){
		    System.out.print("CORREO ELECTRONICO CORRECTAMENTE ENVIADO....."+"\n\n");
		}else{
			System.out.print("CORREO ELECTRONICO NO ENVIADO....."+"\n\n"); 
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
