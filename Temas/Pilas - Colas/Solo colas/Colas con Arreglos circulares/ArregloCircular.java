public class ArregloCircular implements Cola {

    private final short MAXIMO = 10000;

    private Object[] cola;

    private int frente;
    
    private int fondo;
    
    private int numeroElementos;

    /**
     * Construye una cola sin elementos.
     */
    public ArregloCircular() {
        cola = new Object[MAXIMO];
        frente = 0;
        fondo = MAXIMO - 1;
        numeroElementos = 0;
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
    public Object front() {
        return isEmpty() ? null : cola[frente];
    }

    @Override
    public void insert(Object obj) {
        if (numeroElementos == MAXIMO) {
            throw new RuntimeException("Cola llena");            
        }        
        fondo = (fondo + 1) % MAXIMO;
        cola[fondo] = obj;
        numeroElementos++;       
    }   

    @Override
    public Object delete() {
        if (isEmpty()) {
            return null;
        }
        Object tmp = cola[frente];
        cola[frente] = null;
        frente = (frente + 1) % MAXIMO;
        numeroElementos--;
        return tmp;
    }
}
