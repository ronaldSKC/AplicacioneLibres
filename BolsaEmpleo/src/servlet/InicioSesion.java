package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import bdd.Consultas;

/**
 * Servlet implementation class InicioSesion
 */
@WebServlet("/log-in/iniciar")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		Consultas co = new Consultas();
		int i = 0;
		String[] listaFunciones = new String[20];
		String usuario = request.getParameter("correo");
    	String password = request.getParameter("password");
    	String rolSeleccionado = request.getParameter("combogrupousuario");
    	ResultSet funciones = co.funcionesGenerales(rolSeleccionado);
    	
    	//System.out.println(rolSeleccionado);
    	
    
    	if(co.autenticacion(usuario, password, rolSeleccionado)) {
    		
    		//System.out.println(co.funcionesGenerales(rolSeleccionado));
    		//System.out.println(rolSeleccionado);
    		try {

				while(funciones.next()) {
					//System.out.print(funciones.getString("nombreFuncion"));
					//System.out.println("");
					listaFunciones[i] = funciones.getString("nombreFuncion");
					i++;
				}
				
				for (int j = 0; j < listaFunciones.length; j++) {
					System.out.println(listaFunciones[j]);
				}
				//request.getSession().setAttribute("servletMsg", listaFunciones);

				response.sendRedirect("../index.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		//System.out.println(rolSeleccionado);
    	}else {
    		/*out.println("<script type=\"text/javascript\">");
    		out.println("alert('Error Contraseña')");
    		out.println("location='login.jsp'");
    		out.println("</script>");
    		response.sendRedirect("login.jsp");*/
    		//System.out.println("Datos incorrectos");
    		
    		out.println("Correo o contraseña mal ingresados!!!");
    		
    		
    		
    		/*out.println("<dialog class=\"dialog-1\" id=\"dialog-1\">");
    		out.println("<h1> Contraseña o correo incorrectos </h1>");
    		out.println("<input type=\"button\" value=\"Aceptar\" onclick=\"document.getElementById('dialog-1').removeAttribute('open')\">");
    		out.println("</dialog>");
    		out.println("<p>");
    		out.println("<input class=\"btn_submit\" type=\"submit\" value=\"Ingresar\" style =\"font-size:25px\">");
    		out.println("</p>");*/
    	}
		
	}
	
	
	public void listaFunciones() {
		
	}
    
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	String usuario = request.getParameter("correo");
    	String password = request.getParameter("password");
    	
    	Consultas co = new Consultas();
    	if(co.autenticacion(usuario, password)) {
    		response.sendRedirect("logueado.jsp");
    	}else {
    		response.sendRedirect("login.jsp");
    	}
    }*/
	
	
	
}
