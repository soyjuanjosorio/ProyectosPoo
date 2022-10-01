package agenda.app;

import agenda.dominio.Agenda;

public class AppAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.agregar("Gonzalo",  "Serna",   311377645);
        agenda.agregar("Ana",      "Gomez",   312854121);
        agenda.agregar("Bernardo", "Castro",  321216783);
        agenda.agregar("Carlos",   "Murillo", 319205890);
        agenda.agregar("Carlos",   "Osorio",  300467983);
        agenda.agregar("Julian",   "Ramirez", 311431906);
        agenda.agregar("Yeni",     "Parra",   310455678);
        agenda.agregar("Juan",     "Perez",   310413378);

        System.out.println("----- IMPRIMIR CONTACTOS INGRESADOS ----- ");
        agenda.imprimirAgenda();

        System.out.println("----- EDITAR UN CONTACTO ----- ");
        agenda.editarCelular(300467983, 319433382);

        System.out.println("----- ORDENAR ALFABÉTICAMENTE ----- ");
        agenda.ordenarAlfabeticamente();

        System.out.println("----- IMPRIMIR CONTACTOS ORDENADOS ALFABETICAMENTE ----- ");
        agenda.imprimirAgenda();

        System.out.println("----- BUSCAR POR NOMBRE ----- ");
        agenda.buscarPorNombre("Carlos").forEach(c -> System.out
                .println(c.getNombre() + " " + c.getApellido() + " - " + c.getCelular()));
        //agenda.buscarPorNombre("Bernardo").forEach(c -> System.out
        //      .println(c.getNombre() + " " + c.getApellido() + " - " + c.getCelular()));

        System.out.println("----- BUSCAR POR APELLIDO ----- ");
        agenda.buscarPorApellido("Ramirez").forEach(c -> System.out
                .println(c.getNombre() + " " + c.getApellido() + " - " + c.getCelular()));

        System.out.println("----- BUSCAR POR CELULAR ----- ");
        agenda.buscarPorCelular(311377645).forEach(c -> System.out
                .println(c.getNombre() + " " + c.getApellido() + " - " + c.getCelular()));

        System.out.println("----- ELIMINAR ----- ");
        agenda.eliminar(310455678);

        System.out.println("----- IMPRIMIR AGENDA FINAL ----- ");
        agenda.imprimirAgenda();
    }
}
