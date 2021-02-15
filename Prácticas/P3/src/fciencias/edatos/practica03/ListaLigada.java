package fciencias.edatos.practica03;

import java.lang.IndexOutOfBoundsException;

/**
 * Práctica 3: Listas //  Estructura de Datos 2021-1. // Bonilla Ruiz Roberto Adrián // Num. Cta. 31721903-8
 * La implementación a continuación no es mia totalmente // Créditos: Emmanuel Cruz Hernández
 */

/**
* Implementación de una lista ligada.
* @author Emmanuel Cruz Hernández.
* @version 1.0 2020.
* @since Estructuras de datos 2021-1.
*/
public class ListaLigada<T>{

    private class Nodo<T>{

        private T elemento;

        private Nodo<T> siguiente;

        public Nodo(T elemento){
            this.elemento = elemento;
        }

        public T getElemento(){
            return elemento;
        }

        public Nodo<T> getSiguiente(){
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente){
            this.siguiente = siguiente;
        }

        public void setElemento(T elemento){
            this.elemento = elemento;
        }
    }

    private Nodo<T> cabeza;

    private int cantidad;

    /**
     * Devuelve un valor lógico que indica si la lista
     * tiene elementos o no. 
     */
    public boolean isEmpty(){
        return cantidad==0;
    }

    /**
     * Devuelve el número de elementos de la lista.
     */    
    public int size(){
        return cantidad;
    }

    /**
     * Devuelve el objeto que se encuentra en la posición
     * i-ésima de la lista.     
     */
    public T get(int i) throws IndexOutOfBoundsException{
        if(i<0 || i>=cantidad){
            throw new IndexOutOfBoundsException("Índice fuera de rango válido");
        }

        Nodo<T> iterador = cabeza;

        for(int j = 0; j<i; j++)
            iterador = iterador.getSiguiente();

        return iterador.getElemento();
    }

    /**
     * Inserta el objeto obj en la i-ésima posición de la lista.
     */    
    public void add(int i, T obj) throws IndexOutOfBoundsException{
        if(i<0 || i>cantidad){
            throw new IndexOutOfBoundsException("Índice fuera de rango válido");
        }

        Nodo<T> nuevo = new Nodo<>(obj);

        if(i == 0){
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        } else{
            Nodo<T> iterador = cabeza;

            for(int j = 0; j<i-1; j++){
                iterador = iterador.getSiguiente();
            }

            nuevo.setSiguiente(iterador.getSiguiente());
            iterador.setSiguiente(nuevo);
        }

        cantidad++;
    }


    /**
     * Elimina y devuelve el elemento ubicado en la i-ésima posición de la lista.     
     */
    public T remove(int i) throws IndexOutOfBoundsException{
        if(i<0 || i>=cantidad){
            throw new IndexOutOfBoundsException("Índice fuera de rango válido");
        }

        T eliminado = null;

        if(i == 0){
            eliminado = cabeza.getElemento();
            cabeza = cabeza.getSiguiente();
        }else{
            Nodo<T> iterador = cabeza;

            for(int j = 0; j<i-1; j++){
                iterador = iterador.getSiguiente();
            }

            eliminado = iterador.getSiguiente().getElemento();

            iterador.setSiguiente(iterador.getSiguiente().getSiguiente());
        }
        cantidad--;
        return eliminado;
    }
    
}