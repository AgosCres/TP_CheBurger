package Clases;

import tdaCola.ColaOrdenPedidos;
import tdaLista.Lista;
import tdaLista.ListaEnlazada;
import tdaMapa.Mapa;
import tdaMapa.MapaHash;

/**
 * Sistema de gestión de pedidos con cola FIFO.
 */
public class SistemaDeGestionPedidos {
    private ColaOrdenPedidos<Integer> colaPedidos;
    private Mapa<Integer, Pedido> mapaPedidos;
    private Lista<Pedido> listaTodosPedidos;

    public SistemaDeGestionPedidos(int capacidad) {
        colaPedidos = new ColaOrdenPedidos<>(capacidad);
        mapaPedidos = new MapaHash<>();
        mapaPedidos.crear();
        listaTodosPedidos = new ListaEnlazada<>();
        listaTodosPedidos.crear();
    }

    /**
     * Agrega un nuevo pedido al sistema.
     */
    public void altaPedido(Pedido pedido) {
        int id = pedido.getIDPedido();
        mapaPedidos.put(id, pedido);
        colaPedidos.encolar(id);
        listaTodosPedidos.agregar(pedido);
    }

    /**
     * Procesa el siguiente pedido en la cola.
     */
    public void procesarSiguiente() {
        if (!colaPedidos.estaVacia()) {
            int id = colaPedidos.desencolar();
            Pedido p = mapaPedidos.get(id);
            p.setEstado(EstadoPedido.EN_PREPARACION);
            // aquí podrías avanzar más estados o asignar Delivery
        }
    }

    /**
     * Devuelve la lista de todos los pedidos creados.
     */
    public Lista<Pedido> listarPedidos() {
        return listaTodosPedidos;
    }

    /**
     * Actualiza el estado de un pedido existente.
     */
    public boolean actualizarEstado(int id, EstadoPedido nuevoEstado) {
        Pedido p = mapaPedidos.get(id);
        if (p == null) return false;
        p.setEstado(nuevoEstado);
        return true;
    }

    /**
     * Muestra el contenido actual de la cola.
     */
    public String verCola() {
        return colaPedidos.verCola();
    }

    /**
     * Agrega un nuevo Cliente al sistema.

    public void altaCliente(Cliente cliente) {
        int id = pedido.getIDPedido();
        mapaPedidos.put(id, pedido);
        colaPedidos.encolar(id);
        listaTodosPedidos.agregar(pedido);
    }
     */
}
