public interface Pila {
    
    /**
     * Indica si la pila es vacía o no.
     */
    boolean isEmpty();
    
    /**
     * Devuelve el número de elementos de la pila.
     */
    int size();

    /**
     * Inserta el objeto dado en el tope de la pila.
     */
    void push(Object obj);

    /**
     * Devuelve y elimina el objeto que se encuentra
     * en el tope de la pila. Null si la pila es vacía.
     * 
     * @return El objeto ubicado en el tope.     
     */
    Object pop();

    /**
     * Devuelve el objeto que se encuentra en el 
     * tope de la pila. Null si la pila es vacía.
     * 
     * @return El objeto ubicado en el tope.     
     */
    Object peek();
    
}
