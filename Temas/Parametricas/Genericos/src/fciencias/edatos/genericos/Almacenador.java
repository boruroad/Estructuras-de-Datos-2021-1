package fciencias.edatos.genericos;

import java.lang.IndexOutOfBoundsException;

/**
* Ejemplo de clases parametrizadas.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Octubre 2020.
* @since Laboratorio de Estructuras de Datos 2021-1.
*/
public class Almacenador<T, U>{

	/** Arreglo que almacena la información. */
	public T[] almacen;

	/** Elmento U. */
	public U elementoExtra;

	/**
	* Crea un nuevo almacenador con <i>n</i> elementos.
	* @param n la cantidad de elementos.
	*/
	public Almacenador(int n, U elemento){
		almacen = (T[]) new Object[n];
		this.elementoExtra = elemento;
	}

	/**
	* Agrega un nuevo al almacenador.
	* @param i el índice donde se quiere almacenar un elemento.
	* @param e el elemento a almacenar.
	*/
	public void agrega(int i, T e) throws IndexOutOfBoundsException{
		if(i<0 || i>almacen.length)
			throw new IndexOutOfBoundsException("Indice invalido");

		almacen[i] = e;
	}

	/**
	* Elimina un elemento del almacen.
	* @param i el índice donde se requiere eliminar un elemento.
	*/
	public void elimina(int i) throws IndexOutOfBoundsException{
		if(i<0 || i>almacen.length)
			throw new IndexOutOfBoundsException("Indice invalido");

		almacen[i] = null;
	}

	/**
	* Muestra los elementos almacenados.
	*/
	public void muestra(){
		for(T o : almacen){
			System.out.println(o==null ? "" : o);
		}
		System.out.println(elementoExtra);
	}

	/**
	* Regresa el elemento en un índice especifico.
	* @param i el índice del elemento a regresar.
	* @return el elemento en la posición i.
	*/
	public T consulta(int i) throws IndexOutOfBoundsException{
		if(i<0 || i>almacen.length)
			throw new IndexOutOfBoundsException("Indice invalido");

		return almacen[i];
	}

	public static void main(String[] args) {
		Almacenador<Date, Integer> a = new Almacenador<>(5, 3);

		Almacenador<Integer, Double> enteros = new Almacenador<Integer, Double>(2, 6.6);

		Almacenador<String, Character> cadenas = new Almacenador<>(4, 'a');

		try{
			a.agrega(0, new Date(12, 27, 2019));
			a.agrega(2, new Date(11, 13, 2019));

			enteros.agrega(0, 4);

			cadenas.agrega(3, "Hola");
			cadenas.agrega(2, "Mundo");

			System.out.println("Dates");
			a.muestra();

			System.out.println("Enteros");
			enteros.muestra();

			System.out.println("cadenas");
			cadenas.muestra();

			
		} catch(IndexOutOfBoundsException ioobe){
			System.out.println(ioobe.getMessage());
		}

		
	}
}