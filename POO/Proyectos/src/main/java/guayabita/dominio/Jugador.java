package guayabita.dominio;



public class Jugador {

    private String nombre;
    private int presupuesto;
    private int puntos;
    private int valorApostar;

    Dado dado = new Dado();

    //Constructor
    public Jugador(){
    }

    //Getters y Setters
    public int getValorApostar() {
        return valorApostar;
    }

    public void setValorApostar(int valorApostar) {
        this.valorApostar = valorApostar;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodos
    public int tirarDados(){
        return dado.valorDado();
    }
    public void sumarPresupuesto(int cantidad){
        this.presupuesto += cantidad;
    }

    public void restarPresupuesto(int cantidad){
        this.presupuesto -= cantidad;
    }



    }

