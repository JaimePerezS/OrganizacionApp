package presentacion;

import java.util.ArrayList;

public class Participante {
	private int idParticipante;
	private String nombre;
	private String apellidos;
	private String dni;
	private String foto;
	private String direccion;
	private String localidad;
	private String telefono;
	private String fechaNacimiento;
	private String genero; 
	private int posicionFinal;
	
	public Participante (int idParticipante, String nombre,
			String apellidos, String dni,String foto, String direccion,
			String localidad, String telefono, String fechaNacimiento, String genero, int posicionFinal) {
		this.idParticipante = idParticipante;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.foto = foto;
		this.direccion = direccion;
		this.localidad = localidad;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.posicionFinal = posicionFinal;
	}
	
	public int getPosicionFinal() {
		return posicionFinal;
	}

	public void setPosicionFinal(int posicionFinal) {
		this.posicionFinal = posicionFinal;
	}

	public Participante () {
	}

	public int getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
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

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
