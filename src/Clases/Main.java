package Clases;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instancio el sistema
        SistemaDeGestionPedidos sys = new SistemaDeGestionPedidos();

        // -----------------------
        // Fase 3.1: Configurar menú
        // -----------------------
        System.out.println(">>> Agregando combos al menú");
        sys.agregarComboMenu(new ComboClasica());
        sys.agregarComboMenu(new ComboPatria());
        sys.agregarComboMenu(new ComboQueso());
        sys.mostrarMenu();

        // -----------------------
        // Fase 3.2: Crear y procesar pedido
        // -----------------------
        System.out.println("\n>>> Creando pedido para cliente 'Ana'");
        Cliente ana = new Cliente("Ana");
        List<Integer> seleccion = Arrays.asList(1, 2, 3); // IDs de los 3 combos
        Pedido pedido = sys.crearPedido(ana, seleccion);
        System.out.println("Pedido inicial: " + pedido);

        System.out.println("\n>>> Enviando a cocina");
        sys.enviarACocina(pedido);
        System.out.println("Estado: " + pedido);

        System.out.println("\n>>> Marcando combos listos uno a uno");
        for (int idCombo : seleccion) {
            sys.marcarComboListo(pedido.getId(), idCombo);
            System.out.println("→ Después de listo Combo " + idCombo + ": " + pedido);
        }

        System.out.println("\n>>> Actualizando pedidos listos (moverá a LISTO)");
        sys.actualizarPedidosListos();
        System.out.println("Estado final en cocina/entrega: " + pedido);
        System.out.println("Cola cocina: " + sys.getColaCocina());
        System.out.println("Cola entrega: " + sys.getColaEntrega());

        // -----------------------
        // Fase 3.3: Registrar entrega
        // -----------------------
        System.out.println("\n>>> Registrando entrega con pago TARJETA");
        sys.registrarEntrega(pedido.getId(), MetodoPago.TARJETA);

        // -----------------------
        // Fase 3.4: Consultas y reportes
        // -----------------------
        System.out.println("\n>>> Historial de Entregas:");
        sys.mostrarEntregas();

        System.out.println("\n>>> Consultar estado del pedido:");
        System.out.println("Estado pedido#" + pedido.getId() + " = " +
                sys.consultarEstado(pedido.getId()));

        System.out.println("\n>>> Dashboard de Estados:");
        sys.dashboardEstados();
    }
}






