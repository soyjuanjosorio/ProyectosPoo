package agenda.dominio;

public class Contacto {
    private String nombre;
    private String apellido;
    private long celular;

    public Contacto(String nombre, String apellido, long celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getCelular() {
        return celular;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }
}
