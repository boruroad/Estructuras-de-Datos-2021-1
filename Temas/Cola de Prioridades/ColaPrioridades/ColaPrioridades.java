public interface ColaPrioridades {
    
    /**
     * Indica si la cola de prioridades
     * está vacía.
     */
    boolean isEmpty();
    
    /**
     * Devuelve el numero de pares (Elemento, Clave) 
     * existentes en la cola de prioridades.    
     */   
    int size();
    
    /**
     * Inserta una entrada comparable en la cola de prioridades.
     */
    void insert(ComparableEntry e);
    
    /**
     * Devuelve la entrada comparable que contiene la clave minima
     * en la cola de prioridades.
     */
    ComparableEntry min();
    
    /**
     * Devuelve y elimina de la cola de prioridades la entrada comparable 
     * que contiene la clave minima.
     */
    ComparableEntry removeMin();
}
