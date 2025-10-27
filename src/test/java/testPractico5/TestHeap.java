package testPractico5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp05_heap.MaxHeap;
import com.example.tp05_heap.MinHeap;

public class TestHeap {
    private MaxHeap<Integer> maxHeap;
    private MinHeap<Integer> minHeap;

    @BeforeEach
    void setUp() {
        maxHeap = new MaxHeap<>();
        minHeap = new MinHeap<>();
    }

    @Test
    void testAgregarYTope_MaxHeap() {
        maxHeap.agregar(5);
        maxHeap.agregar(10);
        maxHeap.agregar(3);

        // En MaxHeap, el tope debe ser el máximo
        assertEquals(10, maxHeap.tope());
    }

    @Test
    void testAgregarYTope_MinHeap() {
        minHeap.agregar(5);
        minHeap.agregar(10);
        minHeap.agregar(3);

        // En MinHeap, el tope debe ser el mínimo
        assertEquals(3, minHeap.tope());
    }

    @Test
    void testEliminar_MaxHeap() {
        maxHeap.agregar(4);
        maxHeap.agregar(7);
        maxHeap.agregar(2);

        assertEquals(7, maxHeap.eliminar()); // primero sale el máximo
        assertEquals(4, maxHeap.tope()); // ahora el siguiente máximo
        assertEquals(4, maxHeap.eliminar()); // último
    }

    @Test
    void testEliminar_MinHeap() {
        minHeap.agregar(4);
        minHeap.agregar(7);
        minHeap.agregar(2);

        assertEquals(2, minHeap.eliminar()); // primero sale el mínimo
        assertEquals(4, minHeap.tope()); // siguiente mínimo
        assertEquals(4, minHeap.eliminar()); // último
    }

    @Test
    void testHeapVacia() {
        assertTrue(maxHeap.esVacia());
        maxHeap.agregar(5);
        assertFalse(maxHeap.esVacia());
        maxHeap.eliminar();
        assertTrue(maxHeap.esVacia());
    }

    @Test
    void testIntegracion_MaxYMin() {
        int[] valores = { 15, 8, 22, 3, 10 };

        for (int v : valores) {
            maxHeap.agregar(v);
            minHeap.agregar(v);
        }

        // Validar que el tope sea correcto para ambas
        assertEquals(22, maxHeap.tope());
        assertEquals(3, minHeap.tope());

        // Eliminar y validar orden de salida
        assertEquals(22, maxHeap.eliminar());
        assertEquals(15, maxHeap.eliminar());
        assertEquals(10, maxHeap.eliminar());

        assertEquals(3, minHeap.eliminar());
        assertEquals(8, minHeap.eliminar());
        assertEquals(10, minHeap.eliminar());
    }

    @Test
    void testHeapDesdeListaInicial() {
        ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        lista.agregarFinal(4);
        lista.agregarFinal(2);
        lista.agregarFinal(9);

        MaxHeap<Integer> heapConLista = new MaxHeap<>(lista);

        // Dependiendo del orden interno, debería mantener la propiedad de heap
        assertEquals(3, heapConLista.tamanio());
        assertEquals(9, heapConLista.tope());
    }
}