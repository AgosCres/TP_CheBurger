package Clases;

import java.util.List;

public class Combo {
    private int IDcombo;
    private float precio;
    private String nombre;
    private String detalle;
    private List<Extras> extra;

    //Constructor
    public Combo(int IDcombo, float precio, String nombre, String detlale , List<Extras> extra) {
        this.IDcombo = IDcombo;
        this.precio = precio;
        this.nombre = nombre;
        this.detalle = detalle;
        this.extra = extra;
    }


    /*
        //Combo 1
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


    //Busco en la lista general de extras el que tenga el ID igual al pasado como parámetro
    //Si lo encuentra y no está en el combo, lo agrego como a la lista extra el combo
    //Si no, muestro el mensaje de error.
    public void agregarExtra(int IDExtra, List<Extras> extrasDisponibles) {
        for (Extras e : extrasDisponibles) {
            if (e.getIDExtra() == IDExtra) {
                if (!extra.contains(e)) {
                    extra.add(e);
                    System.out.println("Extra agregado:" + e.getNombre());
                } else {
                    System.out.println("Este extra ya está en el combo.");
                }
                return;
            }
        }
        System.out.println("No se encontró un extra con ese ID");
    }

    public void eliminarExtra (int IDExtra){
        for(Extras e : extra){
            if(e.getIDExtra() == IDExtra){
                extra.remove(e);
                System.out.println("Extra eliminado: "+ e.getNombre());
                return;
            }
        }
        System.out.println("No se encontró un extra con ese ID");
    }

    public void mostrarExtras(){
        if(extra.isEmpty()){
            System.out.println("Este combo no tiene extras agregados ");
        }else {
            System.out.println("Extras del combo \"" + nombre + "\": ");
            for (Extras e: extra){
                System.out.println("- "+ e.getNombre());
            }
        }
    }

}

