package presentacion;

public class Organizador {
	private int id;
	private String usuario;
	private String nombre;
	private String apellidos;
	private String dni;
	private String fechaNacimiento;
	private String ultimaConexion;
	private String img;
	
	public Organizador(int id, String usuario, String nombre, String apellidos, String dni,  String fechaNacimiento, String ultimaConexion, String img) {
		this.id = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.ultimaConexion = ultimaConexion;
		this.img = img;
	}
	
	public Organizador() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario(){
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos (String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getUltimaConexion() {
		return ultimaConexion;
	}

	public void setUltimaConexion(String ultimaConexion) {
		this.ultimaConexion = ultimaConexion;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
