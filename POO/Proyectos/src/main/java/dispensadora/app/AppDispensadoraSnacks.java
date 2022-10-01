package dispensadora.app;

import dispensadora.dominio.DispensadoraSnacks;
import dispensadora.dominio.Snack;

public class AppDispensadoraSnacks {
    public static void main(String[] args) {
        DispensadoraSnacks dispensador = new DispensadoraSnacks();
        Snack snackDePrueba1 = new Snack("Papitas de limon", 02, 2000.0, (short) 2);
        Snack snackDePrueba2 = new Snack("No estoy", 07, 2000.0, (short) 2);

        dispensador.agregar("Detodito",         01,  2500.0,  (short) 4);
        dispensador.agregar("Papitas de limon", 02,  2000.0,  (short) 2);
        dispensador.agregar("Hit Mora",         03,  3000.0,  (short) 6);
        dispensador.agregar("Chocolatina jet",  04,  1500.0,  (short) 3);
        dispensador.agregar("Tocinetas",        05,  2800.0,  (short) 10);
        dispensador.agregar("Platanitos",       05,  2800.0,  (short) 0);

        System.out.println("----- IMPRIMIR SNACKS AGREGADOS ----- ");
        dispensador.imprimirDispensador();

        System.out.println("----- SACAR UN SNACK POR CODIGO ----- ");
        dispensador.sacarPorCodigo(03);

        System.out.println("----- IMPRIMIR CANTIDAD DEL SNACK SACADO ----- ");
        dispensador.obtenerCantidad("Hit Mora");

        System.out.println("----- SACAR UN SNACK POR NOMBRE ----- ");
        dispensador.sacarPorNombre("Tocinetas");

        System.out.println("----- IMPRIMIR CANTIDAD DEL SNACK SACADO ----- ");
        dispensador.obtenerCantidad("Tocinetas");

        System.out.println("----- AUMENTAR CANTIDAD ----- ");
        dispensador.aumentarCantidad("Chocolatina jet", 04, (short) 8);

        System.out.println("\n----- IMPRIMIR CANTIDAD DEL SNACK AGREGADO ----- ");
        dispensador.obtenerCantidad("Chocolatina jet ");

        System.out.println("----- QUITAR SNACK ----- ");
        dispensador.quitar(snackDePrueba1);
        dispensador.quitar(snackDePrueba2);

        System.out.println("----- IMPRIMIR CANTIDAD DEL SNACK QUITADO ----- ");
        dispensador.obtenerCantidad(snackDePrueba1.getNombre());
        dispensador.obtenerCantidad(snackDePrueba2.getNombre());

        System.out.println("----- OBTENER SNACKS AGOTADOS ----- ");
        dispensador.obtenerAgotados().forEach(c -> System.out.println(c));

        System.out.println("----- OBTENER NOMBRE Y CANTIDAD DE LOS SNACKS DEL DISPENSADOR ----- ");
        dispensador.obtenerInventario().forEach(c -> System.out.println(c));

        System.out.println("----- OBTENER DISPENSADOR ORDENADO DE MAYOR A MENOR VALOR ----- ");
        dispensador.obtenerValorMayorAMenor().forEach(c -> System.out.println(c.getNombre() + " "
                + c.getCodigo() + " " + c.getValor() + " " + c.getCantidadUnidades()));

        System.out.println("----- OBTENER DISPENSADOR ORDENADO DE MENOR A MAYOR ----- ");
        dispensador.obtenerCantidadMenorAMayor().forEach(c -> System.out.println(c.getNombre() + " "
                + c.getCodigo() + " " + c.getValor() + " " + c.getCantidadUnidades()));
    }
}
