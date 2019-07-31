package administraccion;

import java.util.ArrayList;
import java.util.Vector;

public class mensaje {
	public static String DatosPerUsuario(ArrayList perUsuario, String nom, String ape, String servicio, String parroquia) throws Exception {
		String nombres = " ";
		String apellidos= " ";
		String mensaje=" ";
		for (int i = 0; i< perUsuario.size(); i++) {
			Vector perUsr = (Vector)perUsuario.get(i);
			nombres = perUsr.get(0).toString();
			apellidos= perUsr.get(1).toString();
				
		}
		
		mensaje= "Señor "+nom+" "+ ape+"\n"+
		" Se solicita el servicio de "+servicio+" en la parroquia "+parroquia+ "\n" 
		+" para mayor informacion contactar con "+nombres+ " "+ apellidos;
		
		System.out.println(mensaje);
		return mensaje;
	}
}
