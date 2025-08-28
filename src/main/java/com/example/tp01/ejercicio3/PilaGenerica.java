package com.example.tp01.ejercicio3;

import com.example.tp01.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {
    private ListaGenerica<T> datos;

    public PilaGenerica() {
        datos = new ListaEnlazadaGenerica<T>();
    }

    public void apilar(T elem) {
        datos.agregarInicio(elem);
    }

    public T desapilar() {
        T elem = this.tope();
        datos.eliminarEn(0);
        return elem;
    }

    public T tope() {
        return datos.elemento(0);
    }

    public boolean esVacia() {
        return datos.esVacia();
    }

}
