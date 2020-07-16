package com.sistemaBarbijos;

import com.sistemaBarbijos.Reporte.Reporte;
import com.sistemaBarbijos.Repository.RepositioPedidos;

import java.util.Date;
import java.util.Scanner;

public class Sistema {
	private int minimoPromocion;
	public Scanner scanner;
	public Reporte reporte;
	private int cantidadReportesGenerados = 0;

    public Sistema() {
        RepositioPedidos.iniciarListas();
    	this.minimoPromocion=100;
    	this.reporte = new Reporte();
    	this.scanner = new Scanner(System.in);
    }
    
    public void ejecutarMenu() {    	
    	int opSeleccionada=0;
    	System.out.println("Ingrese un número del menú: \n 1-Agregar pedido. \n 2-Generar reporte. \n 3-Cambiar cant. mín. de barbijos en la promo("+this.getMinimoPromocion() +").");
    	opSeleccionada = this.scanner.nextInt();
    	this.scanner.nextLine();
	    ejecutarOpcionSeleccionada(opSeleccionada);

	    //this.scanner.close();
    }
    
    public void ejecutarOpcionSeleccionada(int opSeleccionada) {
	    if( opSeleccionada == 1) this.obtenerDatosCompra();
	    if( opSeleccionada == 2) this.generarReportes();
	    if( opSeleccionada == 3) this.setCantMinBarbijosPromo();

    }
    
    public void generarReportes() {
    	this.reporte.generarReporte(cantidadReportesGenerados);
    	cantidadReportesGenerados++;
    	System.out.println("Se generaron los reportes correspondientes");
    }
    
    public void setCantMinBarbijosPromo() {
    	System.out.println("Por favor, ingrese la cantidad mínima de barbijos, para la que se aplica la promoción.");
    	this.minimoPromocion = this.scanner.nextInt();
    	this.scanner.nextLine();
    }
    
    public void obtenerDatosCompra(){
        Pedido pedido;
        Cliente cliente;
        String nombre, apellido, direccion, localidad, provincia;
        String respuesta = "S";
        Integer cantidadBarbijos;
        
        
        while (!respuesta.equals("N") ) {
            System.out.println("Ingrese nombre del cliente: ");
            nombre = this.scanner.nextLine();

            System.out.println("Ingrese apellido del cliente: ");
            apellido = this.scanner.nextLine();

            System.out.println("Ingrese direccion del cliente: ");
            direccion = this.scanner.nextLine();
            
            System.out.println("Ingrese localidad del cliente: ");
            localidad = this.scanner.nextLine();
            
            System.out.println("Ingrese provincia del cliente: ");
            provincia = this.scanner.nextLine();
            
            System.out.println("Ingrese cantidad de barbijos: ");
            cantidadBarbijos = this.scanner.nextInt();
            this.scanner.nextLine();
            cliente= registrarCliente(nombre, apellido, direccion, localidad, provincia);

            pedido= registrarPedido(cliente, cantidadBarbijos);
            
            if( aplicaPromocion(pedido,cliente) ) {
            	RepositioPedidos.agregarPedidoGratis(pedido);
            }
            else{
            	RepositioPedidos.agregarPedidoPagos(pedido);
            }
            System.out.println("Desea agregar otro pedido?");
            respuesta = this.scanner.nextLine();
        }

    }

	public Pedido registrarPedido(Cliente cliente, Integer cantidadBarbijos) {
		Pedido pedido = new Pedido();
		Date date = new Date();
		pedido.setCliente(cliente);
        pedido.setCantidadBabijos(cantidadBarbijos);
        pedido.setFecha(date);
        return pedido;

	}

	public Cliente registrarCliente( String nombre, String apellido, String direccion, String localidad, String provincia) {
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setLocalidad(localidad);
        cliente.setProvincia(provincia);

        return cliente;
	}

    public boolean aplicaPromocion(Pedido pedido, Cliente cliente){
    	boolean aplica= false;
        if(pedido.getCantidadBabijos() >= this.minimoPromocion && cliente.getProvincia().equals("Buenos Aires")) {
        	aplica = true;
        }
            return aplica;
    }
   
	public int getMinimoPromocion() {
		return minimoPromocion;
	}

	public void setMinimoPromocion(int minimoPromocion) {
		this.minimoPromocion = minimoPromocion;
	}
    
    
}
