package Clases;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.EnumMap;

/**
 * Controlador central de todo el flujo:
 *  - menú de combos
 *  - cola de cocina
 *  - cola de entrega
 *  - registro de deliveries
 *  - consultas y dashboard
 */
public class SistemaDeGestionPedidos {

    // —————————————————————————————
    // 1. Atributos
    // —————————————————————————————
    private Map<Integer, Combo> menu;
    private Queue<Pedido>       colaCocina;
    private Queue<Pedido>       colaEntrega;
    private List<Delivery>      entregas;

    // —————————————————————————————
    // 2. Constructor
    // —————————————————————————————
    public SistemaDeGestionPedidos() {
        this.menu        = new HashMap<>();
        this.colaCocina  = new LinkedList<>();
        this.colaEntrega = new LinkedList<>();
        this.entregas    = new ArrayList<>();
    }

    // —————————————————————————————
    // 3. Gestión del menú
    // —————————————————————————————
    public void agregarComboMenu(Combo c) {
        menu.put(c.getIDcombo(), c);
        System.out.println("Menú: + " + c);
    }

    public void eliminarComboMenu(int idCombo) {
        if (menu.remove(idCombo) != null) {
            System.out.println("Menú: – Combo ID=" + idCombo);
        } else {
            System.out.println("Menú: no existe Combo ID=" + idCombo);
        }
    }

    public void mostrarMenu() {
        System.out.println("\n=== Menú de Combos ===");
        if (menu.isEmpty()) {
            System.out.println("(vacío)");
            return;
        }
        for (Combo c : menu.values()) {
            System.out.println(c);
        }
    }

    // —————————————————————————————
    // 4. Gestión de pedidos (Fase 3.2)
    // —————————————————————————————
    public Pedido crearPedido(Cliente cliente, List<Integer> comboIds) {
        Pedido p = new Pedido(cliente);
        for (int id : comboIds) {
            Combo c = menu.get(id);
            if (c != null) {
                p.agregarCombo(c);
            } else {
                System.out.println("> ID inválido en menú: " + id);
            }
        }
        return p;
    }

    public void enviarACocina(Pedido p) {
        if (p.getEstado() != EstadoPedido.PENDIENTE) {
            System.out.println("Sólo PENDIENTES pueden enviarse a cocina.");
            return;
        }
        p.setEstado(EstadoPedido.EN_PREPARACION);
        colaCocina.add(p);
        System.out.println("Pedido#" + p.getId() + " → EN_PREPARACION");
    }

    public void marcarComboListo(int pedidoId, int comboId) {
        for (Pedido p : colaCocina) {
            if (p.getId() == pedidoId) {
                p.marcarComboListo(comboId);
                return;
            }
        }
        System.out.println("Pedido#" + pedidoId + " no está en cocina.");
    }

    public void actualizarPedidosListos() {
        Iterator<Pedido> it = colaCocina.iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            if (p.todosListos()) {
                it.remove();
                p.setEstado(EstadoPedido.LISTO);
                colaEntrega.add(p);
                System.out.println("Pedido#" + p.getId() + " → LISTO");
            }
        }
    }

    // —————————————————————————————
    // 5. Registro de entregas (Fase 3.3)
    // —————————————————————————————
    public void registrarEntrega(int pedidoId, MetodoPago metodo) {
        Iterator<Pedido> it = colaEntrega.iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            if (p.getId() == pedidoId) {
                it.remove();
                p.setEstado(EstadoPedido.ENTREGADO);
                Delivery d = new Delivery(p, metodo);
                entregas.add(d);
                System.out.println("Entregado → " + d);
                return;
            }
        }
        System.out.println("Pedido#" + pedidoId + " no está listo para entrega.");
    }

    public void mostrarEntregas() {
        System.out.println("\n=== Historial de Entregas ===");
        if (entregas.isEmpty()) {
            System.out.println("(ninguna entrega registrada)");
            return;
        }
        for (Delivery d : entregas) {
            System.out.println(d);
        }
    }

    // —————————————————————————————
    // 6. Consultas y reportes (Fase 3.4)
    // —————————————————————————————
    public EstadoPedido consultarEstado(int pedidoId) {
        for (Pedido p : colaCocina)
            if (p.getId() == pedidoId) return p.getEstado();
        for (Pedido p : colaEntrega)
            if (p.getId() == pedidoId) return p.getEstado();
        for (Delivery d : entregas)
            if (d.getPedido().getId() == pedidoId)
                return d.getPedido().getEstado();
        System.out.println("Pedido no encontrado: ID=" + pedidoId);
        return null;
    }

    public void dashboardEstados() {
        Map<EstadoPedido,Integer> contador = new EnumMap<>(EstadoPedido.class);
        for (EstadoPedido e : EstadoPedido.values()) {
            contador.put(e, 0);
        }
        for (Pedido p : colaCocina)   contador.merge(p.getEstado(), 1, Integer::sum);
        for (Pedido p : colaEntrega)  contador.merge(p.getEstado(), 1, Integer::sum);
        for (Delivery d : entregas)   contador.merge(d.getPedido().getEstado(), 1, Integer::sum);

        System.out.println("\n=== Dashboard de Estados ===");
        for (Map.Entry<EstadoPedido,Integer> entry : contador.entrySet()) {
            System.out.printf("%-15s : %d%n", entry.getKey(), entry.getValue());
        }
    }

    // —————————————————————————————
    // 7. Getters opcionales para inspección desde Main
    // —————————————————————————————
    public Queue<Pedido> getColaCocina()  { return new LinkedList<>(colaCocina); }
    public Queue<Pedido> getColaEntrega() { return new LinkedList<>(colaEntrega); }
    public List<Delivery> getEntregas()    { return new ArrayList<>(entregas); }
}




