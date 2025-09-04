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
        ListaGenerica<Integer> res = new ListaEnlazadaGenerica<>();
        if (a == null)
            return res;

        if (a.tieneHijos()) {
            // Procesar primer hijo
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            ListaGenerica<Integer> lPrimero = numerosImparesMayoresQueInOrden(hijos.proximo(), n);
            lPrimero.comenzar();
            while (!lPrimero.fin()) {
                res.agregarFinal(lPrimero.proximo());
            }
        }

        // Procesar nodo actual
        if (a.getDato() % 2 != 0 && a.getDato() > n) {
            res.agregarFinal(a.getDato());
        }

        if (a.tieneHijos()) {
            // Procesar resto de hijos
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            hijos.proximo(); // Saltamos el primer hijo que ya procesamos
            while (!hijos.fin()) {
                ListaGenerica<Integer> lResto = numerosImparesMayoresQueInOrden(hijos.proximo(), n);
                lResto.comenzar();
                while (!lResto.fin()) {
                    res.agregarFinal(lResto.proximo());
                }
            }
        }

        return res;
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
