package testPractico1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.tp01.ejercicio1.ListaDeEnteros;
import com.example.tp01.ejercicio1.ListaDeEnterosEnlazada;

public class TestListaDeEnterosEnlazada {

    @Test
    public void ejercicio1_3() {
        ListaDeEnteros lista = new ListaDeEnterosEnlazada();
        int[] numeros = { 1, 2, 3, 4, 5 };

        for (int num : numeros) {
            lista.agregarFinal(num);
        }

        assertEquals(5, lista.tamanio());

        lista.comenzar();
        for (int num : numeros) {
            assertFalse(lista.fin());
            assertEquals(num, lista.proximo());
        }
        assertTrue(lista.fin());
    }

    @Test
    public void ejercicio1_5() {
        ListaDeEnteros lista = new ListaDeEnterosEnlazada();
        int[] numeros = { 1, 2, 3, 4, 5 };
        for (int n : numeros) {
            lista.agregarFinal(n);
        }

        // Capturamos la salida estándar
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Método recursivo usando comenzar/proximo/fin
        imprimirInversoRec(lista);

        System.setOut(System.out); // Restauramos salida estándar

        String resultado = out.toString().trim();
        assertEquals("5 4 3 2 1", resultado);
        imprimirInversoRec(lista);
    }

    // Método recursivo auxiliar dentro del test usando proximo()
    private void imprimirInversoRec(ListaDeEnteros lista) {
        lista.comenzar();
        imprimirInversoRecAux(lista);
    }

    private void imprimirInversoRecAux(ListaDeEnteros lista) {
        if (lista.fin())
            return;
        Integer v = lista.proximo();
        imprimirInversoRecAux(lista);
        System.out.print(v + " ");
    }
}
