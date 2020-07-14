package com.sistemaBarbijos;

import com.sistemaBarbijos.Repository.RepositioPedidos;

import java.util.Date;
import java.util.Scanner;

public class Sistema {

    public Sistema() {
        RepositioPedidos.iniciarListas();
    }

    public void obtenerDatosCompra(){
        Pedido pedido;
        Cliente cliente;
        Scanner scanner = new Scanner(System.in);
        String nombre, apellido, direccion, localidad, provincia;
        String respuesta = "S";
        Integer cantidadBarbijos;
        
        
        while (!respuesta.equals("N") ) {
            System.out.println("Ingrese nombre del cliente: ");
            nombre = scanner.nextLine();

            System.out.println("Ingrese apellido del cliente: ");
            apellido = scanner.nextLine();

            System.out.println("Ingrese direccion del cliente: ");
            direccion = scanner.nextLine();
            
            System.out.println("Ingrese localidad del cliente: ");
            localidad = scanner.nextLine();
            
            System.out.println("Ingrese provincia del cliente: ");
            provincia = scanner.nextLine();
            
            System.out.println("Ingrese cantidad de barbijos: ");
            cantidadBarbijos = scanner.nextInt();
            scanner.nextLine();
            cliente= registrarCliente(nombre, apellido, direccion, localidad, provincia);

            pedido= registrarPedido(cliente, cantidadBarbijos);

            aplicaPromocion(pedido,cliente);

            System.out.println("Desea agregar otro pedido?");
            respuesta = scanner.nextLine();
        }

        scanner.close();

        //metodo reportes

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



    public void aplicaPromocion(Pedido pedido, Cliente cliente){
        if(pedido.getCantidadBabijos() >= 100 && cliente.getProvincia().equals("Buenos Aires")) {
            RepositioPedidos.agregarPedidoGratis(pedido);
        }
        else{
            RepositioPedidos.agregarPedidoPagos(pedido);
        }
    }
}
