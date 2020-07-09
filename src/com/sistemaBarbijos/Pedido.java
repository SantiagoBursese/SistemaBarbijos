package com.sistemaBarbijos;

import java.util.Date;

public class Pedido {
	//private Long id;
	private Date fecha;
	private Cliente cliente;
	private Integer cantidadBabijos;

	public Pedido(Date fecha, Cliente cliente, Integer cantidadBabijos) {
		this.fecha = fecha;
		this.cliente = cliente;
		this.cantidadBabijos = cantidadBabijos;
	}

	public Pedido() {
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getCantidadBabijos() {
		return cantidadBabijos;
	}

	public void setCantidadBabijos(Integer cantidadBabijos) {
		this.cantidadBabijos = cantidadBabijos;
	}
}
