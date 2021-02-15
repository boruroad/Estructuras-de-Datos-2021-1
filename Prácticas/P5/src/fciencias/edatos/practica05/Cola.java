package fciencias.edatos.practica05;

/**
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación no es mia en su totalidad
   fue vista en clase y la estoy usando.
 * Créditos: Emmanuel Cruz Hernández
 * @version 1.0
 */

public class Cola<T>{

    /** Lista que toma el comportamiento de una cola. */
    private ListaLigada<T> cola = new ListaLigada<>();

    /**
     * Agrega un nuevo elemento al final de la cola.
     * @param t el elemento a agregar.
     */
    public void enqueue(T t){
        try{
            cola.add(cola.size(), t);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
    * Regresa y elimina el elemento en el principio de la cola.
    * @return el elemento en el tope de la pila.
    */
    public T dequeue(){
        if(cola.isEmpty())
            return null;
        T eliminado = null;
        try{
            eliminado = cola.remove(0);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return eliminado;
    }
    
    /**
     * Regresa un elemento de la cola en una posicion i.
     * @param i la posicion.
     */
    public T get(int i){
        return cola.get(i);
    }

    /**
    * Regresa el elemento en el principio de la cola. Sin eliminarlo.
    * @return el elemento en el principio de la cola. Null si no hay elementos.
    */    
    public T first(){
        if(cola.isEmpty())
            return null;
        T eliminado = null;
        try{
            eliminado = cola.get(0);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return eliminado;
    }

    /**
    * Regresa la cantidad de elementos contenidos.
    * @return la cantidad de elementos.
    */    
    public int size(){
        return cola.size();
    }

    /**
    * Verifica si la cola contiene elementos.
    * @return <i>true</i> si la cola es vacía, <i>false</i> en otro caso.
    */    
    public boolean isEmpty(){
        return cola.isEmpty();
    }

    /**
    * Elimina todos los elementos contenidos en la cola.
    */
    public void clear(){
        cola.clean();
    }

    /** Muestra como se ve una cola */
    public void muestra(){
        cola.muestra();

    }


}