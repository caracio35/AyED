package testPractico2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01_list.ejercicio2.ListaGenerica;
import com.example.tp02_arb_gen.ArbolGeneral;
import com.example.tp02_arb_gen.RecorridosAG;

public class TestRecArbGenEjer3 {
    @Test
    public void testNumerosImparesMayoresQuePreOrden() {
        ArbolGeneral<Integer> raiz = new ArbolGeneral<>(20);
        // Subárbol izquierdo
        ArbolGeneral<Integer> hijoIzq = new ArbolGeneral<>(11);
        hijoIzq.agregarHijo(new ArbolGeneral<>(7));
        hijoIzq.agregarHijo(new ArbolGeneral<>(15));

        // Subárbol derecho
        ArbolGeneral<Integer> hijoDer = new ArbolGeneral<>(30);
        hijoDer.agregarHijo(new ArbolGeneral<>(25));

        // Nodo 35 y sus hijos
        ArbolGeneral<Integer> nodo35 = new ArbolGeneral<>(35);
        nodo35.agregarHijo(new ArbolGeneral<>(41));
        nodo35.agregarHijo(new ArbolGeneral<>(50));
        nodo35.agregarHijo(new ArbolGeneral<>(60));

        // Agregamos 35 (con sus hijos) al nodo 30
        hijoDer.agregarHijo(nodo35);

        // Agregamos el hijo adicional (12) al nodo 30
        hijoDer.agregarHijo(new ArbolGeneral<>(12));
        // Finalmente, agregamos los hijos izquierdo y derecho a la raíz
        raiz.agregarHijo(hijoIzq);
        raiz.agregarHijo(hijoDer);

        RecorridosAG recorridos = new RecorridosAG();
        ListaGenerica<Integer> resultado = recorridos.numerosImparesMayoresQuePreOrden(raiz, 6);

        // Verificar el resultado esperado
        ListaGenerica<Integer> esperado = new ListaEnlazadaGenerica<>();
        esperado.agregarFinal(11);
        esperado.agregarFinal(7);
        esperado.agregarFinal(15);
        esperado.agregarFinal(25);
        esperado.agregarFinal(35);
        esperado.agregarFinal(41);
        while (!esperado.fin()) {
            assertEquals(esperado.proximo(), resultado.proximo());
        }
    }

    @Test
    public void testNumerosImparesMayoresQueInOrden() {
        // recordar que solo funciona en grado 2pseudo ArbolBinario
        ArbolGeneral<Integer> raiz = new ArbolGeneral<>(21);
        // Subárbol izquierdo
        ArbolGeneral<Integer> hijoIzq = new ArbolGeneral<>(11);
        hijoIzq.agregarHijo(new ArbolGeneral<>(7));
        hijoIzq.agregarHijo(new ArbolGeneral<>(15));
        // Subárbol derecho
        ArbolGeneral<Integer> hijoDer = new ArbolGeneral<>(31);
        hijoDer.agregarHijo(new ArbolGeneral<>(25));
        // Nodo 35 y sus hijos
        ArbolGeneral<Integer> nodo35 = new ArbolGeneral<>(35);
        nodo35.agregarHijo(new ArbolGeneral<>(41));
        nodo35.agregarHijo(new ArbolGeneral<>(50));

        // Agregamos 35 (con sus hijos) al nodo 30
        hijoDer.agregarHijo(nodo35);
        // Finalmente, agregamos los hijos izquierdo y derecho a la raíz
        raiz.agregarHijo(hijoIzq);
        raiz.agregarHijo(hijoDer);

        RecorridosAG recorridos = new RecorridosAG();
        ListaGenerica<Integer> resultado = recorridos.numerosImparesMayoresQueInOrden(raiz, 6);

        // Verificar el resultado esperado
        ListaGenerica<Integer> esperado = new ListaEnlazadaGenerica<>();

        esperado.agregarFinal(7);
        esperado.agregarFinal(11);
        esperado.agregarFinal(15);
        esperado.agregarFinal(21);
        esperado.agregarFinal(25);
        esperado.agregarFinal(31);
        esperado.agregarFinal(41);
        esperado.agregarFinal(35);
        assertEquals(esperado.tamanio(), resultado.tamanio());

        esperado.comenzar();
        resultado.comenzar();

        while (!esperado.fin()) {
            assertEquals(esperado.proximo(), resultado.proximo());
        }
    }

    @Test
    public void testNumerosImparesMayoresQuePostOrden() {
        ArbolGeneral<Integer> raiz = new ArbolGeneral<>(20);
        // Subárbol izquierdo
        ArbolGeneral<Integer> hijoIzq = new ArbolGeneral<>(11);
        hijoIzq.agregarHijo(new ArbolGeneral<>(7));
        hijoIzq.agregarHijo(new ArbolGeneral<>(15));
        // Subárbol derecho
        ArbolGeneral<Integer> hijoDer = new ArbolGeneral<>(30);
        hijoDer.agregarHijo(new ArbolGeneral<>(25));
        // Nodo 35 y sus hijos
        ArbolGeneral<Integer> nodo35 = new ArbolGeneral<>(35);
        nodo35.agregarHijo(new ArbolGeneral<>(41));
        nodo35.agregarHijo(new ArbolGeneral<>(50));
        nodo35.agregarHijo(new ArbolGeneral<>(60));
        // Agregamos 35 (con sus hijos) al nodo 30
        hijoDer.agregarHijo(nodo35);
        // Agregamos el hijo adicional (12) al nodo 30
        hijoDer.agregarHijo(new ArbolGeneral<>(12));
        // Finalmente, agregamos los hijos izquierdo y derecho a la raíz
        raiz.agregarHijo(hijoIzq);
        raiz.agregarHijo(hijoDer);
        RecorridosAG recorridos = new RecorridosAG();
        ListaGenerica<Integer> resultado = recorridos.numerosImparesMayoresQuePostOrden(raiz, 6);
        /*
         * ||||||20
         * ||||/ \
         * ||11 30
         * |/ \ / | \
         * 7 15 |25 35 12
         * |||||||/ | \
         * |||||41 50 60
         */
        // Verificar el resultado esperado
        ListaGenerica<Integer> esperado = new ListaEnlazadaGenerica<>();
        esperado.agregarFinal(7);
        esperado.agregarFinal(15);
        esperado.agregarFinal(11);
        esperado.agregarFinal(25);
        esperado.agregarFinal(41);
        esperado.agregarFinal(35);

        assertEquals(esperado.tamanio(), resultado.tamanio());
        esperado.comenzar();
        resultado.comenzar();

        while (!esperado.fin()) {
            assertEquals(esperado.proximo(), resultado.proximo());
        }
    }

}
