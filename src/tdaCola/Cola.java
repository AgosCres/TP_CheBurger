package tdaCola;

public interface Cola<E> {
    void crear();              // inicializa la cola

    void encolar(E elem);      // añade un elemento al final

    E desencolar();            // retira y devuelve el frente

    E frente();                // consulta el elemento al frente sin removerlo

    boolean estaVacia();       // verifica si no hay elementos

    boolean estaLlena();       // verifica si alcanzó la capacidad máxima

    String verCola();
}