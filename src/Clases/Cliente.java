package Clases;

public class Cliente {
    private static int contador = 1; //generador de IDs unicos

    private int IDCliente;
    private String nombre;

    //Constructor
    public Cliente(String nombre) {
        this.IDCliente = contador++; //con esto se gestiona internaente en la clase (no se necesita set)
        this.nombre = nombre;
    }

    //Getter y Setter

    public int getIDCliente() {
        return IDCliente;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //impresion
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + IDCliente +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

