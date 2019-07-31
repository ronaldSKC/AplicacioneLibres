package administraccion;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				idParroquia = request.getParameter("f_parroquia");
		Date fecha = new Date();
		
		
	try {
		ControladorAdm.ingresar(cedula, apellidos, nombres, direccion, idParroquia, email, numTelefonoD, numTelefonoO, numTelefonoC);
		String idP = Adm.codpersona();
		ControladorAdm.ingresarU("4", fecha.toString(), "1234abcd", idP);
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
