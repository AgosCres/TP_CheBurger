package Clases;

import java.util.List;

public class Pedido {
    private int IDPedido;
    private Cliente cliente;
    private List<Combo> combos;
    private Delivery delivery;
    private EstadoPedido estado;

    // 1) Constructor de 4 parámetros, arranca siempre PENDIENTE
    public Pedido(int IDPedido, Cliente cliente, List<Combo> combos, Delivery delivery) {
        this.IDPedido = IDPedido;
        this.cliente   = cliente;
        this.combos    = combos;
        this.delivery  = delivery;
        this.estado    = EstadoPedido.PENDIENTE;
    }

    // 2) Getter para IDPedido
    public int getIDPedido() {
        return IDPedido;
    }

    // Ya existían:
    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void agregarCombo(Combo combo) {
        combos.add(combo);
    }

}

// se agrega agregaCombo...