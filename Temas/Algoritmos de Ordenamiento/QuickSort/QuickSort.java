
public class QuickSort {

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
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int start, int end) {
        int pivot;
        if (end > start) {
            pivot = choosePivot(array, start, end);
            sort(array, start, pivot - 1);
            sort(array, pivot + 1, end);
        }
    }

    private static int choosePivot(Comparable[] array, int start, int end) {
        int i = start, j = end + 1;
        Comparable v;
        int index = start;
        v = array[index];
        System.out.println("::::::::::");
        System.out.println(positionSwap(start, end, "|"));
        System.out.println(positionSwap(index, index, "!"));
        System.out.println(toString(array));
        while (true) {
            while (array[++i].compareTo(v) < 0) if (i == end) break;
            while (v.compareTo(array[--j]) < 0) if (j == start) break;
            if (i >= j) break;
            swap(array, i, j);
            System.out.println(positionSwap(i, j, "^"));
            System.out.println(toString(array));
        }
        swap(array, start, j);
        System.out.println(positionSwap(start, j, "^"));
        System.out.println(toString(array));
        return j;
    }

    private static String positionSwap(int i, int j, String s) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k <= j; k++) {
            if (k == i || k == j) {
                sb.append(s);
            } else {
                sb.append(" ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String array[] = "5 9 2 0 1 8 4 7 6 3".split(" ");
        System.out.println(toString(array));
        sort(array);
        System.out.println(toString(array));
    }

}
