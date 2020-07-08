package com.sistemaBarbijos;

public class Cliente {
	private String direccion;
	private String apellido;
	private String nombre;

	public Cliente(String direccion, String apellido, String nombre) {
		this.apellido = apellido;
		this.direccion = direccion;
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
