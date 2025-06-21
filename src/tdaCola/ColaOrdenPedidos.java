package tdaCola;

public class ColaOrdenPedidos<E> implements Cola<E> {
    private Object[] datos;
    private int frente;
    private int fin;
    private int cantidad;
    private int capacidad;

    public ColaOrdenPedidos(int capacidad) {
        this.capacidad = capacidad;
        datos = new Object[capacidad];
        crear();
    }

    @Override
    public void crear() {
        frente = 0;
        fin = -1;
        cantidad = 0;
    }

    @Override
    public void encolar(E elem) {
        if (estaLlena()) throw new IllegalStateException("Cola llena");
        fin = (fin + 1) % capacidad;
        datos[fin] = elem;
        cantidad++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E desencolar() {
        if (estaVacia()) throw new IllegalStateException("Cola vacía");
        E elem = (E) datos[frente];
        datos[frente] = null;
        frente = (frente + 1) % capacidad;
        cantidad--;
        return elem;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E frente() {
        return estaVacia() ? null : (E) datos[frente];
    }

    @Override
    public boolean estaVacia() {
        return cantidad == 0;
    }

    @Override
    public boolean estaLlena() {
        return cantidad == capacidad;
    }

    @Override
    public String verCola() {
        if (estaVacia()) return "Cola vacía";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidad; i++) {
            int idx = (frente + i) % capacidad;
            sb.append(datos[idx]);
            if (i < cantidad - 1) sb.append(", ");
        }
        return sb.toString();
    }

    public int size() {
        return cantidad;
    }
}
