package Clases;

import java.util.*;

public class Pedido {
    private static int contador = 1;      // para IDs
    private int id;                       // ID del pedido
    private Cliente cliente;              // quién lo hizo
    private List<ItemPedido> items;       // lista de Combo + estado listo
    private EstadoPedido estado;          // estado global

    //Constructor
    public Pedido(Cliente cliente) {
        this.id       = contador++;
        this.cliente  = cliente;
        this.items    = new ArrayList<>();
        this.estado   = EstadoPedido.PENDIENTE;
    }

    //Getters y Setters

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    //Permite cambiar el estado global del pedido
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    //Snapshot de los ítems (para no exponer la lista interna)
    public List<ItemPedido> getItems() {
        return new ArrayList<>(items);
    }

    //Gestión de combos dentro del pedido

    //Agrega un Combo al pedido -> Crea un ItemPedido con listo=false
    public void agregarCombo(Combo combo) {
        items.add(new ItemPedido(combo));
        System.out.println("[Pedido#" + id + "] + " + combo.getNombre());
    }

    //Elimina el primer ItemPedido cuyo Combo tenga ese ID.
    public void eliminarCombo(int comboId) {
        Iterator<ItemPedido> it = items.iterator();
        while (it.hasNext()) {
            if (it.next().getCombo().getIDcombo() == comboId) {
                it.remove();
                System.out.println("[Pedido#" + id + "] – Combo ID=" + comboId);
                return;
            }
        }
        System.out.println("[Pedido#" + id + "] No encontró Combo ID=" + comboId);
    }


    //Marca un Combo como listo dentro del pedido.
    public void marcarComboListo(int comboId) {
        for (ItemPedido ip : items) {
            if (ip.getCombo().getIDcombo() == comboId) {
                ip.setListo(true);
                System.out.println("[Pedido#" + id + "] Listo Combo ID=" + comboId);
                return;
            }
        }
        System.out.println("[Pedido#" + id + "] No encontró Combo ID=" + comboId);
    }

    //Devuelve true si todos los combos ya están listos
    public boolean todosListos() {
        for (ItemPedido ip : items) {
            if (!ip.isListo()) return false;
        }
        return true;
    }

    //impresion
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido#").append(id)
                .append(" (").append(cliente.getNombre()).append(") ")
                .append(estado).append(" [");
        for (ItemPedido ip : items) {
            sb.append(ip.getCombo().getNombre())
                    .append("(listo=").append(ip.isListo()).append("), ");
        }
        sb.append("]");
        return sb.toString();
    }

    //Clase interna que asocia un Combo con su flag de “listo”
    public static class ItemPedido {
        private Combo combo;
        private boolean listo;

        public ItemPedido(Combo combo) {
            this.combo = combo;
            this.listo = false;
        }

        public Combo getCombo() {
            return combo;
        }

        public boolean isListo() {
            return listo;
        }

        public void setListo(boolean listo) {
            this.listo = listo;
        }
    }
}
