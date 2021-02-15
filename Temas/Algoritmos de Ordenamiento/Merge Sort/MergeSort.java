public class MergeSort {
    
    /**
     * Compara dos objetos comparables. Si uno de los dos es nulo, se asume que
     * el valor es infinito. Regresa:
     * a) un entero negativo si el primero es menor que el segundo;
     * b) 0 si ambos objetos son iguales y 
     * c) un entero positivo si el primero es mayor que el segundo.
     */
    private int compare(Comparable x, Comparable y) {
        if (x == null) {
            if (y == null) {
                return 0;  // ambos son infinitos
            }
            return 1;  // x es infinito, y no lo es
        } else if (y == null) {
            return -1; // y es infinito, x no lo es
        }
        return x.compareTo(y); // ninguno es infinito
    }

    /**
     * Mezcla dos mitades del arreglo de elementos comparables considerando como
     * primera mitad, desde la posición first hasta la posición mid y como 
     * segunda mitad, desde la posición mid + 1 hasta la posicion last.
     */
    private void merge(Comparable[] array, int first, int mid, int last) {
        int n1 = mid - first + 1; // elementos en la primera mitad
        int n2 = last - mid; // elementos en la segunda mitad

        // arreglo temporal correspondiente a la primera mitad
        Comparable[] left = new Comparable[n1 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = array[first + i];
        }

        // arreglo temporal correspondiente a la segunda mitad
        Comparable[] right = new Comparable[n2 + 1];
        for (int j = 0; j < n2; j++) {
            right[j] = array[mid + j + 1];
        }

        // se hacen infinitos los valores
        // en las ultimas posiciones        
        left[n1] = null;
        right[n2] = null;

        for (int izq = 0, der = 0, indice = first; indice <= last; indice++) {
            if (compare(left[izq], right[der]) <= 0) {
                array[indice] = left[izq++];
            } else {
                array[indice] = right[der++];
            }
        }
    }

    /*
     * Ordena el arreglo que le pasan, de las posiciones first
     * a last, por mezcla (Mergesort).
     */
    private void mergeSort(Comparable[] array, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(array, first, mid);
            mergeSort(array, mid + 1, last);
            merge(array, first, mid, last);
        }
    }

    /**
     * Ordena el arreglo por mezcla (usando mergesort).
     *
     * @param array El arreglo a ordenar.
     */
    public void sort(Comparable[] array) {
        mergeSort(array, 0, array.length - 1);
    }
   
}
