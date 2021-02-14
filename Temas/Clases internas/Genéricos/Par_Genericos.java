public class Par_Genericos<E, T> {

    E first;
    T second;

    public Par_Genericos(E first, T second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public static void main(String args[]) {
        Par_Genericos<String, Integer> par = new Par_Genericos<>("hola", 2);
        String string = par.getFirst();
        Integer integer = par.getSecond();
        System.out.println(string);
        System.out.println(integer);
    }
}
