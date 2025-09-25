import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import com.tp03ab.ArbolBinario;

public class TestPractico3 {
    @Test
    public void testEsHoja() {

    }

    public void testContarHojas() {
    }

    @Test
    public void testEspejo() {
        /* creamos el arbol de pruebas */
        // A
        // / \
        // B C
        // / \ / \
        // D E F G

        ArbolBinario<String> a = new ArbolBinario<>("A");

        ArbolBinario<String> b = new ArbolBinario<>("B");
        ArbolBinario<String> c = new ArbolBinario<>("C");
        a.agregarHijoIzquierdo(b);
        a.agregarHijoDerecho(c);

        ArbolBinario<String> d = new ArbolBinario<>("D");
        ArbolBinario<String> e = new ArbolBinario<>("E");
        ArbolBinario<String> f = new ArbolBinario<>("F");
        ArbolBinario<String> g = new ArbolBinario<>("G");
        b.agregarHijoIzquierdo(d);
        b.agregarHijoDerecho(e);
        c.agregarHijoIzquierdo(f);
        c.agregarHijoDerecho(g);

        ArbolBinario<String> espejo = a.espejo();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        espejo.entreNiveles(0, 2);
        assertEquals("A C B G F E D", outContent.toString().trim());

    }

    @Test
    public void testEntreNiveles() {
        /* creamos el arbol de pruebas */
        // A
        // / \
        // B C
        // / \ / \
        // D E F G
        // / \ / \ / \ / \
        // H I J K L M N O
        // / \
        // P Q

        // Nivel 0
        ArbolBinario<String> a = new ArbolBinario<>("A");

        // Nivel 1
        ArbolBinario<String> b = new ArbolBinario<>("B");
        ArbolBinario<String> c = new ArbolBinario<>("C");
        a.agregarHijoIzquierdo(b);
        a.agregarHijoDerecho(c);

        // Nivel 2
        ArbolBinario<String> d = new ArbolBinario<>("D");
        ArbolBinario<String> e = new ArbolBinario<>("E");
        ArbolBinario<String> f = new ArbolBinario<>("F");
        ArbolBinario<String> g = new ArbolBinario<>("G");
        b.agregarHijoIzquierdo(d);
        b.agregarHijoDerecho(e);
        c.agregarHijoIzquierdo(f);
        c.agregarHijoDerecho(g);

        // Nivel 3
        ArbolBinario<String> h = new ArbolBinario<>("H");
        ArbolBinario<String> i = new ArbolBinario<>("I");
        ArbolBinario<String> j = new ArbolBinario<>("J");
        ArbolBinario<String> k = new ArbolBinario<>("K");
        ArbolBinario<String> l = new ArbolBinario<>("L");
        ArbolBinario<String> m = new ArbolBinario<>("M");
        ArbolBinario<String> n = new ArbolBinario<>("N");
        ArbolBinario<String> o = new ArbolBinario<>("O");

        d.agregarHijoIzquierdo(h);
        d.agregarHijoDerecho(i);
        e.agregarHijoIzquierdo(j);
        e.agregarHijoDerecho(k);
        f.agregarHijoIzquierdo(l);
        f.agregarHijoDerecho(m);
        g.agregarHijoIzquierdo(n);
        g.agregarHijoDerecho(o);

        // Nivel 4
        ArbolBinario<String> p = new ArbolBinario<>("P");
        ArbolBinario<String> q = new ArbolBinario<>("Q");
        h.agregarHijoIzquierdo(p);
        h.agregarHijoDerecho(q);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        a.entreNiveles(2, 3);

        assertEquals("D E F G H I J K L M N O ", outContent.toString());
    }
}
