package com.sistemaBarbijos;

import java.util.Date;

public class Pedido {
	//private Long id;
	private Date fecha;
	private Cliente cliente;

	public Pedido( Date fecha, Cliente cliente) {
		//this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
