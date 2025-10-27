package com.example.tp05_heap;

public interface ColaPrioridades<T extends Comparable<T>> {

    boolean esVacia();

    T eliminar(); // elimina y devuelve el elemento con mayor o menor prioridad

    boolean agregar(T dato); // inserta un nuevo elemento respetando la prioridad

    T tope(); // devuelve el elemento con mayor o menor prioridad sin eliminarlo
}