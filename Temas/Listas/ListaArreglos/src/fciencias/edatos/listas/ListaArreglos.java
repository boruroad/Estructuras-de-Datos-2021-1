package fciencias.edatos.listas;

import java.lang.IndexOutOfBoundsException;
import java.util.Arrays;

/**
* Implementación de una lista con arreglos.
* @author Emmanuel Cruz Hernández.
* @version 1.0 2020.
* @since Estructuras de datos 2021-1.
*/
public class ListaArreglos<T> implements TDALista<T>{

	/** Arreglo que almacena los elementos. */
	private T[] elementos;

	/** Tope de la lista. */
	private int cantidad;

	/** Máximo número de elementos. */
	private final int MAX_ELEMENTOS = 100;

	/**
	* Crea una nueva lista.
	* @param n la cantidad de espacios asignados para la lista.
	*/
	public ListaArreglos(int n){
		if(n<=0)
			elementos = (T[]) new Object[MAX_ELEMENTOS];
		else
			elementos = (T[]) new Object[n];
	}

	/** Crea una nueva lista.*/
	public ListaArreglos(){
		elementos = (T[]) new Object[MAX_ELEMENTOS];
	}

	@Override
	public int longitud(){
		return cantidad;
	}

	@Override
	public boolean esVacia(){
		return cantidad==0;
	}

	@Override
	public T obtenElemento(int i) throws IndexOutOfBoundsException{
		if(i<0 || i>=cantidad)
			throw new IndexOutOfBoundsException("Índice fuera de rango.");
		return elementos[i];
	}

	@Override
	public boolean estaContenido(T e){
		for(int i = 0; i<cantidad; i++)
			if(elementos[i].equals(e))
				return true;
		return false;
	}

	@Override
	public void agrega(int i, T e) throws IndexOutOfBoundsException{
		if(i<0 || i>cantidad)
			throw new IndexOutOfBoundsException("Índice fuera de rango.");

		for (int j = cantidad; j>i ; j--) {
			elementos[j] = elementos[j-1];
		}

		elementos[i] = e;

		cantidad++;

		if(cantidad>=elementos.length)
			elementos = Arrays.copyOf(elementos, elementos.length+MAX_ELEMENTOS);
	}

	@Override
	public T elimina(int i) throws IndexOutOfBoundsException{
		if(i<0 || i>=cantidad)
			throw new IndexOutOfBoundsException("Índice fuera de rango.");

		T eliminada = elementos[i];

		for( ; i<cantidad ; i++)
			elementos[i] = elementos[i+1];

		cantidad--;

		return eliminada;
	}

	@Override
	public void limpia(){
		for(int i = 0; i<cantidad; i++)
			elementos[i] = null;

		cantidad = 0;
	}

	private void muestra(){
		for(int i=0; i<cantidad; i++)
			System.out.println(elementos[i]);
	}

	public static void main(String[] args) {
		ListaArreglos<String> l = new ListaArreglos<>(5);

		l.agrega(0, "Hola");
		l.agrega(1, "Hola1");
		l.agrega(2, "Hola2");
		l.agrega(3, "Hola3");
		l.agrega(4, "Hola4");
		l.agrega(5, "Hola5");
		l.agrega(6, "Hola6");
		l.agrega(7, "Hola7");
		l.agrega(8, "Hola8");

		l.muestra();
		System.out.println("Longitud: "+l.longitud());
		System.out.println("Elemento en posición 7: "+l.obtenElemento(7));
		System.out.println("¿Es vacía?: "+l.esVacia());
		System.out.println("'Hola45' está contenido?: "+l.estaContenido("Hola45"));
		System.out.println("'Hola5' está contenido?: "+l.estaContenido("Hola5"));
		
	}

}