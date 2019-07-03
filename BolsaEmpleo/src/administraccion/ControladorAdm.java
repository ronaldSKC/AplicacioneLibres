package administraccion;

import java.util.ArrayList;
import java.util.Vector;

import bdd.BDD;

public class ControladorAdm {
	
	public static ArrayList listarParroquias() throws Exception {
		ArrayList parroquias = Adm.listarParroquia("5");
		Vector parroquias2 = (Vector)parroquias.get(0);
		if(parroquias2.get(0).toString().trim().equals("vacio")) {
			Vector parroquias3 = new Vector();
			//parroquias
		}
		return parroquias;
	}
	public static String verParroquia(String idParroquia)throws Exception{
		String nombreParroquia ="";
		System.out.println(idParroquia);
		if (!idParroquia.equals("0")) {
			nombreParroquia = AdParroquia.nombreParroquia(idParroquia);
			
		}
		return nombreParroquia;
	}
	

}
