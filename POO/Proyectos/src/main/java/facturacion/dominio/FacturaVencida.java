package facturacion.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FacturaVencida extends Factura{
    private int interesDiario = 1;

    public FacturaVencida(String nombreCliente, double valorFactura, LocalDate fechaVencimientoFactura) {
        super(nombreCliente, valorFactura, fechaVencimientoFactura);
    }

    public int getDiasMora(){
        return (int) ChronoUnit.DAYS.between(getFechaVencimientoFactura(),LocalDate.now());
    }

    @Override
    public void calcularTotal() {
        setValorFactura(super.getValorFactura() + super.getValorFactura()*getDiasMora()*((double)interesDiario/100));
    }
}
