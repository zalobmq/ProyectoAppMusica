package modelos;

import java.util.List;

public class Artista {

	protected int id;
	protected String nombre;
	protected String nacionalidad;
	protected String foto;	//URL de la foto
	protected String contraseña;
	protected List<Disco> lista_discos;

	public Artista() {
		super();
	}
	

	public Artista(String nombre, String contraseña) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	

	public Artista(int id, String nombre, String contraseña, List<Disco> lista_discos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.lista_discos = lista_discos;
	}


	public Artista(int id, String nombre, String nacionalidad, String foto, String contraseña,
			List<Disco> lista_discos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.foto = foto;
		this.contraseña = contraseña;
		this.lista_discos = lista_discos;
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


	


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
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
		Artista other = (Artista) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
}
