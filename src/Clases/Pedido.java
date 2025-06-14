package Clases;

import java.util.List;

public class Pedido {
    private int IDPedido;
    private Cliente cliente;
    private List<Combo> combos;
    private Delivery delivery;
    private EstadoPedido estado;

    //Constructor
    public Pedido(int IDPedido, Cliente cliente, List<Combo> combos, Delivery delivery, EstadoPedido estado) {
        this.IDPedido = IDPedido;
        this.cliente = cliente;
        this.combos = combos;
        this.delivery = delivery;
        this.estado = EstadoPedido.PENDIENTE; //Estado incial de todos los pedidos
    }

    //Con este getter puedo acceder al estado ACTUAL del pedido desde afuera de la clase
    public EstadoPedido getEstado(){
        return estado;
    }

    //Con este setter podemos MODIFICAR el estado del pedido
    public void setEstado (EstadoPedido nuevoEstado){
        this.estado = nuevoEstado;
    }

}
