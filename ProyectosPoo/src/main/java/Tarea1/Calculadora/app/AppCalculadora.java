package Tarea1.Calculadora.app;

import Tarea1.Calculadora.dominio.Calculadora;

import java.util.ArrayList;
import java.util.List;

public class AppCalculadora {
    public static void main(String[] args) {
        List<Double> numeros = new ArrayList<>();
        numeros.add(10.0);
        numeros.add(2.0);
        numeros.add(3.0);
        numeros.add(-1.0);

        System.out.println("El resultado de la suma es: " + Calculadora.sumar(numeros));
        System.out.println("El resultado de la resta es: " +Calculadora.restar(numeros));
        System.out.println("El resultado de la multiplicación es: " +Calculadora.multiplicar(numeros));
        System.out.println("El resultado de la División es: " +Calculadora.dividir(numeros));

    }
}
