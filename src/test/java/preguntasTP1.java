public @interface preguntasTP1 {
    /*
     * Estructura interna:
     * Con arreglos usa un array fijo de tamaño 30 para almacenar los elementos.
     * Enlazada usa nodos enlazados dinámicamente, sin límite fijo de tamaño (más
     * allá de la memoria disponible).
     * Inserción y eliminación:
     * Con arreglos insertar o eliminar en posiciones intermedias requiere mover
     * elementos en el array, lo que puede ser costoso si la lista es grande.
     * Enlazada solo requiere cambiar referencias entre nodos, lo que suele ser más
     * eficiente para estas operaciones.
     * Tamaño máximo:
     * 
     * Con arreglos está limitado por el tamaño del array (30 elementos).
     * Enlazada puede crecer dinámicamente.
     * Acceso por posición:
     * 
     * Con arreglos el acceso es inmediato (O(1)), ya que se usa el índice del
     * array.
     * Enlazada el acceso es secuencial (O(n)), ya que hay que recorrer los nodos
     * hasta la posición deseada.
     * //////////////////////////////////////////////////////////////////////////
     * 2.4. Analice las implementaciones de la clase ListaGenerica<T> y sus
     * subclases,luego responda:
     * 
     * Algoritmos y Estructuras de Datos – Cursada 2025
     * a) ¿Qué diferencia observa entre las implementaciones de
     * ListaEnlazadaGenerica y ListaDeEnterosEnlazada?
     * ** la version generica es reutilizable para cualquier tipo de dato mientras
     * que la generica solo sirve para tipo integer
     * 
     * b) ¿Cómo se define el nodo genérico? ¿Cómo se crea una instancia del mismo?
     * el nodoGenerico <t> se define con un campo de dato que usa el parametro de
     * tipo generico <t> eto permite que tenga datos de cualquier tipo
     * para crer una instancia del mismo debes espesificar el tipo de dato con el
     * que lo quieres crear por egemplo este caso donde se crea nodo de estudiante
     * aunque en el egercicio no esta de esta manera internamente lo tomaria como si
     * fuera asi:
     * 23"NodoGenerico<Estudiante> miNodoEstudiante = new NodoGenerico<>();"
     * 
     * c) ¿Qué devuelve el método elemento() de la lista?
     * retorna el elemento ubicado en esa pos de la lista indicado (el tipo de dato
     * depende de cual fue indicado ej en la practica fue de tipo estudiante )
     * 
     * d) ¿Cómo agregaría un método nuevo? Implemente un nuevo método de la lista
     * que se llama agregar(T[]):boolean. El mismo debe agregar todos los elementos
     * del arreglo que recibe como parámetro y retornar true si todos ellos fueron
     * agregados.
     * Para añadir un nuevo método llamado agregar(T[]): boolean a la clase
     * ListaGenerica<T>, se debe agregar la firma del método a la definición de la
     * clase. Este método se implementaría luego en sus subclases, como
     * ListaEnlazadaGenerica<T>. La implementación debe iterar a través del arreglo
     * que se recibe como parámetro y añadir cada elemento a la lista. El método
     * debe retornar true si todos los elementos fueron agregados exitosamente.
     */

}
