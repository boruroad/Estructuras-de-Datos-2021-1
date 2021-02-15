package fciencias.edatos.practica01;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Práctica 1: TDA y Estructura de Datos 2021-1.
 * @author Bonilla Ruíz Roberto Adrián // Num. Cta. 31721903-8
 * @version 1.0
 */


public class Practica1{

	private static int lineas;

	/**
	 * Método que permite leer un archivo con una matriz.
	 * @param nombreDelArchivo el archivo a leer.
	 */
	private static String leerArchivo(String nombreDelArchivo){
		String cadena = "";
		BufferedReader lector = null;
		String line = null;

		try{
			lector = new BufferedReader(new FileReader(nombreDelArchivo));
			lineas = 0;
			while((line=lector.readLine()) != null){
				cadena+=line;
				lineas++;
			}
			lector.close();
			return cadena;
		}catch(FileNotFoundException fnfe){
			return fnfe.getMessage();
		}catch(IOException ioe){
			return  ioe.getMessage();
		}
	}

	/**
	 * Método que permite escribir un archivo con una matriz.
	 * Este archivo estara guardado a nivel del README
	 * @param nombreArchivo el nombre del archivo.
	 * @param contenido lo que vamos a guardar en el archivo
	 */
	private static String escribirArchivo(String nombreArchivo, String contenido){
		try{
			BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
			escritor.write(contenido);
            escritor.close();	
            return "Guardado correctamente";
      	}catch(FileNotFoundException fnfe){
      		return fnfe.getMessage();
      	}catch(IOException ioe){ 
      		return ioe.getMessage();
      	}
	}
	/**
	 * Método que nos permite mostrar el menú al usuario.
	 */	
	private static void muestraMenu(){
		System.out.println("\n-------- Por favor seleccione un número para realizar alguna de las siguientes operaciones -------- \n");
		System.out.println("  [1]  --> Indicar el número de renglones de la matriz");
		System.out.println("  [2]  --> Indicar el número de columnas de la matriz");
		System.out.println("  [3]  --> Indicar el elemento en la posición M[i,j]");
		System.out.println("  [4]  --> Modificar el elemento en la posición M[i,j]");
		System.out.println("  [5]  --> Sumar dos matrices");
		System.out.println("  [6]  --> Multiplicar una matriz por un escalar");
		System.out.println("  [7]  --> Multiplicar dos matrices");
		System.out.println("  [8]  --> Obtener la transpuesta de una matriz");
		System.out.println("  [9]  --> Saber si dos matrices son iguales");
		System.out.println("  [10] --> Salir del programa\n \n  Por favor seleccione una opción");
	}

	/**
	 * Método que nos permite verificar la robustez de lo que ingrese el usuario como opción en el menú.
	 * @param sc la opción que el usuario tecleé.
	 * @return una opción correcta (ya que en caso de que el usuario haya ingresado letras o un número fuera de rango, se le obligará
	 * a ingresar una opción válida).
	 */
	public static int verificaRango(Scanner sc, int n1, int n2){
		int n;
		while(true){
			try{
				n = Integer.parseInt(sc.nextLine());
				if(n < n1 || n > n2){
					throw new IndexOutOfBoundsException("NÚMERO FUERA DE RANGO");
				}
				break;
			}catch(NumberFormatException nfe){
				System.out.print("\n ¡¡¡ LAS LETRAS NO SON VÁLIDAS !!!\n");
				continue;
			}catch(IndexOutOfBoundsException iobe){
				System.out.print("\n ¡¡¡ OPCIÓN FUERA DE RANGO !!!\n");
				continue;
			} catch(Exception e){
				System.out.print("\n ¡¡¡ ALGO INESPERADO OCURRIÓ !!!\n");
				continue;
			}
		}
		return n;
	}

