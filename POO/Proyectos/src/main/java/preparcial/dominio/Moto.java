package preparcial.dominio;

public class Moto {
    private long serial ;
    private String marca;
    private int precio;
    private int cilindraje;
    private boolean esNueva;

    public Moto(long serial, String marca, int precio, int cilindraje, boolean esNueva) {
        this.serial = serial;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.esNueva = esNueva;
    }

    public long getSerial() {
        return serial;
    }

    public String getMarca() {
        return marca;
    }

    public int getCilindraje() {
        return cilindraje;
    }
}
