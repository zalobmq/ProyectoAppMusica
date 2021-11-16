package modelos;

public class Cancion {

	protected int id;
	protected String nombre;
	protected int duracion;	//En segundos
	protected int nReproducciones;
	protected int id_disco;
	protected int id_genero;
	
	
	public Cancion() {
		super();
	}
	

	public Cancion(int id) {
		super();
		this.id = id;
	}


	public Cancion(int id, String nombre, int duracion,int nReproducciones, int id_disco, int id_genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.nReproducciones = nReproducciones;
		this.id_disco = id_disco;
		this.id_genero = id_genero;
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getId_disco() {
		return id_disco;
	}

	public void setId_disco(int id_disco) {
		this.id_disco = id_disco;
	}

	public int getId_genero() {
		return id_genero;
	}

	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}
	public int getnReproducciones() {
		return nReproducciones;
	}

	public void setnReproducciones(int nReproducciones) {
		this.nReproducciones = nReproducciones;
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
		Cancion other = (Cancion) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
}
