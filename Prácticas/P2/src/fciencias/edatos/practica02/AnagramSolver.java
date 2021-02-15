package fciencias.edatos.practica02;

import java.util.Scanner;

/**
 * Práctica 2: Anagramas 2021-1.
 * @author Bonilla Ruíz Roberto Adrián // Num. Cta. 31721903-8
 * @version 1.0
 */
public class AnagramSolver{


	/*Un entero llamado size de tipo int que 
	representa la longitud de la cadena a obtener el ana-
	gramming.*/
	public static int size;

	/*Un arreglo de char’s de longitud size, llamado word.*/
	public static char word[] = new char[size]; 

	/**
	 * ACTIVIDAD 1
	 * Método que permite rota las últimas rotator posiciones del arreglo word a la izquierda.
	 * @param rotator el numero de posiciones
	 */
    public static void rotate(int rotator) {
    	if(rotator < 0 || rotator > word.length)
    		return;
    	int j = word.length-rotator;
    	for (int i =word.length - 1; i >= j+1; i--){
    		char aux = word[j];
    		word[j] = word[i];
    		word[i] = aux;
    	}              
    }

	/**
	 * ACTIVIDAD 2
	 * Método que permite mprime los elementos del arreglo word, 
	 * de tal forma que los caracteres contenidos en el arreglo formen una palabra
	 */
	private static void displayWord() {
		for(int i = 0; i < word.length; i++){
			System.out.print(word[i] + "");
		}
		System.out.println();
	}

	/**
	 * ACTIVIDAD 3
	 * Método que permite realizar nuestro anagrama.
	 * @param newSize la longitud de la palabra ingresada por el usuario
	 */
	public static void doAnagram(int newSize){
		if(newSize == 1){
			return;
		}
		for(int i = 0; i < newSize; i++){
			doAnagram(newSize - 1);
			if(newSize == 2){
				displayWord();
			}
			rotate(newSize);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tecleé la palabra para obtener su anagrama:");
		try{ 
			String cadena = sc.nextLine().trim();
			System.out.println("El anagramming de la palabra "+ cadena+" es:");
			size = cadena.length();
			word = cadena.toCharArray();
			doAnagram(size);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}


