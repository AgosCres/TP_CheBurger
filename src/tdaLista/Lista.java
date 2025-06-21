package tdaLista;

public interface Lista<E> {
    void crear();                      // inicializa la lista
    void agregar(E elem);              // añade al final
    void insertar(int idx, E elem);    // inserta en posición idx
    E quitar(int idx);                 // remueve y devuelve elemento en idx
    E get(int idx);                    // devuelve elemento en idx
    int size();                        // cantidad de elementos
    boolean estaVacia();
}
