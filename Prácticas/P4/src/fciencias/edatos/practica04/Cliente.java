package fciencias.edatos.practica04;

/**
 * Práctica 4: Colas 
 * Clase Cliente
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruíz Roberto Adrián // Num. Cta. 31721903-8
 * @version 1.0
 */

public class Cliente{

	/** EL nombre de un cliente*/
	private String nombre;

	/** Cantidad de comensales contando al cliente*/
	private int comensales;


	/**
	 * Metodo constructor para un nuevo cliente.
	 * @param nombre el nombre del cliente.
	 * @param comensales los comensales contando al cliente
	 */
	 public Cliente(String nombre,int comensales){
		this.nombre = nombre;
		this.comensales =comensales;
	}


	/** MÉTODOS DE ACCESO */

	/** Permite acceder al nombre de un cliente.
	 * @return el nombre del empleado.
	 */
	public String getNombre(){
		return this.nombre;
	}

	/** Permite acceder al número de comensales incluyendo al cliente.
	 * @return el numero de comensales incluyendo al cliente.
	 */
	public int getComensales(){
		return this.comensales;
	}	

	/** MÉTODOS MUTANTES */

	/**
	 * Permite modificar el nombre de un cliente en el restaurante.
	 * @param nombre el nuevo nombre del cliente.
	 */
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	/**
	 * Permite modificar el numero de comensales.
	 * @param comensales el nuevo numero de empleado.
	 */
	public void setComensales(int comensales){
		this.comensales=comensales;
	}




}