package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelos.Artista;
import modelos.Contiene;
import utilidades.Conexion;
import utilidades.UtilidadXml;

public class ContieneDAO extends Contiene{

	//SENTENCIAS
	
	
	private static String AÑADIR = "INSERT INTO contiene (id_listadereproduccion,id_cancion) VALUES (?,?)";
	private final static String BORRAR="DELETE FROM contiene WHERE (id_listadereproduccion=?)AND(id_cancion=?)";
	//---------
	public ContieneDAO() {
		super();
	}
	
	public ContieneDAO(int id_listaReproduccion, int id_cancion) {
		super(id_listaReproduccion,id_cancion);
	
	}
	
	public int añadir() {
		int result = 0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(AÑADIR);
				q.setInt(1, this.id_listaReproduccion);
				q.setInt(2, this.id_cancion);
				result = q.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int eliminar(int id_lista , int id_cancion) {
		int rs=0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(BORRAR);
				q.setInt(1, id_lista);
				q.setInt(2, id_cancion);
				rs = q.executeUpdate();
				this.id_cancion=-1;
				this.id_listaReproduccion=-1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return rs;
	}
}
