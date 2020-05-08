package com.example.recyclerview.model;

import java.util.Date;
import java.util.List;

public class Persona {

    private String nombre;
    private String apellido;
    private Integer edad;
    private Date fechaNacimiento;
    private List<String> apodos;
    private Direccion direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<String> getApodos() {
        return apodos;
    }

    public void setApodos(List<String> apodos) {
        this.apodos = apodos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
