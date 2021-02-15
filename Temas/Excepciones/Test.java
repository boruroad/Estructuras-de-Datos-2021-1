public class Test {
public static void main(String[] args) {
try {
double promedio = promedio(new double[0]);
System.out.println("El promedio es: " + promedio);
} catch (Exception e) {
System.out.println("No fue posible calcular el promedio porque: " + e);
}
}
 public static double promedio(double[] array) throws Exception {
 try {
 return division(suma(array), array.length);
 } catch (IllegalArgumentException e) {
 throw new Exception("Se intento dividir entre cero.");
 }
 }
 public static double suma(double[] array) {
 double suma = 0;
 for (int i = 0; i < array.length; i++) {
 suma += array[i];
 }
 return suma;
 }
 public static double division(double a, double b) {
 if (-0.001 > b && b < 0.001) {
 throw new RuntimeException("Divide entre cero");
 }
 return a / b;
 }
 }