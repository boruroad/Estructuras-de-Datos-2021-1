package fciencias.edatos.analisisAlgoritmos;

import java.lang.System;
import java.util.Random;

/**
* Clase que muestra el análisis del los métodos
* implementados.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Octubre 2020.
* @since Estructuras de Datos 2021-1 and 
* Data Structures and Algorithms in Java by Goodrich
* Tamassia and Goldwasser.
*/
public class Analizador{

	/**
	* Uses repeated concatenation to compose a String with n copies of character c.
	* @param c el caracter a repetir n veces.
	* @param n la cantidad de veces a repetir el caracter c.
	*/
	public static String repeat1(char c, int n) {
		String answer = ""; // 1
		for (int j=0; j < n; j++) // n veces
			answer += c; // n
		// El for se va a tardar n*n
		return answer; // O(1)

		// O(1) + O(n*n) + O(1) -> O(n*n)
	}

	/**
	* Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j].
	* @param x el arreglo del cual obtener los promedios.
	* @param un arreglo con el promedio en cada entrada j de la suma de (x[0],...,x[j]) / (j+1).
	*/
	public static double[] prefixAverage1(double[] x) {
		int n = x.length; // O(1)
		double[] a = new double[n]; // O(n)
		for (int j=0; j < n; j++) { // O(n)
			double total = 0; // O(1)
			for (int i=0; i <= j; i++) // O(n)
				total += x[i]; // O(1)
			// -> O(n)
			a[j] = total / (j+1); // 3 operaciones -> O(1)

			// 1 + n + 3 -> O(n)
		} // n*n
		return a; // 1 operacion -> O(1)

		// O(1) + O(n) + O(n*n) + O(1) -> O(n*n)
	}

	public static double[] prefixAverage2(double[] x){
		int n = x.length; // O(1)
		double[] a = new double[n]; // O(n)
		double total = 0; // O(1)
		for(int j=0; j<n; j++){ // n veces
			total += x[j]; // O(1)
			a[j] = total / (j+1); // O(1)

			// O(1) + O(1) -> O(1)
		} // O(n)

		return a; // O(1)

		// O(1) + O(n) + O(1) + O(n) + O(1) -> O(n)
	}

	private static double[] generaAleatorio(int n){
		Random r = new Random();
		double[] generado = new double[n];

		for(double elemento: generado)
			elemento = Math.random() + r.nextInt(n);

		return generado;
	}

	public static void main(String[] args) {
		double[] arr = generaAleatorio(10000);
		

		long tiempoInicial = System.currentTimeMillis();

		//repeat1('c', 100000);

		prefixAverage2(arr);

		long tiempoFinal = System.currentTimeMillis();

		System.out.println(tiempoFinal - tiempoInicial);

	}


}