package modelos;

public class Usuario {

	protected int id;
	protected String nombre;
	protected String correo;
	protected String contraseña;
	protected String foto;
	
	public Usuario() {
		super();
	}
	
	
	
	public Usuario(int id) {
		super();
		this.id = id;
	}



	public Usuario(String nombre, String contraseña) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
	}


	
	public Usuario(String nombre, String correo, String contraseña) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
	}


	public Usuario(int id, String nombre, String correo, String contraseña) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
	}


	public Usuario(int id, String nombre, String correo, String foto , String contraseña) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.foto = foto;
		this.contraseña = contraseña;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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
		Usuario other = (Usuario) obj;
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
