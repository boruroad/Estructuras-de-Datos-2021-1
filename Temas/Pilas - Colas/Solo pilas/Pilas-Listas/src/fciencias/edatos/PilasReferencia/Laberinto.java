package fciencias.edatos.PilasReferencia;

import java.util.Scanner;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase laberinto busca la solución a un laberinto usando la técnica de Backtracking.
 * @author Cruz Hernández Emmanuel. 314272588.
 * @version 2.0 Noviembre 2020. (Version antigua: 1.0 Septiembre 2017).
 */
public class Laberinto{
    
    /**
    * Clase que almacena una posicion de un laberinto.
    */
    private class Casilla{

    	/** Coordenada x. */
    	private int x;

    	/** Coordenada y. */
    	private int y;

    	/**
    	* Crea un nuevo Casilla.
    	* @param x el Casilla x.
    	* @param y el Casilla y.
    	*/
    	public Casilla(int x, int y){
    		this.x = x;
    		this.y = y;
    	}

    	/**
    	* Regresa el Casilla x
    	* @return la coordenada x
    	*/
    	public int getX(){
    		return x;
    	}

    	/**
    	* Regresa el Casilla y
    	* @return la coordenada y
    	*/
    	public int getY(){
    		return y;
    	}
    }
    
    /** Arreglo que representa el laberinto. */
    private boolean laberinto[][];
    
    /** Coordenada x de la salida del laberinto. */
    private int xFin;
    
    /** Coordenada y de la salida del laberinto. */
    private int yFin;

    /** Arreglo que representa el recorrido de la solución. */
    private boolean[][] explorada;
    
    /**
     * Crea un nuevo laberinto.
     * @param laberinto el laberinto a asignar, este está representado con un arreglo.
     */
    public Laberinto(boolean[][] lab, int x, int y){
    	laberinto=lab;
    	xFin=x;
    	yFin=y;
    	int tam=lab.length;
    	explorada=new boolean[tam][tam];
    }

    /**
     * Permite leer la representación de un laberinto.
     * @return la representación del laberinto a resolver.
     * @throws IOException si ocurre algun error con la lectura.
     */
    public static boolean[][] leeLaberinto() throws IOException{
    	Reader reader = new FileReader("LaberintoA.txt");
    	BufferedReader buffer = new BufferedReader(reader);
    	String linea;
    	boolean[][] laberinto = new boolean[21][21];
    	while((linea = buffer.readLine()) != null){
	    String[] elementos = linea.split(",");
	    int y = Integer.valueOf(elementos[1]);
	    int x = Integer.valueOf(elementos[0]);
	    laberinto[x][y] = true;
    	}
    	return laberinto;
    }

    /**
     * Explora el laberinto y determinar si existe solución.
     * @param x la posición x en las columnas del laberinto a explorar.
     * @param y la posición y en los renglones del laberinto a explorar.
     * @return true si el laberinto tiene solución, false en otro caso.
     */
    public boolean explora(int x,int y){
    	TDAPila<Casilla> recorrido = new Pila<Casilla>();
        recorrido.push(new Casilla(x, y));

        while(!recorrido.isEmpty()){ // Mientras la pila no sea vacia
            Casilla actual = recorrido.pop(); // Es obtener el pendiente en el recorrido.

            if(!laberinto[actual.getX()][actual.getY()]) // Si actual es una pared.
                continue;

            if(!explorada[actual.getX()][actual.getY()]){ // La casilla no esta explorada
                explorada[actual.getX()][actual.getY()] = true; // Marcamos como explorada

                if(actual.getX()==xFin && actual.getY()==yFin) // Si corresponde al fin. Ya terminamos
                    return true;

                this.agregaVecinos(actual, recorrido); // Agregar a los vecinos
            }
        }
    	return false;
    }

    /**
    * Agrega todos los vecinos de una casilla en una pila.
    */
    private void agregaVecinos(Casilla c, TDAPila<Casilla> pendientes){
    	Casilla arriba = new Casilla(c.getX()-1, c.getY());
    	Casilla abajo = new Casilla(c.getX()+1, c.getY());
    	Casilla derecha = new Casilla(c.getX(), c.getY()+1);
    	Casilla izquierda = new Casilla(c.getX(), c.getY()-1);

    	if(esValida(arriba))
    		pendientes.push(arriba);
    	if(esValida(abajo))
    		pendientes.push(abajo);
    	if(esValida(derecha))
    		pendientes.push(derecha);
    	if(esValida(izquierda))
    		pendientes.push(izquierda);
    }

