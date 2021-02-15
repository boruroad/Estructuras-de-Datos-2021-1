package fciencias.edatos.listas;

import java.lang.IndexOutOfBoundsException;

/**
 * Tipo de Datos Abstracto de una lista.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 2020.
 * @since Estructuras de datos 2021-1.
 */
public interface TDALista<T>{

    /**
     * Regresa la cantidad de elementos en la lista.
     * @return la cantidad de elementos en la lista.
     */
    public int longitud();

    /**
     * Verifica si la lista contiene elementos.
     * @return <i>true</i> si la lista es vacía,
     * <i>false</i> en otro caso.
     */
    public boolean esVacia();

    /**
     * Accede a un elemento en una posición específica de la lista.
     * @param i el índice de la lista a obtener el elemento.
     * @throws IndexOutOfBoundException si <i>i</i> no está
     * en un rango válido de la lista. 
     */
    public T obtenElemento(int i) throws IndexOutOfBoundsException;

    /**
     * Verifica si un elemento está contenido en la lista.
     * @param e el elemento a buscar en la lista.
     * @return <i>true</i> si el elemento está en la lista,
     * <i>false</i> en otro caso.
     */
    public boolean estaContenido(T e);

    /**
     * Agrega un elemento a la lista en una posición específica.
     * @param i la posición de la lista donde agregar el elemento.
     * @param e el elemento a agregar.
     * @throws IndexOutOfBoundException si <i>i</i> no está
     * en un rango válido de la lista para agregar.
     */
    public void agrega(int i, T e) throws IndexOutOfBoundsException;

    /**
     * Elimina un elemento de la lista en una posición específica.
     * @param i el índice donde está el elemento a eliminar.
     * @return el elemento eliminado de la lista.
     * @thorws IndexOutOfBoundException si <i>i</i> no está
     * en un rango válido de la lista para eliminar.
     */
    public T elimina(int i) throws IndexOutOfBoundsException;

    /**
    * Elimina todos los elementos de una lista.
    */
    public void limpia();

}
