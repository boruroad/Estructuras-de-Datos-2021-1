/**
 * Implementación de una Lista basada en un arreglo. 
 */
public class ListaArreglo implements Lista {

    // máximo tamaño fisico por omisión
    private static final int MAXIMO_ELEMENTOS = 1000;

    // tamaño físico
    private int maximoElementos;
    
    // tamaño lógico
    private int numeroElementos;

    // arreglo que se usa para el almacenamiento
    private Object[] elementos;

    /**
     * Constructor de una lista con un máximo
     * número de elementos por omisión.
     */
    public ListaArreglo(){
        this(MAXIMO_ELEMENTOS);
    }   
    
    /**
     * Constructor que recibe el número de elementos máximo
     * que va a almacenar la lista.
     * 
     * @param num El número de elementos máximo.
     */
    public ListaArreglo(int num) {
        maximoElementos = num;
        numeroElementos = 0;
        elementos = new Object[num];
    }    

    @Override
    public boolean isEmpty() {
        return numeroElementos == 0;
    }

    @Override
    public int size() {
        return numeroElementos;
    }
    
    @Override
    public Object get(int i) throws IndexOutOfBoundsException {
        if (numeroElementos == 0) {
            throw new IndexOutOfBoundsException("Indice invalido. Lista vacía");
        }
        if (i < 0 || i > numeroElementos - 1) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        return elementos[i];          	
    }   

    @Override
    public void add(int i, Object obj) throws IndexOutOfBoundsException, IllegalStateException {
        if (numeroElementos == maximoElementos) {
            throw new IllegalStateException("Memoria insuficiente");
        }
        
        if (i < 0 || i > numeroElementos) {
            throw new IndexOutOfBoundsException("Indice inválido");
        }
        
        // recorremos una posición hacia adelante los elementos
        // en las posiciones comprendidas desde numElems - 1 hasta i
        int posicion = numeroElementos;
        while (posicion > i) {
            elementos[posicion] = elementos[posicion - 1];
            posicion--;
        }
        elementos[posicion] = obj;
        numeroElementos++;        
    }
    
    @Override
    public Object set(int i, Object obj) throws IndexOutOfBoundsException {
        if (numeroElementos == 0) {
            throw new IndexOutOfBoundsException("Indice invalido. Lista vacía");
        }
        if (i < 0 || i > numeroElementos - 1) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        Object elemento = elementos[i];
        elementos[i] = obj;
        return elemento;         
    }

    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        if (numeroElementos == 0) {
            throw new IndexOutOfBoundsException("Indice inválido. Lista vacía");
        }
        
        if (i < 0 || i > numeroElementos - 1) {
            throw new IndexOutOfBoundsException("Indice inválido");
        }
        
        // recorremos un lugar hacia la izquierda los elementos
        // en las posiciones comprendidas desde i+1 hasta numElems
        int posicion = i;
        Object elemento = elementos[posicion];
        while (posicion < numeroElementos - 1) {
            elementos[posicion] = elementos[posicion + 1];
            posicion++;
        }
        elementos[posicion] = null;
        numeroElementos--; 
        return elemento;
    }    
    
}
