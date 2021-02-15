package fciencias.edatos.colas;

import java.util.*;

/**
 * Clase para despacho de procesos con el algoritmo de RoundRobin
 * @author ALG
 * @version 1a. ed.
 */
public class RoundRobin {

    /**
     * Metodo para despacho de procesos
     * @param q -- quantum de cada proceso
     * @param procesos -- Cola en que se almacenan los procesos en espera
     */
    private static void RoundRobin(int q, Cola<Proceso> procesos) {
        int tiempo = 0;
        int t;
        int resta;

        

        System.out.println("\nNombre Procesos\tT. Proceso\tTiempo de Salida");
        while (!procesos.isEmpty()) {
	    Proceso proceso = procesos.first();
	    procesos.dequeue();
	    t = proceso.obtenerTiempo();
	    resta = t - q;
	    if (resta > 0) {
		tiempo += q;
		proceso.asignarTiempo(resta);
		proceso.asignarEstado(true);
		procesos.enqueue(proceso);
		System.out.println(proceso.obtenerNombre() + "\t" + proceso.obtenerTiempo() + "\t\t" + tiempo);
	    } else {
		tiempo += q + resta;
		proceso.asignarTiempo(0);
		if(proceso.isEstado()){
		    System.out.println(proceso.obtenerNombre() + "\t" + proceso.obtenerTiempo() + "\t\t" + tiempo);
		    proceso.asignarEstado(false);
                }
	    }
        }
    }

    public static void main(String[] args) {
    	Scanner io = new Scanner(System.in);
        Cola<Proceso> procesos = new Cola<>();
        int tiempo;
        System.out.println("Cuantos procesos se van a ejecutar:");
        int nProcesos = io.nextInt();
        System.out.println("Proporciona el Quantum");
        int q = io.nextInt();
        for (int i = 0; i < nProcesos; i++) {
            tiempo = (int) (Math.random() * 100);
            procesos.enqueue(new Proceso("Proceso --> " + (i+1), tiempo));
        }
        RoundRobin(q, procesos);
    }
}
