package fciencias.edatos.practica05;

/**
 * Práctica 5: Aplicaciones de árboles, XML.
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * @version 1.0
 */

public class Automovil{

	/* Atributos de un automovil */
	public String marca; 
	public String modelo; 
	public String placas; 
	public int    anio;
	public String nombre;	
	public String materno;
	public String paterno;
	public String opinion;
	public boolean existAnio;
	public boolean existPlacas;


	/**
	 * Metodo constructor para un nuevo automovil.
	 * @param marca la marca del automovil.
	 * @param modelo el modelo del automovil.
	 * @param placas las placas del automovil.
	 * @param anio el anio del automovil.
	 * @param nombre nombre del duenio del automovil.
	 * @param materno apellido materno del duenio  del automovil.
	 * @param paterno apellido paterno del duenio del automovil.
	 * @param opinion opnion del automovil por parte del duenio.
	 */
	 public Automovil(String marca,String modelo,String placas,int anio,String nombre,String materno,String paterno,String opnion){
		this.marca=marca;
		this.modelo=modelo;
		this.placas=placas;
		this.anio=anio;
		this.nombre=nombre;
		this.materno=materno;
		this.paterno=paterno;
		this.opinion=opinion;
	}


	/** MÉTODOS DE ACCESO */

	/** Permite acceder a la marca del automovil.
	 * @return la marca del automovil.
	 */
	public String getMarca(){
		return this.marca;
	}

	/** Permite acceder al modelo del automovil.
	 * @return el modelo del automovil.
	 */
	public String getModelo(){
		return this.modelo;
	}

	/** Permite acceder a las placas del automovil.
	 * @return las placas del automovil.
	 */
	public String getPlacas(){
		return this.placas;
	}

	/** Permite acceder al anio del automovil.
	 * @return el anio del automovil.
	 */
	public int getAnio(){
		return this.anio;
	}

	/** Permite acceder al nombre del duenio del automovil.
	 * @return el nombre el duenio del automovil.
	 */
	public String getNombre(){
		return this.nombre;
	}

	/** Permite acceder al apellido materno del duenio del automovil.
	 * @return el apellido materno del duenio del automovil.
	 */
	public String getMaterno(){
		return this.materno;
	}

	/** Permite acceder al apellido paterno del duenio del automovil.
	 * @return el apellido paterno del duenio del automovil.
	 */
	public String getPaterno(){
		return this.paterno;
	}

	/** Permite acceder a la opinion del duenio del automovil.
	 * @return la opinion del duenio del automovil.
	 */
	public String getOpinion(){
		return this.opinion;
	}

	/** MÉTODOS MUTANTES */

	/** Permite modificar la marca del automovil.
	 * @param marca la marca del automovil.
	 */
	public void setMarca(String marca){
		this.marca=marca;
	}

	/** Permite modificar al modelo del automovil.
	 * @param modelo el modelo del automovil.
	 */
	public void setModelo(String modelo){
		this.modelo=modelo;
	}

	/** Permite modificar a las placas del automovil.
	 * @param placas las del automovil.
	 */
	public void setPlacas(String placas){
		this.placas=placas;
	}

	/** Permite modificar al anio del automovil.
	 * @param anio el anio del automovil.
	 */
	public void setAnio(int anio){
		this.anio=anio;
	}

	/** Permite modificar al nombre del duenio del automovil.
	 * @param nombre el nombre del duenio del automovil.
	 */
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	/** Permite modificar al apellido materno del duenio del automovil.
	 * @param apellido el apellido materno del duenio del automovil.
	 */
	public void setMaterno(String materno){
		this.materno=materno;
	}

	/** Permite modificar al apellido paterno del duenio del automovil.
	 * @param apellido el apellido paterno del duenio del automovil.
	 */
	public void setPaterno(String paterno){
		this.paterno=paterno;
	}

	/** Permite modificar a la opinion del duenio del automovil.
	 * @param opinion la opinion del duenio del automovil.
	 */
	public void setOpinion(String opinion){
		this.opinion=opinion;
	}

	/** Permite modificar si existe o no el anio del automovil.
	 * @param valor el nuevo valor a ingresar.
	 */
	public void setExistAnio(boolean valor){
		this.existAnio=valor;
	}

	/** Permite modificar si existe o no las placas del automovil.
	 * @param placa el nuevo valor a ingresar.
	 */
	public void setExistPlacas(boolean placa){
		this.existPlacas=placa;
	}
	


}