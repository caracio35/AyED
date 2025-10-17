package com.example.tp03.tp03abb;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01_list.ejercicio2.ListaGenerica;

public class CaminoABB {

    private int comp = 0;

    public ListaGenerica<Integer> caminoRecorrido(ArbolBinarioDeBusqueda<Integer> abb, Integer valor) {
        ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<>();
        camino.agregarFinal(abb.getDato());
        buscarCamino(abb, valor, camino);
        return camino;
    }

    private void buscarCamino(ArbolBinarioDeBusqueda<Integer> nodo, Integer valor, ListaGenerica<Integer> camino) {
        if (nodo == null || nodo.esVacio())
            return;

        comp = valor.compareTo(nodo.getDato());

        if (comp == 0) {
            // Encontramos el valor → se agrega en positivo
            return;
        } else if (comp < 0) {
            // Vamos a la izquierda → agregamos negativo
            if (!nodo.tieneHijoIzquierdo())
                return;
            camino.agregarFinal(-nodo.getHijoIzquierdo().getDato());
            buscarCamino(nodo.getHijoIzquierdo(), valor, camino);
        } else {
            if (!nodo.tieneHijoDerecho())
                return;
            // Vamos a la derecha → agregamos positivo
            camino.agregarFinal(nodo.getHijoDerecho().getDato());
            buscarCamino(nodo.getHijoDerecho(), valor, camino);
        }
    }
}