package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.Genero;
import utilidades.Conexion;
import utilidades.UtilidadXml;

public class GeneroDAO extends Genero{

	//SENTENCIAS 
	
	private static String GENERO_X_ID="SELECT id,nombre FROM genero WHERE id=?";
	
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
	
}
