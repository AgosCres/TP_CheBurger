package Clases;

public class Cliente {
    private int IDCliente;
    private String nombre;
    private MetodoDePago metodoDePago;
    private String direccion;
    private int telefono;

    //Constructor
    public Cliente(int IDCliente, String nombre, MetodoDePago metodoDePago, String direccion, int telefono) {
        this.IDCliente = IDCliente;
        this.nombre = nombre;
        this.metodoDePago = metodoDePago;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
