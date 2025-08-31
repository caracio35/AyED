package com.example.tp02_arb_gen;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01_list.ejercicio2.ListaGenerica;

public class RecorridosAG {

    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {

        /*
         * Método que retorna una lista con los elementos impares del árbol “a” que sean
         * mayores al valor “n” pasados como parámetros, recorrido en preorden.
         */
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica();
        if (a != null) {
            if (a.getDato() % 2 != 0 && a.getDato() > n) {
                lista.agregarFinal(a.getDato());
            }
            if (a.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    ListaGenerica<Integer> listaHijo = numerosImparesMayoresQuePreOrden(hijos.proximo(), n);
                    listaHijo.comenzar();
                    while (!listaHijo.fin()) {
                        lista.agregarFinal(listaHijo.proximo());
                    }
                }
            }
        }

        return lista;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
        /*
         * Método que retorna una lista con los elementos impares del árbol “a” que sean
         * mayores al valor “n” pasados como parámetros, recorrido en inorden.
         * Solo válido si el árbol tiene como máximo 2 hijos (pseudo binario).
         * public void inorden() {
         * if (tieneHijoIzquierdo)
         * hijoIzquierdo.inorden();
         * imprimir(dato);
         * if (tieneHijoDerecho)
         * hijoDerecho.inorden();
         * }
         */
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();

        if (a != null) {
            if (a.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                if (hijos.tamanio() > 0) {
                    // usar índice 1 para el primer elemento (izquierdo)
                    ArbolGeneral<Integer> hijoIzquierdo = hijos.elemento(1);
                    ListaGenerica<Integer> listaIzq = numerosImparesMayoresQueInOrden(hijoIzquierdo, n);
                    listaIzq.comenzar();
                    while (!listaIzq.fin()) {
                        lista.agregarFinal(listaIzq.proximo());
                    }
                }
            }

            if (a.getDato() % 2 != 0 && a.getDato() > n) {
                lista.agregarFinal(a.getDato());
            }

            if (a.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                if (hijos.tamanio() > 1) {
                    // usar índice 2 para el segundo elemento (derecho)
                    ArbolGeneral<Integer> hijoDerecho = hijos.elemento(2);
                    ListaGenerica<Integer> listaDer = numerosImparesMayoresQueInOrden(hijoDerecho, n);
                    listaDer.comenzar();
                    while (!listaDer.fin()) {
                        lista.agregarFinal(listaDer.proximo());
                    }
                }
            }
        }

        return lista;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
        /*
         * Método que retorna una lista con los elementos impares del árbol “a” que sean
         * mayores al valor “n” pasados como parámetros, recorrido en postorden.
         * public void postOrden() {
         * obtener lista de hijos;
         * mientras (lista tenga datos) {
         * hijo obtenerHijo;
         * hijo.postOrden();
         * }
         * imprimir (dato);
         * }
         */
        ListaGenerica<Integer> res = new ListaEnlazadaGenerica<>();

        if (a == null)
            return res;

        if (a.tieneHijos()) {
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                ArbolGeneral<Integer> h = hijos.proximo();
                ListaGenerica<Integer> listaH = numerosImparesMayoresQuePostOrden(h, n);
                listaH.comenzar();
                while (!listaH.fin()) {
                    res.agregarFinal(listaH.proximo());
                }
            }
        }

        // procesar el nodo después de los hijos (postorden)
        if (a.getDato() % 2 != 0 && a.getDato() > n) {
            res.agregarFinal(a.getDato());
        }

        return res;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {

        /*
         * Método que retorna una lista con los elementos impares del árbol “a” que sean
         * mayores al valor “n” pasados como parámetros, recorrido por niveles.
         * public void porNiveles() {
         * encolar(raíz);
         * mientras cola no se vacíe {
         * v desencolar();
         * imprimir (dato de v);
         * para cada hijo de v
         * encolar(hijo);
         * }
         * }
         */
        return null;
    }

}
