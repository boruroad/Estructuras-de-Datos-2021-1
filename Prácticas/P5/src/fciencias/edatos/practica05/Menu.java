package fciencias.edatos.practica05;

/**
 * Práctica 5: Aplicaciones de árboles, XML.
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * @version 1.0
 */

import java.util.Scanner;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.DOMException;

public class Menu{

	/**
	 * Verifica lo que ingrese el usuario como opción en el menú.
	 * @param sc lo que el usuario ingrese.	 
	 * @param n1 el numero minimo a ingresar.
	 * @param n2 el numero máximo a ingresar.
	 * @return una opción válida dentro de los rangos establecidos.
	 */
	public static int verificaMenu (Scanner sc, int n1){
		int n;
		while(true){
			try{
				n = Integer.parseInt(sc.nextLine());
				if(n < n1 ){
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
 	 * Método que  crea e ingresa objetos de tipo Auto a una cola de autos
 	 * @param cantAutos el numero de autos a ingresar a la cola
 	 * @return una cola con la cantidad de autos que nos fue pasada como parametro
	 */
	public static Cola<Automovil> creaAutomoviles(int cantAutos){
		Scanner sc = new Scanner(System.in);		
		Cola<Automovil> colaM= new Cola<>(); 
		Automovil m = null;
		for (int i =1;i<=cantAutos;i++){
			m = new Automovil("","","",0,"","","","");
			System.out.println("Marca del automovil "+i);
			String marca = sc.nextLine();
			m.setMarca(marca);

			System.out.println("Modelo del automovil "+i);
			String modelo= sc.nextLine();
			m.setModelo(modelo);

			System.out.println("¿Deeseas que tu auto tenga placas?");
			System.out.println("\n1 ----> SI");
			System.out.println("\n2 ----> NO");
			int opcion = verificaMenuAux(sc,1,2);

			if(opcion==1){
				System.out.println("Placas del automovil "+i);
				String placas = sc.nextLine();
				m.setPlacas(placas);
				m.setExistPlacas(true);
			}

			System.out.println("¿Deeseas que tu auto tenga año?");
			System.out.println("\n1 ----> SI");
			System.out.println("\n2 ----> NO");
			int opcion2 = verificaMenuAux(sc,1,2);

			if(opcion2 ==1){
				System.out.println("Año del automovil "+i);
				int anio = verificaMenuAux(sc,1900,2020);
				m.setAnio(anio);
				m.setExistAnio(true);
			}

			System.out.println("Nombre del dueño del automovil "+i);
			String nDuenio= sc.nextLine();
			m.setNombre(nDuenio);

			System.out.println("Apellido materno del dueño del automovil "+i);
			String aMaterno = sc.nextLine();
			m.setMaterno(aMaterno);

			System.out.println("Apellido paterno del dueño del automovil "+i);
			String aPaterno = sc.nextLine();
			m.setPaterno(aPaterno);

			System.out.println("Opinion del dueño del automovil "+i);
			String review = sc.nextLine();
			m.setOpinion(review);
			colaM.enqueue(m);
		}
		return colaM;
	}

	public static void menu(){
		Scanner sc = new Scanner(System.in);
		LectorDOM lector = new LectorDOM();
		EscritorDOM escritor = new EscritorDOM();
		int seleccion;
			System.out.println("Bienvenido nuestras opciones son las siguientes\n");
		do{
			System.out.println("¿Qué desea hacer?\n");
			System.out.println("1.- Leer un archivo XML");
			System.out.println("2.- Escribir un auto en un archivo XML");
			System.out.println("3.- Salir");
			seleccion = verificaMenuAux(sc,1,3);
			
			switch(seleccion){
				case 1:
					try{
						System.out.println("Ingrese nombre del archivo a leer");
						String nombreA = sc.nextLine();
				        lector.lee(nombreA+".xml");
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break;

				case 2:
					try{
						System.out.println("Cuántos autos deseas tener");
						int cantidadA = verificaMenu(sc,1);
						Cola cAutos = creaAutomoviles(cantidadA);
						System.out.println("Escribe el nombre de tu archivo XML");
						String name = sc.nextLine();
						escritor.escribe(name+".xml",cAutos);
						System.out.println("Se ha escrito el archivo: "+name+".xml exitosamente");

					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break;
			}

		}while(seleccion!=3);
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, DOMException{
		menu();
   	}

}