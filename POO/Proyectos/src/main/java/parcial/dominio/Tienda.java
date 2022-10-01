package parcial.dominio;

import java.util.List;

public class Tienda {
    private long codigo;
    private String nombre;

    private List<Categoria> categorias;



    public Tienda(long codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
}
