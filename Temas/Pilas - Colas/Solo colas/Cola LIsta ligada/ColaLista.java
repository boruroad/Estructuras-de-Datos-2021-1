public class ColaLista implements Cola {
    
    private final ListaLigada lista;

    /**
     * Construye una cola sin elementos.
     */
    public ColaLista() {
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
    public void insert(Object obj) {
        lista.add(lista.size(), obj);
    }    

    @Override
    public Object delete() {
        if (isEmpty()) {
            return null;
        }        
        Object frente = lista.get(0);
        lista.remove(0);
        return frente;        
    }

   @Override
    public Object front() {
        return isEmpty()?  null : lista.get(0);        
    }    
}
