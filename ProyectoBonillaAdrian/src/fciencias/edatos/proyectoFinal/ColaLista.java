package fciencias.edatos.proyectoFinal;

/**
 * Proyecto Final: Comunicaciones telefónicas
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación incluye material brindado por:
 * Emmanuel Cruz Hernández 
 * @version 1.0
 */
public class ColaLista <T>{
    
    private final ListaLigada<T> lista;

    /** Construye una cola sin elementos. */
    public ColaLista() {
        lista = new ListaLigada();
    }

    /**
     * Devuelve un valor logico que indica si la cola tiene elementos o no.
     * @return true si la cola no tiene elementos y false en caso contrario.
     */
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    
    /** Devuelve el número de elementos de la cola.*/
    public int size() {
        return lista.size();
    }    

    /**
     * Inserta el objeto dado al fondo de la cola.
     * @param obj El objeto a insertar.
     */
    public void insert(T obj) {
        lista.add(lista.size(), obj);
    }    

    /**
     * Devuelve y elimina el objeto en el frente de la cola.
     * @return El objeto en el frente. Null si la cola es vacía.
     */
    public T delete() {
        if (isEmpty()) {
            return null;
        }        
        T frente = lista.get(0);
        lista.remove(0);
        return frente;        
    }

    /**
     * Devuelve el objeto que se encuentra en el frente de la cola.
     * @return El objeto en el frente. Null si la cola es vacía.
     */
    public T front() {
        return isEmpty()?  null : lista.get(0);        
    }    
}
