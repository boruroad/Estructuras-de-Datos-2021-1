import java.util.ArrayList;

/**
* Implementación de Bucket Sort.
* @author Emmanuel Cruz Hernández.
* @version 1.0  Enero 2021.
* @since Laboratorio Estructuras de datos 2021-1.
*/
public class BucketSort{

	public static int n = 10;

	/**
	* Ordena una lista con BucketSort.
	* @param una lista de enteros.
	*/
	public static void bucketSort(ArrayList<Integer> s){
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

		int mayor = s.get(0);

		for(Integer e : s)
			if(e > mayor)
				mayor = e;

		int nuevaL = mayor+1;

		for (int i = 0; i<nuevaL ; i++) {
			buckets.add(new ArrayList<Integer>());
		}

		while(!s.isEmpty()){
			int k = s.remove(0);
			buckets.get(k).add(k);
		}

		for(ArrayList<Integer> bucket : buckets)
			while(!bucket.isEmpty())
				s.add(bucket.remove(0));
	}

	public static void muestraLista(ArrayList<Integer> lista){
		for(Integer elemento : lista)
			System.out.print(elemento + "\t");
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayList<Integer> elementos = new ArrayList<>();
		elementos.add(3);
		elementos.add(9);
		elementos.add(2);
		elementos.add(1);
		elementos.add(0);
		elementos.add(5);
		elementos.add(7);
		elementos.add(3);
		elementos.add(3);
		elementos.add(2);
		elementos.add(20);

		muestraLista(elementos);

		bucketSort(elementos);

		muestraLista(elementos);
	}
}