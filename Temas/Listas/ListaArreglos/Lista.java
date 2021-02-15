public interface Lista {

    /**
     * Devuelve un valor lógico que indica si la lista
     * tiene elementos o no. 
     */
    boolean isEmpty();
    
    /**
     * Devuelve el número de elementos de la lista.
     */
    int size();    
    
    /**
     * Devuelve el objeto que se encuentra en la posición
     * i-ésima de la lista.     
     */
    Object get(int i) throws IndexOutOfBoundsException;  
    
    /**
     * Inserta el objeto obj en la i-ésima posición de la lista.
     */
    void add(int i, Object obj) throws IndexOutOfBoundsException;
    
    /**
     * Sustituye el objeto en la i-ésima posición de la lista por el objeto obj
     * y regresa el objeto sustituido.
     */
    Object set(int i, Object obj) throws IndexOutOfBoundsException;
    
    /**
     * Elimina y devuelve el elemento ubicado en la i-ésima posición de la lista.     
     */
    Object remove(int i) throws IndexOutOfBoundsException;  
    
}
