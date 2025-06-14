package Clases;

public class Delivery {
    private int ID_Rider;
    private String nombre;
    private float costoEnvio;
    private int horaLlegada;
    private int horaSalida;

    //Constructor
    public Delivery(int ID_Rider, String nombre, float costoEnvio, int horaLlegada, int horaSalida) {
        this.ID_Rider = ID_Rider;
        this.nombre = nombre;
        this.costoEnvio = costoEnvio;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
    }
}
