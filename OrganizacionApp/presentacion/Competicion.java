package presentacion;

import java.util.ArrayList;

public class Competicion {
	private int idCompeticion;
	private String nombre;
	private String fechaHora;
	private String modalidad;
	private double distancia;
	private String localidad;
	private String entidadorganizadora;
	private String descripcion;
	private String fechaLimite;
	private String web;
	private String mapa;
	private String cartel;
	private boolean finalizada;
	
	
	public Competicion(int idCompeticion, String nombre, String fechaHora,
			String modalidad, double distancia, String localidad,
			String entidadorganizadora, String descripcion, String fechaLimite,
			String web, String mapa, String cartel, boolean finalizada) {
		
		this.idCompeticion = idCompeticion;
		this.nombre = nombre;
		this.fechaHora = fechaHora;
		this.modalidad = modalidad;
		this.distancia = distancia;
		this.localidad = localidad;
		this.entidadorganizadora = entidadorganizadora;
		this.descripcion = descripcion;
		this.fechaLimite = fechaLimite;
		this.web = web;
		this.mapa = mapa;
		this.cartel = cartel;
		this.setFinalizada(finalizada);
	}

	public int getIdCompeticion() {
		return idCompeticion;
	}
	public void setIdCompeticion(int idCompeticion) {
		this.idCompeticion = idCompeticion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getEntidadorganizadora() {
		return entidadorganizadora;
	}
	public void setEntidadorganizadora(String entidadorganizadora) {
		this.entidadorganizadora = entidadorganizadora;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getCartel() {
		return cartel;
	}
	public void setCartel(String cartel) {
		this.cartel = cartel;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public String getMapa() {
		return mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}
	
}
