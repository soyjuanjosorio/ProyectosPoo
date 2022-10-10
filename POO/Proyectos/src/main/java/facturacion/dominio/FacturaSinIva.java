package facturacion.dominio;

import java.time.LocalDate;

public class FacturaSinIva extends Factura{
    public FacturaSinIva(String nombreCliente, double valorFactura, LocalDate fechaVencimientoFactura) {
        super(nombreCliente, valorFactura, fechaVencimientoFactura);
    }

    @Override
    public void calcularTotal() {
    }


}
