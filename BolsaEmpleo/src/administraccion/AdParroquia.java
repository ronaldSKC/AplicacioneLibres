package administraccion;

import java.util.ArrayList;

import bdd.BDD;

public class AdParroquia {
	int idParroquia;
	String nombreParroquia;
	
	public AdParroquia() {
		super();
	}

	public AdParroquia(int idParroquia, String nombreParroquia) {
		super();
		this.idParroquia = idParroquia;
		this.nombreParroquia = nombreParroquia;
	}

	public int getIdParroquia() {
		return idParroquia;
	}

	public void setIdParroquia(int idParroquia) {
		this.idParroquia = idParroquia;
	}

	public String getNombreParroquia() {
		return nombreParroquia;
	}

	public void setNombreParroquia(String nombreParroquia) {
		this.nombreParroquia = nombreParroquia;
	}

	@Override
	public String toString() {
		return idParroquia + "," + nombreParroquia ;
	}
	
	public static String nombreParroquia (String idParroquia)throws Exception {
		String nombreParroquia ="";
		String nombre = "Select NOMBREPARROQUIA "
				+ "FROM adparroquia "
				+ "where IDPARROQUIA="+idParroquia;
		
		ArrayList nombres = BDD.consultar1(nombre); 
		
		return nombreParroquia;
	}
	
}
