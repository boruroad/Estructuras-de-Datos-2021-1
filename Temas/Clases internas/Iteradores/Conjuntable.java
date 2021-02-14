/**
 * Interfaz que describe las operaciones sobre conjuntos
 * @author Amparo Lopez Gaona
 * @version 1a. ed.
 */
public interface Conjuntable {

    /**
     * Metodo para determinar si un conjunto esta o no vacio.
     * @return boolean -- true si el conjunto esta vacio y false en otro caso.
     */
    public boolean estaVacio();

    /**
     * Metodo para determinar el tamanio de un conjunto
     * @return int -- Cantidad de elementos en el conjunto
     */
    public int tamanio();

    /**
     * Metodo para eliminar todos los elementos de un conjunto
     */
    public void vaciar();

    /**
     * Metodo para agregar un elemento al conjunto
     * @param elemento -- Objeto que se incorporara al conjunto
     */
    public void agregar(Object elemento);

    /**
     * Metodo para eliminar un elemento al conjunto
     * @param elemento -- Objeto que se eliminara del conjunto
     */
    public void eliminar(Object elemento);

    /**
     * Metodo para determinar si un elemento pertenece al conjunto
     * @param elemento -- Objeto que se va a buscar en el conjunto
     * @return true -- si el elemento esta en el conjunto y false en otro caso.
     */
    public boolean contiene(Object elemento);

    /**
     * Metodo para obtener la union de dos conjuntos
     * @param c1 -- conjunto que se va unir
     * @return Conjuntable -- conjunto con la union
     */
    public Conjuntable union(Conjuntable c1);

    /**
     * Metodo para obtener la interseccion de dos conjuntos
     * @param c1 -- conjunto que se va intersectar
     * @return Conjuntable -- conjunto con la interseccion
     */
    public Conjuntable interseccion(Conjuntable c1);

    /**
     * Metodo para obtener la diferencia de dos conjuntos
     * @param c1 -- conjunto que con el se va a calcular la diferencia
     * @return Conjuntable -- conjunto con la diferencia
     */
    public Conjuntable diferencia(Conjuntable c1);

    /**
     * Metodo para determinar si un conjunto esta contenido en otro
     * @param c1 -- conjunto en se va a probar si el que llama es subconjunto
     * @return boolean -- true si el conjunto que llama a este metodo es
     *         subconjunto del parametro y false en otro caso
     */
    public boolean subconjunto(Conjuntable c1);

    /**
     * Metodo para crear un iterador sobre un conjunto
     * @return Iterator -- iterador sobre el conjunto.
     */
    public java.util.Iterator iterador();
}