	/**
	 * Método que nos permite erificar la columna de una Matriz.
	 * @param sc el Scanner con el que vamos a trabajar
	 * @param m la Matriz a verificar respecto a las columnas
	 */	
	public static int verificaColumna(Scanner sc, Matriz m){
		int n;
		while(true){
			try{ 
				n = Integer.parseInt(sc.nextLine());
				if(n<0 || n>m.getNumeroColumnas()){
					throw new IndexOutOfBoundsException("Número fuera de rango");
				}
				break;
			}catch(NumberFormatException nfe){
				System.out.print("\n ¡¡¡ LAS LETRAS NO SON VÁLIDAS !!!\n");
				continue;
			}catch(IndexOutOfBoundsException iobe){
				System.out.print("\n ¡¡¡ OPCIÓN FUERA DE RANGO !!!\n");
				continue;
			} catch(Exception e){
				System.out.print("\n ¡¡¡ ALGO INESPERADO OCURRIÓ !!!\n");
				continue;
			}
		}		 
		return n;
	} 

	/**
	 * Método que nos permite verificar la fila de una Matriz.
	 * @param sc el Scanner con el que vamos a trabajar
	 * @param m la Matriz a verificar respecto a las filas
	 */	
	public static int verificaFila(Scanner sc, Matriz m){
		int n;
		while(true)	{
			try{ 
				n = Integer.parseInt(sc.nextLine());
			
				if(n<0 || n>m.getNumeroRenglones()){
					throw new IndexOutOfBoundsException("Número fuera de rango");
				}
				break;
			}catch(NumberFormatException nfe){
				System.out.print("\n ¡¡¡ LAS LETRAS NO SON VÁLIDAS !!!\n");
				continue;
			}catch(IndexOutOfBoundsException iobe){
				System.out.print("\n ¡¡¡ OPCIÓN FUERA DE RANGO !!!\n");
				continue;
			} catch(Exception e){
				System.out.print("\n ¡¡¡ ALGO INESPERADO OCURRIÓ !!!\n");
				continue;
			}
		}		 
		return n;
	} 


	/** Método main */
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		System.out.println("\n **** Operaciones con matrices EDD **** \n");
		System.out.println("Nuestras matrices son las siguientes\n");
		Matriz matriz  = new Matriz("5,3,3;1,2,2;6,4,1");
        Matriz m2 = matriz;
		Matriz matriz2 = new Matriz("11,3,13;10,12,2;6,14,19");
        Matriz m3 = matriz2;
		Matriz matriz3 = new Matriz("1,2,3,15,;9,11,7,8");
        Matriz m4 = matriz3;

		System.out.println("1) -----> (matriz cuadrada)\n \n"+matriz.formato()+" \n2) -----> (matriz cuadrada)\n\n"+matriz2.formato()+ " \n3) -----> (matriz NO cuadrada)\n\n"+matriz3.formato());
		muestraMenu();
		int opcion = verificaRango(sc,1,10);

