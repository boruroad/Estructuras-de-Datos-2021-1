package fciencias.edatos.graficas;

/**
* Implementacion de una lista con una matriz de adyacencias.
* SI dirigida.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Enero 2021.
* @since Estructuras de datos 2021-1.
*/
public class GraficaMatriz<V, E> implements TDAGrafica<V, E>{
	
	/** Vertices de la grafica. */
	private V[] vertices;

	/** Matriz de adyacencias. */
	private int[][] aristas;

	private final static int MAX = 50;

	private int cantidad;

	/**
	* Crea una nueva grafica.
	*/
	public GraficaMatriz(){
		vertices = (V[]) new Object[MAX];

		aristas = new int[MAX][MAX];

		cantidad = 0;
	}

	@Override
	public int numVertex(){
		return cantidad;
	}

	@Override
	public int numEdges(){
		int arist = 0;

		for(int[] renglon : aristas)
			for(int elemento : renglon)
				if( elemento == 1)
					arist ++;

		return arist;
	}

	@Override
	public TDALista<V> getVertex(){
		TDALista<V> verticesLista = new ListaLigada<>();

		for(V vertice : vertices)
			if(vertice != null)
				verticesLista.add(0, vertice);

		return verticesLista;
	}

	@Override
	public TDALista<Arista<V, E>> getEdge(){
		TDALista<Arista<V, E>> aristasLista = new ListaLigada<>();

		for(int i = 0; i < vertices.length; i++)
			for(int j = 0; j < vertices.length; j++)
				if(aristas[i][j] == 1){
					Arista<V, E> nueva = new Arista<>(vertices[i], vertices[j]);
					aristasLista.add(0, nueva);
				}

		return aristasLista;

	}

	@Override
	public boolean getEdge(V v1, V v2){
		int pos1 = posId(v1);
		int pos2 = posId(v2);

		if(pos1 < 0 || pos2 < 0)
			return false;

		int existe = aristas[pos1][pos2];

		return existe == 1;
	}

	private int posId(V v){
		for(int i = 0; i < vertices.length; i++)
			if(v.equals(vertices[i]))
				return i;

		return -1;
	}

	@Override
	public int outDegree(V v){
		int pos = posId(v);
		int cantidad = 0;

		for(int i = 0; i < vertices.length ; i++)
			if(aristas[pos][i] == 1)
				cantidad++;

		return cantidad;
	}

	@Override
	public void insertVertex(V v){
		if(cantidad == vertices.length)
			return;

		vertices[cantidad++] = v;
	}

	@Override
	public V removeVertex(V v){
		int pos = posId(v);

		if(pos == -1)
			return null;

		V eliminado = vertices[pos];
		vertices[pos] = null;

		for(int i = 0; i<vertices.length; i++){
			aristas[pos][i] = 0;
			aristas[i][pos] = 0;
		}

		return eliminado;

	}

	@Override
	public void removeEdge(V v1, V v2){
		int pos1 = posId(v1);
		int pos2 = posId(v2);

		if(pos1 < 0 || pos2 < 0)
			return;

		aristas[pos1][pos2] = 0;
	}
}