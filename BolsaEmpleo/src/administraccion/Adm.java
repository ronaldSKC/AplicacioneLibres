package administraccion;

import java.util.ArrayList;
import java.util.Vector;

import bdd.BDD;

public class Adm {

	public static ArrayList listarParroquia(String idCanton) throws Exception {
		ArrayList parroquia = new ArrayList();
		String sentencia = "SELECT IDPARROQUIA, NOMBREPARROQUIA, IDCANTON " + "FROM adparroquia " + "where IDCANTON = "
				+ idCanton + " " + "ORDER BY NOMBREPARROQUIA";
		ArrayList parroquia1 = BDD.consultar1(sentencia);
		if (!parroquia1.isEmpty()) {
			Vector parroquias2 = (Vector) parroquia1.get(0);
			if (!parroquias2.isEmpty()) {
				String parroquias3 = parroquias2.get(0).toString().trim();
				if (!parroquias3.isEmpty()) {
					parroquia = parroquia1;
				}
			}
		}
		if (parroquia.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("EL CANTON " + idCanton + " NO TIENE PARROQUIAS");
			parroquia.add(vacios);
		}
		return parroquia;
	}

	public static ArrayList listarProvincias() throws Exception {
		ArrayList provincia = new ArrayList();
		String sentencia = "SELECT IDPROVINCIA, NOMBREPROVINCIA " + "FROM adprovincia " + "ORDER BY NOMBREPROVINCIA";
		ArrayList provincia1 = BDD.consultar1(sentencia);
		if (!provincia1.isEmpty()) {
			Vector provincia2 = (Vector) provincia1.get(0);
			if (!provincia2.isEmpty()) {
				String provincias3 = provincia2.get(0).toString().trim();
				if (!provincias3.isEmpty()) {
					provincia = provincia1;
				}
			}
		}
		if (provincia.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("NO EXISTE PROVINCIAS EN LA BASE DE DATOS");
			provincia.add(vacios);
		}
		return provincia;
	}

	public static ArrayList listarCantones(String idProvincia) throws Exception {
		ArrayList canton = new ArrayList();
		String sentencia = "SELECT IDCANTON, NOMBRECANTON " + "FROM adcanton " + "where IDPROVINCIA = " + idProvincia
				+ " " + "ORDER BY NOMBRECANTON";
		ArrayList canton1 = BDD.consultar1(sentencia);
		if (!canton1.isEmpty()) {
			Vector canton2 = (Vector) canton1.get(0);
			if (!canton2.isEmpty()) {
				String canton3 = canton2.get(0).toString().trim();
				if (!canton3.isEmpty()) {
					canton = canton1;
				}
			}
		}
		if (canton.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("LA PROVINCIA " + idProvincia + " NO TIENE CANTONES");
			canton.add(vacios);
		}
		return canton;
	}
	
	public static ArrayList listarDatosPersonasCNA (String imputCedula,String imputNombre,String imputApellido) throws Exception{
		ArrayList datosPersonas = new ArrayList();
		String consulta = "SELECT CEDULA, APELLIDOS, NOMBRES, DIRECCION, EMAIL,TELEFONOD, TELEFONOOF, TELEFONOC, adparroquia.IDPARROQUIA, adparroquia.IDCANTON, adcanton.IDPROVINCIA,NOMBREPARROQUIA, NOMBRECANTON, NOMBREPROVINCIA, perpersona.CODIGOPERSONA\r\n" + 
				"				FROM perpersona INNER JOIN adparroquia \r\n" + 
				"				on perpersona.IDPARROQUIA = adparroquia.IDPARROQUIA INNER JOIN adcanton \r\n" + 
				"				on adparroquia.IDCANTON = adcanton.IDCANTON INNER JOIN adprovincia \r\n" + 
				"				on adcanton.IDPROVINCIA = adprovincia.IDPROVINCIA WHERE perpersona.CEDULA = '"+imputCedula+"'";
			
		ArrayList datosPersonas1 = BDD.consultar1(consulta);
		if(!datosPersonas1.isEmpty()) {
			Vector datosPersonas2 = (Vector)datosPersonas1.get(0);
			if(!datosPersonas2.isEmpty()) {
				String datosPersonas3 = datosPersonas2.get(0).toString().trim();
				if(!datosPersonas3.isEmpty()) {
					datosPersonas = datosPersonas1;
				}
			}
		}
		if (datosPersonas.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("LA PERSONA NO HAY DATOS");
			datosPersonas.add(vacios);
		}
		System.out.println(datosPersonas);
		return datosPersonas;
	}

