package Clases;

//Guarda la referencia al Pedido que se entregó y el método de pago usado

public class Delivery {
    private Pedido pedido;
    private MetodoPago metodo;

    //Constructor
    public Delivery(Pedido pedido, MetodoPago metodo) {
        this.pedido = pedido;
        this.metodo = metodo;
    }

    //Getters y Setters
    public Pedido getPedido() {
        return pedido;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    //impresion
    @Override
    public String toString() {
        return "Delivery{ pedido#" + pedido.getId() +
                ", cliente=" + pedido.getCliente().getNombre() +
                ", pago=" + metodo + " }";
    }
}

