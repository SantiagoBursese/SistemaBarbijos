package com.sistemaBarbijos;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Sistema {


    public void registrarPedido(){
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

        LocalDate date = LocalDate.now();
        System.out.println(date.getDayOfWeek().getValue() + "-" + date.getMonthValue() + "-" + date.getYear());

        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(direccion);
        System.out.println(cantidadBarbijos);
    }
}
