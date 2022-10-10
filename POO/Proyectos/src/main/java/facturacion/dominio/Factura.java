package facturacion.dominio;


import java.time.LocalDate;

public abstract class Factura {
    private String nombreCliente;
    private double valorFactura;
    private LocalDate fechaVencimientoFactura;

    //Constructores
    public Factura(String nombreCliente, double valorFactura, LocalDate fechaVencimientoFactura) {
        this.nombreCliente = nombreCliente;
        this.valorFactura = valorFactura;
        this.fechaVencimientoFactura = fechaVencimientoFactura;
    }

    //Getters y Setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getValorFactura() {
        return valorFactura;
    }

    public LocalDate getFechaVencimientoFactura() {
        return fechaVencimientoFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }

    //toString
    @Override
    public String toString() {
        return "Factura{" +
                "nombreCliente='" + nombreCliente + '\'' +
                "valorFactura='" + valorFactura + '\'' +
                ", fechaVencimientoFactura=" + fechaVencimientoFactura +
                '}';
    }

    //Metodos
    public abstract void calcularTotal();
}
