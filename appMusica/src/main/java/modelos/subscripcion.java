package modelos;

public class subscripcion {

	protected int id_usuario;
	protected int id_listadereproduccion;
	
	
	
	public subscripcion() {
		super();
	}

	public subscripcion(int id_usuario, int id_listadereproduccion) {
		super();
		this.id_usuario = id_usuario;
		this.id_listadereproduccion = id_listadereproduccion;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_listadereproduccion() {
		return id_listadereproduccion;
	}
	public void setId_listadereproduccion(int id_listadereproduccion) {
		this.id_listadereproduccion = id_listadereproduccion;
	}
	@Override
	public String toString() {
		return "subscripcion [id_usuario=" + id_usuario + ", id_listadereproduccion=" + id_listadereproduccion + "]";
	}
	
	
}