	public static ArrayList listarDatosPersona(String codigoPersona) throws Exception {
		ArrayList datosPersonas = new ArrayList();
		String consulta = "SELECT CEDULA, APELLIDOS, NOMBRES, DIRECCION, EMAIL,TELEFONOD, TELEFONOOF, TELEFONOC, adparroquia.IDPARROQUIA, adparroquia.IDCANTON, adcanton.IDPROVINCIA,NOMBREPARROQUIA, NOMBRECANTON, NOMBREPROVINCIA\r\n"
				+ "FROM perpersona \r\n"  + "INNER JOIN adparroquia \r\n"
				+ "on perpersona.IDPARROQUIA = adparroquia.IDPARROQUIA\r\n" + "INNER JOIN adcanton \r\n"
				+ "on adparroquia.IDCANTON = adcanton.IDCANTON\r\n" + "INNER JOIN adprovincia \r\n"
				+ "on adcanton.IDPROVINCIA = adprovincia.IDPROVINCIA\r\n" + "WHERE perpersona.CODIGOPERSONA = "
				+ codigoPersona;
		ArrayList datosPersonas1 = BDD.consultar1(consulta);
		if (!datosPersonas1.isEmpty()) {
			Vector datosPersonas2 = (Vector) datosPersonas1.get(0);
			if (!datosPersonas2.isEmpty()) {
				String datosPersonas3 = datosPersonas2.get(0).toString().trim();
				if (!datosPersonas3.isEmpty()) {
					datosPersonas = datosPersonas1;
				}
			}
		}
		if (datosPersonas.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("LA PERSONA " + codigoPersona + " NO HAY DATOS");
			datosPersonas.add(vacios);
		}
		System.out.println(datosPersonas);
		return datosPersonas;
	}
	public static void ingresarU(String estado, String fecha, String clave, String idP ) throws Exception {
		String sentencia="INSERT INTO perusuario" + 
				"(idEstado," + 
				"fecha," + 
				"clave," + 
				"CODIGOPERSONA)" + 
				"VALUES (" + 
				estado + 
				"'"+fecha+"'" + 
				"'"+clave+"'" + 
				idP+")";
		BDD.ingresar(sentencia);
	}
	public static String codpersona() throws Exception {
		String nombreParroquia ="";
		String nombre = "SELECT CODIGOPERSONA" + 
				"		FROM perpersona " + 
				"		ORDER by CODIGOPERSONA DESC limit 1";
		ArrayList nombres = BDD.consultar1(nombre); 
		nombreParroquia = nombres.toString();
		return nombreParroquia;
		
	}
	public static void ingresar(String cEDULA, String aPELLIDOS, String nOMBRES, String dIRECCION, String iDPARROQUIA,
			String eMAIL, String tELEFONOD, String tELEFONOOF, String tELEFONOC) throws Exception {
		String respuesta = "";
		String sentencia = "INSERT INTO perpersona " + "(CEDULA,APELLIDOS,NOMBRES," + "DIRECCION,IDPARROQUIA,"
				+ "EMAIL,TELEFONOD,TELEFONOOF,TELEFONOC) " + "VALUES (" + cEDULA + ",'" + aPELLIDOS + "'," + "'"
				+ nOMBRES + "'," + "'" + dIRECCION + "'," + "" + iDPARROQUIA + ",'" + eMAIL + "', " + "'" + tELEFONOD
				+ "'," + "'" + tELEFONOOF + "','" + tELEFONOC + "')";
		BDD.ingresar(sentencia);

	}

	public static void actualizar(String cEDULA, String aPELLIDOS, String nOMBRES, String dIRECCION, String iDPARROQUIA,
			String eMAIL, String tELEFONOD, String tELEFONOOF, String tELEFONOC, String id) throws Exception {
		String respuesta = "";
		String sentencia = "UPDATE `perpersona`\r\n" + 
				"SET \r\n" + 
				"`APELLIDOS` = '"+aPELLIDOS+"',\r\n" + 
				"`NOMBRES` = '"+nOMBRES+"',\r\n" + 
				"`DIRECCION` ='"+ dIRECCION+"',\r\n" + 
				"`IDPARROQUIA` = "+iDPARROQUIA+",\r\n" + 
				"`EMAIL` = '"+eMAIL+"',\r\n" + 
				"`TELEFONOD` = '"+tELEFONOD+"',\r\n" + 
				"`TELEFONOOF` = '"+tELEFONOOF+"',\r\n" + 
				"`TELEFONOC` = '"+tELEFONOC+"'\r\n" + 
				"WHERE `CODIGOPERSONA` ="+ id;
		BDD.ingresar(sentencia);

	}

