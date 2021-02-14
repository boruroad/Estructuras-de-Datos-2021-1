package fciencias.edatos.proyectoFinal;

/**
 * Proyecto Final: Comunicaciones telefónicas
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * @version 1.0
 */

public class Estacion{

		/* ATRIBUTOS DE UNA ESTACIÓN */

	/* El nombre de la estación */
	String nombre;

	/* Código identificador de área (número único). */
	int id;

	/* Lista de clientes de la estación */
	ListaLigada<Cliente> listaC;


	/**
	 * METODO CONSTRUCTOR PARA UNA NUEVA ESTACIÓN.
	 * @param nombre nombre de la estación.
	 * @param id el código identificador de área (número único) de la estación.
	 * @param cantidadClientes la cantidad de clientes que tiene la estación.
	 */
	public Estacion(String nombre, int id, ListaLigada<Cliente> listaC){ //, int cantidadClientes){
		this.nombre  		  = nombre;
		this.id     		  = id;
		this.listaC 		  = new ListaLigada<>();
	}

	public Estacion(){}

		/*  MÉTODOS DE ACCESO */

	/** Permite acceder al nombre de la estación.
	 * @return el nombre de la estación.
	 */
	public String getNombre(){
		return this.nombre;
	}

	/** Permite acceder al código identificador de área (número único) de la estación.
	 * @return el id de la estación.
	 */
	public int getId(){
		return this.id;
	}

	/** Permite acceder a la cantidad de clientes de la estación
	 * @return la cantidad de clientes de la estación.
	 */
	public ListaLigada<Cliente> getListaC(){
		return this.listaC;
	}

	/* MÉTODOS MUTANTES */

	/** Permite modificar el nombre de una estación.
	 * @param nombre el nuevo nombre de la estación.
	 */
	public void setNombre(String nombre){
		 this.nombre = nombre;
	}

	/** Permite modificar el código identificador de área (número único) de la estación.
	 * @param id el nuevo id de la estación.
	 */
	public void setId(int id){
		 this.id = id;
	}

	/** Permite modificar la cantidad de clientes de la estación.
	 * @param listaC la nueva lista de clientes de la estación.
	 */
	public void setListaC(ListaLigada<Cliente> listaC){
		 this.listaC = listaC;
	}
	

	/** Método que nos muestra las propiedades de una estación*/
	@Override 
	public String toString(){
		return "\nEstación: "+this.nombre+"\nCódigo identificador de área (número único): "+this.id+"\n";//+"\nCantidad de clientes: "+this.cantidadClientes;

	}

}