package com.example.tp02_arb_gen;

import com.example.tp01_list.ejercicio2.ListaGenerica;
import com.example.tp01_list.ejercicio3.ColaGenerica;
import com.example.tp01_list.objetos.AreaEmpresa;

public class AnalizadorArbol {

    public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
        int maximoPromedio = -1; // Inicializamos con un valor bajo
        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
        cola.encolar(arbol);
        cola.encolar(null); // Marcador de fin de nivel

        int sumaNivel = 0;
        int contadorNivel = 0;

        while (!cola.esVacia()) {
            ArbolGeneral<AreaEmpresa> nodo = cola.desencolar();

            if (nodo != null) {
                sumaNivel += nodo.getDato().getTardanzaMensaje();
                contadorNivel++;

                if (nodo.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = nodo.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else {
                // Fin de nivel
                if (contadorNivel > 0) {
                    int promedioNivel = sumaNivel / contadorNivel;
                    if (promedioNivel > maximoPromedio) {
                        maximoPromedio = promedioNivel;
                    }
                }

                // Si la cola no está vacía, significa que hay otro nivel
                if (!cola.esVacia()) {
                    cola.encolar(null); // Agregamos un nuevo marcador de fin de nivel
                    sumaNivel = 0;
                    contadorNivel = 0;
                }
            }
        }
        return maximoPromedio;
    }

}
