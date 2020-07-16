package com.sistemaBarbijos.Reporte;

import com.sistemaBarbijos.Pedido;
import com.sistemaBarbijos.Repository.RepositioPedidos;
import com.sistemaBarbijos.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Reporte {

    private void crearArchivo(String nombreArchivo, boolean envioPago) {
        if (envioPago && (RepositioPedidos.getListaPedidosPagos() == null || RepositioPedidos.getListaPedidosPagos().size() == 0)) {
            return;
        }

        if (!envioPago && (RepositioPedidos.getListaPedidosGratis() == null || RepositioPedidos.getListaPedidosGratis().size() == 0)) {
            return;
        }
        List<Pedido> listaPedidos = envioPago ? RepositioPedidos.getListaPedidosPagos() : RepositioPedidos.getListaPedidosGratis();
        String path = envioPago ? "reportes-envios-pagos/" : "reportes-envios-gratis/";
        String ruta = path + nombreArchivo + ".txt";
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        File archivo = new File(ruta);
        if (archivo.exists()) {
            ruta = path + nombreArchivo + '-' + (envioPago ? Utils.obtainCountPedidosPagos() : Utils.obtainCountPedidoGratis()) + ".txt";
            archivo = new File(ruta);
        }
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));

            for (int i = 0; i < listaPedidos.size(); i++) {
                Pedido pedido = listaPedidos.get(0);
                if (i > 0) {
                    bw.write('\n');
                }
                bw.write((i + 1) + "- " + simpleDateFormat.format(pedido.getFecha()) + '-' + pedido.getCliente().getNombre() + '-' + pedido.getCliente().getApellido() + '-' + pedido.getCliente().getDireccion() + '-' + pedido.getCliente().getLocalidad() + '-' + pedido.getCliente().getProvincia() + '-' + pedido.getCantidadBabijos());
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generarReporte() {
        crearArchivo("pedidos-EG", false);
        crearArchivo("pedido-EP", true);
    }
}
