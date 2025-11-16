package testPractico6_grafos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.tp01_list.ejercicio2.ListaGenerica;
import com.example.tp06.Arista;
import com.example.tp06.Vertice;
import com.example.tp06.implementacion.GrafoImplListAdy;
import com.example.tp06.implementacion.VerticeImplListAdy;
import com.example.tp06.recorridos.Recorridos;

public class TestGrafos {

    @Test
    public void testGrafoBasico() {
        GrafoImplListAdy<String> grafo = new GrafoImplListAdy<>();

        // Crear 4 vértices
        VerticeImplListAdy<String> a = new VerticeImplListAdy<>("A");
        VerticeImplListAdy<String> b = new VerticeImplListAdy<>("B");
        VerticeImplListAdy<String> c = new VerticeImplListAdy<>("C");
        VerticeImplListAdy<String> d = new VerticeImplListAdy<>("D");

        // Agregar vértices
        grafo.agregarVertice(a);
        grafo.agregarVertice(b);
        grafo.agregarVertice(c);
        grafo.agregarVertice(d);

        // Conexiones (A→B, A→C, B→D, C→D)
        grafo.conectar(a, b, 3);
        grafo.conectar(a, c, 5);
        grafo.conectar(b, d, 2);
        grafo.conectar(c, d, 4);

        // 📍 Verificar adyacencias
        assertTrue(grafo.esAdyacente(a, b));
        assertTrue(grafo.esAdyacente(a, c));
        assertTrue(grafo.esAdyacente(b, d));
        assertFalse(grafo.esAdyacente(b, c));

        // ⚖️ Verificar pesos
        assertEquals(3, grafo.peso(a, b));
        assertEquals(5, grafo.peso(a, c));
        assertEquals(2, grafo.peso(b, d));
        assertEquals(4, grafo.peso(c, d));

        // ❌ Desconectar un vértice
        grafo.desConectar(a, c);
        assertFalse(grafo.esAdyacente(a, c));

        // 🔁 Comprobar lista de adyacentes de A (debería tener solo B)
        var ady = grafo.listaDeAdyacentes(a);
        ady.comenzar();
        Arista<String> arista = ady.proximo();
        assertEquals("B", arista.verticeDestino().dato());
        assertEquals(3, arista.peso());

        // 🧾 Verificar tamaño total
        assertEquals(4, grafo.listaDeVertices().tamanio());
        assertFalse(grafo.esVacio());
    }

    @Test
    public void testRecorridos() {
        GrafoImplListAdy<String> grafo = new GrafoImplListAdy<>();

        VerticeImplListAdy<String> a = new VerticeImplListAdy<>("A");
        VerticeImplListAdy<String> b = new VerticeImplListAdy<>("B");
        VerticeImplListAdy<String> c = new VerticeImplListAdy<>("C");
        VerticeImplListAdy<String> d = new VerticeImplListAdy<>("D");

        grafo.agregarVertice(a);
        grafo.agregarVertice(b);
        grafo.agregarVertice(c);
        grafo.agregarVertice(d);

        grafo.conectar(a, b);
        grafo.conectar(a, c);
        grafo.conectar(b, d);
        grafo.conectar(c, d);

        Recorridos<String> recorridos = new Recorridos<>();

        ListaGenerica<String> dfs = recorridos.dfs(grafo);
        ListaGenerica<Vertice<String>> bfs = recorridos.bfs(grafo);

        assertEquals(List.of("A", "B", "D", "C"), toDatoList(dfs));
        assertEquals(List.of("A", "B", "C", "D"), toDatoListFromVertices(bfs));
    }

    private List<String> toDatoList(ListaGenerica<String> lista) {
        List<String> datos = new ArrayList<>();
        if (lista == null) {
            return datos;
        }
        lista.comenzar();
        while (!lista.fin()) {
            datos.add(lista.proximo());
        }
        return datos;
    }

    private List<String> toDatoListFromVertices(ListaGenerica<Vertice<String>> lista) {
        List<String> datos = new ArrayList<>();
        if (lista == null) {
            return datos;
        }
        lista.comenzar();
        while (!lista.fin()) {
            datos.add(lista.proximo().dato());
        }
        return datos;
    }
}
