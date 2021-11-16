package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Artista;
import modelos.Disco;
import modelos.Usuario;
import utilidades.Conexion;
import utilidades.UtilidadXml;

public class ArtistaDAO extends Artista{

	
	//SENTENCIAS 
	
	private final static String AÑADIR="INSERT INTO artista (nombre,nacionalidad,foto,contraseña) VALUES (?,?,?,?)"; //AÑADIR ARTISTA
	private final static String BORRAR="DELETE FROM artista WHERE id=?";				  //BORRAR ARTISTA
	//COMPROBAR NOMBRE Y CONTASEÑA EN EL INICIO DE SESION
	private final static String ARTISTA="SELECT id,nombre,nacionalidad,foto,contraseña FROM artista WHERE (nombre=?)AND(contraseña=?)";
	private final static String INICIO="SELECT id,nombre,nacionalidad,foto,contraseña FROM artista WHERE (nombre=?) AND (contraseña=?)";
	private final static String BUSCAR_POR_NOMBRE="SELECT id,nombre,nacionalidad,foto FROM artista WHERE nombre=?";
	private final static String BUSCAR_ARTISTA_X_ID="SELECT nombre FROM artista WHERE id=?";

	/*
	 * BUSCA ARTISTA POR NOMBRE, 
	 * EL ID DEL ARTISTA LO USUAREMOS PARA BUSCAR LOS DISCOS DEL ARTISTA EN DISCO DAO.
	 * 
	 */

	
	
	public ArtistaDAO() {
		super();
	}
	
	public ArtistaDAO(String nombre, String contraseña) {
		super(nombre,contraseña);
		
	}
	public ArtistaDAO(int id, String nombre, String nacionalidad, String foto, String contraseña,
			List<Disco> lista_discos) {
		super(id , nombre , nacionalidad , foto , contraseña , lista_discos);
	}
	
	/*
	 * AÑARIR ARTISTA -- Un artista podra crear una nueva cuenta.
	 */
	
	public int añadir() {
		int result = 0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(AÑADIR);
				q.setString(1, this.nombre);
				q.setString(2, this.nacionalidad);
				q.setString(3, "iconoUsuarioInicioSesion.png");
				q.setString(4, this.contraseña);
				result = q.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	/*
	 * ELIMINAR ARTISTA -- Se añadira una opcion en el propio artista para borrar su cuenta.
	 */
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
				this.nacionalidad="";
				this.foto="";
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return rs;
	}
	/*
	 * COMPROBAR NOMBRE Y CONTRASEÑA -- Comprueba si el nombre y la contraseña introducicos estan
	 * 									en la base de datos.
	 */
	public boolean comprobarNombre_Contraseña(ArtistaDAO u) {
        boolean result=false;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
        if(con!=null) {
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            try {
                ps = con.prepareStatement(INICIO);
                ps.setString(1, u.getNombre());
                ps.setString(2, u.getContraseña());
                rs=ps.executeQuery();
                while(rs.next()) {
                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setNacionalidad(rs.getString("nacionalidad"));
                    u.setFoto(rs.getString("foto"));
                    u.setContraseña(rs.getString("contraseña"));
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
        }
        if(u.getId()==0) {
            result=false;
        }else {
            result=true;
        }
        return result;
    }
	
	public ArtistaDAO ArtistaBD(Artista a) {
		ArtistaDAO result =new ArtistaDAO();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(ARTISTA);
				ResultSet rs = q.executeQuery();
				q.setString(1, a.getNombre());
				q.setString(2, a.getContraseña());
				while (rs.next()) {
					
					result.setId(rs.getInt("id"));
					result.setNombre(rs.getString("nombre"));
					result.setNacionalidad(rs.getString("nacionalidad"));
					result.setFoto(rs.getString("foto"));
					result.setContraseña(rs.getString("contraseña"));
				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
	
	public ArtistaDAO buscarArtistaId(int idArtista) {
		ArtistaDAO result =new ArtistaDAO();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
        if(con!=null) {
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            try {
                ps = con.prepareStatement(BUSCAR_ARTISTA_X_ID);
                ps.setInt(1, idArtista);

                rs=ps.executeQuery();
                while(rs.next()) {
                	
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
