public interface Cola {    

    /**
     * Devuelve un valor logico que indica si la cola tiene elementos o no.
     * 
     * @return true si la cola no tiene elementos y false en caso contrario.
     */
    boolean isEmpty();
    
    /**
     * Devuelve el número de elementos de la cola.     
     */
    int size();

    /**
     * Inserta el objeto dado al fondo de la cola.
     * 
     * @param obj El objeto a insertar.
     */
    void insert(Object obj);
    
    /**
     * Devuelve y elimina el objeto en el frente de la cola.
     * 
     * @return El objeto en el frente. Null si la cola es vacía.
     */
    Object delete();
    
    /**
     * Devuelve el objeto que se encuentra en el frente de la cola.
     * 
     * @return El objeto en el frente. Null si la cola es vacía.
     */
    Object front();

}
