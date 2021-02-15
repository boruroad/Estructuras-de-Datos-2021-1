public class PilaLista implements Pila {

    private final ListaLigada lista;    
    
    /**
     * Constructor de una pila
     * basada en una lista ligada. 
     */
    public PilaLista() {
        lista = new ListaLigada();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    
    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public void push(Object obj) {
        lista.add(0, obj);
    }

    @Override
    public Object pop() {
        if (lista.isEmpty()) {
            return null;
        }
        Object tmp = lista.get(0);
        lista.remove(0);
        return tmp;        
    }

    @Override
    public Object peek() {
        return lista.isEmpty() ? null : lista.get(0);        
    }
}
