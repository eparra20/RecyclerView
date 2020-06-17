package com.example.recyclerview.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * POJO
 * Es nuestra clase para representar cada elemento de la celda.
 */
@Entity(indices = {
        @Index(value = {"nombre","imagenRef"},unique = true)
})
public class Animal implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo()
    private String nombre;

    @ColumnInfo
    private Integer imagen;

    @ColumnInfo
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
