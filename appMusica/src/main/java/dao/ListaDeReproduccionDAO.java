package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.util.Callback;
import modelos.Cancion;
import modelos.ListaDeReproduccion;
import modelos.Usuario;
import utilidades.Conexion;
import utilidades.UtilidadXml;

public class ListaDeReproduccionDAO extends ListaDeReproduccion{

	//SENTENCIAS 
	
	private static String AÑADIR="INSERT INTO listadereproduccion (id,nombre,descripcion,id_usuario) VALUES (?,?,?,?)";
	private static String BORRAR="DELETE FROM listadereproduccion WHERE id=?";
	private static String MOSTRAR_TODOS="SELECT id,nombre,descripcion,id_usuario FROM listadereproduccion";
	private static String MOSTRAR_TODAS_MIS_LISTAS="SELECT id,nombre,descripcion,id_usuario FROM listadereproduccion WHERE id_usuario=?";
	//private static String MOSTRAR_TODAS_SUBSCRITO="SELECT subscripcion.id_listadereproduccion from subscripcion where subscripcion.id_usuario=?";
	private static final String MOSTRAR_SUBSCRIBE = "SELECT l.id,l.nombre,l.descripcion,l.id_usuario FROM listadereproduccion AS l ,subscripcion WHERE (subscripcion.id_listadereproduccion=l.id) AND (subscripcion.id_usuario=?)";
	private static String MOSTRAR_LISTA_X_ID="SELECT id,nombre,descripcion,id_usuario FROM listadereproduccion WHERE id=?";
	
	private static String OBTENER_CANCIONES="SELECT id_cancion FROM contiene WHERE id_listadereproduccion=?";
	

	
	public ListaDeReproduccionDAO() {
		super();
	}
	
	public ListaDeReproduccionDAO(int id) {
		super(id);
	}
	public ListaDeReproduccionDAO(int id, String nombre, String descripcion, int usuarioCreador ,List<Cancion> lista) {
		super(id,nombre,descripcion,usuarioCreador , lista);
		
	}
	/*
	 * Recibe el usuario que quiere añadir la lista.
	 */
	public int añadir() {
		int result = 0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(AÑADIR);
				q.setInt(1, this.id);
				q.setString(2, this.nombre);
				q.setString(3, this.descripcion);
				q.setInt(4, this.usuarioCreador);
				
				result = q.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int eliminar(int id) {
		int rs=0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(BORRAR);
				q.setInt(1, id);
				rs = q.executeUpdate();
				this.id=-1;
				this.nombre="";
				this.descripcion="";
				this.usuarioCreador=-1;
				this.lista=null;		// ? Ns si nulear la lista.
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return rs;
	}
	
	public static List<ListaDeReproduccion> Mostrar_todos() {
		List<ListaDeReproduccion> result = new ArrayList<ListaDeReproduccion>();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(MOSTRAR_TODOS);
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						ListaDeReproduccion lista = new ListaDeReproduccion();
				
						lista.setId(rs.getInt("id"));
						lista.setNombre(rs.getString("nombre"));
						lista.setDescripcion(rs.getString("descripcion"));
						lista.setId_usuario(rs.getInt("id_usuario"));
						result.add(lista);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	/*
	 * Muestra todas mis listas ,pasando mi id en la sentencia.
	 */
	public static List<ListaDeReproduccion> Mostrar_todas_mis_listas(Usuario u) {
		List<ListaDeReproduccion> result = new ArrayList<ListaDeReproduccion>();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(MOSTRAR_TODAS_MIS_LISTAS);
				q.setInt(1, u.getId());
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						ListaDeReproduccion lista = new ListaDeReproduccion();
				
						lista.setId(rs.getInt("id"));
						lista.setNombre(rs.getString("nombre"));
						lista.setDescripcion(rs.getString("descripcion"));
						lista.setId_usuario(rs.getInt("id_usuario"));
						
						result.add(lista);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	 
	
	public static List<ListaDeReproduccion> Mostrar_todos_Sub(Usuario u) {
		List<ListaDeReproduccion> result = new ArrayList<ListaDeReproduccion>();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(MOSTRAR_SUBSCRIBE);
				q.setInt(1, u.getId());
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						ListaDeReproduccion lista = new ListaDeReproduccion();
				
						lista.setId(rs.getInt("id"));
						lista.setNombre(rs.getString("nombre"));
						lista.setDescripcion(rs.getString("descripcion"));
						lista.setId_usuario(rs.getInt("id_usuario"));
						result.add(lista);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}

	
	
	public ListaDeReproduccionDAO Mostrar_lista_x_id(ListaDeReproduccion list) {
		ListaDeReproduccionDAO result = new ListaDeReproduccionDAO();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(MOSTRAR_LISTA_X_ID);
				q.setInt(1, list.getId());
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						result.setId(rs.getInt("id"));
						result.setNombre(rs.getString("nombre"));
						result.setDescripcion(rs.getString("descripcion"));
						result.setId_usuario(rs.getInt("id_usuario"));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	
	@Override
	public  List<Cancion> getLista() {
		List<Cancion> l = new ArrayList<Cancion>();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));

		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(OBTENER_CANCIONES);
				q.setInt(1, getId());
				ResultSet rs= q.executeQuery();
					while(rs.next()) {
						CancionDAO c = CancionDAO.cancion_x_id((rs.getInt("id_cancion")));
						l.add(c);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return l;
	}	
}
