package com.sistemaBarbijos;

import com.sistemaBarbijos.Repository.RepositioPedidos;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Sistema {

    public Sistema() {
        RepositioPedidos.iniciarListas();
    }

    public Pedido obtenerDatosCompra(){
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);
        String nombre, apellido, direccion, fecha;
        Integer cantidadBarbijos;

        System.out.println("Ingrese su nombre: ");
        nombre = scanner.nextLine();

        System.out.println("Ingrese su apellido: ");
        apellido = scanner.nextLine();

        System.out.println("Ingrese su direccion: ");
        direccion = scanner.nextLine();

        System.out.println("Ingrese cantidad de barbijos: ");
        cantidadBarbijos = scanner.nextInt();

        Date date = new Date();

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);

        pedido.setCliente(cliente);
        pedido.setCantidadBabijos(cantidadBarbijos);
        pedido.setFecha(date);

        return pedido;
    }

    public void registrarPedido(){
        Pedido pedido = this.obtenerDatosCompra();

        if(pedido.getCantidadBabijos() > 100){
            RepositioPedidos.getListaPedidosMayores().add(pedido);
        }
        else{
            RepositioPedidos.getListaPedidosMenores().add(pedido);
        }
    }
}
