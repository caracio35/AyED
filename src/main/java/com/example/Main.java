package com.example;

import com.example.tp01.ejercicio1.ListaDeEnteros;
import com.example.tp01.ejercicio1.ListaDeEnterosEnlazada;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        ListaDeEnteros lista = new ListaDeEnterosEnlazada();
        int[] numeros = { 1, 2, 3, 4, 5 };
        for (int n : numeros) {
            lista.agregarFinal(n);
        }

        // Capturamos la salida estándar

        // Método recursivo usando la API existente
        imprimirInversoRec(lista, 1);
        // System.out.println("\n");

    }

    // Método recursivo auxiliar dentro del test
    private static void imprimirInversoRec(ListaDeEnteros lista, int pos) {
        if (pos > lista.tamanio())
            return;
        imprimirInversoRec(lista, pos + 1);
        System.out.print(lista.elemento(pos) + " ");
    }
}
