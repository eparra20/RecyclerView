package com.example.recyclerview.model;

import java.io.Serializable;

/**
 * POJO
 * Es nuestra clase para representar cada elemento de la celda.
 */
public class Animal implements Serializable {

    private String nombre;
    private Integer imagen;
    private String imagenRef;

    public Animal() {
    }

    public Animal(String nombre, Integer imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Animal(String nombre, Integer imagen, String imagenRef) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.imagenRef = imagenRef;
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

    public String getImagenRef() {
        return imagenRef;
    }

    public void setImagenRef(String imagenRef) {
        this.imagenRef = imagenRef;
    }
}
