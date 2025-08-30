package testPractico1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.tp01_list.ejercicio2.ListaEnlazadaGenerica;
import com.example.tp01_list.ejercicio2.ListaGenerica;
import com.example.tp01_list.objetos.Estudiante;

public class TestListaEnlazadaGenerica {
    @Test
    public void testAgregarYVerificarEnteros() {
        // 1. Arrange: Crear la lista y agregar elementos
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();

        for (int i = 1; i <= 5; i++) {
            lista.agregarFinal(i);
        }
        lista.agregarFinal(5); // La lista ahora es [1, 2, 3, 4, 5, 5]

        // 2. Act & Assert: Verificar el tamaño y cada elemento en su posición
        assertEquals(6, lista.tamanio());
        assertEquals(Integer.valueOf(1), lista.elemento(1));
        assertEquals(Integer.valueOf(2), lista.elemento(2));
        assertEquals(Integer.valueOf(3), lista.elemento(3));
        assertEquals(Integer.valueOf(4), lista.elemento(4));
        assertEquals(Integer.valueOf(5), lista.elemento(5));
        assertEquals(Integer.valueOf(5), lista.elemento(6)); // Verificar el último elemento
    }

    @Test
    public void testAgregarListEstudiante() {
        ListaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<>();
        for (int i = 1; i <= 5; i++) {
            Estudiante estudiante = new Estudiante("estudiante" + i, "apellido" + i, "carrera" + i * i);
            lista.agregarFinal(estudiante);
        }

    }

    @Test
    public void testAgregarYVerificarEstudiantes() {
        // 1. Se crean 4 objetos de tipo Estudiante
        // Asumo que la clase Estudiante tiene un constructor como:
        // public Estudiante(String nombre, String apellido, String legajo)
        // Y un método tusDatos() o toString() que devuelve un formato como "Apellido:
        // ..., Nombre: ..., Legajo: ..."
        Estudiante e1 = new Estudiante("Ana", "Gomez", "115-20");
        Estudiante e2 = new Estudiante("Bernardo", "Perez", "116-21");
        Estudiante e3 = new Estudiante("Clara", "Garcia", "117-22");
        Estudiante e4 = new Estudiante("David", "Martinez", "118-23");

        ListaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<>();

        // 2. Se agregan a la lista usando diferentes métodos
        lista.agregarInicio(e3); // Lista ahora es: [e3]
        lista.agregarFinal(e4); // Lista ahora es: [e3, e4]
        lista.agregarInicio(e1); // Lista ahora es: [e1, e3, e4]
        lista.agregarEn(e2, 2); // Lista ahora es: [e1, e2, e3, e4] (asumiendo índice base 1)

        // 3. Se comprueba que el tamaño es correcto y que cada elemento está en la
        // posición esperada.
        // Esta forma es más robusta que comparar un String largo.
        // NOTA: Para que esto funcione correctamente, la clase Estudiante debe tener
        // un método equals() bien implementado (por ejemplo, que compare por legajo).
        assertEquals(4, lista.tamanio());
        assertEquals(e1, lista.elemento(1));
        assertEquals(e2, lista.elemento(2));
        assertEquals(e3, lista.elemento(3));
        assertEquals(e4, lista.elemento(4));
    }

    @Test
    public void testAgregarArregloEstudiantes() {
        // 1. Arrange: Crear la lista y el arreglo de estudiantes
        ListaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<>();
        Estudiante[] lEstudiante = new Estudiante[5]; // Notación preferida para declarar arreglos
        for (int i = 0; i < 5; i++) {
            // Corregimos el bucle para usar índices de 0 a 4
            lEstudiante[i] = new Estudiante("estudiante" + (i + 1), "apellido" + (i + 1),
                    "carrera" + (i + 1) * (i + 1));
        }
        // 2. Act: Agregar el arreglo a la lista
        boolean resultado = lista.agregar(lEstudiante);

        // 3. Assert: Verificar que la operación fue exitosa y que los datos son
        // correctos
        assertTrue(resultado, "El método agregar() debería devolver true");
        assertEquals(5, lista.tamanio(), "La lista debería tener 5 elementos después de agregar el arreglo");

        // Opcional pero recomendado: Verificar que cada estudiante está en la posición
        // correcta.
        // NOTA: Para que esto funcione, la clase Estudiante debe tener un método
        // equals() bien implementado.
        for (int i = 0; i < 5; i++) {
            assertEquals(lEstudiante[i], lista.elemento(i + 1),
                    "El elemento en la posición " + (i + 1) + " no es el esperado.");
        }
    }
}
