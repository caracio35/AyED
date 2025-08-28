package com.example.tp01.ejercicio3;

import com.example.tp01.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01.ejercicio2.ListaGenerica;

public class ColaGenerica<T> {

    private ListaGenerica<T> datos = new ListaEnlazadaGenerica<>();

    public void encolar(T elem) {
        datos.agregarFinal(elem);
    }

    public T desencolar() {
        T elem = datos.elemento(1);
        datos.eliminarEn(1);
        return elem;
    }

    public T tope() {
        return datos.elemento(0);
    }

    public boolean esVacia() {
        return datos.esVacia();
    }
}
