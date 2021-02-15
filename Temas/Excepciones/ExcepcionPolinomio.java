/**
 * Clase que representa una excepción para operaciones
 * en polinomios.
 * 
 * @author Carlos Zerón Martínez
 */
public class ExcepcionPolinomio extends Exception {
    public ExcepcionPolinomio() {
        super();
    }

    public ExcepcionPolinomio(String msg) {
        super(msg);
    }
}
