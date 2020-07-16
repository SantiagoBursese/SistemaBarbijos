package com.sistemaBarbijos.Reporte;

import com.sistemaBarbijos.Pedido;
import com.sistemaBarbijos.Repository.RepositioPedidos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Reporte {

    private void crearArchivo(String nombreArchivo, boolean envioPago, int cantidadReportesGenerados) {
        if (envioPago && (RepositioPedidos.getListaPedidosPagos() == null || RepositioPedidos.getListaPedidosPagos().size() == 0)) {
            return;
        }

        if (!envioPago && (RepositioPedidos.getListaPedidosGratis() == null || RepositioPedidos.getListaPedidosGratis().size() == 0)) {
            return;
        }
        List<Pedido> listaPedidos = envioPago ? RepositioPedidos.getListaPedidosPagos() : RepositioPedidos.getListaPedidosGratis();
        String path = envioPago ? "reportes-envios-pagos/" : "reportes-envios-gratis/";
        String pattern = "MM-dd-yyyy";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String ruta = path + nombreArchivo +'-' + simpleDateFormat.format(date) + ".txt";
        File archivo = new File(ruta);
        if (archivo.exists()) {
            ruta = path + nombreArchivo + '-' + simpleDateFormat.format(date) + '-' + cantidadReportesGenerados + ".txt";
            archivo = new File(ruta);
        }
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Indice" + ' ' + "Fecha" + ' ' + "Nombre"+ ' ' + "Apellido"+ ' ' +"Direccion" + ' ' + "Localidad"+ ' ' +"Provincia"+ ' ' +"Cant. barbijos");
            bw.write('\n');
            for (int i = 0; i < listaPedidos.size(); i++) {
                Pedido pedido = listaPedidos.get(i);
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

    public void generarReporte(int cantidadReportesGenerados) {
        crearArchivo("pedidos-EG", false,cantidadReportesGenerados);
        crearArchivo("pedido-EP", true,cantidadReportesGenerados);
    }
}
