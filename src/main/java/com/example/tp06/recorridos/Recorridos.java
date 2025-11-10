package com.example.tp06.recorridos;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01_list.ejercicio2.ListaGenerica;
import com.example.tp01_list.ejercicio3.ColaGenerica;
import com.example.tp06.Arista;
import com.example.tp06.Grafo;
import com.example.tp06.Vertice;

public class Recorridos<T> {

    // 🔹 Recorrido en profundidad (DFS)
    public ListaGenerica<T> dfs(Grafo<T> grafo) {
        ListaGenerica<T> resultado = new ListaEnlazadaGenerica<>();
        boolean[] visitado = new boolean[grafo.listaDeVertices().tamanio() + 1];

        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
        vertices.comenzar();

        while (!vertices.fin()) {
            Vertice<T> v = vertices.proximo();
            if (!visitado[v.getPosicion()]) {
                dfsRecursivo(grafo, v, visitado, resultado);
            }
        }
        return resultado;
    }

    private void dfsRecursivo(Grafo<T> grafo, Vertice<T> v, boolean[] visitado, ListaGenerica<T> resultado) {
        visitado[v.getPosicion()] = true;
        resultado.agregarFinal(v.dato());

        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<T> arista = ady.proximo();
            Vertice<T> destino = arista.verticeDestino();
            if (!visitado[destino.getPosicion()]) {
                dfsRecursivo(grafo, destino, visitado, resultado);
            }
        }
    }

    // 🔹 Recorrido en amplitud (BFS)
    public ListaGenerica<T> bfs(Grafo<T> grafo) {
        ListaGenerica<T> resultado = new ListaEnlazadaGenerica<>();
        boolean[] visitado = new boolean[grafo.listaDeVertices().tamanio() + 1];
        ColaGenerica<Vertice<T>> cola = new ColaGenerica<>();

        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
        vertices.comenzar();

        while (!vertices.fin()) {
            Vertice<T> v = vertices.proximo();
            if (!visitado[v.getPosicion()]) {
                bfsDesde(grafo, v, visitado, resultado, cola);
            }
        }
        return resultado;
    }

    private void bfsDesde(Grafo<T> grafo, Vertice<T> v, boolean[] visitado,
            ListaGenerica<T> resultado, ColaGenerica<Vertice<T>> cola) {

        cola.encolar(v);
        visitado[v.getPosicion()] = true;

        while (!cola.esVacia()) {
            Vertice<T> actual = cola.desencolar();
            resultado.agregarFinal(actual.dato());

            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(actual);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> arista = ady.proximo();
                Vertice<T> destino = arista.verticeDestino();
                if (!visitado[destino.getPosicion()]) {
                    cola.encolar(destino);
                    visitado[destino.getPosicion()] = true;
                }
            }
        }
    }
}