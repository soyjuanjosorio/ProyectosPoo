package parcial.dominio;

import agenda.dominio.Contacto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CentroComercial {
    public static byte CAPACIDAD = 100;
    private String nombre;

    private List<Tienda> tiendas = new ArrayList<>();


    public boolean abrirTienda(long codigo, String nombre) {
        Tienda tienda = null;
        if ((this.tiendas.size() + 1) <= CAPACIDAD) {
            tienda = this.buscarTienda(codigo);
            if (tienda == null) {
             // tienda = new tienda(codigo, nombre);
                this.tiendas.add(tienda);
                return true;

            } else {
                System.out.println(" La tienda  : " + tienda.getNombre() + " ya se encuentra abierta. ");
                return true;
            }

        } else {
            System.out.println(" El centro comercial esta lleno ");
            return false;
        }
    }

    public void cerrarTienda(long codigo) {

        Tienda tiendaCerrar = this.buscarTienda(codigo);
        if (tiendaCerrar != null) {
           // this.tiendaCerrar.remove();
        } else {
            System.out.println("  ");
        }
    }

    public Tienda buscarTienda(String nombre) {
        List<Tienda> buscadoNombre = this.tiendas.stream()
                .filter(tienda -> nombre.equals(tienda.getNombre()))
                .collect(Collectors.toList());
        if (buscadoNombre != null) {
            return (Tienda) buscadoNombre;
        } else {
            System.out.println(" La tienda buscada no existe");
            return null;
        }
    }

    public Tienda buscarTienda(long codigo) {
        List<Tienda> buscadoCodigo = this.tiendas.stream()
                .filter(tienda -> tienda.getCodigo() == codigo)
                .collect(Collectors.toList());
        if (buscadoCodigo != null) {
            return buscadoCodigo();
        } else {
            System.out.println(" La tienda buscada no existe");
            return null;
        }
    }

    private Tienda buscadoCodigo() {
        return null;
    }


    public List<Tienda> buscarTiendas(String categoria) {
        return this.tiendas.stream()
                .filter(tienda -> tienda.getCategorias().size() >= 1)
                .collect(Collectors.toList());
    }

    public List<Tienda> getTiendasConMasDeDosCategorias() {
    return null;
    }


  //  public void ordenarTiendasPorNombre() {
       // this.tiendas.sort(Comparator.comparing(Tienda::getNombre);
       // System.out.printf("Se ha ordenado la tienda por nombre alfabetico.");
   // }


    //private void buscarTienda() { }

   // private void buscarTienda() {    }
}