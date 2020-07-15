package com.sistemaBarbijos;

public class Utils {

    private static int countPedidosPagos = 0;
    private static int countPedidosGratis = 0;


    public static int obtainCountPedidosPagos(){
        countPedidosPagos++;
        return countPedidosPagos;
    }

    public static int obtainCountPedidoGratis(){
        countPedidosGratis++;
        return countPedidosGratis;
    }
}
