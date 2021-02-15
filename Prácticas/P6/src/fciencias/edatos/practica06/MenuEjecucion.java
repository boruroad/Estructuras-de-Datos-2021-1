package fciencias.edatos.practica06;
import java.util.ArrayList; 

/**
 * Práctica 6: Árboles binarios de búsqueda.
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * @version 1.0
 */

import java.util.Scanner;

public class MenuEjecucion{
	/**
	 * Verifica que lo que ingrese el usuario sea de tipo double.
	 * @param sc el scanner a pasar.	 
	 * @return una opción válida de tipo double
	 */
	public static double esDouble(Scanner sc){
		double n;
		while(true){
			try{
				n = Double.parseDouble(sc.nextLine());
				break;
			}catch(NumberFormatException nfe){
				System.out.println("El dato ingresado no es de tipo double");//nfe.getMessage());
				continue;
			}catch(Exception e){
				System.out.print("\n Lo sentimos, algo imprevisto sucedió \n");
				continue;
			}
		}
		return n;
	}

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
	/** Método que ejecuta todas las operaciones a través de un menú */
	public static void menu(){
		Scanner sc = new Scanner(System.in);
		ArbolBinarioBusqueda<Ciudad>  a1 = new ArbolBinarioBusqueda<>();
		EscritorDOM escritor = new EscritorDOM();
		LectorDOM lector = new LectorDOM();
		ArrayList<Ciudad> directorio = new ArrayList<>();	  
		String ciudad ="";
		String estado="";
		double longitud=0.0;
		double latitud=0.0;
		String ciudadAux ="";
		Ciudad borrada = null;
		double rangoAux1 = 0;
		double rangoAux2 = 0;
		int seleccion;
			System.out.println("Bienvenido nuestras opciones son las siguientes\n");
		do{
			System.out.println("¿Qué desea hacer?\n");
			System.out.println("1.- Agregar una ciudad al directorio");
			System.out.println("2.- Eliminar una ciudad al directorio");
			System.out.println("3.- Mostrar la información de una ciudad");
			System.out.println("4.- Determinar todas las ciudades dentro de un rango y a partir de una coordenada");
			System.out.println("5.- Leer \"Directorio.xml\" ");
			System.out.println("6.- Salir");

			seleccion = verificaMenuAux(sc,1,5);


			switch(seleccion){
				case 1:
					try{
						Ciudad c1 = new Ciudad(null,null,0.0,0.0);
						System.out.println("Ingrese nombre de la ciudad");
						ciudad = sc.nextLine().toUpperCase();
						c1.setNombre(ciudad);

						System.out.println("Ingrese el estado al que pertenece la ciudad");
						estado = sc.nextLine();
						c1.setEstado(estado);	

						System.out.println("Ingrese la longitud de la ciudad");
						longitud = esDouble(sc);
						c1.setLongitud(longitud);

						System.out.println("Ingrese la latitud de la ciudad");
						latitud = esDouble(sc);
						c1.setLatitud(latitud);
						a1.insert(c1,ciudad);
						directorio.add(c1);

						escritor.escribe(directorio);
						System.out.println("\"Directorio.xml\" fue actualizado exitosamente\n");
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break;

				case 2:
					try{
						System.out.println("Ingrese el nombre de la ciudad");
						ciudadAux = sc.nextLine().toUpperCase();
						borrada = a1.delete(ciudadAux);
						if(borrada!=null){
							System.out.println(ciudadAux +" ha sido eliminada");
							System.out.println(borrada);
							directorio.remove(borrada);
						}else{
							System.out.println(ciudadAux +" no se encuentra");
						}
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break;

				case 3:
					try{
						System.out.println("Ingrese el nombre de la ciudad");
						String n = sc.nextLine().toUpperCase();
						Ciudad busqueda = a1.retrieve(n);
						if(busqueda ==null){
							System.out.println("La ciudad "+n+" no fue encontrada (fue borrada o no existe)");
						}else{
							System.out.println(busqueda);	
						}
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break;

				case 4:
					System.out.println("Buscar ciudad por: ");
					System.out.println("1) Latitud");
					System.out.println("2) Longitud");
					int opcion = verificaMenuAux(sc,1,2);
					boolean porLatitud = opcion == 1 ? true : false;
					System.out.println("NOTA: Sin importar el orden en que ingrese los números, el programa determinara el rango de menor a mayor");
					System.out.println("Ingrese primer número del rango");
					double primerNum = esDouble(sc);
					System.out.println("Ingrese segundo número del rango");
					double segundoNum = esDouble(sc);
					if(primerNum > segundoNum){
						System.out.println("Rango : "+segundoNum +" a "+primerNum);
						rangoAux1 = segundoNum;
						rangoAux2 = primerNum;

					}else{
						System.out.println("Rango : "+primerNum +" a "+segundoNum);
						rangoAux1 = primerNum;
						rangoAux2 = segundoNum;
					}

					ArrayList<Ciudad> ciudades = a1.encuentraRango(porLatitud,rangoAux1,rangoAux2);

					for(Ciudad cd : ciudades){
						System.out.println( "***************");
						System.out.println("Ciudad   : "+cd.getNombre());	
						System.out.println((porLatitud?"Latitud" :"Longitud ") +": "+ (porLatitud? cd.getLatitud() : cd.getLongitud()));
						System.out.println( "***************");
					}
				break;

				case 5:
					try{
						escritor.escribe(directorio);
						lector.lee();
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break; 
			}

		}while(seleccion!=6);
	}
	
	/* MÉTODO MAIN - (Compatco pero poderoso) */
	public static void main(String[] args) {
		menu();
	}


}