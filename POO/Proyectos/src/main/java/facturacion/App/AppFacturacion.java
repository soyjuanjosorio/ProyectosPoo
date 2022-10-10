package facturacion.App;

import facturacion.dominio.FacturaConDescuento;
import facturacion.dominio.FacturaConIva;
import facturacion.dominio.Facturacion;

import java.time.LocalDate;
import java.util.List;

public class AppFacturacion {
    public static void main(String[] args) {
        Facturacion facturacion = new Facturacion();

        //Factura sin IVA sin descuento NO vencida
        facturacion.crearFactura("Santiago",50000,LocalDate.of(2022,11,19));
        //Factura con IVA sin descuento NO vencida
        facturacion.crearFactura("Vanessa",150000,LocalDate.of(2022,11,19));
        //Factura con IVA con descuento NO vencida
        facturacion.crearFactura("Alejandra",100000,LocalDate.of(2022,11,19));
        //Factura vencida
        facturacion.crearFactura("Camilo",50000,LocalDate.of(2022,10,18));
        //Factura vencida
        facturacion.crearFactura("Juan",150000,LocalDate.of(2022,10,18));

        System.out.println("\n FACTURAS");
        facturacion.getFacturas().stream().forEach(factura -> System.out.println(factura.toString()));

        facturacion.identificarFacturasVencidas();
        System.out.println("\n FACTURAS VENCIDAS");
        facturacion.getFacturasVencidas().stream().forEach(facturaVencida -> System.out.println(facturaVencida.toString()));

        System.out.println("\n FACTURAS");
        facturacion.getFacturas().stream().forEach(factura -> System.out.println(factura.toString()));

        facturacion.calcularTotalFacturas();
        System.out.println("\n El total de facturas es: " + facturacion.getTotalFacturas());
    }
}
