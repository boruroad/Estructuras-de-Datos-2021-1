public class Heap implements ColaPrioridades {

    private int MAX_HEAP = 1000;

    private ComparableEntry[] elementos;

    private int numElems;

    /**
     * Crea un heap sin elementos.
     */
    public Heap() {
        elementos = new ComparableEntry[MAX_HEAP];
        numElems = 0;
        elementos[0] = null; //deliberadamente hacemos nula la posicion 0
    }

    @Override
    public boolean isEmpty() {
        return numElems == 0;
    }

    @Override
    public int size() {
        return numElems;
    }

    /*
     * Verifica si la posición que le pasan esta en el rango de
     * enteros del 1 al numero de elementos existentes
     * en el heap. En caso contrario lanza una excepción.
     */
    private void checkPosition(int i) throws InvalidPositionException {
        if (i < 1 || i > numElems) {
            throw new InvalidPositionException("Posición inválida");
        }            
    }

    /**
     * Devuelve un valor lógico que indica si el nodo de la 
     * posición i corresponde a la raiz del heap.
     * 
     * @param i la posicion de interés.
     * @return true si corresponde a la raíz y false si no.  
     */
    public boolean isRoot(int i) {
        checkPosition(i);
        return i == 1;
    }

    /**
     * Devuelve un valor booleano que indica si el nodo de
     * la posición i corresponde a un nodo hoja.
     * 
     * @param i la posición requerida
     * @return true si el nodo en la posicion i es hoja y false 
     * en otro caso.
     */
    public boolean isLeaf(int i) {
        checkPosition(i);
        return (i > numElems / 2) && (i <= numElems);
    }

    /**
     * Devuelve un valor booleano que indica si el nodo de la posicion
     * i corresponde a un nodo interno.
     * 
     * @param i la posición requerida
     * @return true si el nodo en la posicion i es interno y false en otro caso.
     */
    public boolean isInternal(int i) {
        return !isLeaf(i);
    }

    /**
     * Indica si el nodo cuya posición es i
     * tiene hijo izquierdo en este árbol.
     * 
     * @param i la posicion requerida
     * @return true si el nodo en la posición i tiene hijo
     * izquierdo y false en otro caso.
     */
    public boolean hasLeftChild(int i) {
        checkPosition(i);
        return i <= numElems / 2;
    }

    /**
     * Devuelve la posición del hijo izquierdo
     * del nodo cuya posición es i.
     * 
     * @param i la posición requerida
     * @return int la posición del hijo izquierdo
     * @throws InvalidPositionException si la posición no corresponde
     * con algún elemento existente en el heap.
     */
    public int daHijoIzquierdo(int i) {        
        if (!hasLeftChild(i)) {
            throw new InvalidPositionException("El nodo no tiene"
                                                                   + " hijo izquierdo");
        }            
        return 2 * i;
    }

    /**
     * Indica si el nodo de la posición i
     * tiene hijo derecho en este árbol.
     * 
     * @param i la posición requerida
     * @return true si el nodo en la posición i tiene hijo
     * derecho y false en otro caso.
     */
    public boolean hasRightChild(int i) {
        checkPosition(i);
        return i <= (numElems - 1) / 2;
    }

    /**
     * Devuelve la posición del hijo derecho
     * del nodo cuya posición es i.
     * 
     * @param i la posición requerida
     * @return int la posición del hijo derecho
     * @throws InvalidPositionException si la posición es inválida
     * o corresponde a un nodo que no tiene hijo derecho.
     */
    public int daHijoDerecho(int i) {        
        if (!hasRightChild(i)) {
            throw new InvalidPositionException("El nodo no tiene "
                                                                   + "hijo derecho");
        }            
        return 2*i + 1;
    }
    
    /** 
     * Devuelve la posición del padre del nodo con posición i.     * 
     * @param i la posición requerida
     * @return int la posición del nodo padre. En caso de que se trate
     * del nodo raiz, devuelve -1.
     */
    public int parent(int i) {
        checkPosition(i);
        return (i == 1) ? -1 : i/2;
    }
    
    /*
     * Reemplaza el contenido del nodo en la posicion i por la 
     * entrada que le pasan.
     */
    private void replace(int i, ComparableEntry entry) {
        checkPosition(i);
        elementos[i] = entry;
    }

    /*
     * Intercambia los contenidos de los nodos
     * que se encuentran en las posiciones i y j.
     */
    private void swap(int i,int j) {
        ComparableEntry temp = elementos[i];       
        replace(i, elementos[j]);
        replace(j, temp);
    }

    /*
     * Realiza el burbujeo hacia arriba a partir
     * de la posicion i.
     */
    private void upHeap(int i) {        
        Comparable claveHijo, clavePadre;
        int z = i;
        while (!isRoot(z)) {
            int u = parent(z);
            claveHijo = elementos[z].getKey();
            clavePadre = elementos[u].getKey();
            if (clavePadre.compareTo(claveHijo) <= 0) {
                break;
            }
                
            swap(u,z);
            z = u;
        }
    }

    @Override
    public void insert(ComparableEntry e) {
        if (numElems == MAX_HEAP) {
            throw new IllegalStateException("Heap lleno");
        }
            
        numElems++;
        elementos[numElems] = e;
        if (numElems > 1) {
            upHeap(numElems);
        }            
    }

    /*
     * Burbujeo hacia abajo desde la posicion de la raiz.
     */
    private void downHeap() {
        int r = 1;
        while (isInternal(r)) {
           // la entrada de los nodos hijos con clave minima
           int s;
           int hijoIzq = daHijoIzquierdo(r);
           if (!hasRightChild(r)) {
               s = hijoIzq;
           } else {
               int hijoDer = daHijoDerecho(r);
               Comparable claveIzq = elementos[hijoIzq].getKey();
               Comparable claveDer = elementos[hijoDer].getKey();
               if (claveIzq.compareTo(claveDer) <= 0) {
                   s = hijoIzq;
               } else {
                   s = hijoDer;
               }
           }
           if (elementos[s].getKey().compareTo(elementos[r].getKey()) < 0) {
               swap(r, s);
               r = s;
           } else {
               break;
           }               
        }
    }   

    @Override
    public ComparableEntry removeMin() {
        if (numElems == 0) {
            return null;
        }            
        ComparableEntry minimo = min();
        elementos[1] = elementos[numElems];
        elementos[numElems] = null;
        numElems--;
        if (numElems > 1) {
            downHeap();
        }
        return minimo;
    }
    
    @Override
    public ComparableEntry min() {
        if (numElems == 0) {
            return null;
        }        
        return elementos[1];
    }

}
