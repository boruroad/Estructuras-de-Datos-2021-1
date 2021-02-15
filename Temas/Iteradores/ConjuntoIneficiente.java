import java.util.*;

/**
 * Programa que implementa el tipo de datos abstracto conjunto.
 * @author Amparo L&oacute;pez Gaona
 * @version 1a edicion.
 */
public class ConjuntoIneficiente implements Conjuntable {
    private Object[] datos;

    /**
     * Constructor por omision. Crea espacio para un conjunto de 20 objetos.
     */
    public ConjuntoIneficiente() {
        this(20);
    }

    /**
     * Constructor de un conjunto con capacidad para los elementos
     * indicados. Si el tamanio es negativo o cero, se construye un
     * conjunto con capacidad para 20 elementos.
     * @param tam capacidad del conjunto.
     */
    public ConjuntoIneficiente(int tam) {
        datos = new Object[tam <= 0 ? 20 : tam];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = null;
        }
    }

    /**
     * Constructor de copia.
     * @param c -- conjunto que se tomara como valor inicial para
     * crear el nuevo.
     */
    public ConjuntoIneficiente(ConjuntoIneficiente c) {
        datos = new Object[c.datos.length];

        for (int i = 0; i < c.datos.length; i++) {
            datos[i] = c.datos[i];
        }
    }

    /**
     * Determina si el conjunto tiene elementos o no.
     * @return boolean - Devuelve true si el conjunto no tiene elementos y
     *  false en otro caso.
     */
    public boolean estaVacio() {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null) return false;
        }
        return true;
    }

    /**
     * Devuelve la cantidad de elementos que tiene el conjunto.
     * @return int - cantidad de  elementos que tiene el conjunto.
     */
    public int tamanio() {
        int tam = 0;

        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null) tam++;
        }
        return tam;
    }

    /**
     * Elimina los elementos que tiene el conjunto.
     */
    public void vaciar() {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = null;
        }
    }


    /**
     * Determina si un elemento esta contenido en el conjunto.
     * @param elemento - elemento que se desea saber si esta en el conjunto.
     * @return boolean - devuelve true si el elemento esta en el conjunto y
     *                   false en otro caso.
     */
    public boolean contiene(Object elemento) {
        if (!estaVacio()) {
            for (int i = 0; i < datos.length; i++) {
                if (elemento.equals(datos[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Elimina del conjunto el elemento especificado.
     * @param elemento - elemento que se desea eliminar del conjunto.
     */
    public void eliminar(Object elemento) {
        if (!estaVacio()) {
            for (int i = 0; i < datos.length; i++) {
                if (elemento.equals(datos[i])) {
                    datos[i] = null;
                    return;
                }
            }
        }
    }

    /**
     * Agrega un elemento al conjunto, siempre y cuando no exista.
     * @param elemento - Elemento a insertar.
     * @throws IllegalArgumentException - cuando el conjunto esta lleno.
     */
    public void agregar(Object elemento) {
        if (!contiene(elemento)) {
            for (int i = 0; i < datos.length; i++) {
                if (datos[i] == null) {
                    datos[i] = elemento;
                    return;
                }
            }
        }
        throw new IllegalArgumentException("El elemento  ya esta en el conjunto");
    }

    /**
     * Metodo para obtener la diferencia de dos conjuntos
     * @param c1 -- conjunto que con el se va a calcular la diferencia
     * @return Conjuntable -- conjunto con la diferencia
     */
    public Conjuntable diferencia(Conjuntable c1) {
        ConjuntoIneficiente cMenos = new ConjuntoIneficiente(this);
        Iterator it = iterador();

        while (it.hasNext()) {
            Object elemento = it.next();
            if (c1.contiene(elemento))
                cMenos.eliminar(elemento);
        }
        return cMenos;
    }

    /**
     * Metodo para obtener la union de dos conjuntos
     * @param c1 -- conjunto que se va unir
     * @return Conjuntable -- conjunto con la union
     */
    public Conjuntable union(Conjuntable c1) {
        ConjuntoIneficiente cUnion = new ConjuntoIneficiente(this);
        Iterator it = c1.iterador();
        while (it.hasNext()) {
            cUnion.agregar(it.next());
        }
        return cUnion;
    }
    /**
     * Metodo para obtener la interseccion de dos conjuntos
     * @param c1 -- conjunto que se va intersectar
     * @return Conjuntable -- conjunto con la interseccion
     */
    public Conjuntable interseccion(Conjuntable c1) {
        ConjuntoIneficiente cInterseccion = new ConjuntoIneficiente(this);

        Iterator it = iterador();
        while (it.hasNext()) {
            Object elemento = it.next();
            if (!c1.contiene(elemento))
                cInterseccion.eliminar(elemento);
        }
        return cInterseccion;
    }

    /**
     * Metodo para determinar si un conjunto esta contenido en otro
     * @param c1 -- conjunto en se va a probar si el que llama es subconjunto
     * @return boolean -- true si el conjunto que llama a este metodo es
     *         subconjunto del parametro y false en otro caso
     */
    public boolean subconjunto(Conjuntable c1) {
        Iterator it = c1.iterador();
        while (it.hasNext())
            if (!contiene(it.next()))
                return false;
        return true;
    }

    /**
     * Metodo para crear un iterador sobre un conjunto
     * @return Iterator -- iterador sobre el conjunto.
     */
    public Iterator iterador() {
        return new miIterador();
    }

    private class miIterador implements Iterator {
        private int pos;

        public miIterador() {
            pos = 0;
        }

        /*  Determina si aun hay elementos en el conjunto, moviendo el
            indice hasta la posicion del primer elemento diferente de
            null, si es que lo hay */
        public boolean hasNext() {
            while (pos < datos.length && datos[pos] == null) {
                pos++;
            }
            return (pos < datos.length);
        }

        public Object next() throws NoSuchElementException {
            if (hasNext()) {
                return datos[pos++];
            }
            throw new NoSuchElementException();
        }

        public void remove() throws IllegalStateException,
            NoSuchElementException {}

    }

}
