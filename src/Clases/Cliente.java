package Clases;

public class Cliente {
    private int IDCliente;
    private String nombre;
    private MetodoDePago metodoDePago;

    //Constructor
    public Cliente(int IDCliente, String nombre, MetodoDePago metodoDePago) {
        this.IDCliente = IDCliente;
        this.nombre = nombre;
        this.metodoDePago = metodoDePago;
    }
}
