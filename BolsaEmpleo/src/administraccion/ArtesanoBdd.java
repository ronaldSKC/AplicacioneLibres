package administraccion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bdd.BDD;

public class ArtesanoBdd {

	public ArrayList<Artesano> consultarArtesanos() throws SQLException {
		ArrayList<Artesano> artesanos = new ArrayList<Artesano>();
		ResultSet resultadoConsulta = BDD.ejecutarConsulta1("SELECT * FROM perpersona");
		while (resultadoConsulta.next()) {
			Artesano artesano = new Artesano();
			try {
				artesano.setCodigoPersona(resultadoConsulta.getInt("CODIGOPERSONA"));
			} catch (Exception e) {
				artesano.setCodigoPersona(0);
			}
			try {
				artesano.setNombres(resultadoConsulta.getString("NOMBRES"));
			} catch (Exception e) {
				artesano.setNombres("Vacio");
			}
			try {
				artesano.setApellidos(resultadoConsulta.getString("APELLIDOS"));
			} catch (Exception e) {
				artesano.setApellidos("Vacio");
			}
			artesanos.add(artesano);
		}
		return artesanos;
	}

}
