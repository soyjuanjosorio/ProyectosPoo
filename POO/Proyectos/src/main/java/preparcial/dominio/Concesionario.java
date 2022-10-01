package preparcial.dominio;

import java.util.ArrayList;
import java.util.List;

public class Concesionario {

    public static int CAPACIDAD_TOTAL= 15;
    private String nombre;
    private List<preparcial.dominio.Moto> motos= new ArrayList<>();


    public Concesionario(String nombre) {
        this.nombre = nombre;
    }

    public boolean ingresar(preparcial.dominio.Moto moto){
        if (getCapacidadActual()<CAPACIDAD_TOTAL && buscar(moto.getSerial())==false){
           motos.add(moto);
            return true;
        }else {
            return false ;
        }
    }
    public preparcial.dominio.Moto buscar(long serial){
        return null;
    }

    public List<preparcial.dominio.Moto> buscar(String marca){
    return null;
    }


    public List<preparcial.dominio.Moto> buscar(boolean soloNuevas){
    return null;
    }

    public List<preparcial.dominio.Moto> buscarQueTenganMasDe(int cilindraje){
    return null;
    }

    public void vender(preparcial.dominio.Moto moto){

    }

    public int getCapacidadActual(){

    }

}

