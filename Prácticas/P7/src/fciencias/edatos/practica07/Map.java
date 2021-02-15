package fciencias.edatos.practica07;

/**
 * Práctica 7: Tablas de dispersión.
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación incluye material brindado por:
 * Emmanuel Cruz Hernández 
 * @version 1.0
 */
public interface Map<K,V>{
	
	/**
	* Regresa la cantidad de elementos contenidos en el mapa.
	* @return la cantidad de elementos contenidos.
	*/
	public int size();

	/**
	* Verifica si el mapa es vacio.
	* @return true si es vacio, false en otro caso.
	*/
	public boolean isEmpty();

	/**
	* Obtiene el elemento con clave k en el mapa.
	* @param key la clave asignada a un elemento para obtener.
	* @return el elemento con clave key.
	*/
	public V get(K key);

	/**
	* Agrega un nuevo elemento al mapa.
	* @param key la clave del elemento a agregar.
	* @param value el elemento a agregar.
	* @return el elemento antiguo almacenado con clave key o null si no existe.
	*/
	public V put(K key, V value);

	/**
	* Elimina el elemento con clave key.
	* @param key la clave del elemento a remover.
	* @return el elemento con clave key eliminado o null si no existe.
	*/
	public V remove(K key);
}