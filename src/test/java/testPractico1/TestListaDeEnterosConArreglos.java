package testPractico1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.tp01.ejercicio1.ListaDeEnteros;
import com.example.tp01.ejercicio1.ListaDeEnterosConArreglos;

public class TestListaDeEnterosConArreglos {

    @Test
    public void ejercicio1_2() {
        // Creamos la lista y cargamos los elementos usando la API definida
        // (agregarFinal, elemento, tamano), sin usar obtenerElementos()
        ListaDeEnteros lista = new ListaDeEnterosConArreglos();
        int[] numeros = { 1, 2, 3, 4, 5 };

        for (int n : numeros) {
            // según el diagrama, agregarFinal(Integer) existe y devuelve boolean
            // no necesitamos el valor de retorno para esta prueba
            lista.agregarFinal(n);
        }

        // Verificamos tamaño
        assertEquals(5, lista.tamanio());

        // Verificamos cada posición con elemento(i)
        // Usar posiciones desde 1
        for (int i = 1; i <= numeros.length; i++) {
            assertEquals(Integer.valueOf(numeros[i - 1]), lista.elemento(i));
        }
    }
}
