package administraccion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bdd.BDD;

public class ServicioBdd {

	public ArrayList<Servicio> consultarServicios(String tipoServicio) throws SQLException {
		ArrayList<Servicio> servicios = new ArrayList<Servicio>();
		ResultSet resultadoConsulta = BDD.ejecutarConsulta1("Select * from servicio where idTipoServicio=" + tipoServicio + " order by nombreServicio");
		while(resultadoConsulta.next()) {
			Servicio servicio = new Servicio();
			try {
				servicio.setIdServicio(resultadoConsulta.getInt("idServicio"));
			} catch (Exception e) {
				servicio.setIdServicio(0);
			}
			
			try {
				servicio.setIdCatalogo(resultadoConsulta.getInt("idCatalogo"));
			} catch (Exception e) {
				servicio.setIdCatalogo(0);
			}
			
			try {
				servicio.setNombreServicio(resultadoConsulta.getString("nombreServicio"));
			} catch (Exception e) {
				servicio.setNombreServicio("Vacío");
			}
			
			servicios.add(servicio);
		}
		
		return servicios;
	}
	
	
	public ArrayList<TipoServicio> consultarTipoServicios() throws SQLException {
		ArrayList<TipoServicio> tiposServicio = new ArrayList<TipoServicio>();
		ResultSet resultadoConsulta = BDD.ejecutarConsulta1("Select idCatalogo, Catalogo from adCatalogo where idTipoCatalogo=4 order by Catalogo");
		while(resultadoConsulta.next()) {
			TipoServicio tipoServicio = new TipoServicio();
			try {
				tipoServicio.setIdTipo(resultadoConsulta.getInt("idCatalogo"));
			} catch (Exception e) {
				tipoServicio.setIdTipo(0);
			}
						
			try {
				tipoServicio.setNombreTipo(resultadoConsulta.getString("Catalogo"));
			} catch (Exception e) {
				tipoServicio.setNombreTipo("Vacío");
			}
			
			tiposServicio.add(tipoServicio);
		}
		
		return tiposServicio;
	}
}
