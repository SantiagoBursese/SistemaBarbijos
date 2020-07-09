package com.sistemaBarbijos.Repository;

import com.sistemaBarbijos.Pedido;

import java.util.ArrayList;
import java.util.List;

public class RepositioPedidos {
    private static List<Pedido> LISTA_PEDIDOS_GRATIS = null;
    private static List<Pedido> LISTA_PEDIDOS_PAGOS = null;

    public static List<Pedido> getListaPedidosGratis() {
        return LISTA_PEDIDOS_GRATIS;
    }

    public static List<Pedido> getListaPedidosPagos() {
        return LISTA_PEDIDOS_PAGOS;
    }
    
    public static void agregarPedidoGratis(Pedido pedido) {
    	LISTA_PEDIDOS_GRATIS.add(pedido);
    }
    
    public static void agregarPedidoPagos(Pedido pedido) {
    	LISTA_PEDIDOS_PAGOS.add(pedido);
    }

     public static void iniciarListas (){
         if (RepositioPedidos.LISTA_PEDIDOS_GRATIS == null){
             RepositioPedidos.LISTA_PEDIDOS_GRATIS = new ArrayList<>();
         }

         if(RepositioPedidos.LISTA_PEDIDOS_PAGOS == null){
             RepositioPedidos.LISTA_PEDIDOS_PAGOS = new ArrayList<>();
         }
     }
}