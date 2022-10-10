package guayabita.dominio;

public class Dado {
    private int numeroDado;

    public int getNumeroDado() {
        return numeroDado;
    }

    public void setNumeroDado(int numeroDado) {
        this.numeroDado = numeroDado;
        System.out.println("los dados cayeron " + getNumeroDado()); //Prueba
    }

    public double generarNumeroAleatorio(){
        return Math.random();
    }

    public int valorDado(){
        double valor = generarNumeroAleatorio();
        System.out.println(valor);
        if (valor >= 0 && valor < 0.167) {
            return 1;
        } else if (valor >= 0.167 && valor < 0.334) {
            return 2;
        } else if (valor >= 0.334 && valor < 0.5) {
            return 3;
        } else if (valor >= 0.5 && valor < 0.668) {
            return 4;
        } else if (valor >= 0.668 && valor <= 0.835) {
            return 5;
        } else {
            return 6;
        }
    }
}
