package fciencias.edatos.proyectoFinal;

import java.lang.IndexOutOfBoundsException;

/**
 * Proyecto Final: Comunicaciones telefónicas
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación incluye material brindado por:
 * Emmanuel Cruz Hernández 
 * @version 1.0
 */

public class ListaLigada<T> implements TDALista<T>{

    public class Nodo<T>{

        public T elemento;

        public Nodo<T> siguiente;

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

    public Nodo<T> cabeza;

    public int cantidad;

    @Override
    public boolean isEmpty(){
        return cantidad==0;
    }

    @Override
    public int size(){
        return cantidad;
    }

    @Override
    public T get(int i) throws IndexOutOfBoundsException{
        if(i<0 || i>=cantidad){
            throw new IndexOutOfBoundsException("Índice fuera de rango válido");
        }

        Nodo<T> iterador = cabeza;

        for(int j = 0; j<i; j++)
            iterador = iterador.getSiguiente();

        return iterador.getElemento();
    }

    @Override
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

    @Override
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

    @Override
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

    /**
    * Nos permite vaciar la lista.
    */
    public void clean(){
        cabeza = null;
        cantidad = 0;
    }

    /**
    * Muestra los elementos contenidos en una lista.
    */
    public void muestra(){
        Nodo<T> iterador = cabeza;
        System.out.println("RUTA: ");
        for(int i = 0; i<cantidad; i++){

            System.out.print(iterador.getElemento()+((i==cantidad-1) ? "\n":" => "));
            iterador = iterador.getSiguiente();
        }
    }
}