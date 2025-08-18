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

        // Método recursivo usando la API existente
        imprimirInversoRec(lista, 1);

        System.setOut(System.out); // Restauramos salida estándar

        String resultado = out.toString().trim();
        assertEquals("5 4 3 2 1", resultado);
        imprimirInversoRec(lista, 1);
    }

    // Método recursivo auxiliar dentro del test
    private void imprimirInversoRec(ListaDeEnteros lista, int pos) {
        if (pos > lista.tamanio())
            return;
        imprimirInversoRec(lista, pos + 1);
        System.out.print(lista.elemento(pos) + " ");
    }
}
