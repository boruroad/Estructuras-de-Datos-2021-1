public class Entrada implements ComparableEntry {
    
    private String cadena;
    
    private int clave;

    public Entrada(String obj, int key) {        
        cadena = obj;
        clave = key;
    }

    public Comparable getKey() {
        return clave;
    }

    public Object getElement() {
        return cadena;
    }

}
