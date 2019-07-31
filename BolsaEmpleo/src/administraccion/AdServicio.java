package administraccion;

import java.util.ArrayList;
import java.util.Vector;

import bdd.BDD;

public class AdServicio {
	private int idServicio;
	private String nombreServicio;
	
	
	public AdServicio() {
		super();
	}

	public AdServicio(int idServicio, String nombreServicio) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	@Override
	public String toString() {
		return "idServicio=" + idServicio + ", nombreServicio=" + nombreServicio;
	}
	
	public  static String nombreServicio(String idServicio) throws Exception {
		String nombreServicio= "";
		String nombre = "Select nombreServicio FROM servicio WHERE IDSERVICIO = "+idServicio;
		ArrayList nombres = BDD.consultar1(nombre);
		Vector v = (Vector)nombres.get(0);
		
		if(idServicio==" ") {
			nombreServicio="No has seleccionado nada";
		}else {
	
		nombreServicio = v.get(0).toString().trim();
		}
		System.out.println("vengo de la clase AdServicio "+nombreServicio);
		return nombreServicio;
	}
	
	

}
