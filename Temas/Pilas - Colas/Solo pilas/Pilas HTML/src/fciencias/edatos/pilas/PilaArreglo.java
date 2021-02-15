package fciencias.edatos.pilas;

import java.util.EmptyStackException;

/**
 * Implementación de una pila con arreglos.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 2020.
 * @since Estructuras de datos 2021-1.
 */
public class PilaArreglo<T> implements TDAPila<T>{

    /** Arreglo con propiedades de lista. */
    private T[] arreglo;

    /** Numero maximo de elementos. */
    private final int MAX_NUM = 100;

    /** Tope de la pila. */
    private int tope;

    /**
    * Crea una nueva pila.
    * @param longitud la longitud de la pila.
    */
    public PilaArreglo(int longitud){
        if(longitud<0){
            arreglo = (T[]) new Object[MAX_NUM];
        } else{
            arreglo = (T[]) new Object[longitud];
        }
        tope = -1;
    }

    /**
    * Crea una nueva pila.
    */
    public PilaArreglo(){
        arreglo = (T[]) new Object[MAX_NUM];
        tope = -1;
    }
    
    @Override
    public void push(T t) throws IllegalStateException{
        if(arreglo.length == tope+1){
            throw new IllegalStateException("Pila llena");
        }

        arreglo[++tope] = t;
    }

    @Override
    public T pop() throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        T eliminado = arreglo[tope];
        arreglo[tope--] = null;
        return eliminado;
    }

    @Override
    public T top() throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        return arreglo[tope];
    }

    @Override
    public boolean isEmpty(){
        return tope<0;
    }

    @Override
    public void clear(){
        arreglo = (T[]) new Object[MAX_NUM];
        tope = -1;
    }

}
