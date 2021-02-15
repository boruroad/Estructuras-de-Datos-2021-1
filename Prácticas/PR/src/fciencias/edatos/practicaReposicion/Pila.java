package fciencias.edatos.practicaReposicion;

/**
 * Práctica de Reposición: Pilas.
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación no es mia en su totalidad 
 * Créditos: Emmanuel Cruz Hernández
 * @version 1.0
 */

public interface Pila {

    
    /** Indica si la pila es vacía o no. */
    boolean isEmpty();
    
    /** Devuelve el número de elementos de la pila. */
    int size();

    /** Inserta el objeto dado en el tope de la pila. */
    void push(Object obj);

    /**
     * Devuelve y elimina el objeto que se encuentra
     * en el tope de la pila. Null si la pila es vacía.
     * @return El objeto ubicado en el tope.     
     */
    Object pop();

    /**
     * Devuelve el objeto que se encuentra en el 
     * tope de la pila. Null si la pila es vacía.
     * @return El objeto ubicado en el tope.     
     */
    Object peek();
    
}
