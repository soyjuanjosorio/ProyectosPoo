package dispensadora.dominio;

public class Snack {
    private String nombre;
    private int codigo;
    private double valor;
    private short cantidadUnidades;

    public Snack(String nombre, int codigo, double valor, short cantidadUnidades) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.valor = valor;
        this.cantidadUnidades = cantidadUnidades;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public short getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCantidadUnidades(short cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }
}

