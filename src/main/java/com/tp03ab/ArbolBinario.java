package com.tp03ab;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * 
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public int contarHojas() {
		int cantHojas = 0;

		return cantHojas;
	}

	public ArbolBinario<T> espejo() {
		if (this.esVacio()) {
			return null;
		}
		ArbolBinario<T> arbolEspejo = new ArbolBinario<>(this.getDato());
		if (this.tieneHijoIzquierdo()) {
			arbolEspejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		}
		if (this.tieneHijoDerecho()) {
			arbolEspejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		}
		return arbolEspejo;
	}

	public void entreNiveles(int n, int m) {
		if (this.esVacio())
			return;

		Queue<ArbolBinario<T>> cola = new LinkedList<>();
		Queue<ArbolBinario<T>> colaAux = new LinkedList<>();
		int nivel = 0;

		cola.add(this);

		while (!cola.isEmpty() && nivel <= m) {
			while (!cola.isEmpty()) {
				ArbolBinario<T> nodo = cola.remove();

				// Imprimir solo si estamos en el rango [n, m]
				if (nivel >= n) {
					System.out.print(nodo.getDato() + " ");
				}

				// Encolar hijos si existen
				if (nodo.tieneHijoIzquierdo()) {
					colaAux.add(nodo.getHijoIzquierdo());
				}
				if (nodo.tieneHijoDerecho()) {
					colaAux.add(nodo.getHijoDerecho());
				}
			}

			// Avanzar de nivel
			cola = colaAux;
			colaAux = new LinkedList<>();
			nivel++;
		}
	}

}
