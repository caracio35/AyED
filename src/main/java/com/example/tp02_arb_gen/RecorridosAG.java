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
         */
        // solo se podria en arboles de grado dos (pseudo AB)saliendo de ahi no se
        // podria
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica();
        if (a != null) {
            if (a.getDato() % 2 != 0 && a.getDato() > n) {
                lista.agregarFinal(a.getDato());
            }
            if (a.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    ListaGenerica<Integer> listaHijo = numerosImparesMayoresQueInOrden(hijos.proximo(), n);
                    listaHijo.comenzar();
                    while (!listaHijo.fin()) {
                        lista.agregarFinal(listaHijo.proximo());
                    }
                }
            }
        }

        return lista;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
        /*
         * Método que retorna una lista con los elementos impares del árbol “a” que sean
         * mayores al valor “n” pasados como parámetros recorrido en postorden.
         */
        return null;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {

        /*
         * Método que retorna una lista con los elementos impares del árbol “a” que sean
         * mayores al valor “n” pasados como parámetros, recorrido por niveles.
         */
        return null;
    }

}
