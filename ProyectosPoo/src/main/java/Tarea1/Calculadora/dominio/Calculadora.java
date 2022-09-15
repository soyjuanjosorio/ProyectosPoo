package Tarea1.Calculadora.dominio;

import java.util.List;

public class Calculadora {
    public static <Double> double sumar(List<Double> numerosAOperar){
        double resultado = numerosAOperar.get(0);
        for (int i = 1; i < numerosAOperar.size(); i++)
            resultado = resultado + numerosAOperar.get(i);
        return resultado;
    }

    public static double restar(List<Double> numerosAOperar){
        double resultado = numerosAOperar.get(0);
        for (int i = 1; i < numerosAOperar.size(); i++)
            resultado = resultado - numerosAOperar.get(i);
        return resultado;
    }

    public static double multiplicar(List<Double> numerosAOperar){
        double resultado = numerosAOperar.get(0);
        for (int i = 1; i < numerosAOperar.size(); i++)
            resultado = resultado * numerosAOperar.get(i);
        return resultado;
    }

    public static double dividir(List<Double> numerosAOperar){
        double resultado = numerosAOperar.get(0);
        for (int i = 1; i < numerosAOperar.size(); i++) {
            resultado = resultado / numerosAOperar.get(i);
        }
        return resultado;
    }
}
