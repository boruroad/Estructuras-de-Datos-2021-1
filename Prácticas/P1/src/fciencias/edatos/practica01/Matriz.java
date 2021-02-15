package fciencias.edatos.practica01;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Práctica 1: TDA y Estructura de Datos 2021-1.
 * @author Bonilla Ruíz Roberto Adrián // Num. Cta. 31721903-8
 * @version 1.0
 */

/** Clase que representa una Matriz e implementa nuestra interfaz. */
public class Matriz implements OperacionesMatrices{

	private double[][] matriz;

	/** Constructor sin parámetros*/
	public Matriz(){};

	/**
	 * Método que permite escribir una matriz.
	 * @param cadena los valores que va a tener la matriz.
	 */
	public Matriz(String cadena){
		String[] array1 = cadena.split(";");

		matriz = new double[array1.length][array1[0].split(",").length];

		for (int i=0;i<array1.length;i++){
			String[] array2 = array1[i].split(",");
			for (int j=0; j<array2.length;j++){
				matriz[i][j] = Double.parseDouble(array2[j]);
			}
		}
	}
	/** Método de acceso (getter) */
	public double[][] getMatriz(){
		return this.matriz;
	}

	/** Método mutante (setter)*/
	public void setMatriz(double [][] arreglo){
		this.matriz = arreglo;
	}
	/**
	 * Regresa la cantidad de renglones de una matriz
     * @return la cantidad de renglones de una matriz.
     */
	public int getNumeroRenglones(){
		return matriz == null ? 0:matriz.length;
	}

	/**
	 * Regresa la cantidad de columnas de una matriz
     * @return la cantidad de columnas de una matriz.
     */
	public int getNumeroColumnas(){
		return matriz ==null ? 0:matriz[0].length;	
	}

	/**
	 * Método que indica el elemento en la posición M[i, j] de una matriz
	 * @param matriz la matriz sumando
	 * @param inicio -- la representacion de i
	 * @param fin -- la representacion de j  
	 * @return double -- el elemento de la matriz
	 */
	 public double indicaElemento(Matriz matriz, int inicio, int fin){
		try{
			return  matriz.getMatriz()[inicio-1][fin-1];
		}catch(IndexOutOfBoundsException iobe){
			System.out.println("Fuera de rango");
			return 0;			
		}
  	}	

	/**
	 * Método que modifica un elemento de una matriz en la posición [i, j]
	 * @param matriz la matriz seleccionada
	 * @param elemento -- el elemento a reemplazar
	 * @param inicio -- la representacion de i
	 * @param fin -- la representacion de j 
	 * @return Matriz la matriz con el elemento nuevo 
	 */
  	public Matriz modificaElemento(Matriz matriz, double elemento, int inicio, int fin){
  		try{
  			matriz.getMatriz()[inicio-1][fin-1]=elemento;
			return  matriz;
		}catch(IndexOutOfBoundsException iobe){
			System.out.println("Fuera de rango");
			return null;			
		}
  	}

	/**
	 * Método para sumar dos matrices
	 * @param matriz la matriz sumando
	 * @param matriz2 la matriz sumador 
	 * @return Matriz -- la matriz resultado
	 */
	public  Matriz sumarMatrices(Matriz matriz, Matriz matriz2){
		Matriz m1 = new Matriz();
		double [][] sumando = matriz.getMatriz();
		double [][] sumador =matriz2.getMatriz();
		if(sumando.length == sumador.length){
			double [][]resultado = new double [sumando.length][sumador[0].length];
			for(int i = 0; i < sumando.length; i++){
	           for(int j=0; j < sumando[i].length; j++){
	               resultado[i][j] = sumando[i][j] + sumador[i][j];
	              System.out.print(resultado[i][j]+ " ");
	           }
	              System.out.print("\n");
	        }
	           		m1.setMatriz(resultado);
		}else{ 
			System.out.println("Las matrices ingresadas no pueden ser sumadas debido a que no tienen el mismo tamaño (no se creará ningún archivo)");
		}
		return m1;
	}

	/** Nota: En este método no añadí archivos porque yo vi que el escalar no se contaba como matriz, entonces por eso solo lo
			  muestro en pantalla, pero no lo guardo (porque es un escalar, no una matriz)*/
	/**
	 * Método para multiplicar una matriz por un escalar.
	 * @param matriz la matriz que va a ser multiplicada
	 * @param escalar el escalar a multiplicar por la matriz  
	 */
	public void multiplicarEscalar(Matriz mat, double escalar){ 
		double [][] obtiene = mat.getMatriz();
        for(int i=0;i<obtiene.length;i++){
            for(int j=0;j<obtiene[i].length;j++){
                obtiene[i][j] *= escalar;
            	System.out.print("\t" + obtiene[i][j]);
            }
            System.out.println();
        }
    }