    /**
    * Verifica que una casilla sea valida. Esto es, que este en los
    * rangos validos de un laberinto.
    * @param c la casilla a verificar valides.
    * @return true si es una casilla valida, false en otro caso.
    */
    private boolean esValida(Casilla c){
    	return c.getX()>=0 && c.getX()<laberinto.length &&
    		c.getY()>=0 && c.getY()<laberinto.length;
    }
    
    /**
     * Imprime el laberinto sin índices.
     */
    private void muestra(){
    	String white = "\u001B[0m";
    	String green = "\033[32m";
	for(int i=0;i<laberinto.length;i++){
	    for(int j=0;j<laberinto[0].length;j++)
		if(i==xFin&&j==yFin)
		    System.out.print("EXIT");
		else
		    if(explorada[i][j])
			System.out.print(green+"*."+white);
		    else
			if(laberinto[i][j])
			    System.out.print("  ");
			else
			    System.out.print("@@");
	    System.out.println();
	}
    }
    
    /**
     * Imprime el laberinto con índices.
     */
    private void muestraI(){
	for(int i=0;i<laberinto.length;i++)
	    System.out.print(" "+i+(i<10?" ":"")+" ");
	System.out.println("");
	for(int i=0;i<laberinto.length;i++){
	    for(int j=0;j<laberinto[0].length;j++){
		if(i==xFin&&j==yFin)
		    System.out.print("EXIT");
		if(laberinto[i][j])
		    System.out.print("    ");
		else
		    System.out.print("@@@@");
	    }
	    System.out.print(" "+i);
	    System.out.println();
	}
    }
    
    /**
     * Permite al usuario elegir un laberinto.
     * Este método es la interacción en consola para elegir un laberinto
     * y la coordenada de inicio.
     */
    private static void elige(){
	Scanner sc=new Scanner(System.in);
	boolean[][] l=null;
	try{
	    l=leeLaberinto();
	}catch(Exception e){
	    System.out.println("\nAlgo salió mal en la lectura del XML que contiene el laberinto.");
	}
	System.out.println("\n¿En qué coordenadas quieres comenzar?");
	Laberinto la=new Laberinto(l,9,20);
	la.muestraI();
	System.out.println("\nx= ");
	int x;
	try{
	    int op=sc.nextInt();
	    x=op;
	}catch(Exception e){
	    System.out.println("\nNo ingresaste un número válido. "+
			       "Por omisión x=0.");
	    x=0;
	}
	if(x<0||x>=la.laberinto.length){
	    System.out.println("\nIndice inválido. "+
			       "Por omisión x=0.");
	    x=0;
	}
	System.out.println("\ny= ");
	int y;
	try{
	    int op1=sc.nextInt();
	    y=op1;
	}catch(Exception e){
	    System.out.println("\nNo ingresaste un número válido. "+
			       "Por omisión y=9.");
	    y=9;
	}
	if(y<0||y>=la.laberinto.length){
	    System.out.println("\nIndice inválido. "+
			       "Por omisión y=9.");
	    y=9;
	}
	if(!la.laberinto[y][x]){
	    System.out.println("\nLa coordenada que elegiste es un obstáculo. "+
			       "Por omisión x=0, y=9.");
	    x=0;
	    y=9;
	}
	if(la.explora(y,x)){
	    System.out.println("\nLa solución del laberinto es: ");
	    la.explora(y,x);
	    la.explorada[y][x]=true;
	    la.muestra();
	    System.out.println("\nEl recorrido de la solución es: ");
	    System.out.println();
	} else{
	    System.out.println("\nEl laberinto no tiene solución. :(");
	}
    }
    
    /**
     * Método que simula el menú.
     * Es la interacción con el usuario para poder elegir entre salir o resolver
     * un laberinto nuevo.
     */
    private static void menu(){
	Scanner sc=new Scanner(System.in);
	System.out.println("\n[1] Resolver un laberinto.\n"+
			   "[2] salir.\n"+
			   "Elige una opción: ");
	int op;
	try{
	    int op1=sc.nextInt();
	    op=op1;
	}catch(Exception e){
	    System.out.print("\nNo ingresaste un número válido.\n");
	    menu();
	    return;
	}
	switch(op){
	case 1:
	    elige();
	    menu();
	    return;
	case 2:
	    System.out.print("\nSALIENDO DE LABERINTO\n");
	    sc.close();
	    return;
	default:
	    System.out.println("\nOpción no válida.");
	    menu();
	    return;
	}
    }
    
    public static void main(String[] args){
	System.out.print("\nBIENVENIDO A LABERINTO\n");
	menu();
    }
}
