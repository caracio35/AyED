package com.example.tp01_list.ejercicio3;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01_list.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {
    private ListaGenerica<T> datos;

    public PilaGenerica() {
        datos = new ListaEnlazadaGenerica<T>();
    }

    public void apilar(T elem) {
        datos.agregarFinal(elem);
    }

    public T desapilar() {
        int tam = datos.tamanio();
        T elem = datos.elemento(tam);
        datos.eliminarEn(tam);
        return elem;
    }

    public T tope() {
        int tam = datos.tamanio();
        return datos.elemento(tam);
    }

    public boolean esVacia() {
        return datos.esVacia();
    }

}
