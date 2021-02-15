public class MainHeap {
    
    public static void main(String[] args) {
        Heap ejem = new Heap();
        ejem.insert(new Entrada( "Aguascalientes", 10));
        ejem.insert(new Entrada( "CD MX", 6));
        ejem.insert(new Entrada("Jalisco", 8));
        ejem.insert(new Entrada("Edo. México", 7));
        ejem.insert(new Entrada("Coahuila", 1));
        ejem.insert(new Entrada("Guanajuato", 3));
        ejem.insert(new Entrada("Tamaulipas", 2));
        ejem.insert(new Entrada("Nuevo Leon", 5));
        ejem.insert(new Entrada("Veracruz", 9));
        while (!ejem.isEmpty()) {
            ComparableEntry entrada = ejem.removeMin();
            System.out.println("clave: "+ entrada.getKey());
            System.out.println("objeto: "+ entrada.getElement());
        }      

    }
    
}
