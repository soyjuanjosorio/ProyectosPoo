package facturacion.dominio;

import java.time.LocalDate;

public class FacturaConIva extends Factura{

    public int IVA = 19;

    //Contructores
    public FacturaConIva(String nombreCliente, double valorFactura, LocalDate fechaVencimientoFactura) {
        super(nombreCliente, valorFactura, fechaVencimientoFactura);
    }

    //Metodos
    @Override
    public void calcularTotal() {
        setValorFactura(getValorFactura() + getValorFactura()*((double) this.IVA/100));
    }
}