	/**
	 * Método para multiplicar una matriz por otra.
	 * @param ma1 la primer matriz de la multiplicacion
	 * @param m2  la segunda matriz de la multiplicacion 
	 * @return Matriz - la matriz como producto de las ingresadas como parámetro
	 */
		public  Matriz multiplicar (Matriz ma1,Matriz ma2) { 
		Matriz m = new Matriz(); 
		double[][] m1 = ma1.getMatriz();
		double[][] m2 = ma2.getMatriz();
		
		int filasMatriz1 = m1.length;
		int columnasMatriz1 = m1[0].length;
		
		int filasMatriz2 = m2.length;
		int columnasMatriz2 = m2[0].length;
		
		try{ 
			if (columnasMatriz1 != filasMatriz2){
				throw new RuntimeException("Operacion inválida: No se pueden multiplicar las matrices (No se creará ningún archivo) ");
			}
			// La nueva matriz es de filas de M1 y columnas de M2
			double[][] multiplicacion = new double[filasMatriz1][columnasMatriz2];
	
				for (int x=0; x < multiplicacion.length; x++) {
		            for (int y=0; y < multiplicacion[x].length; y++) {
		            	for (int z=0; z<columnasMatriz1; z++) {
		            		multiplicacion [x][y] += m1[x][z]*m2[z][y];
		            	}
		            }	
				}
			m.setMatriz(multiplicacion);
		}catch(RuntimeException re){
			System.out.println("Estas tratando de multiplicar una matriz con un número de columnas en la primera matriz, distinto al de los reglones ó filas de la segunda\n(No se creará ningún archivo)");
		}catch(Exception e){
			System.out.println("ALGO INESPERADO OCURRIÓ");
		}
		return m;
	}

	/** Nota: En este método si añadí archivos porque aunque no se empleaban dos matrices, creí relevante 
			  hacer notar la diferencia usanod archivos*/
	/**
	 * Método para hacer la transpuesta de una matriz.
	 * @param ma1 la primer matriz de la multiplicacion
	 * @return Matriz -- la matriz transpuesta
	 */
	public Matriz  transpuesta(Matriz trans) {
		Matriz t = new Matriz();
		double[][] matriz = trans.getMatriz();
		double[][] nuevaMatriz = new double[matriz[0].length][matriz.length];
		
		for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
            		nuevaMatriz[y][x] = matriz[x][y];
            }
		}
			t.setMatriz(nuevaMatriz);
		return t;
	}

	/** Nota: El método "deepEquals" lo obtuve gracias a: https://www.geeksforgeeks.org/java-util-arrays-deepequals-java/ y a: https://docs.oracle.com/javase/8/docs/api/java/util/Objects.html (siempre es bueno dar crédito).
			  Asimismo, este método no crea archivos porque a pesar de operar con dos matrices, el resultado no es una matriz */
	/**
	 * Método que comprueba si dos matrices son iguales.
	 * @param matrizUno la primer matriz a comparar
	 * @param matrizDos la primer segunda matriz a comparar
	 * @return boolean -- "true" si son iguales, "false" si no.
	 */
	public  boolean sonIguales(Matriz matrizUno, Matriz matrizDos) {
		double [][] m1 = matrizUno.getMatriz();
		double [][] m2 = matrizDos.getMatriz();
		 if(Arrays.deepEquals(m1, m2)){
		 	System.out.println("La matriz \n"+matrizUno.formato()+" \nSI es igual a \n"+matrizDos.formato());
		 	return true;
		 }else{
		 	System.out.println("La matriz \n"+matrizUno.formato()+" \nNO es igual a \n"+matrizDos.formato());
		 }
		 return false;
	}
///////////////////////////////////////////////
	/** Método toString de una Matriz */
	@Override
    public String toString() {
    	if(this.matriz == null){
    		return "";
    	}
        String texto = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                texto += matriz[i][j] + ",";
            }
            texto += ";";
        }
        texto = texto.replace(",;", ";");
        texto = texto.substring(0, texto.length() - 1);
        return texto;
    }

    /** Método que da formato a nuestra matriz*/
	public String formato() {
	    String texto = "";
	    for(int i = 0; i < matriz.length; i++) {
			texto+="|";
	        for(int j = 0; j < matriz[i].length; j++) {
	            texto += matriz[i][j] + ",";
	        }
	        texto += "|\n";
	    }
	        texto = texto.replace(",|", "|").replaceAll(","," ");
	        return texto;
	    }





}