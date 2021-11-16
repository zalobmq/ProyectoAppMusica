package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Cancion;
import utilidades.Conexion;
import utilidades.UtilidadXml;

public class CancionDAO extends Cancion{

	//SENTENCIAS 
	/*
	 * ESTAS OPCIONES LAS EJECUTARA EL ARTISTA
	 */
	private final static String AÑADIR="INSERT INTO cancion (id,nombre,duracion,n_reproducciones,id_disco,id_genero) VALUES (?,?,?,?,?,?)"; //AÑADIR CANCION
	private final static String BORRAR="DELETE FROM cancion WHERE id=?";			//BORRAR CANCION
	
	/*
	 * ESTAS OPCIONES LAS EJECUTARA EL USUARIO
	 */
	//NUMERO DE REPRODUCCIONES DE LA CANCION POR UN ID
	private final static String VER_Nº_REPRODUCCIONES="SELECT n_reproducciones FROM cancion WHERE id=?";
	//TODAS LAS CANCIONES DE LA BD
	private final static String TODAS_LAS_CANCIONES="SELECT id,nombre,duracion,n_reproducciones,id_disco,id_genero FROM cancion";
	//BUSCAR CANCION POR NOMBRE Y MOSTRAR TODA SU INFO 
	private final static String BUSCAR_POR_NOMBRE="SELECT id,nombre,duracion,n_reproducciones,id_disco,id_genero FROM cancion WHERE nombre=?";
	private final static String BUSCAR_CANCIONES_X_ID_DISCO="SELECT id,nombre,duracion,n_reproducciones,id_disco,id_genero FROM cancion WHERE id_disco=?";
	private final static String CANCION="SELECT id,nombre,duracion,n_reproducciones,id_disco,id_genero FROM cancion WHERE id=? ";

	private final static String AÑADIR_REP_CANCION="UPDATE cancion SET n_reproducciones=?";
	

	public CancionDAO() {
		super();
		
	}
	public CancionDAO(int id) {
		super(id);
		
	}
	
	public CancionDAO(int id, String nombre, int duracion,int nReproducciones, int id_disco, int id_genero) {
		super(id,nombre,duracion,nReproducciones,id_disco,id_genero);
	}
	
	
	public int añadir() {
		int result = 0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(AÑADIR);
				q.setInt(1, this.id);
				q.setString(2, this.nombre);
				q.setInt(3, 2);	
				q.setInt(4, 0);
				q.setInt(5, this.id_genero);
				q.setInt(6, this.id_disco);

				result = q.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static CancionDAO cancion_x_id(int idCancion) {
		
		CancionDAO result = new CancionDAO();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(CANCION);
				q.setInt(1, idCancion);
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						result.setId(rs.getInt("id"));
						result.setNombre(rs.getString("nombre"));
						result.setDuracion(rs.getInt("duracion"));
						result.setnReproducciones(rs.getInt("n_reproducciones"));
						result.setId_genero(rs.getInt("id_genero"));
						result.setId_disco(rs.getInt("id_disco"));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	public static List<Cancion> todas_las_canciones() {
		
		List<Cancion> result = new ArrayList<Cancion>();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(TODAS_LAS_CANCIONES);
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						CancionDAO c=new CancionDAO();
						c.setId(rs.getInt("id"));
						c.setNombre(rs.getString("nombre"));
						c.setDuracion(rs.getInt("duracion"));
						c.setnReproducciones(rs.getInt("n_reproducciones"));
						c.setId_genero(rs.getInt("id_genero"));
						c.setId_disco(rs.getInt("id_disco"));
						result.add(c);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	public static List<Cancion> lista_canciones_x_id_disco(int id_disco) {
		
		List<Cancion> result = new ArrayList<Cancion>();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(BUSCAR_CANCIONES_X_ID_DISCO);
				q.setInt(1, id_disco);
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						CancionDAO c=new CancionDAO();
						c.setId(rs.getInt("id"));
						c.setNombre(rs.getString("nombre"));
						c.setDuracion(rs.getInt("duracion"));
						c.setnReproducciones(rs.getInt("n_reproducciones"));
						c.setId_genero(rs.getInt("id_genero"));
						c.setId_disco(rs.getInt("id_disco"));
						result.add(c);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	public  int añadirMasREP(int manNrep) {
		int result = 0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(AÑADIR_REP_CANCION);
				q.setInt(1, manNrep);
				result = q.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
