package tdaMapa;

import java.util.LinkedList;

public class MapaHash<K, V> implements Mapa<K, V> {
    private static class Entrada<K, V> {
        K clave;
        V valor;
        Entrada(K k, V v) { clave = k; valor = v; }
    }

    private LinkedList<Entrada<K,V>>[] buckets;
    private int capacidad;
    private int tamaño;

    @SuppressWarnings("unchecked")
    @Override
    public void crear() {
        capacidad = 16;
        buckets = new LinkedList[capacidad];
        for (int i = 0; i < capacidad; i++) buckets[i] = new LinkedList<>();
        tamaño = 0;
    }

    private int indiceDe(K clave) {
        return (clave == null ? 0 : Math.abs(clave.hashCode())) % capacidad;
    }

    @Override
    public void put(K clave, V valor) {
        int idx = indiceDe(clave);
        for (Entrada<K,V> e : buckets[idx]) {
            if ((clave == null && e.clave == null) || (clave != null && clave.equals(e.clave))) {
                e.valor = valor;
                return;
            }
        }
        buckets[idx].add(new Entrada<>(clave, valor));
        tamaño++;
        // (Opcional) Rehash cuando load factor > 0.75
    }

    @Override
    public V get(K clave) {
        int idx = indiceDe(clave);
        for (Entrada<K,V> e : buckets[idx]) {
            if ((clave == null && e.clave == null) || (clave != null && clave.equals(e.clave))) {
                return e.valor;
            }
        }
        return null;
    }

    @Override
    public V remove(K clave) {
        int idx = indiceDe(clave);
        for (Entrada<K,V> e : buckets[idx]) {
            if ((clave == null && e.clave == null) || (clave != null && clave.equals(e.clave))) {
                V val = e.valor;
                buckets[idx].remove(e);
                tamaño--;
                return val;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K clave) {
        return get(clave) != null;
    }

    @Override
    public int size() { return tamaño; }

    @Override
    public boolean estaVacio() { return tamaño == 0; }
}
