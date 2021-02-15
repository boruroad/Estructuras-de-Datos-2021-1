package fciencias.edatos.practica07;

import java.util.Scanner;

public class Menu{

	/**
	 * Verifica lo que ingrese el usuario como opción en el menú.
	 * @param sc lo que el usuario ingrese.	 
	 * @param n1 el numero minimo a ingresar.
	 * @param n2 el numero máximo a ingresar.
	 * @return una opción válida dentro de los rangos establecidos.
	 */
	public static int verificaMenuAux (Scanner sc, int n1, int n2){
		int n;
		while(true){
			try{
				n = Integer.parseInt(sc.nextLine());
				if((n < n1)|| (n >n2)){
					throw new IndexOutOfBoundsException("Ingresaste un número fuera de rango");
				}
				break;
			}catch(NumberFormatException nfe){
				System.out.print("\n Asegurate de ingresar solo números\n");
				continue;
			}catch(IndexOutOfBoundsException ioobe){
				System.out.println(ioobe.getMessage());
			}catch(Exception e){
				System.out.print("\n Lo sentimos, algo imprevisto sucedió \n");
				continue;
			}
		}
		return n;
	}	
	/**
	 * Cuenta la cantidad de veces que aparece un caracter en una cadena.
	 * @param cadena la cadena principal.	 
	 * @param c el caracter a buscar en la cadena ingresada.
	 * @return la cantidad de veces que aparece el caracter en la cadena.
	 */
	  public static int cuentaCaracter(String cadena, char c){
	    int inicio = 0;
	    int conta = 0;
	    int termina= cadena.length()-1;
	    while (inicio <= termina){
	      inicio++;
	      if(c == cadena.charAt(inicio-1)){
	        conta++;
	      }
	    }
	    return conta;
	  }		

	/**
	  * Método que verifica la sintaxis de una fórmula ingresada
	  * @param  cadena la fórmula ingresada
	  * @return true en caso de ser aceptada, false en caso contrario
	  */
	public static boolean verificaCadena(String cadena){
		String  mensaje    = "SINTAXIS INCORRECTA\n";
		boolean variable   = false;
		String  auxCadena  = cadena;
		auxCadena          = auxCadena.replace(".","#");
		
		String [] partes   = auxCadena.split("#"); 
		int cantidadPuntos = cuentaCaracter(cadena,'.');

		if((cantidadPuntos >= partes.length)){
			System.out.println(mensaje);
			return false;
		}

		for (int i=0;i<partes.length;i++){
			String primer = partes[i];
			char c1       = primer.charAt(0);
			if(Character.isDigit(c1)){
				System.out.println(mensaje);
				return false;
			}
		}

		String auxiliar = cadena.replace(".."," ").replace(".","");

		/* Utilicé una expresion regular por cuestiones de practicidad, se qué no se ha visto en este curso
		 * pero fue algo visto en el curso de Autómatas y lenguajes formales.
		 * En la práctica 3 de este curso también utilicé expresiones regulares sin ningun problema	
		 */
		if(auxiliar.matches( "[A-Za-z0-9]+")){
			mensaje  = "SINTAXIS CORRECTA\n";
			variable = true;
		}else{
			mensaje  = "SINTAXIS INCORRECTA\n";
			variable =false;
		}
		System.out.println("La cadena "+cadena+" tiene: "+mensaje+"\n");		
		return variable;
	}	

	/**
	  * Método que recibe una fórmula química y regresa un arreglo donde de tamaño 2
	  * en el primer "cajón" del arreglo ingresa el simbolo, y en el segundo el coeficiente
	  * @param cadena la fórmula química como tal
	  * @return un arreglo estratégicamente dividido
	  */
	public static String [] datos(String cadena){
		String [] datos = new String [2];
		String simbolo ="";
		String numero = "";

		for(int i=0; i<cadena.length(); i++){
			if(!Character.isDigit(cadena.charAt(i))){
				simbolo += cadena.charAt(i);
				datos[0] =simbolo; 
			}else{
				numero+=cadena.charAt(i);
				datos[1] = numero;
			}
		}
		return datos;
	}

	/** Método que realiza toda la ejecución dela práctica como tal */
	public static void menu(){
		Scanner sc = new Scanner(System.in);
		LectorDOM lector = new LectorDOM();
        ChainHashMap<String,Double> map = new ChainHashMap<>();
		try{
			map =lector.lee();			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		int seleccion;
			System.out.println("Bienvenido nuestras opciones son las siguientes\n");
		do{
			System.out.println("¿Qué desea hacer?");
			System.out.println("1.- Ingresar una fórmula");
			System.out.println("2.- Salir");
			seleccion = verificaMenuAux(sc,1,2);
	
			switch(seleccion){
				case 1:
					try{ 
						System.out.println("Ingrese su fórmula:");
						String cadena = sc.next();
						if(!verificaCadena(cadena)){
						}else{
							System.out.println("Inicia un procesamiento sobre la primera cadena");
							String  auxCadena  = cadena;
							auxCadena          = auxCadena.replace(".","#");
							String [] partes   = auxCadena.split("#");
							String [] arreglo  = new String [2];
							double total       = 0;
							System.out.println("\nREALIZANDO OPERACIONES . . . ");
							for (int i  = 0; i<partes.length; i++){
								arreglo        = datos(partes[i]);
								double masa    = map.get(arreglo[0]);
								if(arreglo[1]  == null){
									arreglo[1] = "1";
								}
								double coefi     = Double.parseDouble(arreglo[1]);
								System.out.println("\nMasa del símbolo \""+arreglo[0]+"\": "+masa);
								System.out.println("Coeficiente: "+coefi);
								double operacion = coefi*masa;
								System.out.println("\t\t\t\nTotal de masa ya multiplicada por el coeficiente: "+operacion);
								total            += operacion;
							}
							System.out.println("\t\t\t\t\t\t\t\t\t****** SUMA TOTAL: "+total+" ******");
						}
					}catch(Exception e){
						System.out.println("**** \n\t\t\tLO SENTIMOS, AUNQUE TU SINTAXIS ES CORRECTA\n NO PUDIMOS CONCLUIR EL CÁLCULO TOTAL, YA QUE HAY SÍMBOLOS QUE NO ESTÁN EN LA TABLA :c \n" );
					}
				break;
			}

		}while(seleccion!=2);
	}

	public static void main(String[] args) {
		menu();
	}


}