	public static ArrayList listarPerServ(String idServicio) throws Exception {
		ArrayList PerSer = new ArrayList();
		String sentencia = "SELECT  perpersona.CODIGOPERSONA,NOMBRES, APELLIDOS, nombreServicio, DIRECCION, NOMBREPARROQUIA, EMAIL "
				+ "FROM adparroquia, perpersona, personaservicio, servicio "
				+ "where adparroquia.IDPARROQUIA = perpersona.IDPARROQUIA "
				+ "and perpersona.CODIGOPERSONA = personaservicio.CODIGOPERSONA "
				+ "and personaservicio.idServicio = servicio.idServicio " + "and servicio.idServicio = " + idServicio
				+ " " + "ORDER BY APELLIDOS";
		ArrayList PerSer1 = BDD.consultar1(sentencia);
		if (!PerSer1.isEmpty()) {
			Vector PerSer2 = (Vector) PerSer1.get(0);
			if (!PerSer2.isEmpty()) {
				String PerSer3 = PerSer2.get(0).toString().trim();
				if (!PerSer3.isEmpty()) {
					PerSer = PerSer1;
				}
			}
		}
		if (PerSer.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("EL SERVICIO " + idServicio + " NO ESTA DISPONIBLE");
			PerSer.add(vacios);
		}
		return PerSer;
	}

	public static ArrayList listarPerServParr(String idServicio, String idparroquia) throws Exception {
		ArrayList SerPer = new ArrayList();
		String sentencia = "SELECT perpersona.CODIGOPERSONA, NOMBRES, APELLIDOS, nombreServicio, DIRECCION, NOMBREPARROQUIA, EMAIL "
				+ "FROM adparroquia, perpersona, personaservicio, servicio "
				+ "where adparroquia.IDPARROQUIA = perpersona.IDPARROQUIA "
				+ "and perpersona.CODIGOPERSONA = personaservicio.CODIGOPERSONA "
				+ "and personaservicio.idServicio = servicio.idServicio " + "and servicio.idServicio = " + idServicio
				+ " " + "and perpersona.IDPARROQUIA = " + idparroquia + " " + "ORDER BY APELLIDOS";
		ArrayList SerPer1 = BDD.consultar1(sentencia);
		if (!SerPer1.isEmpty()) {
			Vector SerPer2 = (Vector) SerPer1.get(0);
			if (!SerPer2.isEmpty()) {
				String SerPer3 = SerPer2.get(0).toString().trim();
				if (!SerPer3.isEmpty()) {
					SerPer = SerPer1;
				}
			}
		}
		if (SerPer.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			SerPer.add(vacios);
		}
		return SerPer;
	}

	public static ArrayList datosPerUsuario(String idusuario) throws Exception {
		ArrayList PerUsuario = new ArrayList();
		String sentencia = "SELECT NOMBRES, APELLIDOS " + "FROM  perpersona " + "where perpersona.CODIGOPERSONA= "
				+ idusuario + " ";
		ArrayList PerUsuario1 = BDD.consultar1(sentencia);
		if (!PerUsuario1.isEmpty()) {
			Vector PerUsuario2 = (Vector) PerUsuario1.get(0);
			if (!PerUsuario2.isEmpty()) {
				String PerUsuario3 = PerUsuario2.get(0).toString().trim();
				if (!PerUsuario3.isEmpty()) {
					PerUsuario = PerUsuario1;
				}
			}
		}
		if (PerUsuario.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			PerUsuario.add(vacios);
		}
		return PerUsuario;
	}

