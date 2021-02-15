package fciencias.edatos.practica07;

/**
 * Práctica 7: Tablas de dispersión.
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * @version 1.0
 */

public class Elemento{

		/* ATRIBUTOS DE UN ELEMENTO */

	/* El nombre del Elemento */
	String nombre;

	/* El simbolo  del elemento */
	String simbolo;

	/* La masa del elemento*/
	double masa;

	public Elemento(){
	}
		/*  MÉTODOS DE ACCESO */

	/** Permite acceder al nombre del elemento.
	 * @return el nombre de la elemento.
	 */
	public String getNombre(){
		return this.nombre;
	}

	/** Permite acceder al simbolo del elemento.
	 * @return el nombre del elemento.
	 */
	public String getSimbolo(){
		return this.simbolo;
	}

	/** Permite acceder a la masa del elemento.
	 * @return la masa del elemento.
	 */
	public double getMasa(){
		return this.masa;
	}

		/* MÉTODOS MUTANTES */

	/** Permite modificar el nombre del elemento.
	 * @param nombre el nuevo nombre del elemeto.
	 */
	public void setNombre(String nombre){
		 this.nombre = nombre;
	}

	/** Permite modificar el simbolo del elemento.
	 * @param simbolo el nuevo simbolo del elemeto.
	 */
	public void setSimbolo(String simbolo){
		 this.simbolo = simbolo;
	}

	/** Permite modificar la masa del elemento.
	 * @param masa la nueva masa del elemeto.
	 */
	public void setMasa(double masa){
		 this.masa = masa;
	}
	

}