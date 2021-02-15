package fciencias.edatos.practica01;

/**
 * Interfaz que describe las operaciones sobre matrices
 * @author Bonilla Ruiz Roberto Adrián // Num. Cta. 31721903-8
 * @version 1.0
 */

public interface OperacionesMatrices{

	/**
	 * Método para indicar el número de renglones de una Matriz
	 * @return int -- Número de renglones de la Matriz 
	 */
	public int getNumeroRenglones(); //ACTIVIDAD 1

	/**
	 * Método para indicar el número de columnas de una Matriz
	 * @return int -- Número de columnas de la Matriz 
	 */
	public int getNumeroColumnas(); // ACTIVIDAD 2

	/**
	 * Método que indica el elemento en la posición M[i, j] de una matriz
	 * @param matriz la matriz sumando
	 * @param inicio -- la representacion de i
	 * @param fin -- la representacion de j  
	 * @return double -- el elemento de la matriz
	 */
	public double indicaElemento(Matriz matriz, int inicio, int fin);//ACTIVIDAD 3	

	/**
	 * Método que modifica un elemento de una matriz en la posición [i, j]
	 * @param matriz la matriz seleccionada
	 * @param elemento -- el elemento a reemplazar
	 * @param inicio -- la representacion de i
	 * @param fin -- la representacion de j 
	 * @return Matriz la matriz con el elemento nuevo 
	 */
	public Matriz modificaElemento(Matriz matriz, double elemento, int inicio, int fin);//ACTIVIDAD 4

	/**
	 * Método para sumar dos matrices
	 * @param matriz la matriz sumando
	 * @param matriz2 la matriz sumador 
	 * @return Matriz -- la matriz resultado
	 */
	public Matriz sumarMatrices(Matriz matriz, Matriz matriz2);	 //ACTIVIDAD 5 

	/**
	 * Método para multiplicar una matriz por un escalar.
	 * @param matriz la matriz que va a ser multiplicada
	 * @param escalar el escalar a multiplicar por la matriz  
	 */
	public void multiplicarEscalar(Matriz mat, double escalar);//ACTIVIDAD 6 

	
	/**
	 * Método para multiplicar una matriz por otra.
	 * @param ma1 la primer matriz de la multiplicacion
	 * @param m2  la segunda matriz de la multiplicacion 
	 * @return Matriz - la matriz como producto de las ingresadas como parámetro
	 */
	public  Matriz multiplicar (Matriz ma1,Matriz ma2); //ACTIVIDAD 7

	/**
	 * Método para hacer la transpuesta de una matriz.
	 * @param ma1 la primer matriz de la multiplicacion
	 * @return Matriz -- la matriz transpuesta
	 */
	public Matriz  transpuesta(Matriz trans); //ACTIVIDAD 8


	/**
	 * Método que comprueba si dos matrices son iguales.
	 * @param matrizUno la primer matriz a comparar
	 * @param matrizDos la primer segunda matriz a comparar
	 * @return boolean -- "true" si son iguales, "false" si no.
	 */
	public  boolean sonIguales(Matriz matrizUno, Matriz matrizDos); //ACTIVIDAD 9
}