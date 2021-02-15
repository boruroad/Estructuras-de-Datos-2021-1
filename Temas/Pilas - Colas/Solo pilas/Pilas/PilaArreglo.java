public class PilaArreglo implements Pila {
    
    private static final int MAX_ELEMS = 1000;
    
    private Object elementos[];
    
    private int tope;
    
    /**
     * Construye una pila basada en un arreglo 
     * con un número máximo de elementos por
     * omisión. 
     */
    public PilaArreglo() {
        elementos = new Object[MAX_ELEMS];
        tope = -1;
    }    

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }
    
    @Override
    public int size() {
        return tope + 1;
    }
    
    @Override
    public void push(Object obj) {
        if (size() == elementos.length)  {
            throw new RuntimeException("Pila llena. No hay espacio");
        }
        tope++;
        elementos[tope] = obj;       
    }

    @Override
    public Object peek() {
        return isEmpty() ? null : elementos[tope];        
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object tmp = elementos[tope];
        elementos[tope] = null;
        tope--;
        return tmp;
    }
}
