package modelos;

import java.util.ArrayList;
import java.util.List;

public class ListaDeReproduccion {

	protected int id;
	protected String nombre;
	protected String descripcion;
	protected int usuarioCreador;		//En la base de datos se guarda el id del usuario
	protected List<Cancion> lista = new ArrayList<Cancion>();
	
	
	public ListaDeReproduccion() {
		super();
	}
	
	public ListaDeReproduccion(int id) {
		super();
		this.id = id;
	}

	public ListaDeReproduccion(int id, String nombre, String descripcion, int usuarioCreador , List<Cancion> lista) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCreador = usuarioCreador;
		this.lista = lista;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId_usuario() {
		return usuarioCreador;
	}
	public void setId_usuario(int i) {
		this.usuarioCreador = i;
	}
	public List<Cancion> getLista() {
		return lista;
	}
	public void setLista(List<Cancion> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "ListaDeReproduccion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", usuarioCreador=" + usuarioCreador + ", lista=" + lista + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + usuarioCreador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaDeReproduccion other = (ListaDeReproduccion) obj;
		if (usuarioCreador != other.usuarioCreador)
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
}
