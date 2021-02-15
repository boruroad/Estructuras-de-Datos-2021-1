package fciencias.edatos.practica04;

import java.lang.IndexOutOfBoundsException;

/**
 * Práctica 4: Colas
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación no es mia en su totalidad 
 * Créditos: Emmanuel Cruz Hernández
 * @version 1.0
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
     * Sustituye el objeto en la i-ésima posición de la lista por el objeto obj
     * y regresa el objeto sustituido.
    */
    public T set(int i, T obj) throws IndexOutOfBoundsException{
        if(i<0 || i>=cantidad){
            throw new IndexOutOfBoundsException("Índice fuera de rango válido");
        }

        Nodo<T> iterador = cabeza;

        for(int j = 0; j<i; j++)
            iterador = iterador.getSiguiente();

        T anterior = iterador.getElemento();

        iterador.setElemento(obj);

        return anterior;
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

    /**
    * Permite saber si un elemento está contenido en una lista.
    * @param elemento a verificar si está en la lista.
    * @return true si el elemento está contenido, false en otro.
    */
    public boolean isContained(T obj){
        Nodo<T> iterador = cabeza;

        while(iterador!=null){
            if(obj.equals(iterador.getElemento()))
                return true;
            iterador = iterador.getSiguiente();
        }

        return false;
    }

    /** Nos permite vaciar la lista. */
    public void clean(){
        cabeza = null;
        cantidad = 0;
    }

    /**
    * Muestra los elementos contenidos en una lista.
    */
    public void muestra(){
        Nodo<T> iterador = cabeza;

        for(int i = 0; i<cantidad; i++){
            System.out.println(iterador.getElemento());
            iterador = iterador.getSiguiente();
        }
    }


}