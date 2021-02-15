package fciencias.edatos.practicaReposicion;

/**
 * Práctica de Reposición: Pilas.
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación no es mia en su totalidad 
 * Créditos: Emmanuel Cruz Hernández
 * @version 1.0
 */

public class PilaArreglo implements Pila {
    
    private static final int MAX_ELEMS = 255;
    
    private Object elementos[];
    
    private int tope;
    
    /**
     * Construye una pila basada en un arreglo 
     * con un número máximo de elementos por
     * omisión. 
     */
    public PilaArreglo() {
        elementos = new Object[MAX_ELEMS];
        tope      = -1;
    }

    public PilaArreglo(String cadena){
        int tamanio = cadena.length()+1;
        elementos   = new Object[tamanio];
        tope        = -1;
    }         

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }
    
    @Override
    public int size() {
        return tope + 1;
    }
    
    @Override
    public void push(Object obj) {
        if (size() == elementos.length)  {
            throw new RuntimeException("Pila llena. No hay espacio");
        }
        tope++;
        elementos[tope] = obj;       
    }

    @Override
    public Object peek() {
        return isEmpty() ? null : elementos[tope];        
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object tmp      = elementos[tope];
        elementos[tope] = null;
        tope--;
        return tmp;
    }

    /** Método que muestra la pila en terminal */
    public void muestra(){
        for(int i =elementos.length-1;i>=0;i--){
            if(elementos[i]!=null){
                System.out.println(elementos[i]);
            }
        }
    }

}
