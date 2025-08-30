package testPractico1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.tp01_list.ejercicio3.ColaGenerica;
import com.example.tp01_list.ejercicio3.PilaGenerica;
import com.example.tp01_list.ejercicio4.TestBalanceo;

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

    @Test
    public void testBalanceo() {
        TestBalanceo balanceChecker = new TestBalanceo();

        String s1 = "{()[]}";
        String s2 = "([)]";
        String s3 = "(()";
        // Casos que deberían ser verdaderos (balanceados)
        assertTrue(balanceChecker.estaBalanceado(s1), "La cadena '{()[]}' debería estar balanceada");
        assertTrue(balanceChecker.estaBalanceado(""), "Una cadena vacía debería estar balanceada");
        System.out.println("'" + s2 + "' está balanceado? " + balanceChecker.estaBalanceado(s2)); // Debería ser false
        System.out.println("'" + s3 + "' está balanceado? " + balanceChecker.estaBalanceado(s3)); // Debería ser false
        // Casos que deberían ser falsos (no balanceados)
        assertFalse(balanceChecker.estaBalanceado(s2), "La cadena '([)]' no debería estar balanceada");
        assertFalse(balanceChecker.estaBalanceado(s3), "La cadena '(()' no debería estar balanceada");
        assertFalse(balanceChecker.estaBalanceado("]"), "Una cadena con solo un cierre no debería estar balanceada");
    }

}
