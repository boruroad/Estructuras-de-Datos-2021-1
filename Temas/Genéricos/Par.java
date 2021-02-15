public class Par {

    Object first;
    Object second;

    public Par(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    public static void main(String args[]) {
        Par par = new Par("hola", 2);
        String string = (String)par.getFirst();
        Integer integer = (Integer)par.getSecond();
        System.out.println(string);
        System.out.println(integer);
    }
}
