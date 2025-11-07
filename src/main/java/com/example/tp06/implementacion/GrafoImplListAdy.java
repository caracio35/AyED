package com.example.tp06.implementacion;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01_list.ejercicio2.ListaGenerica;
import com.example.tp06.Arista;
import com.example.tp06.Grafo;
import com.example.tp06.Vertice;

public class GrafoImplListAdy<T> implements Grafo<T> {

    private ListaGenerica<Vertice<T>> vertices = new ListaEnlazadaGenerica<>();
    private ListaGenerica<ListaGenerica<Arista<T>>> adys = new ListaEnlazadaGenerica<>();

    public void agregarVertice(Vertice<T> v) {
        // seteo posición (1..n) siguiendo la convención de la ListaGenerica
        int pos = vertices.tamanio() + 1;
        if (v instanceof VerticeImplListAdy) {
            ((VerticeImplListAdy<T>) v).setPosicion(pos);
        }
        vertices.agregarFinal(v);
        adys.agregarFinal(new ListaEnlazadaGenerica<Arista<T>>());
    }

    public void eliminarVertice(Vertice<T> v) {
        int i = v.getPosicion(); // 1..n
        if (i <= 0 || i > vertices.tamanio())
            return;

        // 1) quitar aristas entrantes hacia v
        adys.comenzar();
        for (int fila = 1; fila <= adys.tamanio(); fila++) {
            ListaGenerica<Arista<T>> lista = adys.elemento(fila);
            eliminarAristaHacia(lista, v);
        }

        // 2) quitar su lista de adyacentes (aristas salientes)
        adys.eliminarEn(i);

        // 3) quitar vértice y reindexar posiciones posteriores
        vertices.eliminarEn(i);
        // reindexar
        vertices.comenzar();
        for (int pos = 1; pos <= vertices.tamanio(); pos++) {
            Vertice<T> vx = vertices.elemento(pos);
            if (vx instanceof VerticeImplListAdy)
                ((VerticeImplListAdy<T>) vx).setPosicion(pos);
        }
    }

    private void eliminarAristaHacia(ListaGenerica<Arista<T>> lista, Vertice<T> destino) {
        // remover todas las aristas cuyo destino == destino
        ListaGenerica<Arista<T>> aBorrar = new ListaEnlazadaGenerica<>();
        lista.comenzar();
        while (!lista.fin()) {
            Arista<T> a = lista.proximo();
            if (a.verticeDestino().equals(destino))
                aBorrar.agregarFinal(a);
        }
        aBorrar.comenzar();
        while (!aBorrar.fin())
            lista.eliminar(aBorrar.proximo());
    }

    public void conectar(Vertice<T> v1, Vertice<T> v2) {
        conectar(v1, v2, 1);
    }

    public void conectar(Vertice<T> v1, Vertice<T> v2, int peso) {
        ListaGenerica<Arista<T>> lista = adys.elemento(v1.getPosicion());
        // evitar duplicados
        if (!esAdyacente(v1, v2)) {
            lista.agregarFinal(new AristaImpl<T>(v2, peso));
        }
    }

    public void desConectar(Vertice<T> v1, Vertice<T> v2) {
        ListaGenerica<Arista<T>> lista = adys.elemento(v1.getPosicion());
        eliminarAristaHacia(lista, v2);
    }

    public boolean esAdyacente(Vertice<T> v1, Vertice<T> v2) {
        ListaGenerica<Arista<T>> lista = adys.elemento(v1.getPosicion());
        lista.comenzar();
        while (!lista.fin()) {
            Arista<T> a = lista.proximo();
            if (a.verticeDestino().equals(v2))
                return true;
        }
        return false;
    }

    public boolean esVacio() {
        return vertices.esVacia();
    }

    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return vertices;
    }

    public int peso(Vertice<T> v1, Vertice<T> v2) {
        ListaGenerica<Arista<T>> lista = adys.elemento(v1.getPosicion());
        lista.comenzar();
        while (!lista.fin()) {
            Arista<T> a = lista.proximo();
            if (a.verticeDestino().equals(v2))
                return a.peso();
        }
        return 0; // o -1 si prefieren "inexistente"; ajustá según consigna
    }

    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        return adys.elemento(v.getPosicion());
    }

    public Vertice<T> vertice(int pos) {
        if (pos <= 0 || pos > vertices.tamanio())
            return null;
        return vertices.elemento(pos);
    }

    @Override
    public Vertice<T> vetice(int posicion) {
        return vertice(posicion);

    }
}