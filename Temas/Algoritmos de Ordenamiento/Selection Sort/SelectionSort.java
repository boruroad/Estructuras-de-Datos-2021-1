
public class SelectionSort {

    private static void swap(Comparable[] array, int i, int j) {
        Comparable c;
        if (i != j) {
            c = array[i];
            array[i] = array[j];
            array[j] = c;
        }
    }

    private static String toString(Object array[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void sort(Comparable[] array) {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }
            swap(array, i, min);
            System.out.println(toString(array));
            System.out.println(positionSwap(i, min));
        }
    }

    private static String positionSwap(int i, int j) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k <= j; k++) {
            if (k == i || k == j) {
                sb.append("^");
            } else {
                sb.append(" ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String array[] = "q w e r t y u".split(" ");
        System.out.println(toString(array));
        sort(array);
        System.out.println(toString(array));
    }

}
