package administraccion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bdd.BDD;

public class ParroquiaBdd {

	public ArrayList<Parroquia> consultarParroquias(String canton) throws SQLException {
		ArrayList<Parroquia> parroquias = new ArrayList<Parroquia>();
		String consulta = "SELECT * FROM adparroquia where IDCANTON = " + canton + " order by nombreparroquia";
		ResultSet resultadoConsulta = BDD.ejecutarConsulta1(consulta);
		while (resultadoConsulta.next()) {
			Parroquia parroquia = new Parroquia();
			try {
				parroquia.setIdParroquia(resultadoConsulta.getInt("IDPARROQUIA"));
			} catch (Exception e) {
				parroquia.setIdParroquia(0);
			}
			try {
				parroquia.setNombreParroquia(resultadoConsulta.getString("NOMBREPARROQUIA"));
			} catch (Exception e) {
				parroquia.setNombreParroquia("Vacio");
			}
			try {
				parroquia.setCodigoParroquia(resultadoConsulta.getString("CODIGOPARROQUIA"));
			} catch (Exception e) {
				parroquia.setCodigoParroquia("0");
			}
			try {
				parroquia.setIdCanton(resultadoConsulta.getInt("IDCANTON"));
			} catch (Exception e) {
				parroquia.setIdCanton(0);
			}
			parroquias.add(parroquia);
		}
		return parroquias;
	}

}
