package Taller1.dispensadora.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DispensadoraSnacks {

    private List<Snack> snacks = new ArrayList<>();

    private Snack buscarPorCodigo(int codigo){
        if (codigo>=0){
            return this.snacks.stream().filter(c-> c
                    .getCodigo()== codigo).findFirst().orElse(null);
        }else{
            return null;
        }
    }

    private Snack buscarPorNombre(String nombre){
        if(nombre !=null){
            return this.snacks.stream().filter(s-> nombre
                    .equals(s.getNombre())).findFirst().orElse(null);
        }else{
            return null;
        }

    }

    private void snackASacar(Snack snackASacar){
        if(snackASacar !=null){
            if (snackASacar.getCantidadUnidades()>0){
                int posicionAReemplazar=this.snacks.indexOf(snackASacar);
                snackASacar.setCantidadUnidades((short) (snackASacar.getCantidadUnidades()-1));
                this.snacks.set(posicionAReemplazar,snackASacar);
                System.out.printf("Se ha sacado un snack de: "
                        + snackASacar.getNombre());
            }else{
                System.out.printf("El snack esta agotado.");
            }
        }else{
            System.out.printf("Este snack no esta en la dispensadora.");
        }
    }


    private void aumentarCantidadSnack(int nuevaCantidad, Snack snackAumentar ){
        int posicionAReemplazar= this.snacks.indexOf(snackAumentar);
        int cantidadAReemplazar =snackAumentar.getCantidadUnidades() + nuevaCantidad;
        if (snackAumentar!=null){
            if (cantidadAReemplazar<6){
                snackAumentar.setCantidadUnidades((short) cantidadAReemplazar);
            }else{
                snackAumentar.setCantidadUnidades((short) 6);
            }
            this.snacks.set(posicionAReemplazar,snackAumentar);
            System.out.printf(" Se ha aumentado la cantidad del snack: " + snackAumentar.getNombre());
        }else{
            System.out.printf("Este snack no esta en la dispensadora");
        }
    }

    public void agregar(String nombre, int codigo ,double valor, short cantidadUnidades){
        if (snacks.size()<12){
            Snack snackAAgregar= new Snack(nombre, codigo,valor,cantidadUnidades);
            this.snacks.add(snackAAgregar);
            System.out.printf(" Se agregó el snack " + snackAAgregar.getNombre());
            if (cantidadUnidades> 6){
                snackAAgregar.setCantidadUnidades((short) 6);
            }
        }else{
            System.out.printf(" No se agregó el snack " + nombre + " porque el dispensador esta lleno");
        }
    }

    public void imprimirDispensador(){
        this.snacks.forEach(c-> System.out.println(c.getNombre() + " " + c.getCodigo()
                + " - " + c.getValor() + " - " + c.getCantidadUnidades()));
    }

    public void sacarPorCodigo(int codigo){
        Snack snackASacar = buscarPorCodigo(codigo);
        snackASacar(snackASacar);
    }

    public void sacarPorNombre(String nombre){
        Snack snackASacar = buscarPorNombre(nombre);
        snackASacar(snackASacar);
    }

    public void aumentarCantidad(String nombre, int codigo, int nuevaCantidad){
        Snack snackASacar=buscarPorNombre(nombre);
        if (snackASacar.getNombre() != null){
            Snack snackAAumentar= buscarPorNombre(nombre);
            aumentarCantidadSnack(nuevaCantidad, snackAAumentar);
        }else{
            Snack snackAAumentar=buscarPorCodigo(codigo);
            aumentarCantidadSnack(nuevaCantidad, snackAAumentar);
        }
    }

    public void quitar(Snack snackAQuitar){
        Snack snackBuscado= buscarPorNombre(snackAQuitar.getNombre());
        if (snackBuscado !=null){
            this.snacks.remove(snackAQuitar);
            System.out.println("Se ha eliminado el snack: "
                    + snackAQuitar.getNombre() + ", porque no existe. ");
        }
    }

    public void obtenerCantidad(String nombre){
        Snack snackABuscar= buscarPorNombre(nombre);
        if (snackABuscar != null){
            System.out.println("Hay " + snackABuscar.getCantidadUnidades()
                    + " unidades de snack: " + snackABuscar.getNombre());
        }else{
            System.out.println(" El snack ingresado no existe. ");
        }
    }
    public List<String> obtenerAgotados() {
        List<String> agotados = new ArrayList<>();
        this.snacks.stream()
                .filter(s -> s.getCantidadUnidades() == 0)
                .collect(Collectors.toList())
                .forEach(c -> agotados.add(c.getNombre()));
        return agotados;
    }

    public List<String> obtenerInventario() {
        List<String> inventario = new ArrayList<>();
        this.snacks.forEach(c -> inventario.add(c.getNombre()
                + " " + c.getCantidadUnidades()));
        return inventario;
    }

    public List<Snack> obtenerValorMayorAMenor() {
        List<Snack> ordenada = new ArrayList<>();
        ordenada = snacks;
        ordenada.sort(Comparator.comparing(Snack::getValor).reversed());
        return ordenada;
    }

    public List<Snack> obtenerCantidadMenorAMayor() {
        List<Snack> ordenada = new ArrayList<>();
        ordenada = snacks;
        ordenada.sort(Comparator.comparing(Snack::getCantidadUnidades));
        return ordenada;
    }
}

