package com.example.tp06.implementacion;

import com.example.tp06.Arista;
import com.example.tp06.Vertice;

public class AristaImpl<T> implements Arista<T> {
    private Vertice<T> destino;
    private int peso;

    public AristaImpl(Vertice<T> destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice<T> verticeDestino() {
        return destino;
    }

    public int peso() {
        return peso;
    }
}