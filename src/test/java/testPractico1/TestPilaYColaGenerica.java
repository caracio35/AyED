package testPractico1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.tp01.ejercicio3.ColaGenerica;
import com.example.tp01.ejercicio3.PilaGenerica;

public class TestPilaYColaGenerica {
    @Test
    void testPilaYCola() {
        PilaGenerica<Integer> pila = new PilaGenerica<>();
        ColaGenerica<Integer> cola = new ColaGenerica<>();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        assertEquals(pila.tope(), 3);
        for (int i = 3; i > 0; i--) {
            assertEquals(pila.desapilar(), i);
        }
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        for (int i = 1; i < 4; i++) {
            assertEquals(cola.desencolar(), i);
        }
        assertTrue(pila.esVacia());
        assertTrue(cola.esVacia());

    }

}
