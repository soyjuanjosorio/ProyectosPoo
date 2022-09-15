package Taller1.agenda.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {
    private List<Contacto> contactos= new ArrayList<>();
    public void agregar(String nombre, String apellido, long celular) {
        if (contactos.size() < 50) {
            Contacto contactoAAgregar = new Contacto(nombre, apellido, celular);
            this.contactos.add(contactoAAgregar);
            System.out.println("Se agregó el contacto : " + contactoAAgregar.getNombre());
        }else{
            System.out.println("No se agregó el contacto" + nombre + " La agenda se encuentra llena.");
        }

    }

    public void editarCelular(long celularAnterior, long celularNuevo){
        Contacto contactoAEditar=this.contactos.stream()
                .filter(contacto-> contacto.getCelular()== celularAnterior)
                .findFirst().orElse(null);

        if(contactoAEditar!= null){
            int posicionARemplazar= this.contactos.indexOf(contactoAEditar);
            contactoAEditar.setCelular(celularNuevo);
            this.contactos.set(posicionARemplazar,contactoAEditar);
            System.out.printf("Se ha editado el contacto de : "
                    + contactoAEditar.getNombre() + " "
                    + contactoAEditar.getApellido());
        }else{
            System.out.printf("El contacto a editar no existe.");
        }

    }

    public void ordenarAlfabeticamente(){
        this.contactos.sort(Comparator.comparing(Contacto::getNombre)
                .thenComparing(Contacto::getApellido))  ;
        System.out.printf("Se ha ordenado la agenda en orden alfabetico.");

    }

    public List<Contacto> buscarPorNombre(String nombre){
        List<Contacto> buscadoNombre=this.contactos.stream()
                .filter(contacto-> nombre.equals(contacto.getNombre()))
                .collect(Collectors.toList());
        if (buscadoNombre !=null){
            return buscadoNombre;
        }else{
            System.out.printf("El contacto ingresado no exixte.");
            return null;
        }
    }

    public List<Contacto> buscarPorApellido(String apellido) {
        List<Contacto> buscadoApellido= this.contactos.stream()
                .filter(contacto-> apellido.equals(contacto.getApellido()))
                .collect(Collectors.toList());
        if (buscadoApellido !=null){
            return buscadoApellido;
        }else {
            System.out.printf("El contacto ingresado no exixte");
            return null;
        }
    }

    public List<Contacto> buscarPorCelular(long celular) {
        List<Contacto> buscadoCelular= this.contactos.stream()
                .filter(contacto-> contacto.getCelular()== celular)
                .collect(Collectors.toList());
        if (buscadoCelular !=null){
            return buscadoCelular;
        }else {
            System.out.printf("El contacto ingresado no exixte");
            return null;
        }
    }
    public void eliminar(long celular) {
        List<Contacto> contactoAEliminar = buscarPorCelular(celular);
        if (contactoAEliminar != null) {
            contactoAEliminar.forEach(c -> this.contactos.remove(c));
            System.out.println("Se han eliminado los siguientes contactos: ");
            contactoAEliminar.forEach(c -> System.out.println(c.getNombre() + " "
                    + c.getApellido() + " - " + c.getCelular()));
        } else {
            System.out.println("No se puede eliminar el contacto con el numero celular: "
                    + celular + " porque no existe.");
        }
    }

    public void imprimirAgenda() {
        this.contactos.forEach(c -> System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getCelular()));
    }

}
