package fciencias.edatos.practica06;

/**
 * Práctica 6: Árboles binarios de búsqueda.
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * @version 1.0
 */

public class Ciudad{

	/* Atributos de una Ciudad */

	/** Nombre de la ciudad */
	public String nombre;

	/** Estado de la república donde se encuentra */
	public String estado;

	/** Coordenadas geográficas de la ciudad */
	public double longitud;
	public double latitud;

	/** Constructor por omision */
	public Ciudad (){
	}

	/**
	 * Metodo constructor para una Ciudad.
	 * @param nombre el nombre de la ciudad.
	 * @param estado el estado al que pertenece la ciudad.
	 * @param longitud lo longitud de la ciudad.
	 * @param latitud la latitud de la ciudad.
	 */
	 public Ciudad(String nombre,String estado,double longitud,double latitud){
		this.nombre=nombre;
		this.estado=estado;
		this.longitud=longitud;
		this.latitud=latitud;
	}

	/** MÉTODOS DE ACCESO */

	/** Permite acceder al nombre de la ciudad.
	 * @return el nombre de la ciudad.
	 */
	public String getNombre(){
		return this.nombre;
	}

	/** Permite acceder al estado que pertenece la ciudad.
	 * @return el estado que pertenece la ciudad.
	 */
	public String getEstado(){
		return this.estado;
	}

	/** Permite acceder a la longitud de la ciudad.
	 * @return la longitud de la ciudad
	 */
	public double getLongitud(){
		return this.longitud;
	}

	/** Permite acceder a la latitud de la ciudad.
	 * @return la latitud de la ciudad.
	 */
	public double getLatitud(){
		return this.latitud;
	}	

		/** MÉTODOS MUTANTES */

	/** Permite modificar el nombre de la ciudad.
	 * @param nombre el nuevo nombre de la ciudad.
	 */
	public void setNombre(String nombre){
		 this.nombre = nombre;
	}

	/** Permite modificad al estado que pertenece la ciudad.
	 * @param estado el nuevo estado al que pertenece la ciudad.
	 */
	public void setEstado(String estado){
		this.estado = estado;
	}

	/** Permite modificar la longitud de la ciudad.
	 * @param longitud la nueva long de la ciudad
	 */
	public void setLongitud(double longitud){
		this.longitud = longitud;
	}

	/** Permite modificar la latitud de la ciudad.
	 * @param latitud la latitud de la ciudad.
	 */
	public void setLatitud(double latitud){
		this.latitud = latitud;
	}	

	@Override
	public String toString(){
		return "Ciudad: "+this.nombre+"\nEstado: "+this.estado+"\nLongitud:"+this.longitud+"\nLatitud: "+this.latitud+"\n";
	} 


	

}
