package Clases;

//atributos
public class Combo {
    private int    IDcombo;
    private float  precio;
    private String nombre;
    private String detalle;     // <- nuevo

    // Constructor de 4 parámetros
    public Combo(int IDcombo, float precio, String nombre, String detalle) {
        this.IDcombo = IDcombo;
        this.precio   = precio;
        this.nombre   = nombre;
        this.detalle  = detalle;
    }

    // Getters que faltaban
    public int    getIDcombo() { return IDcombo; }
    public float  getPrecio()  { return precio;   }
    public String getNombre()  { return nombre;   }
    public String getDetalle() { return detalle;  }
}

    /*
        Combo 1
        Hamburguesa patria
        IDcombo: 001
        Detalle: PAN + CARNE + CRIOLLA + PROVOLETA
        Precio: 14500

        Combo 2
        Hamburguesa clasica
        IDcombo: 002
        Detalle: PAN + CARNE + LECHUGA + TOMATE
        Precio: 12000

        Combo 3
        Hamburguesa con queso
        IDcombo: 003
        Detalle: PAN + CARNE + DOBLE CHEDDAR
        Precio: 13000
     */

// 1 llega -> cola -> opera -> sale de la cola (agregar combo a un pedido)
// 1 nuevo combo = nueva clase = nueva herencia (agregar combo nuevo al menu)

