package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Artista;
import modelos.Disco;
import utilidades.Conexion;
import utilidades.UtilidadXml;

public class DiscoDAO extends Disco{

	/*
	 * ESTAS OPCIONES LAS EJECUTARA EL ARTISTA
	 */
	
	//AÑADIR DISCO
	private final static String AÑADIR="INSERT INTO disco (id,nombre,foto,id_artista,fecha_produccion) VALUES(?,?,?,?,?)"; 
	//BORRAR
	private final static String BORRAR="DELETE FROM disco WHERE (nombre = ?)AND(id_artista = ?)";
	//MUESTRA TODOS LOS DISCOS 
	private final static String MOSTRAR_TODOS="SELECT id,nombre,foto,id_artista,fecha_produccion FROM disco";	
	//MUESTRA TODOS LOS DISCO DE ARTISTA CON ID=?
	//Se usara tambien en el usuario para buscar por artista
	private final static String MOSTAR_DISCOS_ARTISTA="SELECT id,nombre,foto,id_artista,fecha_produccion FROM disco WHERE id_artista=?";
	
	private final static String DISCO_X_ID="SELECT id,nombre,foto,id_artista,fecha_produccion FROM disco WHERE ID=?";	

	

	
	public DiscoDAO() {
		super();
	}
	public DiscoDAO(int id) {
		super(id);
	}
	public DiscoDAO(int id, String nombre, String foto, Date fecha_produccion, int id_Artista) {
		super(id, nombre, foto, fecha_produccion, id_Artista);
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.fecha_produccion = fecha_produccion;
		this.id_Artista = id_Artista;
	}
	/*
	 * Añadir disco , recibe el artista actual , para setear su id.
	 */
	public int añadir() {
		int result = 0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(AÑADIR);
				q.setInt(1, this.id);
				q.setString(2, this.nombre);
				q.setString(3, "iconoDisco.png");	
				q.setInt(4, this.id_Artista);
				q.setDate(5, this.fecha_produccion);
				result = q.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	/*
	 * Borra un disco , introduciendo el 
	 */
	public int eliminar(String nombre , Artista a) {
		int rs=0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(BORRAR);
				q.setString(1, nombre);
				q.setInt(2, a.getId());
				rs = q.executeUpdate();
				q.setInt(1, this.id);
				q.setString(2, this.nombre);
				q.setString(3, this.foto);	
				q.setInt(4, this.id_Artista);
				q.setDate(5, this.fecha_produccion);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return rs;
	}
	/*
	 * Lista de todos los discos de la base de datos.
	 * 
	 */
	public static List<Disco> listaTodosDiscos(){
		
		List<Disco> result = new ArrayList<Disco>();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(MOSTRAR_TODOS);
				ResultSet rs = q.executeQuery();
				while (rs.next()) {
					Disco d = new Disco();
					d.setId(rs.getInt("id"));
					d.setNombre(rs.getString("nombre"));
					d.setFoto(rs.getString("foto"));
					d.setId_Artista(rs.getInt("id_artista"));
					d.setFecha_produccion(rs.getDate("fecha_produccion"));
					result.add(d);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}	


	public  static List<Disco> buscarPorArtista(int idDelArtista){
		List<Disco> result = new ArrayList<Disco>();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(MOSTAR_DISCOS_ARTISTA);
				q.setInt(1,idDelArtista);
				ResultSet rs = q.executeQuery();
				while (rs.next()) {
					Disco d = new Disco();
					d.setId(rs.getInt("id"));
					d.setNombre(rs.getString("nombre"));
					d.setFoto(rs.getString("foto"));
					d.setId_Artista(rs.getInt("id_artista"));
					d.setFecha_produccion(rs.getDate("fecha_produccion"));
					result.add(d);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
	public DiscoDAO disco_x_id(int idDisco){
		DiscoDAO result = new DiscoDAO();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(DISCO_X_ID);
				q.setInt(1,idDisco);
				ResultSet rs = q.executeQuery();
				while (rs.next()) {

					result.setId(rs.getInt("id"));
					result.setNombre(rs.getString("nombre"));
					result.setFoto(rs.getString("foto"));
					result.setId_Artista(rs.getInt("id_artista"));
					result.setFecha_produccion(rs.getDate("fecha_produccion"));

				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
	
}
	


