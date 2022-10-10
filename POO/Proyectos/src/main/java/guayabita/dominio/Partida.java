package guayabita.dominio;

import javax.swing.*;
import java.awt.*;

public class Partida {
    private int numeroJugadores = 2;
    private int apuesta;
    private int apuestaTotal = 0;
    private boolean terminarJuego = false;

    Jugador jugadores[] = new Jugador[numeroJugadores];
    Dado dado = new Dado();

    public void generarJugadores(){
        for (int i = 0; i < numeroJugadores; i++) {
            jugadores[i] = new Jugador();
            jugadores[i].setNombre((String) JOptionPane.showInputDialog((Component)null, "Ingrese el nombre del jugador " + (i+1), "Nombre", 2, new ImageIcon(this.getClass().getResource("guayabaP.png")), (Object[])null, (Object)null));
            jugadores[i].setPresupuesto(Integer.parseInt((String)JOptionPane.showInputDialog((Component)null, "Ingrese el presupuesto de " + jugadores[i].getNombre(), "Presupuesto", 2, new ImageIcon(this.getClass().getResource("dinero.png")), (Object[])null, (Object)null)));
        }
    }

    public void iniciarJuego() {
        int opcionInicial;
        do {
            opcionInicial = menuInicial();
            if (opcionInicial == 1) {
                this.Intrucciones();
            }
        } while (opcionInicial == 1);

        if (opcionInicial == 0) {
            this.generarJugadores();
            //this.apuestaTotal = 0;
            this.apuesta = Integer.parseInt((String) JOptionPane.showInputDialog((Component) null, "Ingrese la apuesta: ", "Apuesta", 2, new ImageIcon(this.getClass().getResource("dinero.png")), (Object[]) null, (Object) null));

            for (int i = 0; i < numeroJugadores; i++) {
                jugadores[i].restarPresupuesto(this.apuesta);
                this.apuestaTotal += this.apuesta;
            }
                do {
                    this.ronda();
                } while (this.terminarJuego == false);
                this.verificarGanador();
            }
    }

    public void ronda(){
        for (int i = 0; i < numeroJugadores; i++) {
            if ((this.apuestaTotal == 0)) {
                if (JOptionPane.showOptionDialog((Component) null, jugadores[i].getNombre() + ", no hay dinero en el pote. \n ¿Que deseas hacer?", "Seguir Apuesta", -1, 3, new ImageIcon(this.getClass().getResource("guayabaP.png")), new String[]{"Apostar ", "Salir"}, (Object) null) == 0) {
                    do{
                        this.apuesta = Integer.parseInt((String)JOptionPane.showInputDialog((Component) null, jugadores[i].getNombre() + ", ¿Cuanto desean ingresar al pote?", "Apuesta", 2, new ImageIcon(this.getClass().getResource("dinero.png")), (Object[]) null, (Object) null));
                    } while (!verificarDineroJugador(this.apuesta, jugadores[i].getPresupuesto()));
                    for (Jugador jugador: jugadores) {
                        jugador.restarPresupuesto(this.apuesta);
                        this.apuestaTotal += this.apuesta;
                    }
                } else {
                    JOptionPane.showMessageDialog((Component) null, "JUEGO TERMINADO", "GAME OVER", 1, null);
                    this.terminarJuego = true;
                    break;
                }
            }
            int lanzarDados = JOptionPane.showOptionDialog((Component) null, jugadores[i].getNombre() + " la apuesta actual es " + apuestaTotal + " \n ¿Desea lanzar el dado?", "Guayabita", -1, 3, new ImageIcon(this.getClass().getResource("guayabaP.png")), new String[]{"Si", "No"}, (Object) null);
            if (lanzarDados == 1) {
                System.exit(0);
            }

            jugadores[i].setPuntos(jugadores[i].tirarDados());
            dado.setNumeroDado(jugadores[i].getPuntos());
            if (this.realizarApuesta(jugadores[i]) == 0) {
                do {
                    jugadores[i].setValorApostar(Integer.parseInt((String) JOptionPane.showInputDialog((Component) null, jugadores[i].getNombre() + ", ¿Cuanto deseas apostar?", "Apuesta", 2, new ImageIcon(this.getClass().getResource("dinero.png")), (Object[]) null, (Object) null)));
                } while (!verificarApuesta(jugadores[i]));

                dado.setNumeroDado(jugadores[i].tirarDados());
                this.resultadoDadoApuesta(jugadores[i], dado.getNumeroDado());
                validarResultadoApuesta(jugadores[i]);
                JOptionPane.showMessageDialog((Component) null, jugadores[i].getNombre() + ", este es tu presupuesto actual :" + jugadores[i].getPresupuesto(), " Presupuesto", 1, null);

                if (jugadores[i].getPresupuesto() <= 0) {
                    JOptionPane.showMessageDialog((Component) null, jugadores[i].getNombre() + ", has sido eliminado", "GAME OVER", 1, null);
                    this.terminarJuego = true;
                    break;
                }
            }
        }
    }

