package Clases;

public class Extras {
    private int IDExtra;
    private String nombre;
    private float precioUnitario;
    private int cantidad;

    //Constructor
    public Extras(int IDExtra, String nombre, float precioUnitario, int cantidad) {
        this.IDExtra = IDExtra;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getIDExtra(){
        return IDExtra;
    }
}
