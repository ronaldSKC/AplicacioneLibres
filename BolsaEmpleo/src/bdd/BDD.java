package bdd;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class BDD {
	
	final static String DB_URL = "jdbc:mysql://localhost/bolsa_de_empleo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final static String USER = "root";
	final static String PASS = "root";
	int oldTransactionIsolation = 0;
	Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	String errorInicial = null;
	String errorPeticion = null;
	String errorGeneral = null;
	
	public static Connection con() {
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}

	public static Statement st() {
		Statement stmt;
		try {
			stmt = BDD.con().createStatement();
			return stmt;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return null;
		}
	}
	
	public static  ArrayList consultar1(String sentencia) throws Exception {
		ArrayList cifras = new ArrayList();
		Statement p = st();
		ResultSet rs = p.executeQuery(sentencia);
		ResultSetMetaData rsmd = rs.getMetaData();
		while(rs.next()) {
			Vector cifras2 = new Vector();
				
			for(int i=1;i<=rsmd.getColumnCount();i++)
	        {
				cifras2.add(rs.getString(i));
	            
	        }
			
			cifras.add(cifras2);
			
		}   
		
		System.out.println(cifras);
		return cifras;
		
	}
	public static int ingresar(String sentencia) throws Exception{
		System.out.println("resultado");
		int resultado ;
		Statement p = st();
		resultado = p.executeUpdate(sentencia);
		System.out.println("resultado1"+resultado);
		return resultado;
	}
	
	public static ResultSet consultar(String consulta) throws Exception{
		Statement statement = st();
		ResultSet resultado = statement.executeQuery(consulta);
		return resultado;
	}
	public void beginTransaccion()throws Exception {
		oldTransactionIsolation = con.getTransactionIsolation();
		con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		con.setAutoCommit(false);
	}
	public Vector beginTransaccion(Vector datos) throws Exception{
		Vector respuesta = new Vector();
		int cntri = 0;
		boolean commit = true;
		oldTransactionIsolation = con.getTransactionIsolation();
		con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		con.setAutoCommit(false);
		try {
			int tamanio = datos.size();
			for (int i = 0; i<tamanio;i++) {
				System.out.println(datos.get(i).toString());
				cntri = i;
				ejecutarSentencia(datos.get(i).toString());
			}
			respuesta.add("true");
			respuesta.add("0");
		}
		catch (Exception e) {
			commit = false;
			System.out.println(datos.get(cntri).toString());
			System.out.println(e.toString());
			respuesta.add("false");
			respuesta.add(e.toString());
		}
		if (commit) {
			con.setAutoCommit(commit);
			con.commit();
			con.setTransactionIsolation(oldTransactionIsolation);
			close();
			
		}
		else{
			con.rollback();
			con.setTransactionIsolation(oldTransactionIsolation);
			con.setAutoCommit(true);
			close();
		}return respuesta;
	}
	public void commit()throws Exception{
		con.setAutoCommit(true);
		con.commit();
		con.setTransactionIsolation(oldTransactionIsolation);
	}
	public void rollback()throws Exception{
		con.rollback();
		con.setTransactionIsolation(oldTransactionIsolation);
		con.setAutoCommit(true);
	}
	public synchronized ResultSet ejecutarConsulta(String sentencia) throws Exception{
		
		try
		{
			if(errorPeticion == null) {
				System.out.println(sentencia);
				rs= st.executeQuery(sentencia);
			}
		}
		catch (Exception e) {
			errorGeneral = new String(e.toString());
			System.out.println(sentencia);
			System.out.println(errorGeneral);
			throw new Exception();
		}
		return rs;
	}
	
	public synchronized int ejecutarSentencia(String sentencia) throws Exception{
		int num_filas=0;
		try
		{
			if(errorPeticion == null) {
				num_filas= st.executeUpdate(sentencia);
			}
		}
		catch (Exception e) {
			errorGeneral = new String(e.toString());
			System.out.println(sentencia);
			System.out.println(errorGeneral);
			throw new Exception();
		}
		return num_filas;
	}
	public synchronized void close() {
		try {
			if(errorPeticion == null) {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(con!=null) con.close();
			}
		}
		catch (Exception e) {
			errorGeneral = new String(e.toString());
			System.out.println(errorGeneral);
		}
	}

	public Connection getCon() {
		return con;
	}

	public String getErrorInicial() {
		return errorInicial;
	}

	public String getErrorPeticion() {
		return errorPeticion;
	}

	public String getErrorGeneral() {
		return errorGeneral;
	}	
	public static ResultSet ejecutarConsulta1(String consulta) throws SQLException {
		ResultSet resultado = null;
		Connection conexion = con();
		Statement sentencia = conexion.createStatement();
		resultado = sentencia.executeQuery(consulta);
		return resultado;
	}
	
	public static int ejecutarActualizacion(String consulta) throws SQLException {
		Connection conexion = con();
		Statement sentencia = conexion.createStatement();
		return sentencia.executeUpdate(consulta);
	}
	public static void instruccion(String sql) throws Exception{
    	Connection con = con();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.executeUpdate();
        //pst = con.prepareStatement("commit");
        //pst.executeUpdate();
        con.close();
}
	
}












