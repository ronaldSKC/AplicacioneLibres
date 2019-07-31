package administraccion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log-in/ActualizarPersona")
public class ActualizarPersona extends HttpServlet {

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
				id = request.getParameter("idP") ;
		
	try {
		ControladorAdm.actualizar(cedula, apellidos, nombres, direccion, idParroquia, email, numTelefonoD, numTelefonoO, numTelefonoC, id);
		EnvioCorreo enviar = new EnvioCorreo();
		boolean resultado = enviar.enviarCorreo(email, "Se actualizo su información");

		if(resultado){
		    System.out.print("CORREO ELECTRONICO CORRECTAMENTE ENVIADO....."+"\n\n");
		}else{
			System.out.print("CORREO ELECTRONICO NO ENVIADO....."+"\n\n"); 
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	request.getRequestDispatcher("buscadorpersona.jsp").forward(request, response);
	}
}
