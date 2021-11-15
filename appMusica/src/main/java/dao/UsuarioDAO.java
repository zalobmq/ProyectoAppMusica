package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.Artista;
import modelos.Usuario;
import utilidades.Conexion;
import utilidades.UtilidadXml;

public class UsuarioDAO extends Usuario{

	//SENTENCIAS
	private final static String AÑADIR="INSERT INTO usuario (nombre,correo,foto,contraseña) VALUES (?,?,?,?)"; //AÑADIR ARTISTA
	private final static String BORRAR="DELETE FROM usuario WHERE id=?";			//BORRAR ARTISTA
	//COMPROBAR NOMBRE Y CONTASEÑA EN EL INICIO DE SESION
	private final static String INICIO="SELECT id,nombre,correo,foto,contraseña FROM usuario WHERE (nombre=?) AND (contraseña=?)";
	private final static String BUSCAR_USUARIO_X_ID="SELECT nombre FROM usuario WHERE id=?";
	private final static String CAMBIAR_FOTO="UPDATE usuario SET foto=? WHERE id=?";


	
	public UsuarioDAO() {
		super();
	}
	public UsuarioDAO(int id) {
		super(id);
	}
	public UsuarioDAO(String nombre, String contraseña) {
		super(nombre,contraseña);
		
	}
	public UsuarioDAO(int id, String nombre, String correo, String foto , String contraseña) {
		super(id,nombre,correo,foto,contraseña);
	}
	/*
	 * AÑARIR USUARIO -- Un usuario podra crear una nueva cuenta.
	 */
	
	public int añadir() {
		int result = 0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(AÑADIR);
				q.setString(1, this.nombre);
				q.setString(2, this.correo);
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
	 * ELIMINAR USUARIO -- Se añadira una opcion en el propio usuario para borrar su cuenta.
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
				this.correo="";
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
	public boolean comprobarNombre_Contraseña(UsuarioDAO u) {
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
                    u.setCorreo(rs.getString("correo"));
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
	public UsuarioDAO buscarUsuarioId(int idUsuario) {
		UsuarioDAO result =new UsuarioDAO();
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
        if(con!=null) {
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            try {
                ps = con.prepareStatement(BUSCAR_USUARIO_X_ID);
                ps.setInt(1, idUsuario);

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
	public  int cambiarFoto(String fotoCam,int idUsuario) {
		int result = 0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(CAMBIAR_FOTO);
				q.setString(1, fotoCam);
				q.setInt(2, idUsuario);
				result = q.executeUpdate();	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