	do{ 

		switch(opcion){
				case 1:
					System.out.println("Tecleé el número correspondiente a la Matriz para conocer el número de renglones que contiene");	
					int select = verificaRango(sc,1,3);
									
					switch(select){
						case 1:
						System.out.println("Seleccionaste la matriz 1) \n");
						System.out.println("\n"+matriz.formato()+ " \nTiene "+matriz.getNumeroRenglones()+ " renglones");
						break;

						case 2:
						System.out.println("Seleccionaste la matriz 2) \n");
						System.out.println("\n"+matriz2.formato()+ " \nTiene "+matriz2.getNumeroRenglones()+ " renglones");
						break;

						case 3:
						System.out.println("Seleccionaste la matriz 3) \n");
						System.out.println("\n"+matriz3.formato()+ " \nTiene "+matriz3.getNumeroRenglones()+ " renglones");
						break;
					}
						muestraMenu();
						opcion = verificaRango(sc,1,10);		
				break;

				case 2:
					System.out.println("Tecleé el número correspondiente a la Matriz para conocer el número de columnas que contiene");	
					int select2 = verificaRango(sc,1,3);
									
					switch(select2){
						case 1:
							System.out.println("Seleccionaste la matriz 1)\n ");
							System.out.println(matriz.formato()+"\nTiene "+matriz.getNumeroColumnas() + " columnas");
						break;

						case 2:
							System.out.println("Seleccionaste la matriz 2)\n ");
							System.out.println(matriz2.formato()+"\nTiene "+matriz2.getNumeroColumnas() + " columnas");
						break;

						case 3:
							System.out.println("Seleccionaste la matriz 3)\n ");
							System.out.println(matriz3.formato()+"\nTiene "+matriz3.getNumeroColumnas()+ " columnas");

						break;
					}
						muestraMenu();
						opcion = verificaRango(sc,1,10);					
				break;

				case 3: 
					System.out.println("Tecleé el número correspondiente a la Matriz para después indicar el elemento en la posición M[i,j]");	
					int select3 = verificaRango(sc,1,3);

					switch(select3){ 
						case 1:
							System.out.println("Seleccionaste la matriz 1) ");
							System.out.println(matriz.formato());
							System.out.println("Tecleé posicion \"i\" (renglón) de la matriz ");
							int i =verificaFila(sc, matriz);

							System.out.println("Tecleé posicion \"j\" (columna) de la matriz ");
							int j =verificaColumna(sc, matriz);
							double posicion = matriz.indicaElemento(matriz,i,j);
							System.out.println("El elemento ("+i+","+j+") de la matriz 1) es "+ posicion );
						break;

						case 2:
							System.out.println("Seleccionaste la matriz 2) ");
							System.out.println(matriz2.formato());
							System.out.println("Tecleé posicion \"i\" (renglón) de la matriz ");
							int iDos =verificaFila(sc, matriz2);
							System.out.println("Tecleé posicion \"j\" (columna) de la matriz ");
							int jDos =verificaColumna(sc, matriz2);
							double posicionDos = matriz2.indicaElemento(matriz2,iDos,jDos);
							System.out.println("El elemento ("+iDos+","+jDos+") de la matriz 1) es "+ posicionDos);
						break;

						case 3:
							System.out.println("Seleccionaste la matriz 3) ");
							System.out.println(matriz3.formato());
							System.out.println("Tecleé posicion \"i\" (renglón) de la matriz ");
							int iTres =verificaFila(sc, matriz3);
							System.out.println("Tecleé posicion \"j\" (columna) de la matriz ");
							int jTres =verificaColumna(sc, matriz3);
							double posicionTres = matriz3.indicaElemento(matriz3,iTres,jTres);
							System.out.println("El elemento ("+iTres+","+jTres+") de la matriz 1) es "+ posicionTres);
						break;
					}
						muestraMenu();
						opcion = verificaRango(sc,1,10);	

				break;

				case 4:
					System.out.println("Tecleé el número correspondiente a la Matriz para después modificar el elemento en la posición M[i,j]");	
					int select4 = verificaRango(sc,1,3);
					switch(select4){ 
						case 1:
							System.out.println("Seleccionaste la matriz 1) ");
							System.out.println(matriz.formato());
							System.out.println("Tecleé posicion \"i\" (renglón) de la matriz ");
							int i =verificaFila(sc, matriz);
							System.out.println("Tecleé posicion \"j\" (columna) de la matriz ");
							int j =verificaColumna(sc, matriz);
							
							boolean es = false;
							
							do{ 
								System.out.println("Tecleé el nuevo elemento a modificar");
								String e = sc.nextLine();
								try{
									double elemento= Double.parseDouble(e);
									m2.modificaElemento(matriz,elemento,i,j);
									System.out.println("El elemento ("+i+","+j+") de la matriz 1) fue reemplazado por "+elemento +"\n");
									es=false;									    
								}catch(NumberFormatException nfe){
									System.out.println("Esto no es un número");
									es =true;	   
								}						
							}while(es);	
							System.out.println(matriz.formato());
						break;

						case 2:
							System.out.println("Seleccionaste la matriz 2) ");
							System.out.println(matriz2.formato());
							System.out.println("Tecleé posicion \"i\" (renglón) de la matriz ");
							int iTwo =verificaFila(sc, matriz2);
							System.out.println("Tecleé posicion \"j\" (columna) de la matriz ");
							int jTwo =verificaColumna(sc, matriz2);
							boolean es2 = false;
							
							do{ 
								System.out.println("Tecleé el nuevo elemento a modificar");
								String e = sc.nextLine();
								try{
									double elemento2= Double.parseDouble(e);
									m3.modificaElemento(matriz2,elemento2,iTwo,jTwo);
									System.out.println("El elemento ("+iTwo+","+jTwo+") de la matriz 1) fue reemplazado por "+elemento2 +"\n");
									es2=false;									    
								}catch(NumberFormatException nfe){
									System.out.println("Esto no es un número");
									es2 =true;	   
								}						
							}while(es2);	
								System.out.println(matriz2.formato());			
						break;

						case 3:
							System.out.println("Seleccionaste la matriz 3) ");
							System.out.println(matriz3.formato());
							System.out.println("Tecleé posicion \"i\" (renglón) de la matriz ");
							int iTres =verificaFila(sc, matriz3);

							System.out.println("Tecleé posicion \"j\" (columna) de la matriz ");
							int jTres =verificaColumna(sc, matriz);

							boolean es3 = false;
							
							do{ 
								System.out.println("Tecleé el nuevo elemento a modificar");
								String e = sc.nextLine();
								try{
									double elemento3= Double.parseDouble(e);
									m4.modificaElemento(matriz3,elemento3,iTres,jTres);
									System.out.println("El elemento ("+iTres+","+jTres+") de la matriz 1) fue reemplazado por "+elemento3 +"\n");
									es3=false;									    
								}catch(NumberFormatException nfe){
									System.out.println("Esto no es un número");
									es3 =true;	   
								}						
							}while(es3);	
								System.out.println(matriz3.formato());

						break;
					}
						muestraMenu();
						opcion = verificaRango(sc,1,10);	
				break;

				case 5:
					System.out.println("Tecleé el número correspondiente a la matriz para sumar");	
					int select5 = verificaRango(sc,1,3);

					switch(select5){
						case 1:
							System.out.println("Seleccionaste la matriz 1) ");

							System.out.println("Sumar matriz 1) + matriz 1) ...... selecciona 1");	
							System.out.println("Sumar matriz 1) + matriz 2) ...... selecciona 2");
							System.out.println("Sumar matriz 1) + matriz 3) ...... selecciona 3");	

							int opt5 = verificaRango(sc,1,3);
							switch(opt5){
								case 1:
									Matriz r1= m2.sumarMatrices(matriz, matriz);
									System.out.println("\nCreando archivo suma(1,1).txt ");
									System.out.println(escribirArchivo("suma(1,1).txt", r1.toString()));
								break;

								case 2:
									Matriz r2 = m2.sumarMatrices(matriz, matriz2);
									System.out.println("\nCreando archivo suma(1,2).txt ");
									System.out.println(escribirArchivo("suma(1,2).txt", r2.toString()));
								break;

								case 3:
									Matriz r3 =m2.sumarMatrices(matriz, matriz3);
									System.out.println("\nCreando archivo suma(1,3).txt ");
									System.out.println(escribirArchivo("suma(1,3).txt", r3.toString()));
								break;
							}

						break;

						case 2:
							System.out.println("Seleccionaste la matriz 2) ");
							System.out.println("Sumar matriz 2) + matriz 1) ...... selecciona 1");	
							System.out.println("Sumar matriz 2) + matriz 2) ...... selecciona 2");
							System.out.println("Sumar matriz 2) + matriz 3) ...... selecciona 3");	

							int opt52 = verificaRango(sc,1,3);
							switch(opt52){
								case 1:
									Matriz r4 = m3.sumarMatrices(matriz2, matriz);
									System.out.println("\nCreando archivo suma(2,1).txt ");
									System.out.println(escribirArchivo("suma(2,1).txt", r4.toString()));
								break;

								case 2:
									Matriz r5 =m3.sumarMatrices(matriz2, matriz2);
									System.out.println("\nCreando archivo (suma(2,2).txt ");
									System.out.println(escribirArchivo("(suma(2,2).txt", r5.toString()));

								break;

								case 3:
									Matriz r6 =m3.sumarMatrices(matriz2, matriz3);
									System.out.println("\nCreando archivo suma(2,3).txt ");
									System.out.println(escribirArchivo("suma(2,3).txt", r6.toString()));

								break;
							}
						break;

						case 3:
							System.out.println("Seleccionaste la matriz 3) ");
							System.out.println("Sumar matriz 3) + matriz 1) ...... selecciona 1");	
							System.out.println("Sumar matriz 3) + matriz 2) ...... selecciona 2");
							System.out.println("Sumar matriz 3) + matriz 3) ...... selecciona 3");	

							int opt53 = verificaRango(sc,1,3);
							switch(opt53){
								case 1:
									Matriz r7 = m4.sumarMatrices(matriz3, matriz);
								break;

								case 2:
									Matriz r8 = m4.sumarMatrices(matriz3, matriz2);
								break;

								case 3:
									Matriz r9 =m4.sumarMatrices(matriz3, matriz3);
									System.out.println("\nCreando archivo suma(3,3).txt ");
									System.out.println(escribirArchivo("suma(3,3).txt", r9.toString()));
								break;
							}
						break;
					}
					muestraMenu();
					opcion = verificaRango(sc,1,10);	

				break;

				case 6:
					System.out.println("Tecleé el número correspondiente a la matriz para multiplicar por escalar");	
					int select6 = verificaRango(sc,1,3);
					switch(select6){
						case 1:
							System.out.println("Seleccionaste la matriz 1) ");
							System.out.println("Ingresa el escalar para multiplicar a la matriz");
								try{ 
									int esc = sc.nextInt();
									m2.multiplicarEscalar(m2,esc);
									System.out.println("\nLa matriz 1) ha sido multiplicada por "+esc);
									break;
								}catch(InputMismatchException ime){
									System.out.println("Dato inválido"); 
								}catch(IllegalArgumentException iae){ 
									System.out.println("Solo números porfavor");
								}catch(Exception e){
									System.out.println("OCCURRIÓ ALGO INESPERADO");
									
								}
						break;

						case 2:
							System.out.println("Seleccionaste la matriz 2) ");
							System.out.println("Ingresa el escalar para multiplicar a la matriz");
								try{ 
									int esc2 = sc.nextInt();
									m3.multiplicarEscalar(m3,esc2);
									System.out.println("\nLa matriz 2) ha sido multiplicada por "+esc2);
									break;
								}catch(InputMismatchException ime){
									System.out.println("Dato inválido"); 
								}catch(IllegalArgumentException iae){ 
									System.out.println("Solo números porfavor");
								}catch(Exception e){
									System.out.println("OCCURRIÓ ALGO INESPERADO");
								}
						break;

						case 3:
							System.out.println("Seleccionaste la matriz 3) ");
							System.out.println("Ingresa el escalar para multiplicar a la matriz");
								try{ 
									int esc3 = sc.nextInt();
									m4.multiplicarEscalar(m4,esc3);
									System.out.println("\nLa matriz 2) ha sido multiplicada por "+esc3);
									break;
								}catch(InputMismatchException ime){
									System.out.println("Dato inválido"); 
								}catch(IllegalArgumentException iae){ 
									System.out.println("Solo números porfavor");
								}catch(Exception e){
									System.out.println("OCCURRIÓ ALGO INESPERADO");
								}
						break;

					}
						muestraMenu();
						opcion = verificaRango(sc,1,10);	
				break;

				case 7:
					System.out.println("Tecleé el número correspondiente a la matriz para multiplicar por otra matriz");	
					int select7 = verificaRango(sc,1,3);

					switch(select7){
						case 1:
							System.out.println("Seleccionaste la matriz 1) ");
							System.out.println("Multiplicar matriz 1) x matriz 1) ...... selecciona 1");	
							System.out.println("Multiplicar matriz 1) x matriz 2) ...... selecciona 2");
							System.out.println("Multiplicar matriz 1) x matriz 3) ...... selecciona 3");	

							int opt7 = verificaRango(sc,1,3);
							switch(opt7){
								case 1:
									Matriz r1= m2.multiplicar(matriz, matriz);
									System.out.println(r1.formato());
									System.out.println("\nCreando archivo multiplicación(1,1).txt ");
									System.out.println(escribirArchivo("multiplicación(1,1).txt", r1.toString()));
								break;

								case 2:
									Matriz r2 = m2.multiplicar(matriz, matriz2);
									System.out.println(r2.formato());
									System.out.println("\nCreando archivo multiplicación(1,2).txt ");
									System.out.println(escribirArchivo("multiplicación(1,2).txt", r2.toString()));
								break;

								case 3:
									Matriz r3 =m2.multiplicar(matriz, matriz3);
								break;
							}

						break;

						case 2:
							System.out.println("Seleccionaste la matriz 2) ");
							System.out.println("Multiplicar matriz 2) x matriz 1) ...... selecciona 1");	
							System.out.println("Multiplicar matriz 2) x matriz 2) ...... selecciona 2");
							System.out.println("Multiplicar matriz 2) x matriz 3) ...... selecciona 3");	

							int opt72 = verificaRango(sc,1,3);
							switch(opt72){
								case 1:
									Matriz r4 = m3.multiplicar(matriz2, matriz);
									System.out.println(r4.formato());								
									System.out.println("\nCreando archivo multiplicación(2,1).txt ");
									System.out.println(escribirArchivo("multiplicación(2,1).txt", r4.toString()));
								break;

								case 2:
									Matriz r5 =m3.multiplicar(matriz2, matriz2);
									System.out.println(r5.formato());								
									System.out.println("\nCreando archivo multiplicación(2,2).txt ");
									System.out.println(escribirArchivo("multiplicación(2,2).txt", r5.toString()));
								break;

								case 3:
									Matriz r6 =m3.multiplicar(matriz2, matriz3);
								break;
							}
						break;

						case 3:
							System.out.println("Seleccionaste la matriz 3) ");
							System.out.println("Multiplicar matriz 3) x matriz 1) ...... selecciona 1");	
							System.out.println("Multiplicar matriz 3) x matriz 2) ...... selecciona 2");
							System.out.println("Multiplicar matriz 3) x matriz 3) ...... selecciona 3");	

							int opt73 = verificaRango(sc,1,3);
							switch(opt73){
								case 1:
									Matriz r7 = m4.multiplicar(matriz3, matriz);
								break;

								case 2:
									Matriz r8 = m4.multiplicar(matriz3, matriz2);
								break;

								case 3:
									Matriz r9 =m4.multiplicar(matriz3, matriz3);

								break;
							}
						break;
					}
					muestraMenu();
					opcion = verificaRango(sc,1,10);				

				break;


				case 8:
					System.out.println("Tecleé el número correspondiente a la matriz para después obtener su transpuesta");	
					int select8 = verificaRango(sc,1,3);
					switch(select8){
						case 1:
							System.out.println("Seleccionaste la matriz 1) \n\n"+matriz.formato()+ " \nSu matriz transpuesta es: \n");
							Matriz s8 = m2.transpuesta(matriz);
							System.out.println(s8.formato());
							System.out.println("\nCreando archivo Transpuesta1.txt ");
							System.out.println(escribirArchivo("Transpuesta1.txt", s8.toString()));
						break;

						case 2:
							System.out.println("Seleccionaste la matriz 2) \n\n"+matriz2.formato()+ " \nSu matriz transpuesta es: \n");
							Matriz s82 = m3.transpuesta(matriz2);
							System.out.println(s82.formato());
							System.out.println("\nCreando archivo Transpuesta2.txt ");
							System.out.println(escribirArchivo("Transpuesta2.txt", s82.toString()));
						break;


						case 3:
							System.out.println("Seleccionaste la matriz 1) \n\n"+matriz3.formato()+ " \nSu matriz transpuesta es: \n");
							Matriz s83 = m4.transpuesta(matriz3);
							System.out.println(s83.formato());
							System.out.println("\nCreando archivo Transpuesta3.txt ");
							System.out.println(escribirArchivo("Transpuesta3.txt", s83.toString()));
						break;
					}
					muestraMenu();
					opcion = verificaRango(sc,1,10);
				break;

				case 9:
					System.out.println("Tecleé el número correspondiente a la matriz para compararla y saber si es igual");	
					int select9 = verificaRango(sc,1,3);
						switch(select9){ 

						case 1:
							System.out.println("Seleccionaste la matriz 1) ");

							System.out.println("Comparar si matriz 1) es igual a  matriz 1) ...... selecciona 1");	
							System.out.println("Comparar si matriz 1) es igual a  matriz 2) ...... selecciona 2");
							System.out.println("Comparar si matriz 1) es igual a  matriz 3) ...... selecciona 3");	

							int opt91 = verificaRango(sc,1,3);
							switch(opt91){
								case 1:
									m2.sonIguales(matriz,matriz);
								break;

								case 2:
									m2.sonIguales(matriz, matriz2);
								break;

								case 3:
									m2.sonIguales(matriz, matriz3);
								break;
							}

						break;

						case 2:
							System.out.println("Seleccionaste la matriz 2) ");
							System.out.println("Comparar si la matriz 2) es igual a la matriz 1) ...... selecciona 1");	
							System.out.println("Comparar si la matriz 2) es igual a la matriz 2) ...... selecciona 2");
							System.out.println("Comparar si la matriz 2) es igual a la matriz 3) ...... selecciona 3");	

							int opt92 = verificaRango(sc,1,3);
							switch(opt92){
								case 1:
									m3.sonIguales(matriz2, matriz);
								break;

								case 2:
									m3.sonIguales(matriz2, matriz2);
								break;

								case 3:
									m3.sonIguales(matriz2, matriz3);
								break;
							}
						break;

						case 3:
							System.out.println("Seleccionaste la matriz 3) ");
							System.out.println("Comparar si la matriz 3) es igual a la matriz 1) ...... selecciona 1");	
							System.out.println("Comparar si la matriz 3) es igual a la matriz 2) ...... selecciona 2");
							System.out.println("Comparar si la matriz 3) es igual a la matriz 3) ...... selecciona 3");	

							int opt93 = verificaRango(sc,1,3);
							switch(opt93){
								case 1:
									m4.sonIguales(matriz3,matriz3);
								break;

								case 2:
									m4.sonIguales(matriz3, matriz2);
								break;

								case 3:
									m4.sonIguales(matriz3, matriz3);
								break;
							}
						}
						muestraMenu();
						opcion = verificaRango(sc,1,10);	
				break;

				case 10:
					System.out.println("  Que tenga buen día :D -----> Hasta pronto !!! ");
					sc.close();
					opcion =10;
				break;
			}
	 }while(opcion !=10);		

	
	}


}