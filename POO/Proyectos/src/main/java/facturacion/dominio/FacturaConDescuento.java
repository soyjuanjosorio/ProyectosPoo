package facturacion.dominio;

import java.time.LocalDate;

public class FacturaConDescuento extends FacturaConIva {

    private int descuento = 30;

    public FacturaConDescuento(String nombreCliente, double valorFactura, LocalDate fechaVencimientoFactura) {
        super(nombreCliente, valorFactura, fechaVencimientoFactura);
    }

    @Override
    public void calcularTotal() {
        super.calcularTotal();
        setValorFactura(getValorFactura()-getValorFactura()*((double)descuento/100));
    }
}
