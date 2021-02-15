package fciencias.edatos.practicaReposicion;

import java.util.Scanner;
import java.util.EmptyStackException;
import java.util.ArrayList; 

/**
 * Práctica de Reposición: Pilas.
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * @version 1.0
 */

public class Menu {

	/** Creamos atributos de la clase */
	public static PilaArreglo pila               = new PilaArreglo();
	public static ArrayList<Object> listaCadenas = new ArrayList<>();	

	/**
	 * Método que verifica lo que ingrese el usuario como opción en el menú.
	 * @param sc lo que el usuario ingrese.	 
	 * @param n1 el numero minimo a ingresar.
	 * @param n2 el numero máximo a ingresar.
	 * @return una opción válida dentro de los rangos establecidos.
	 */
	public static int verificaMenuAux (Scanner sc, int n1, int n2){
		int n;
		while(true){
			try{
				n = Integer.parseInt(sc.nextLine());
				if((n < n1)|| (n >n2)){
					throw new IndexOutOfBoundsException("Ingresaste un número fuera de rango");
				}
				break;
			}catch(NumberFormatException nfe){
				System.out.print("\n Asegurate de ingresar solo números\n");
				continue;
			}catch(IndexOutOfBoundsException ioobe){
				System.out.println(ioobe.getMessage());
			}catch(Exception e){
				System.out.print("\n Lo sentimos, algo imprevisto sucedió \n");
				continue;
			}
		}
		return n;
	}	

	/**
	 * Método que almacena una cadena de longitud k en la pila
	 * y luego insertar el entero k para tener referencia
	 * de la longitud de dicha cadena.
	 * @param cadena la cadena que va a ingresar a la pila
	 * @return la pila con la cadena mas su longitud en el tope
	 */
	public static PilaArreglo pushString(String cadena){
		listaCadenas.add(cadena);
		int longitud = cadena.length();
		for (int i=cadena.length()-1; i>=0;i--){
			Character aux = cadena.charAt(i);
			pila.push(aux);
		}
		pila.push(longitud);
		pila.muestra();
		return pila;
	}

	/**
	 * Nos devuelve un número k que a su vez nos indica que la primer 
	 * cadena que podemos sacar de la pila es de tamaño k 
	 * y se requerirı́an k operaciones pop para extraerla.
	 * @return el numero k (Integer)
	 */
	public static Object topString(){
		if (pila.isEmpty()){
            throw new RuntimeException("Pila vacia. No hay ningun elemento en la pila");
        }
        return pila.peek();
	}

	/**
	 * Método que debe devolver la última cadena insertada en la pila
	 * la cadena y su tamaño deben ser eliminados de la pila.
	 * @return la última cadena insertada en la pila
	 */
	public static String popString(){	
		int aux = (int)pila.peek();
		String cadena  ="";
		String reversa ="";
		pila.pop();
			for (int i = 1; i<=aux; i++){
				cadena+=pila.pop();	
			}
		return cadena;
	}

	/**
	 * Método que devuelve en un ArrayList las cadenas de la pila
	 * @return listaCadenas la lista con las cadenas de la pila
	 */
	public static ArrayList<Object> regresaCadenas(){
		return listaCadenas;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Object> lAux = new ArrayList<>();	
		EscritorDOM escritor   = new EscritorDOM();
		PilaArreglo p =null;
		int seleccion;
			System.out.println("Bienvenido nuestras opciones son las siguientes");
		do{
			System.out.println("\n¿Qué desea hacer?");
			System.out.println("1.- Ingresar una cadena a la pila");
			System.out.println("2.- Eliminar la cadena de la pila");
			System.out.println("3.- Salir");
			seleccion = verificaMenuAux(sc,1,3);

			switch(seleccion){
				case 1:
					try{
						System.out.println("Ingrese cadena:");
						String c1 = sc.next();
						p         = pushString(c1);
						System.out.println("\nRegresamos de topString() un número: "+topString());
						System.out.println("un número k que a su vez nos indica que la primer cadena que podemos sacar de la pila\nes de tamaño k y se requerirı́an k operaciones pop para extraerla.");
						if(p != null){
							lAux = regresaCadenas();
							escritor.escribe(lAux);
						}
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break;

				case 2:
					try{ 
						String popS   = popString();
						String cadena =popS;
						listaCadenas.remove(cadena);
						System.out.println("Regresamos de popString() devolver la última cadena insertada en la pila\ny tanto la cadena como su tamaño deben ser eliminados de la pila\n"+"Regresamos: "+cadena+"\n");
						p.muestra();

						escritor.escribe(regresaCadenas());
						if(popS ==null || p.isEmpty()){
							throw new EmptyStackException();	
						}
						
					}catch(NullPointerException npe){
						System.out.println("\nLa pila es null, por lo tanto no puedes eliminar una cadena no ingresada");
					}catch(EmptyStackException ese){
						System.out.println("\nPila vacía. No hay nada que mostrar");
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break;
			}

		}while(seleccion!=3);
	}
}