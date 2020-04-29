package com.example.recyclerview;

import java.io.Serializable;

/**
 * POJO
 * Es nuestra clase para representar cada elemento de la celda.
 */
public class Animal implements Serializable {

    private String nombre;
    private Integer imagen;

    public Animal() {
    }

    public Animal(String nombre, Integer imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }
}
