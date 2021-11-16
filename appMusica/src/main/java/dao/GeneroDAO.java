package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Cancion;
import modelos.Genero;
import utilidades.Conexion;
import utilidades.UtilidadXml;

public class GeneroDAO extends Genero{

	//SENTENCIAS 
	
	private static String GENERO_X_ID="SELECT id,nombre FROM genero WHERE id=?";
	private static String TODOS_LOS_GENEROS="SELECT id,nombre FROM genero";
	
	//--------------------------
	public GeneroDAO() {
		super();
	}
	
	public GeneroDAO(int id) {
		super(id);
	}
	public GeneroDAO(int id,String nombre) {
		super(id,nombre);
	}
	
	public GeneroDAO genero_x_id (int idGenero) {
		GeneroDAO result = new GeneroDAO();
		
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(GENERO_X_ID);
				q.setInt(1, idGenero);
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						result.setId(rs.getInt("id"));
						result.setNombre(rs.getString("nombre"));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	public static List<Genero> todas_los_generos() {
		
		List<Genero> result = new ArrayList<Genero>();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(TODOS_LOS_GENEROS);
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						GeneroDAO c = new GeneroDAO();
						c.setId(rs.getInt("id"));
						c.setNombre(rs.getString("nombre"));
						result.add(c);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
}
