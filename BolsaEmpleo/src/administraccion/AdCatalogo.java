package administraccion;

import java.util.ArrayList;
import java.util.Vector;

import bdd.BDD;

public class AdCatalogo {
	int idCatalogo;
	String nombreCatalogo;
	public AdCatalogo(int idCatalogo, String nombreCatalogo) {
		super();
		this.idCatalogo = idCatalogo;
		this.nombreCatalogo = nombreCatalogo;
	}
	public AdCatalogo() {
		super();
	}
	public int getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(int idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public String getNombreCatalogo() {
		return nombreCatalogo;
	}
	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}
	
	public  static String nombreCatalogo(String idCatalogo) throws Exception {
		String nombreCatalogo= "";
		
		String nombre = "Select CATALOGO FROM adcatalogo WHERE IDCATALOGO = "+idCatalogo;
		ArrayList nombres = BDD.consultar1(nombre);
		Vector v = (Vector)nombres.get(0);
		
		nombreCatalogo = v.get(0).toString().trim();
		
		return nombreCatalogo;
	}
	
	@Override
	public String toString() {
		return "AdCatalogo [idCatalogo=" + idCatalogo + ", nombreCatalogo=" + nombreCatalogo + "]";
	}
	
	

}
