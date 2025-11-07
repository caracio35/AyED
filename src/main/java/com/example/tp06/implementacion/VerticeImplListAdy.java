package com.example.tp06.implementacion;

import com.example.tp06.Vertice;

public class VerticeImplListAdy<T> implements Vertice<T> {
    private T dato;
    private int posicion; // la setea el grafo

    public VerticeImplListAdy(T dato) {
        this.dato = dato;
    }

    public T dato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public int posicion() {
        return posicion;
    }

    // setter extra (no está en la interfaz, pero es válido tenerlo en la impl)
    public void setPosicion(int pos) {
        this.posicion = pos;
    }

    @Override
    public int getPosicion() {
        return posicion;
    }

}