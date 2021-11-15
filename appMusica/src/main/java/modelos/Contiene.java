package modelos;

public class Contiene {

	protected int id_listaReproduccion;
	protected int id_cancion;
	
	
	
	public Contiene() {
		super();
	}
	
	public Contiene(int id_listaReproduccion, int id_cancion) {
		super();
		this.id_listaReproduccion = id_listaReproduccion;
		this.id_cancion = id_cancion;
	}

	public int getId_listaReproduccion() {
		return id_listaReproduccion;
	}

	public void setId_listaReproduccion(int id_listaReproduccion) {
		this.id_listaReproduccion = id_listaReproduccion;
	}

	public int getId_cancion() {
		return id_cancion;
	}

	public void setId_cancion(int id_cancion) {
		this.id_cancion = id_cancion;
	}

	@Override
	public String toString() {
		return "Contiene [id_listaReproduccion=" + id_listaReproduccion + ", id_cancion=" + id_cancion + "]";
	}
	
	
	
	
}