    public void validarResultadoApuesta(Jugador jugador){
        if (dado.getNumeroDado() > jugador.getPuntos()) {
            jugador.sumarPresupuesto(jugador.getValorApostar());
            this.apuestaTotal -= jugador.getValorApostar();
            JOptionPane.showMessageDialog((Component) null, jugador.getNombre() + ", ganaste :) ", " Ganaste", 1, null);
        } else {
            jugador.restarPresupuesto(jugador.getValorApostar());
            this.apuestaTotal += jugador.getValorApostar();
            JOptionPane.showMessageDialog((Component) null, jugador.getNombre() + ", perdiste :( ", " Perdiste", 1, null);
        }
    }

    public void Intrucciones(){
        JOptionPane.showMessageDialog((Component)null, "1. Inicialmente  se ingresa el nombre de cada jugador y su presupuesto \n 2." +
                " Para poder entrar en el juego  el dinero a apostar debe ser mayor que el monto de la apuesta inicial\n " +
                "3. Al lanzar el dado si sale 1 ó 6 tendrá que ceder el turno\n " +
                "4. Si sale un número del 2 al 5 tendrá la posibilidad de apostar hasta la cantidad existente en la apuesta total\n" +
                "5. Si el número del dado es mayor al que anteriormente sacó se lleva lo apostado, de lo contrario lo perderá\n" +
                "6. El juego termina cuando uno de los dos jugadores queda sin dinero ó la apuesta total queda en cero. ","Instrucciones",1,null);
    }

    public int menuInicial(){
        return JOptionPane.showOptionDialog((Component)null, "Bienvenido al juego de la Guayabita\n¿Que deseas hacer?", "Guayabita", -1, 3,new ImageIcon(this.getClass().getResource("guayabaP.png")), new String[]{"Jugar", "Ver Instruciones"}, (Object)null);
    }

    public int realizarApuesta(Jugador jugador){
        if (jugador.getPuntos() == 1) {
            JOptionPane.showMessageDialog((Component)null, jugador.getNombre() + ", este es tu dado. \n No puedes apostar ","Guayabita",1,new ImageIcon(this.getClass().getResource("uno.png")));
            return 1;
        } else if (jugador.getPuntos() == 2) {
            return JOptionPane.showOptionDialog((Component)null, jugador.getNombre() + ", este es tu dado. \n ¿Desea hacer una apuesta? " , "Guayabita", -1, 3,new ImageIcon(this.getClass().getResource("dos.png")), new String[]{"Si", "No"}, (Object)null);
        } else if (jugador.getPuntos() == 3) {
            return JOptionPane.showOptionDialog((Component)null, jugador.getNombre() + ", este es tu dado. \n ¿Desea hacer una apuesta? " , "Guayabita", -1, 3,new ImageIcon(this.getClass().getResource("tres.png")), new String[]{"Si", "No"}, (Object)null);
        } else if (jugador.getPuntos() == 4) {
            return JOptionPane.showOptionDialog((Component)null, jugador.getNombre() + ", este es tu dado. \n ¿Desea hacer una apuesta? " , "Guayabita", -1, 3,new ImageIcon(this.getClass().getResource("cuatro.png")), new String[]{"Si", "No"}, (Object)null);
        } else if (jugador.getPuntos() == 5) {
            return JOptionPane.showOptionDialog((Component)null, jugador.getNombre() + ", este es tu dado. \n ¿Desea hacer una apuesta? " , "Guayabita", -1, 3,new ImageIcon(this.getClass().getResource("cinco.png")), new String[]{"Si", "No"}, (Object)null);
        } else {
            JOptionPane.showMessageDialog((Component)null, jugador.getNombre() + ", este es tu dado. \n No puedes apostar ","Guayabita",1,new ImageIcon(this.getClass().getResource("seis.png")));
            return 1;
        }
    }

