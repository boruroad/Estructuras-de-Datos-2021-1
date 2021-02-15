package fciencias.edatos.practica04;

/**
 * Práctica 4: Colas 
 * Clase Mesa 
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruíz Roberto Adrián // Num. Cta. 31721903-8
 * @version 1.0
 */

public class Mesa{

	/** El identificador de una mesa */
	private String id;

	/** La capacidad de comensales que hay en una mesa */
	private int capComen;

	/** Saber si una mesa esta ocupada o no*/
	private boolean ocupado; 

	/**
	 * CONSTRUCTOR. Construye una nueva Mesa.
	 * @param id el id de la mesa.
	 * @param capComen cantidad de comensales de la mesa.
	 * @param ocupado el estado de una mesa.
	 */
	 public Mesa(String id, int capComen, boolean ocupado){
		this.id = id;
		this.capComen = capComen;		
		this.ocupado = ocupado;
	}


	/** METODOS DE ACCESO */

	/** Permite acceder al identificador de una mesa.
	 *  @return el identificador de una mesa.
	 */	
	public String getIdentificador(){
		return this.id;
	}

	/** Permite acceder a la capacidad de comensales de una mesa.
	 *  @return la capacidad de comensales de una mesa.
	 */
	public int getCapacidadComen(){
		return this.capComen;
	}	

	/** Permite acceder al estado de una mesa.
	 *  @return el estado de una mesa.
	 */
	public boolean getEstado(){
		return this.ocupado;
	}		


	/** MÉTODOS MUTANTES */

	/** Permite modificar el identificador de una mesa.
	 *  @param num el nuevo identificador de una mesa.
	 */	
	public void setIdentificador(int num){
		this.id = "Mesa "+num;
	}

	/** Permite modificar la capacidad de comensales de una mesa.
	 *  @param capComen la nueva capacidad de comensales de una mesa.
	 */
	public void setCapacidadComen(int capComen){
		this.capComen = capComen;
	}	

	/** Permite modificar el estado de una mesa.
	 *  @param ocupado el nuevo estado a ingresar.
	 */
	public void setEstado(boolean ocupado){
		this.ocupado= ocupado;
	}	

	/** Método toString para mostrar un mesa */
	@Override
	public String toString() {
		if(this.ocupado==false){
			if(this.capComen==1){
				return "\nIdentificador: " + this.id + "\nCapacidad de la mesa: " + this.capComen+ " persona"+"\nOcupada: NO";
			}else{
				return "\nIdentificador: " + this.id + "\nCapacidad de la mesa: " + this.capComen+ " personas"+"\nOcupada: NO";
			}
		}else{
			if(this.capComen==1){
				return "\nIdentificador: " + this.id + "\nCapacidad de la mesa: " + this.capComen+ " persona"+"\nOcupada: SI";
			}else{
				return "\nIdentificador: " + this.id + "\nCapacidad de la mesa: " + this.capComen+ " personas"+"\nOcupada: SI";
			}
		}
	}
}