package administraccion;

import java.util.ArrayList;
import java.util.Vector;

public class ControladorAdm {
	
	public static ArrayList listarParroquias(String idCanton) throws Exception {
		ArrayList parroquias = Adm.listarParroquia(idCanton);
		return parroquias;
	}
	public static ArrayList listarCantones(String idProvincia) throws Exception {
		ArrayList cantones = Adm.listarCantones(idProvincia);
		return cantones;
	}
	public static ArrayList listarProvincias() throws Exception {
		ArrayList provincias = Adm.listarProvincias();
		return provincias;
	}
	public static String verParroquia(String idParroquia)throws Exception{
		String nombreParroquia ="";
		System.out.println(idParroquia);
		if (!idParroquia.equals("0")) {
			nombreParroquia = AdParroquia.nombreParroquia(idParroquia);
			
		}
		return nombreParroquia;
	}
	
	public static String verCanton(String idCanton)throws Exception{
		String nombreParroquia ="";
		System.out.println(idCanton);
			nombreParroquia = ControladorAdm.verCanton(idCanton);
		return nombreParroquia;
	}
	public static String verProvincia(String idProvincia)throws Exception{
		String nombreParroquia ="";
		nombreParroquia = ControladorAdm.verProvincia(idProvincia);
		return nombreParroquia;
	}
	
	public static ArrayList verPersona(String codigoPersona) throws Exception {
		ArrayList personas = Adm.listarDatosPersona(codigoPersona);
		return personas;
	}

	public static void ingresar(String cEDULA, String aPELLIDOS, 
			String nOMBRES, String dIRECCION, 
			String iDPARROQUIA, String eMAIL, 
			String tELEFONOD, String tELEFONOOF, String tELEFONOC, String grupo) throws Exception {
		Adm.ingresar(cEDULA, aPELLIDOS, nOMBRES, dIRECCION, iDPARROQUIA, eMAIL, tELEFONOD, tELEFONOOF, tELEFONOC,grupo);
	
	}
	public static void ingresarU(String estado, String fecha, String clave, String idP ) throws Exception{
		Adm.ingresarU(estado, fecha, clave, idP);
	}
	public static void actualizar(String cEDULA, String aPELLIDOS, 
			String nOMBRES, String dIRECCION, 
			String iDPARROQUIA, String eMAIL, 
			String tELEFONOD, String tELEFONOOF, String tELEFONOC, String id ) throws Exception {
		Adm.actualizar(cEDULA, aPELLIDOS, nOMBRES, dIRECCION, iDPARROQUIA, eMAIL, tELEFONOD, tELEFONOOF, tELEFONOC, id);{
		System.out.print("Actualizadoooo");}
	}
	
	public static ArrayList DatosReq() throws Exception {
		ArrayList datosReq = Adm.datosRequerimientos();
		Vector datosReq2 = (Vector)datosReq.get(0);
		if(datosReq2.get(0).toString().trim().equals("vacio")) {
			Vector datosReq3 = new Vector();
		}
		return datosReq;
	}
	
	public static ArrayList listarPersonasServ(String idServicio) throws Exception {
		ArrayList PerSer = Adm.listarPerServ(idServicio);
		Vector PerSer2 = (Vector)PerSer.get(0);
		if(PerSer2.get(0).toString().trim().equals("vacio")) {
			Vector PerSer3 = new Vector();
			//parroquias
		}
		return PerSer;
	}
	
	public static ArrayList listarPersonasServParr(String idServicio,String idparroquia) throws Exception {
		ArrayList PerSer = Adm.listarPerServParr(idServicio, idparroquia);
		Vector PerSer2 = (Vector)PerSer.get(0);
		if(PerSer2.get(0).toString().trim().equals("vacio")) {
			PerSer=listarPersonasServ(idServicio);
		}
		return PerSer;
	}
	
	public static ArrayList DatosPerUsr(String idUsuario) throws Exception {
		ArrayList PerSer = Adm.datosPerUsuario(idUsuario);
		Vector PerSer2 = (Vector)PerSer.get(0);
		if(PerSer2.get(0).toString().trim().equals("vacio")) {
			Vector PerSer3 = new Vector();
		}
		return PerSer;
	}
	public static ArrayList listarServicios(String idtiposervicio) throws Exception {

		ArrayList servicios = Adm.listarServicio(idtiposervicio);
		Vector servicios2 = (Vector)servicios.get(0);
		if(servicios2.get(0).toString().trim().equals("vacio")) {
			Vector servicios3 = new Vector();
			}
		return servicios;
	}
	
	public static ArrayList listarCatalogos() throws Exception {
		ArrayList catalogos = Adm.listarCatalogo();
		Vector catalogos2 = (Vector)catalogos.get(0);
		if(catalogos2.get(0).toString().trim().equals("vacio")) {
			Vector catalogos3 = new Vector();
			}
		return catalogos;
	}
	
	public static String listarPersona(String codPersona) throws Exception {
		ArrayList persona = Adm.listarPersona(codPersona);
		Vector persona2 = (Vector)persona.get(0);
		String nombre = persona2.get(0).toString();
		String apellidos = persona2.get(1).toString();
		if(persona2.get(0).toString().trim().equals("vacio")) {
			Vector persona3 = new Vector();
			}
		return apellidos+" "+nombre;
	}
	
	
	public static ArrayList listaGrupos() throws Exception{
		ArrayList grupos = Adm.listarGrupos();
		return grupos;		
	}
	
	public static String verCatalogo(String idCatalogo) throws Exception{
		System.out.println("ID del catalogo:"+ idCatalogo);		
		String nombreCatalogo = "";
		if(!idCatalogo.equals("0")) {
			nombreCatalogo=AdCatalogo.nombreCatalogo(idCatalogo);
		}
		
		return nombreCatalogo;
	}
	
	public static String verServicio(String idServicio) throws Exception{
		System.out.println("ID del servicio:"+idServicio);
		
		String nombreServicio = "";
		if(!idServicio.equals("0")) {
			nombreServicio=AdServicio.nombreServicio(idServicio);
		}
		return nombreServicio;
	}
	
}
