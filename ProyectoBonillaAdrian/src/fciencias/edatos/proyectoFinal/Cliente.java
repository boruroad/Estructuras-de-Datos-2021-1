package fciencias.edatos.proyectoFinal;

/**
 * Proyecto Final: Comunicaciones telefónicas
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * @version 1.0
 */

public class Cliente{

		/* ATRIBUTOS DE UN CLIENTE */

	/* El nombre del cliente */
	String nombre;

	/* El telefono del cliente */
	int telefono;

	
	/* MÉTODO CONSTRUCTOR DE UN CLIENTE */
	public Cliente(String nombre, int telefono){
		this.nombre   = nombre;
		this.telefono = telefono;
	}

	public Cliente(){}

		/*  MÉTODOS DE ACCESO */

	/** Permite acceder al nombre del cliente.
	 * @return el nombre del cliente.
	 */
	public String getNombre(){
		return this.nombre;
	}

	/** Permite acceder al telefono del cliente.
	 * @return el telefono del cliente.
	 */
	public int getTelefono(){
		return this.telefono;
	}

	
		/* MÉTODOS MUTANTES */

	/** Permite modificar el nombre del cliente.
	 * @param nombre el nuevo nombre del cliente.
	 */
	public void setNombre(String nombre){
		 this.nombre = nombre;
	}

	/** Permite modificar el telefono del cliente.
	 * @param telefono el nuevo telefono del cliente.
	 */
	public void setTelefono(int telefono){
		 this.telefono = telefono;
	}
}