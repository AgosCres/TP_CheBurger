package Clases;

public class Combo {
    private int IDcombo;
    private float precio;
    private String nombre;

    //Constructor
    public Combo(int IDcombo, float precio, String nombre) {
        this.IDcombo = IDcombo;
        this.precio = precio;
        this.nombre = nombre;
    }

    //Getters y Setters
    public int getIDcombo() {
        return IDcombo;
    }
    public void setIdCombo(int idCombo) {
        this.IDcombo = idCombo;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //impresión
    @Override
    public String toString() {
        return "Combo{" +
                "id=" + IDcombo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

