package modelos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Disco {

	protected int id;
	protected String nombre;
	protected String foto;
	protected Date fecha_produccion;
	protected List<Cancion> lista = new ArrayList<Cancion>();
	
	protected int id_Artista;

	public Disco() {
		super();
	}
	
	

	public Disco(int id) {
		super();
		this.id = id;
	}



	public Disco(int id, String nombre, String foto, Date fecha_produccion, int id_Artista) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.fecha_produccion = fecha_produccion;
		this.id_Artista = id_Artista;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getFecha_produccion() {
		return fecha_produccion;
	}

	public void setFecha_produccion(Date fecha_produccion) {
		this.fecha_produccion = fecha_produccion;
	}

	public int getId_Artista() {
		return id_Artista;
	}

	public void setId_Artista(int id_Artista) {
		this.id_Artista = id_Artista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Disco other = (Disco) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
