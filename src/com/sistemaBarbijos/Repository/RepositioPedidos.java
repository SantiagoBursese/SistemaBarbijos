package com.sistemaBarbijos.Repository;

import com.sistemaBarbijos.Pedido;

import java.util.ArrayList;
import java.util.List;

public class RepositioPedidos {
    private static List<Pedido> LISTA_PEDIDOS_MENORES = null;
    private static List<Pedido> LISTA_PEDIDOS_MAYORES = null;

    public static List<Pedido> getListaPedidosMenores() {
        return LISTA_PEDIDOS_MENORES;
    }

    public static List<Pedido> getListaPedidosMayores() {
        return LISTA_PEDIDOS_MAYORES;
    }

     public static void iniciarListas (){
         if (RepositioPedidos.LISTA_PEDIDOS_MAYORES == null){
             RepositioPedidos.LISTA_PEDIDOS_MAYORES = new ArrayList<>();
         }

         if(RepositioPedidos.LISTA_PEDIDOS_MENORES == null){
             RepositioPedidos.LISTA_PEDIDOS_MENORES = new ArrayList<>();
         }
     }
}
