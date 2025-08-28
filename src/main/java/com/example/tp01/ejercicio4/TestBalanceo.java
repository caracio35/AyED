package com.example.tp01.ejercicio4;

import com.example.tp01.ejercicio3.PilaGenerica;

/**
 * Clase para verificar si un String de caracteres (), [], {} está balanceado.
 */
public class TestBalanceo {

    /**
     * Método que determina si un String dado está balanceado.
     * 
     * @param s El String a verificar.
     * @return true si el String está balanceado, false en caso contrario.
     */
    public boolean estaBalanceado(String s) {
        // Usamos la PilaGenerica para almacenar los caracteres de apertura.
        PilaGenerica<Character> pila = new PilaGenerica<>();

        // El problema define que un string vacío está balanceado.
        if (s == null || s.isEmpty()) {
            return true;
        }

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // Si es un caracter de apertura, lo apilamos.
                pila.apilar(c);
            } else if (c == ')' || c == ']' || c == '}') {
                // Si es un caracter de cierre, verificamos.
                // Si la pila está vacía, hay un cierre sin apertura. No está balanceado.
                if (pila.esVacia()) {
                    return false;
                }

                char apertura = pila.desapilar();
                // Si el cierre no corresponde con la última apertura, no está balanceado.
                if ((c == ')' && apertura != '(') || (c == ']' && apertura != '[') || (c == '}' && apertura != '{')) {
                    return false;
                }
            }
        }

        // Si al final la pila está vacía, todos los símbolos se cerraron correctamente.
        return pila.esVacia();
    }
}