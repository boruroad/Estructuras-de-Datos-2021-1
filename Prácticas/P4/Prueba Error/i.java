package fciencias.edatos.practica04;
import java.util.Scanner;

import java.util.Scanner;
import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Writer;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Práctica 4: Colas 
 * Clase Restaurante
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruíz Roberto Adrián // Num. Cta. 31721903-8
 * @version 1.0
 */

public class Restaurante{


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
 	 * Método que  crea e ingresa objetos de tipo Mesa a una cola de mesas
 	 * @param cantMesas el numero de meses a ingresar a la cola
 	 * @return una cola con la cantidad de mesas que nos fue pasada como parametro
	 */
	public static Cola<Mesa> creaMesas(int cantMesas){
		Scanner sc = new Scanner(System.in);		
		Cola<Mesa> colaM= new Cola<>(); 
		for (int i =1;i<=cantMesas;i++){
			Mesa m = new Mesa("MESA "+i,0,false);
			System.out.println("Capacidad de la mesa "+i);
			int c = verificaMenu(sc,1);
			m.setCapacidadComen(c);
			colaM.enqueue(m);
		}
		return colaM;
	}

	/**
 	 * Método que crea e ingresa objetos de tipo Cliente a una cola de clientes
 	 * @param cantClient el numero de clientes a ingresar a la cola
 	 * @return una cola con la cantidad de clientes que nos fue pasada como parametro
	 */
	public static Cola<Cliente> creaClientes(int cantClient){
		Scanner sc = new Scanner(System.in);		
		Cola<Cliente> colaC= new Cola<>(); 
		for (int i =1;i<=cantClient;i++){
			Cliente c = new Cliente("",0);
			System.out.println("Nombre del cliente "+i+": ");
			String name = sc.nextLine();
			c.setNombre(name);
			System.out.println("¿Cuántas personas son contando al cliente "+i+"?");
			int acompa = verificaMenu(sc,1);
			c.setComensales(acompa);
			colaC.enqueue(c);
		}
		return colaC;
	}

	/**
 	 * Método que dice CUANTAS mesas hay disponibles 
 	 * @param cola la cola donde estan las mesas
 	 * @return el numero de mesas disponibles
	 */
	public static int noOcupadas(Cola<Mesa> cola){
		int contador = 0;
		String cadena = "";
		for (int i =0;i<=cola.size()-1;i++){
			Mesa n = cola.regresa(i);
			if(n.getEstado()==false){
				contador++;
				cadena+= n.getIdentificador()+ "\tCapacidad: "+n.getCapacidadComen()+"\n";
			}
		}
		System.out.println(cadena);
		return contador;
	}


//	/**
// 	 * Método que dice CUALES mesas hay disponibles 
// 	 * @param colaM la cola de mesas
// 	 * @return el numero de mesas disponibles
//	 */
//	public static Cola<Mesa> disponibles(Cola<Mesa> colaM){
//		Cola<Mesa> colaMAux = new Cola<>();
//
//		for (int i =0;i<=colaM.size()-1;i++){
//			Mesa n = colaM.regresa(i);
//			if(n.getEstado()==false){
//				colaMAux.enqueue(n);
//			}
//		}
//
//		return colaMAux;
//	}

	/**
 	 * Método que dice en un mensaje cual es la mejor mesa para un cliente 
 	 * @param colaM la cola donde estan las mesas
 	 * @param colaC la cola donde estan los clientes
	 */
	public static void mensajeAsignaMejor(Cola<Mesa> colaM, Cola<Cliente> colaC ){
		Cliente c = colaC.first();
		int numComen = c.getComensales();
		int dActual=0;
		int dMinimo=0;
		String mejorMesa="";
		String mensaje="";
		for (int i=0;i<=colaM.size()-1;i++){
				Mesa n = colaM.regresa(i);
				int cupoMesa = n.getCapacidadComen();
					if(i==0){
						dActual =cupoMesa-numComen; 
						dMinimo = dActual;
						if(cupoMesa<numComen){
							mensaje="RESERVACIÓN CANCELADA (no hay suficientes sillas para sentar a los comensales con nuestras mesas disponibles)";
						}else{
							mejorMesa = n.getIdentificador();
							mensaje ="La mejor mesa respecto al numero de comensales es "+mejorMesa;
						}
					}

			if(i>0){
				dActual=cupoMesa-numComen;
				if(dMinimo>=dActual){
					if(dActual>=0){
						dMinimo=dActual;
						mejorMesa=n.getIdentificador();
						mensaje ="La mejor mesa respecto al numero de comensales es "+mejorMesa;
						//Podria regresar a la mesa para que sea asignada a un cliente(tipo Object)
					}else{
				       	mensaje="RESERVACIÓN CANCELADA (no hay suficientes sillas para sentar a los comensales con nuestras mesas disponibles)";
					}
				}
			}
		}
		System.out.println(mensaje);
	}


	public static Mesa aignarMesaACliente(Cola<Mesa> colaM, Cola<Cliente> colaC ){
		Cliente c = colaC.first();
		int numComen = c.getComensales();
		int dActual=0;
		int dMinimo=0;
		String mejorMesa="";
		String mensaje="";
		Mesa n = null;
		//Cola<Mesa> colaM = disponibles(colaTodas);
		for (int i=0;i<=colaM.size()-1;i++){
				n = colaM.regresa(i);
				int cupoMesa = n.getCapacidadComen();
					if(i==0){
						dActual =cupoMesa-numComen; 
						dMinimo = dActual;
						if(cupoMesa<numComen){
							mensaje="RESERVACIÓN CANCELADA (no hay suficientes sillas para sentar a los comensales con nuestras mesas disponibles)";
						}else{
							mejorMesa = n.getIdentificador();
							mensaje =c.getNombre()+" está ocupando la mesa "+mejorMesa;
							n.setEstado(true);
						}
					}

			if(i>0){
				dActual=cupoMesa-numComen;
				if(dMinimo>=dActual){
					if(dActual>=0){
						dMinimo=dActual;
						mejorMesa=n.getIdentificador();
						mensaje =c.getNombre()+" está ocupando la mesa "+mejorMesa;
						n.setEstado(true);
						//Podria regresar a la mesa para que sea asignada a un cliente(tipo Object)
					}else{
				       	mensaje="RESERVACIÓN CANCELADA (no hay suficientes sillas para sentar a los comensales con nuestras mesas disponibles)";
					}
				}
			}
		}
		return n;
	}	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cola<Mesa> colaMesas = new Cola<>();
		Cola<Cliente> colaClientes = new Cola<>();

		System.out.println("Ingrese la cantidad de mesas para el restaurante");
		//Validar Robustez(que solo sea numero y no negativo)
		int cant = verificaMenu(sc,1);
		colaMesas = creaMesas(cant);
		colaMesas.muestra();

		System.out.println("\nCuántos clientes están a la espera");
		//Validar Robustez(que solo sea numero y no negativo)
		int clientes = verificaMenu(sc,1);
		colaClientes = creaClientes(clientes);

		System.out.println("PERFECTO !! (En cola hay "+colaClientes.size()+" clientes esperando a ser antendidos)\n");
		System.out.println("Mesas no ocupadas: ");
		noOcupadas(colaMesas);

		mensajeAsignaMejor(colaMesas,colaClientes);


		
	}






}



