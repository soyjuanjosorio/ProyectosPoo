package facturacion.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Facturacion {
    //La facturacion es el proceso de crear una o mas facturas
    //Los criterios son:
    //Las facturas mayores a 100 mil, son factures con IVA
    //Las facturas menores a 100 mil, son facturas sin IVA
    //Los clientes cuyo nombre empieze por una vocal, tienen descuento

    private double totalFacturas;
    private List<Factura> facturas = new ArrayList<>();
    private List<FacturaVencida> facturasVencidas = new ArrayList<>();

    //Getters y Setters
    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<FacturaVencida> getFacturasVencidas() {
        return facturasVencidas;
    }

    public void setFacturasVencidas(List<FacturaVencida> facturasVencidas) {
        this.facturasVencidas = facturasVencidas;
    }

    public double getTotalFacturas() {
        return totalFacturas;
    }

    //Metodos
    public void crearFactura(String nombreCliente, double valorFactura, LocalDate fecha){
        if ("aeiouAEIOU".indexOf(nombreCliente.charAt(0)) != -1){
            facturas.add(new FacturaConDescuento(nombreCliente,valorFactura,fecha));
        } else {
            if (valorFactura >= 100000){
                facturas.add(new FacturaConIva(nombreCliente,valorFactura,fecha));
            } else {
                facturas.add(new FacturaSinIva(nombreCliente,valorFactura,fecha));
            }
        }
        facturas.get(facturas.size()-1).calcularTotal();
    }

    public void identificarFacturasVencidas(){
        facturas.stream().filter(factura -> factura.getFechaVencimientoFactura().isBefore(LocalDate.now())).
                forEach(facturaVencida -> {
                    facturasVencidas.add(new FacturaVencida(facturaVencida.getNombreCliente(),facturaVencida.getValorFactura()
                            ,facturaVencida.getFechaVencimientoFactura()));
                    facturasVencidas.get(facturasVencidas.size()-1).calcularTotal();
                    }
                );
        facturas.removeIf(factura -> factura.getFechaVencimientoFactura().isBefore(LocalDate.now()));
    }

    public void calcularTotalFacturas(){
        facturas.forEach(factura -> totalFacturas += factura.getValorFactura());
        facturasVencidas.forEach(facturaVencida -> totalFacturas += facturaVencida.getValorFactura());
    }

/*    public Factura encontrarFacturaMasCara(){
        return facturas.stream().max(Comparator.comparing(Factura::calcularTotal)).orElse(null);
    }*/
}
