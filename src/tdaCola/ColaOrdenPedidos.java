package tdaCola;

public class ColaOrdenPedidos implements Cola{
    int [] datos;

    private int frente, fin, cantidad, capacidad;

    public ColaOrdenPedidos (int capacidad){
        this.capacidad = capacidad;
        datos = new int [capacidad];
        frente = 0;
        fin = -1;
    }

    @Override
    public void crear() {

    }

    @Override
    public void encolar(int elemento) {
        if(estaLlena()) {
            System.out.println("Cola completa, no se aceptan más pedidos..");
        }else  {
            fin = (fin+1);
            datos[fin] = elemento;
            cantidad++;
            System.out.println("Se agregó el pedido "+datos[1]+" en el orden:" + fin);
        }
    }

    @Override
    public void desencolar() {
        if(estaVacia()){
            System.out.println("No hay pedidos pendientes");
        }else{
            int auxiliar = datos [frente];
            frente = (frente+1);
            cantidad --;
            System.out.println("Se entregó el pedido " + auxiliar);
        }

    }

    @Override
    public int frente() { //muestro el primer pedido a ser atendido
        if (cantidad == 0) {
            System.out.println("No hay pedidos pendientes");
            return 1;
        } else {
            int auxiliar = datos[frente];
            System.out.println("El primer pedido a preprar es -->" + auxiliar);
            return auxiliar;
        }
    }

    @Override
    public boolean estaVacia() {
        if(cantidad == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean estaLlena() {
        if(cantidad==capacidad)
            return  true;
        else
          return false;
    }
    @Override
    public void verCola() {
        if(estaVacia()){
            System.out.println("Cola sin pedidos pendientes");
            return;
        }
        System.out.println("\nListado de pedidos: ");
        for (int  i=0; i<cantidad; i++){
            int indice  = (frente+i) % capacidad; //calculo el índice, calculando el resto para saber la posición de la cola
            System.out.print(datos[indice]+ " " + "|");
        }
        System.out.println();
    }
}
