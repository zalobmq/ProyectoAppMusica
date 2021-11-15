package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelos.subscripcion;
import utilidades.Conexion;
import utilidades.UtilidadXml;

public class SubscripcionDAO extends subscripcion{

	

	//SENTENCIAS
	
	private static String AÑADIR_SUB="INSERT INTO subscripcion (id_usuario,id_listadereproduccion) VALUES (?,?)";
	private static String BORRAR_SUB="DELETE FROM subscripcion WHERE (id_usuario=?)AND(id_listadereproduccion=?)";
	private static String MOSTRAR_TODAS_SUBSCRITO_IDUsuario="SELECT id_listadereproduccion from subscripcion where id_usuario=?";

	//+++++++++++
	
	public SubscripcionDAO() {
		super();
	}
	
	public SubscripcionDAO(int id_usuario, int id_listadereproduccion) {
		super(id_usuario, id_listadereproduccion);
	}
	
	public int añadirSub() {
		int result = 0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			
			try {
				PreparedStatement q = con.prepareStatement(AÑADIR_SUB);
				q.setInt(1, this.id_usuario);
				q.setInt(2, this.id_listadereproduccion);
				
				result = q.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int eliminarSub(int id_usuarioBorr,int id_listaRepBorr) {
		int rs=0;
		Connection con = Conexion.getConexion(UtilidadXml.unmarshal("Conexion.xml"));
		if(con != null) {
			try {
				PreparedStatement q = con.prepareStatement(BORRAR_SUB);
				q.setInt(1, id_usuarioBorr);
				q.setInt(2, id_listaRepBorr);
				rs = q.executeUpdate();
				this.id_usuario=-1;
				this.id_listadereproduccion=-1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return rs;
	}

	
	
}
