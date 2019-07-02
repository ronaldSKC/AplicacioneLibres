package administraccion;

import java.util.ArrayList;
import java.util.Vector;

import bdd.BDD;

public class Adm {
	
	public static ArrayList listarParroquia(String idCanton) throws Exception {
		ArrayList parroquia = new ArrayList();
		String sentencia = "SELECT IDPARROQUIA, NOMBREPARROQUIA, IDCANTON "
				+ "FROM adparroquia "
				+ "where IDCANTON = "+idCanton +" "
				+ "ORDER BY NOMBREPARROQUIA";
		ArrayList parroquia1 = BDD.consultar1(sentencia);
		if(!parroquia1.isEmpty()) {
			Vector parroquias2 = (Vector)parroquia1.get(0);
			if(!parroquias2.isEmpty()) {
				String parroquias3 = parroquias2.get(0).toString().trim();
				if(!parroquias3.isEmpty()) {
					parroquia = parroquia1;
				}
			}
		}
		if (parroquia.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("EL CANTON "+idCanton+ " NO TIENE PARROQUIAS");
			parroquia.add(vacios);
		}
		return parroquia;
	}
	
}
