package tdaLista;

public class ListaEnlazada<E> implements Lista<E> {
    private static class Nodo<E> {
        E dato;
        Nodo<E> siguiente;
        Nodo(E dato) { this.dato = dato; }
    }

    private Nodo<E> cabeza;
    private int longitud;

    @Override
    public void crear() {
        cabeza = null;
        longitud = 0;
    }

    @Override
    public void agregar(E elem) {
        if (cabeza == null) {
            cabeza = new Nodo<>(elem);
        } else {
            Nodo<E> curr = cabeza;
            while (curr.siguiente != null) curr = curr.siguiente;
            curr.siguiente = new Nodo<>(elem);
        }
        longitud++;
    }

    @Override
    public void insertar(int idx, E elem) {
        if (idx < 0 || idx > longitud) throw new IndexOutOfBoundsException();
        Nodo<E> nuevo = new Nodo<>(elem);
        if (idx == 0) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo<E> prev = cabeza;
            for (int i = 0; i < idx - 1; i++) prev = prev.siguiente;
            nuevo.siguiente = prev.siguiente;
            prev.siguiente = nuevo;
        }
        longitud++;
    }

    @Override
    public E quitar(int idx) {
        if (idx < 0 || idx >= longitud) throw new IndexOutOfBoundsException();
        Nodo<E> rem;
        if (idx == 0) {
            rem = cabeza;
            cabeza = cabeza.siguiente;
        } else {
            Nodo<E> prev = cabeza;
            for (int i = 0; i < idx - 1; i++) prev = prev.siguiente;
            rem = prev.siguiente;
            prev.siguiente = rem.siguiente;
        }
        longitud--;
        return rem.dato;
    }

    @Override
    public E get(int idx) {
        if (idx < 0 || idx >= longitud) throw new IndexOutOfBoundsException();
        Nodo<E> curr = cabeza;
        for (int i = 0; i < idx; i++) curr = curr.siguiente;
        return curr.dato;
    }

    @Override
    public int size() { return longitud; }

    @Override
    public boolean estaVacia() { return longitud == 0; }
}
