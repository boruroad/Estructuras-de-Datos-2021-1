package fciencias.edatos.practica06;
import java.util.ArrayList; 

/**
 * Práctica 6: Árboles binarios de búsqueda.
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación incluye material brindado por:
 * Emmanuel Cruz Hernández 
 * @version 1.0
 */
public class ArbolBinarioBusqueda<T>{

	/** Nodo binario de un arbol de binario de busqueda */
	private class NodoBinario<T>{

		/** Nodo padre. */
		private NodoBinario<T> padre;

		/** Hijo izquierdo. */
		private NodoBinario<T> izquierdo;

		/** Hijo derecho. */
		private NodoBinario<T> derecho;

		/** Elemento almacenado en el nodo. */
		private T elemento;

		/** Peso del nodo. */
		private String key;

		/**
		* Crea un nuevo nodo binario.
		* @param elemento el elemento almacenar en el nodo.
		* @param key el peso del nodo.
		*/
		public NodoBinario(T elemento, String key){
			this.elemento = elemento;
			this.key = key;
		}

		/**
		* Crear un nuevo nodo binario con padre.
		* @param elemento el elemento almacenar en el nodo.
		* @param key el peso del nodo.
		* @param padre el padre del nodo creado.
		*/
		public NodoBinario(T elemento, String key, NodoBinario<T> padre){
			this.elemento = elemento;
			this.key = key;
			this.padre = padre;
		}

	}

	/** Root. */
	private NodoBinario<T> raiz;
	static ArrayList<Ciudad> listaCiudades;


	public T retrieve(String key){
		NodoBinario<T> buscado = retrieveAux(key, raiz);
		if(buscado == null)
			return null;
		return buscado.elemento;
	}

	/**
	* Recorrer los nodos del arbol hasta llegar
	* a aquel con clave key.
	* @param key la clave buscada.
	* @param actual el nodo actual del recorrido sobre el arbol.
	* @return el nodo con clave key.
	*/
	private NodoBinario<T> retrieveAux(String key, NodoBinario<T> actual){
		if(actual == null)
			return null;

		if(key.compareTo(actual.key)==0){
			return actual;
		}

		if(key.compareTo(actual.key)<0){
			if(actual.izquierdo==null){
				return null;
			}
			return retrieveAux(key, actual.izquierdo);
		}else{
			if(actual.derecho==null){
				return null;
			}
			return retrieveAux(key, actual.derecho);
		}
	}

	public void insert(T e, String key){
		NodoBinario<T> nuevo = new NodoBinario<T>(e, key);
		if(raiz == null){
			raiz = nuevo;
		} else{
			insertAux(nuevo, raiz);
		}
	}

	/**
	* Permite agregar un nuevo elemento a un arbol.
	* @param nuevo el nuevo nodo a agregar.
	* @param actual el nodo auxiliar del recorrido.
	*/
	private void insertAux(NodoBinario<T> nuevo, NodoBinario<T> actual){
		if(nuevo.key.compareTo(actual.key)<0){
			if(actual.izquierdo == null){
				nuevo.padre = actual;
				actual.izquierdo = nuevo;
			} else{
				insertAux(nuevo, actual.izquierdo);
			}
		} else{
			if(actual.derecho == null){
				nuevo.padre = actual;
				actual.derecho = nuevo;
			} else{
				insertAux(nuevo, actual.derecho);
			}
		}
	}

	public T delete(String key){
		NodoBinario<T> eliminado = retrieveAux(key, raiz);
		return removeAux(eliminado);
	}

	/**
	* Permite eliminar un nodo de un arbol.
	* @param eliminado el nodo a eliminar.
	* @return el elemento almacenado en el nodo a eliminar.
	*/
	public T removeAux(NodoBinario<T> eliminado){
		if(eliminado == null){
			return null;
		}

		NodoBinario<T> padre = eliminado.padre;
		T elemento = eliminado.elemento;

		// Cuando eliminado no tiene hijos.
		if(eliminado.izquierdo==null && eliminado.derecho==null){
			eliminado.elemento = null;
			return elemento;
		}

		// Cuando eliminado tiene dos hijos.
		if(eliminado.izquierdo!=null && eliminado.derecho!=null){
			NodoBinario<T> maximo = findMax(eliminado.izquierdo);

			eliminado.key = maximo.key;
			eliminado.elemento = maximo.elemento;

			removeAux(maximo);
			return elemento;
		}

		// Cuando eliminado tiene un hijo.
		NodoBinario<T> reemplazado = eliminado.derecho!=null? eliminado.derecho : eliminado.izquierdo;

		if(padre.izquierdo == eliminado){ // Hijo izquierdo
			padre.izquierdo = reemplazado;
			reemplazado.padre = padre;
		} else{ // Hijo derecho
			padre.derecho = reemplazado;
			reemplazado.padre = padre;
		}


		return elemento;
	}

	/**
	* Encuentra el elemento máximo a partir de un nodo actual
	* @param actual el nodo a partir del cual buscar el máximo.
	* @return nodo que contiene al elemento con peso máximo
	* a partir del nodo actual.
	*/
	private NodoBinario<T> findMax(NodoBinario<T> actual){
		NodoBinario<T> max = actual;

		while(max.derecho != null){
			max = max.derecho;
		}

		return max;
	}

	public T findMin(){
		if(raiz == null)
			return null;
		NodoBinario<T> min = raiz;

		while(min.izquierdo != null)
			min = min.izquierdo;

		return min.elemento;
	}

	public T findMax(){
		if(raiz == null)
			return null;
		NodoBinario<T> max = raiz;

		while(max.derecho != null)
			max = max.derecho;

		return max.elemento;
	}

	 /** 
	  * Método que encuentra las ciudades que estan dentro de un rango
	  * @param porLatitud un booleano que nos indica si hay que buscar por latitud o no
	  * @param num1 el primer numero
	  * @param num2 el segundo numero
	  * @return un ArrayList con elementos de tipo ciudad que se encuentran 
	  * dentro del rango establecido 
	  */
	public ArrayList<Ciudad> encuentraRango(boolean porLatitud, double num1, double num2){
		listaCiudades = new ArrayList<>();		
		encuentraRangoAux(porLatitud,num1, num2, raiz);
		System.out.println("Se terminó la validación del rango ");
		System.out.println("Ciudades dentro del rango "+num1+" a "+num2+" por "+(porLatitud?"latitud":"longitud\n"));
		return listaCiudades;
	}

	 /** 
	  * Método que auxiliar que encuentra las ciudades que estan dentro de un rango
	  * @param porLatitud un booleano que nos indica si hay que buscar por latitud o no
	  * @param num1 el primer numero
	  * @param num2 el segundo numero
	  * @param actual un NodoBinario
	  */
	private void encuentraRangoAux(boolean porLatitud, double num1, double num2, NodoBinario<T> actual){				
		if(actual != null){			
			if(actual.elemento != null){
				Ciudad cd = (Ciudad) actual.elemento;					
				
				if(porLatitud){					
					if((cd.getLatitud()>=num1) && (cd.getLatitud()<=num2)){						
						listaCiudades.add(cd);
					}
				}else{					
					if((cd.getLongitud()>=num1) && (cd.getLongitud()<=num2)){						
						listaCiudades.add(cd);
					}
				}
			}					
			if(actual.izquierdo!=null){				
				encuentraRangoAux(porLatitud,num1,num2, actual.izquierdo);						
			}			
			if(actual.derecho!=null){					
				encuentraRangoAux(porLatitud,num1,num2, actual.derecho);
			}			
		}
	}	
}