	public static ArrayList datosRequerimientos() throws Exception {
		ArrayList datosReq = new ArrayList();
		String sentencia = "SELECT perpersona.CODIGOPERSONA, NOMBRES, APELLIDOS, nombreServicio, NOMBREPARROQUIA, fechaSolicitada,  berequerimiento.idParroquia, berequerimiento.idServicio,email "
				+ "FROM berequerimiento, adparroquia, perpersona, servicio "
				+ "WHERE adparroquia.IDPARROQUIA = berequerimiento.idParroquia "
				+ "and perpersona.CODIGOPERSONA = berequerimiento.CODIGOPERSONA "
				+ "and servicio.idServicio = berequerimiento.idServicio " + "and berequerimiento.idEstado = '1' "
				+ "ORDER BY fechaSolicitada";
		ArrayList datosReq1 = BDD.consultar1(sentencia);
		if (!datosReq1.isEmpty()) {
			Vector datosReq2 = (Vector) datosReq1.get(0);
			if (!datosReq2.isEmpty()) {
				String datosReq3 = datosReq2.get(0).toString().trim();
				if (!datosReq3.isEmpty()) {
					datosReq = datosReq1;
				}
			}
		}
		if (datosReq.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			datosReq.add(vacios);
		}
		return datosReq;
	}

	public static ArrayList listarServicio(String idtiposervicio) throws Exception {
		ArrayList servicio = new ArrayList();
		String sentencia = "SELECT IDSERVICIO, NOMBRESERVICIO " + "FROM servicio WHERE idtiposervicio ="
				+ idtiposervicio;

		ArrayList servicios1 = BDD.consultar1(sentencia);
		if (!servicios1.isEmpty()) {
			Vector servicios2 = (Vector) servicios1.get(0);
			if (!servicios2.isEmpty()) {
				String servicios3 = servicios2.get(0).toString().trim();
				if (!servicios3.isEmpty()) {
					servicio = servicios1;
				}
			}
		}
		if (servicio.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("EL SERVICIOS  NO EXISTE");
			servicio.add(vacios);
		}

		return servicio;
	}

	/*-----------------------------------------------------------*/
	public static void registrarServicioArtesano(String idServicio, String codPer, String estado) throws Exception {
		String sql = "INSERT INTO personaservicio (idServicio,CODIGOPERSONA,estado)VALUES (" + idServicio + "," + codPer
				+ "," + estado + ")";
		BDD.instruccion(sql);
	}
	/*-----------------------------------------------------------*/

	public static ArrayList listarCatalogo() throws Exception {
		ArrayList catalogo = new ArrayList();
		String sentencia = "SELECT idCatalogo,catalogo "
				+ "FROM   adcatalogo where idTipoCatalogo = 4 ORDER BY catalogo ";

		ArrayList catalogos1 = BDD.consultar1(sentencia);
		if (!catalogos1.isEmpty()) {
			Vector catalogos2 = (Vector) catalogos1.get(0);
			if (!catalogos2.isEmpty()) {
				String catalogos3 = catalogos2.get(0).toString().trim();
				if (!catalogos3.isEmpty()) {
					catalogo = catalogos1;
				}
			}
		}
		if (catalogo.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("EL catalogo  NO EXISTE");
			catalogo.add(vacios);
		}

		return catalogo;
	}

	public static ArrayList listarPersona(String codPersona) throws Exception {
		ArrayList persona = new ArrayList();
		String sentencia = "SELECT apellidos, nombres " + "FROM   perpersona where codigopersona = "+codPersona+" ORDER BY nombres";

		ArrayList persona1 = BDD.consultar1(sentencia);
		if (!persona1.isEmpty()) {
			Vector persona2 = (Vector) persona1.get(0);
			if (!persona2.isEmpty()) {
				String persona3 = persona2.get(0).toString().trim();
				if (!persona3.isEmpty()) {
					persona = persona1;
				}
			}
		}
		if (persona.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("Persona  NO EXISTE");
			persona.add(vacios);
		}

		return persona;
	}
	public static ArrayList listarGrupos() throws Exception {
		ArrayList listaGrupos = new ArrayList();
		String sentencia = "Select * from grupousuario where nombreGrupoUsuario !='Invitado'";
		ArrayList grupos = BDD.consultar1(sentencia);
		if(!grupos.isEmpty()) {
			Vector grupoV = (Vector)grupos.get(0);
			if(!grupoV.isEmpty()) {
				String provincias3 = grupoV.get(0).toString().trim();
				if(!provincias3.isEmpty()) {
					listaGrupos = grupos;
				}
			}
		}
		if (listaGrupos.isEmpty()) {
			Vector vacios = new Vector();
			vacios.add("vacio");
			vacios.add("NO EXISTE PROVINCIAS EN LA BASE DE DATOS");
			listaGrupos.add(vacios);
		}
		return listaGrupos;
	}


}
