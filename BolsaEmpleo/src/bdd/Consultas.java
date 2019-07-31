package bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Consultas extends BDD {


	public boolean autenticacion(String usuario, String clave, String GrupoUsuario) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String consulta = "select nombreUsuario, clave, nombreGrupoUsuario from perusuario join grupoperusuario \r\n" + 
					"on (perusuario.idPerUsuario = grupoperusuario.idPerUsuario) join grupousuario \r\n" + 
					"on (grupousuario.idGrupoUsuario = grupoperusuario.idGrupoUsuario) \r\n" + 
					"where nombreUsuario = ? and clave = ? and nombreGrupoUsuario = ? ";
			pst = con().prepareStatement(consulta);
			pst.setString(1, usuario);
			pst.setString(2, clave);
			pst.setString(3, GrupoUsuario);
			rs = pst.executeQuery();
			if (rs.absolute(1)) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {

			try {
				if (con() != null) {
					//Si la conexion no se ha cerrado
					con().close();
				}
				if(pst !=null) {
					pst.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				System.out.println("Error: " + e2);
			}

		}

		return false;
	}
	
	
	
	
	public ResultSet funcionesGenerales(String rol) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String consulta = "select nombreFuncion from adFuncion join GrupoFuncion on(adFuncion.idFuncion = grupoFuncion.idFuncion) \r\n" + 
				"join grupoUsuario on(GrupoFuncion.idGrupoUsuario = grupousuario.idGrupoUsuario)\r\n" + 
				"where nombreGrupoUsuario = ?";
		try {
			pst = con().prepareStatement(consulta);
			pst.setString(1, rol);
			rs = pst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error:"+ e);
			
		}
		
		return rs;
	}
	
	
	
	public ResultSet mostrarCombo() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String consulta = "select idGrupoUsuario, nombreGrupoUsuario from grupousuario";
		try {
			pst = con().prepareStatement(consulta);
			rs = pst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	/*public static void main(String[] args) {
		Consultas co = new Consultas();
		ResultSet funciones = co.funcionesGenerales("Empleador");
		String[] listaFunciones = new String[100];
		int i = 0;
		
		try {
			while(funciones.next()) {
				//System.out.print(funciones.getString("nombreFuncion"));
				//System.out.println("");
				listaFunciones[i] = funciones.getString("nombreFuncion");
				i++;
			}
			
			for (int j = 0; j < listaFunciones.length; j++) {
				System.out.println("Empleado "+j+": "+listaFunciones[j]);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e);
		}
		//System.out.println(co.autenticacion("luis.ang", "1234"));
		
	}*/
}
