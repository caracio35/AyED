package com.example.tp05_heap;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01_list.ejercicio2.ListaGenerica;

public class MinHeap<T extends Comparable<T>> implements ColaPrioridades<T> {

    private ListaGenerica<T> datos;
    private int cantElementos;

    public MinHeap() {
        datos = new ListaEnlazadaGenerica<>();
        cantElementos = 0;
    }

    public MinHeap(ListaGenerica<T> listaInicial) {
        datos = listaInicial;
        cantElementos = listaInicial.tamanio();
        // build-heap para propiedad de mínimo
        for (int i = cantElementos / 2; i >= 1; i--) {
            percolate_down(i);
        }
    }

    @Override
    public boolean esVacia() {
        return cantElementos == 0;
    }

    @Override
    public boolean agregar(T dato) {
        datos.agregarFinal(dato);
        cantElementos++;
        percolate_up();
        return true;
    }

    @Override
    public T eliminar() {
        if (cantElementos == 0)
            return null;

        T minimo = datos.elemento(1);

        if (cantElementos == 1) {
            datos.eliminarEn(1);
            cantElementos = 0;
            return minimo;
        }

        T ultimo = datos.elemento(cantElementos);
        datos.eliminarEn(cantElementos);
        cantElementos--;

        datos.reemplazarEn(ultimo, 1);
        percolate_down(1);
        return minimo;
    }

    @Override
    public T tope() {
        return datos.elemento(1);
    }

    private void percolate_up() {
        int i = cantElementos;
        while (i > 1) {
            int padre = i / 2;
            T actual = datos.elemento(i);
            T padreElem = datos.elemento(padre);

            if (actual.compareTo(padreElem) < 0) {
                swap(i, padre);
            } else {
                break;
            }
            i = padre;
        }
    }

    private void percolate_down(int indice) {
        while (indice * 2 <= cantElementos) {
            int hijoIzq = indice * 2;
            int hijoDer = hijoIzq + 1;
            int hijoMenor = hijoIzq;

            if (hijoDer <= cantElementos && datos.elemento(hijoDer).compareTo(datos.elemento(hijoIzq)) < 0) {
                hijoMenor = hijoDer;
            }

            if (datos.elemento(hijoMenor).compareTo(datos.elemento(indice)) < 0) {
                swap(indice, hijoMenor);
                indice = hijoMenor;
            } else {
                break;
            }
        }
    }

    public void imprimir() {
        for (int i = 1; i <= cantElementos; i++)
            System.out.print(datos.elemento(i) + " ");
        System.out.println();
    }

    public int tamanio() {
        return cantElementos;
    }

    private void swap(int i, int j) {
        T vi = datos.elemento(i);
        T vj = datos.elemento(j);
        datos.reemplazarEn(vj, i);
        datos.reemplazarEn(vi, j);
    }

}
