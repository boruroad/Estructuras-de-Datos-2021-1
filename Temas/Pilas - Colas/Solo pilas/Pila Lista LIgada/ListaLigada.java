public class ListaLigada implements Lista {
    
    //cabeza de la lista
    private Nodo head; 
    
    private int numeroElementos;   
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public int size() {
        return numeroElementos;
    }    
    
    /*
     * Devuelve el nodo en la posición i.
     * Precondición: 0 <= i <= numeroElementos - 1
     */    
    private Nodo find(int i){
        Nodo actual = head;
        int posicion = 0;
        while (posicion < i) {
            actual = actual.daSiguiente();
            posicion++;
        }
        return actual;
    }   
    
    @Override
    public Object get(int i) throws IndexOutOfBoundsException {
        if (numeroElementos == 0) {
            throw new IndexOutOfBoundsException("Indice inválido. Lista vacía.");
        }
        
        if (i < 0 || i > numeroElementos - 1) {
            throw new IndexOutOfBoundsException("Indice inválido");
        }

        Nodo actual = find(i);
        return actual.daElemento();        
    }    
    
     @Override
     public Object set(int i, Object obj) throws IndexOutOfBoundsException {
         if (numeroElementos == 0) {
            throw new IndexOutOfBoundsException("Indice inválido. Lista vacía.");
        }
        
        if (i < 0 || i > numeroElementos - 1) {
            throw new IndexOutOfBoundsException("Indice inválido");
        }
        
        Nodo actual = find(i);
        Object temp = actual.daElemento();
        actual.cambiaElemento(obj);
        return temp;
     }
    
    @Override
    public void add(int i, Object obj) throws IndexOutOfBoundsException {
        if (i < 0 || i > numeroElementos) {
            throw new IndexOutOfBoundsException("Indice inválido");
        }
        if (i == 0) {
            Nodo nuevo = new Nodo(obj);
            nuevo.cambiaSiguiente(head);            
            head = nuevo;
        } else {
            Nodo previo = find(i-1);
            Nodo nuevo = new Nodo(obj);
            nuevo.cambiaSiguiente(previo.daSiguiente());
            previo.cambiaSiguiente(nuevo);
        }
        numeroElementos++;       	
    }
    
    @Override
    public Object remove(int i) throws IndexOutOfBoundsException{
        if (numeroElementos == 0) {
            throw new IndexOutOfBoundsException("Indice inválido. Lista vacía");
        }
        
        if (i < 0 || i > numeroElementos - 1) {
            throw new IndexOutOfBoundsException("Indice inválido");
        }
        
        Object temp;
        if (i == 0) {
            temp = head.daElemento();
            head = head.daSiguiente();
        } else {
            Nodo previo = find(i-1);            
            Nodo actual = previo.daSiguiente();
            temp = actual.daElemento();
            previo.cambiaSiguiente(actual.daSiguiente());
        }
        numeroElementos--;
        return temp;
    }   
    
   /*
    * Clase que representa un nodo de una lista
    * ligada.
    */
    private class Nodo {
        
        private Object elemento;
        
        private Nodo siguiente;
        
        /**
         * Construye un nodo con un objeto
         * y referencia nula al siguiente elemento.
         * 
         * @param e El contenido del nodo.          
         */
        public Nodo(Object e) {
            elemento = e;
        }        
        
        /**
         * Establece el nuevo contenido del nodo.
         */
        public void cambiaElemento(Object nuevo) {
            elemento = nuevo;
        }
        
        /**
         * Devuelve el contenido del nodo.
         */
        public Object daElemento() {
            return elemento;
        }
        
        /**
         * Establece una nueva referencia al
         * nodo siguiente.
         */
        public void cambiaSiguiente(Nodo sig){
            siguiente = sig;
        }
        
        /**
         * Devuelve la referencia al siguiente
         * nodo.
         */
        public Nodo daSiguiente() {
            return siguiente;
        }        
    }
    
}
