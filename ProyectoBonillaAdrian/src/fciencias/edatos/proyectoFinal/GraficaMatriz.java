package fciencias.edatos.proyectoFinal;
/**
 * Proyecto Final: Comunicaciones telefónicas
 * Estructura de Datos 2021-1.
 * Implementacion de una lista con una matriz de adyacencias.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación incluye material brindado por:
 * Emmanuel Cruz Hernández 
 * @version 1.0
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
		int pos = posId(v)
;		int cantidad = 0;

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
		aristas[pos2][pos1] = 0;

	}

	/** Método que agrega aristas*/
	public void addEdge(Integer e1, Integer e2){
		aristas[e1][e2] = 1;
		aristas[e2][e1] = 1;

	}

//	public void showE(){
//		for (int i=0;i<this.aristas.length;i++){
//			for (int j=0;j<this.aristas[i].length;j++){
//				System.out.println("C1: "+String.valueOf(aristas[i])+"\nA2: "+aristas[j]+"\n");
//				//System.out.println(aristas[j]);
//			}
//		}
//	}	
}