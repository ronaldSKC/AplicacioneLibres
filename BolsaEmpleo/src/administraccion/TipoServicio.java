package administraccion;

import java.sql.SQLException;
import java.util.ArrayList;

public class TipoServicio {

	int idTipo;
	String nombreTipo;
	
	
	
	public TipoServicio() {
		super();
	}
	
	public TipoServicio(int idTipo, String nombreTipo) {
		super();
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
	}

	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	public ArrayList<TipoServicio> listarTipoServicios() throws SQLException {
		ServicioBdd datos = new ServicioBdd();
		return datos.consultarTipoServicios();
	}
	
	
}