    public void resultadoDadoApuesta(Jugador jugador, int NumeroDado){
        if (NumeroDado == 1) {
            JOptionPane.showMessageDialog((Component)null, jugador.getNombre() + ", este es tu dado","Guayabita",1,new ImageIcon(this.getClass().getResource("uno.png")));
        } else if (NumeroDado == 2) {
            JOptionPane.showMessageDialog((Component)null, jugador.getNombre() + ", este es tu dado","Guayabita",1,new ImageIcon(this.getClass().getResource("dos.png")));
        } else if (NumeroDado == 3) {
            JOptionPane.showMessageDialog((Component)null, jugador.getNombre() + ", este es tu dado","Guayabita",1,new ImageIcon(this.getClass().getResource("tres.png")));
        } else if (NumeroDado == 4) {
            JOptionPane.showMessageDialog((Component)null, jugador.getNombre() + ", este es tu dado","Guayabita",1,new ImageIcon(this.getClass().getResource("cuatro.png")));
        } else if (NumeroDado == 5) {
            JOptionPane.showMessageDialog((Component)null, jugador.getNombre() + ", este es tu dado","Guayabita",1,new ImageIcon(this.getClass().getResource("cinco.png")));
        } else {
            JOptionPane.showMessageDialog((Component)null, jugador.getNombre() + ", este es tu dado","Guayabita",1,new ImageIcon(this.getClass().getResource("seis.png")));
        }
    }

    public void verificarGanador(){
        JOptionPane.showMessageDialog((Component)null, jugadores[0].getNombre() + ", este es tu presupuesto: " + jugadores[0].getPresupuesto()
                + "\n" + jugadores[1].getNombre() + ", este es tu presupuesto: " + jugadores[1].getPresupuesto(),"GAME OVER",1,null);
        if (jugadores[0].getPresupuesto() > jugadores[1].getPresupuesto()) {
            JOptionPane.showMessageDialog((Component)null, jugadores[0].getNombre() + ", GANASTE" ,"GAME OVER",1,null);
        } else {
            JOptionPane.showMessageDialog((Component)null, jugadores[1].getNombre() + ", GANASTE" ,"GAME OVER",1,null);
        }
    }

    public Boolean verificarApuesta(Jugador jugador){
        if (jugador.getValorApostar() > this.apuestaTotal) {
            JOptionPane.showMessageDialog((Component)null, "No hay suficiente dinero en el pote. \n " +
                    "Dinero en el pote: " + this.apuestaTotal,"Mensaje",1,null);
            return false;
        }
        if (jugador.getValorApostar() > jugador.getPresupuesto()) {
            JOptionPane.showMessageDialog((Component)null, "No tienes suficiente dinero. \n " +
                    "Tu presupuesto es: " + jugador.getPresupuesto(),"Mensaje",1,null);
            return false;
        }
        return true;
    }

    /*public Boolean verificarDineroPote(int valorApostar) {
        if (valorApostar > this.apuestaTotal) {
            JOptionPane.showMessageDialog((Component) null, "No hay suficiente dinero en el pote. \n " +
                    "Dinero en el pote: " + this.apuestaTotal, "Mensaje", 1, null);
            return false;
        }
        return true;
    }
    */
    public Boolean verificarDineroJugador(int valorApostar, int presupuesto){
        if(valorApostar - presupuesto == 0){
            JOptionPane.showMessageDialog((Component)null, "No puedes quedar en cerp. \n " +
                    "Tu presupuesto es: " + presupuesto,"Mensaje",1,null);
            return false;
        }
        if (valorApostar > presupuesto) {
            JOptionPane.showMessageDialog((Component)null, "No tienes suficiente dinero. \n " +
                    "Tu presupuesto es: " + presupuesto,"Mensaje",1,null);
            return false;
        }
        return true;
    }
}
