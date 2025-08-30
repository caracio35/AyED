package com.example.tp01_list.objetos;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String legajo;

    public Estudiante(String nombre, String apellido, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

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

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String tusDatos() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Legajo: " + legajo;
    }
}
