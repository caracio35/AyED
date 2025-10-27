package com.example.tp05_heap;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01_list.ejercicio2.ListaGenerica;

// para usar ListaGenerica y ListaEnlazadaGenerica

public class MaxHeap<T extends Comparable<T>> implements ColaPrioridades<T> {

    private ListaGenerica<T> datos;
    private int cantElementos;

    public MaxHeap() {
        datos = new ListaEnlazadaGenerica<>();
        cantElementos = 0;
    }

    public MaxHeap(ListaGenerica<T> listaInicial) {
        datos = listaInicial;
        cantElementos = listaInicial.tamanio();
        // Asegurar propiedad de heap (build-heap)
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

    public T eliminar() {
        if (cantElementos == 0)
            return null;

        T maximo = datos.elemento(1);

        if (cantElementos == 1) {
            datos.eliminarEn(1);
            cantElementos = 0;
            return maximo;
        }

        T ultimo = datos.elemento(cantElementos);
        datos.eliminarEn(cantElementos);
        cantElementos--;

        datos.reemplazarEn(ultimo, 1); // coloca el último en la raíz
        percolate_down(1); // lo baja hasta su posición correcta

        return maximo;
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

            if (actual.compareTo(padreElem) > 0) {
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
            int hijoMayor = hijoIzq;

            if (hijoDer <= cantElementos && datos.elemento(hijoDer).compareTo(datos.elemento(hijoIzq)) > 0) {
                hijoMayor = hijoDer;
            }

            if (datos.elemento(hijoMayor).compareTo(datos.elemento(indice)) > 0) {
                swap(indice, hijoMayor);
                indice = hijoMayor;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T vi = datos.elemento(i);
        T vj = datos.elemento(j);
        datos.reemplazarEn(vj, i);
        datos.reemplazarEn(vi, j);
    }

    public void imprimir() {
        for (int i = 1; i <= cantElementos; i++)
            System.out.print(datos.elemento(i) + " ");
        System.out.println();
    }

    public int tamanio() {
        return cantElementos;
    }

}
