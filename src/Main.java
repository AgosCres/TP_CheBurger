import Clases.*;
import tdaLista.Lista;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        SistemaDeGestionPedidos sistema = new SistemaDeGestionPedidos(100);
        Scanner sc = new Scanner(System.in);

        // Definición de combos disponibles
        List<Combo> menuCombos = Arrays.asList(
                new ComboClasica(1, 1500, "Clasica", "Carne, queso"),
                new ComboQueso(2, 1700, "Queso", "Carne, doble queso"),
                new ComboPatria(3, 2000, "Patria", "Carne, queso, panceta")
        );
        MetodoDePago[] metodos = MetodoDePago.values(); //array metodo de pago para el menú

        while (true) {
            System.out.println("\n--- CheBurger Menu ---");
            System.out.println("1. Agregar pedido");
            System.out.println("2. Ver pedido");
            System.out.println("3. Actualizar estado de pedido");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:

                    // Mostrar menú de combos y permitir agregar varios
                    List<Combo> combosSeleccionados = new ArrayList<>();
                    String seguir;
                    do {
                        System.out.println("\n-- Menú de Combos --");
                        for (Combo c : menuCombos) {
                            System.out.printf("%d. %s ($%.0f) - Detalle: %s%n",
                                    c.getIDcombo(), c.getNombre(), c.getPrecio(), c.getDetalle());
                        }
                        System.out.print("Elige ID de combo: ");
                        int comboId = sc.nextInt();
                        sc.nextLine(); // limpiar

                        Combo seleccionado = null;
                        for (Combo c : menuCombos) {
                            if (c.getIDcombo() == comboId) {
                                seleccionado = c;
                                break;
                            }
                        }

                        if (seleccionado != null) {
                            combosSeleccionados.add(seleccionado);
                            System.out.println("Combo agregado al pedido.");
                        } else {
                            System.out.println("Combo inválido.");
                        }

                        System.out.print("¿Deseás agregar otro combo al mismo pedido? (s/n): ");
                        seguir = sc.nextLine();
                    } while (seguir.equalsIgnoreCase("s"));

                    if (combosSeleccionados.isEmpty()) {
                        System.out.println("No se agregó ningún combo. Pedido cancelado.");
                        break;
                    }

                    System.out.print("ID de pedido: ");
                    int pedidoId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre cliente: ");
                    String nombre = sc.nextLine();

                    System.out.println("\n-- Métodos de Pago --");
                    for (int i = 0; i < metodos.length; i++) {
                        System.out.printf("%d. %s%n", i + 1, metodos[i]);

                    }
                    System.out.print("Elige método de pago: ");
                    int mp = sc.nextInt();
                    sc.nextLine();
                    MetodoDePago elegido;
                    if (mp >= 1 && mp <= metodos.length) {
                        elegido = metodos[mp - 1];

                    } else {
                        System.out.println("Método inválido, se usará EFECTIVO por defecto.");
                        elegido = MetodoDePago.EFECTIVO;
                    }

                    Cliente cliente = new Cliente(pedidoId, nombre, elegido);
                    Pedido nuevo = new Pedido(pedidoId, cliente, combosSeleccionados, null);
                    sistema.altaPedido(nuevo);
                    System.out.println("✅ Pedido agregado con " + combosSeleccionados.size() + " combo(s).");
                    break;

                // se agrega funcion de agregar mas de un combo en un mismo pedido

                case 2:
                    Lista<Pedido> lista = sistema.listarPedidos();
                    if (lista.estaVacia()) {
                        System.out.println("No hay pedidos realizados.");
                    } else {
                        System.out.println("\n-- Pedidos --");
                        for (int i = 0; i < lista.size(); i++) {
                            Pedido p = lista.get(i);
                            System.out.printf("ID: %d , Estado: %s%n",
                                    p.getIDPedido(),
                                    p.getEstado());
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID de pedido a actualizar: ");
                    int actualizarId = sc.nextInt();
                    sc.nextLine();

                    // --- Nuevo bloque: menú de estados ---
                    EstadoPedido[] estados = EstadoPedido.values();
                    System.out.println("\n-- Seleccione nuevo estado --");
                    for (int i = 0; i < estados.length; i++) {
                        System.out.printf("%d. %s%n", i + 1, estados[i]);
                    }
                    System.out.print("Opción: ");
                    int es = sc.nextInt();
                    sc.nextLine();
                    if (es >= 1 && es <= estados.length) {
                        boolean ok = sistema.actualizarEstado(actualizarId, estados[es - 1]);
                        System.out.println(ok ? "Estado actualizado." : "Pedido no encontrado.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
