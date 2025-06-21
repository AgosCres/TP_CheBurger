package tdaMapa;

public interface Mapa<K, V> {
    void crear();               // inicializa la tabla
    void put(K clave, V valor); // inserta o actualiza
    V get(K clave);             // obtiene o devuelve null
    V remove(K clave);          // elimina y devuelve el valor
    boolean containsKey(K clave);
    int size();
    boolean estaVacio();
}

