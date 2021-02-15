package fciencias.edatos.graficas;

/**
* Implementación de una gráfica 
* NO dirigda usando una lista de adyacencias.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Enero 2021.
* @since Estructuras de datos 2021-1.
*/
public class GraficaLista<V, E> implements TDAGrafica<V, E>{
	
	/** Lista que almacena los vértices. */
	private ListaLigada<V> vertices;

	/** Lista de aristas. */
	private ListaLigada<Arista<V, E>> aristas;

	/**
	* Crea una nueva grafica.
	*/
	public GraficaLista(){
		vertices = new ListaLigada<>();
		aristas = new ListaLigada<>();
	}

	@Override
	public int numVertex(){
		return vertices.size();
	}

	@Override
	public int numEdges(){
		return aristas.size();
	}

	@Override
	public TDALista<V> getVertex(){
		return vertices;
	}

	@Override
	public TDALista<Arista<V, E>> getEdge(){
		return aristas;
	}

	@Override
	public boolean getEdge(V v1, V v2){
		int longitud = aristas.size();
		for(int i = 0; i < longitud ; i++)
			if(aristas.get(i).isContained(v1, v2))
				return true;

		return false;
	}

	@Override
	public int outDegree(V v){
		int longitud = aristas.size();
		int out = 0;
		for(int i = 0; i < longitud ; i++)
			if(aristas.get(i).isContained(v))
				out++;

		return out;
	}

	@Override
	public void insertVertex(V v){
		vertices.add(vertices.size(), v);
	}

	@Override
	public V removeVertex(V v){
		int eliminado = -1;
		int longitud = vertices.size();
		for(int i = 0; i < longitud ; i++){
			if(v.equals(vertices.get(i))){
				eliminado = i;
				break;
			}
		}

		if(eliminado == -1)
			return null;

		V e = vertices.remove(eliminado);
		return e;
	}

	@Override
	public void removeEdge(V v1, V v2){
		int longitud = aristas.size();
		int pos = -1;
		for(int i = 0; i < longitud ; i++)
			if(aristas.get(i).isEdge(v1, v2)){
				pos = i;
				break;
			}

		if(pos == -1)
			return;

		aristas.remove(pos);
	}
}