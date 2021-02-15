package fciencias.edatos.practica04;
import java.util.Random;
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

	static String contenidoB  = ""; 

	/**
	 * Crea una bitácora nueva a partir de una ejecucion.
	 * @param cadena el contenido de la Bitacora.	 
	 * @param contador la cantidad de veces que se hace esta ejecución.	 
	 */													
	public static void escribirBitacora(String cadena, int contador ){
		int nuevo=0; 
		try{
			File f = new File("\nBitacora día " +contador+ ".txt");
			FileWriter fw;
			BufferedWriter bw;

			if(f.exists()){
				contador++;
				nuevo=contador;
				escribirBitacora(cadena,nuevo);
			} else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write("\tBITACORA DÍA "+contador+"\n\n"+cadena);
				bw.close();
				fw.close();
			}
		} catch(FileNotFoundException fnfe){
			System.out.println("   Lo sentimos, tu archivo no fue encontrado");
		} catch (Exception ex){
			System.out.println("   Lo sentimos, algo imprevisto sucedió");
		}
	}

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
		Mesa m = null;
		contenidoB+="Total de mesas en el restaurante: "+cantMesas+"\n";
		for (int i =1;i<=cantMesas;i++){
			m = new Mesa("MESA "+i,0,false);
			System.out.println("Capacidad de la mesa "+i);
			int c = verificaMenu(sc,1);
			m.setCapacidadComen(c);
			colaM.enqueue(m);
			contenidoB+= "\n"+m.getIdentificador() +"\n"+"Capacidad de la mesa: "+m.getCapacidadComen()+"\nOcupada: "+m.getEstado()+"\n";
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
		String nombresClientes="";
		for (int i =1;i<=cantClient;i++){
			Cliente c = new Cliente("",0);
			System.out.println("Nombre del cliente "+i+": ");
			String name = sc.nextLine();
			c.setNombre(name);
			System.out.println("¿Cuántas personas son contando al cliente "+i+"?");
			int acompa = verificaMenu(sc,1);
			c.setComensales(acompa);
			colaC.enqueue(c);
			nombresClientes+=" "+name+" ";
		}
		if(colaC.size()!=1){
			contenidoB+="\nClientes en el restaurante: "+cantClient+"\nNombres: "+nombresClientes +"\n\n\t\t\t\t\tOPERACIONES\n";
		}else{
			contenidoB+="\nClientes en el restaurante: "+cantClient+"\nNombre: "+nombresClientes+"\n\n\t\t\t\t\tOPERACIONES\n";
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

	/**
	 * NOTA: El método fue implementado porque asi lo pedia el primer punto de la actividad 2, sin embargo nunca se uso
	 * puesto que un correo Emmanuel me comento que debiamos atender cliente por cliente y dejar todas las mesas lubres, a excepcion de 
	 * la que usaba el cliente.
	 *
 	 * Método que dice CUALES mesas hay disponibles 
 	 * @param colaM la cola de mesas
 	 * @return el numero de mesas disponibles
	 */
	public static Cola<Mesa> disponibles(Cola<Mesa> colaM){
		Cola<Mesa> colaMAux = new Cola<>();

		for (int i =0;i<=colaM.size()-1;i++){
			Mesa n = colaM.regresa(i);
			if(n.getEstado()==false){
				colaMAux.enqueue(n);
			}
		}
		return colaMAux;
	}

	/**
	 * Método que dice cual es la mejor mesa para cada cliente.
	 * @param colaM una cola de Mesas.	 
	 * @param colaC una cola de clientes.
	 */	
	public static String mensajeAsignaMejor(Cola<Mesa> colaM, Cola<Cliente> colaC ){
		Cliente c = colaC.first();
		int numComen = c.getComensales();
		int dActual=0;
		int dMinimo=0;
		String mejorMesa="";
		String mensaje="";
		Mesa n = null;
		for (int i=0;i<=colaM.size()-1;i++){
				n = colaM.regresa(i);
				int cupoMesa = n.getCapacidadComen();
				if(colaM.size()==2){
						if(i==0){
							dActual =cupoMesa-numComen; 
							dMinimo = dActual;
							if(cupoMesa<numComen){
								mensaje="RESERVACIÓN CANCELADA (no hay suficientes sillas para sentar a los comensales con nuestras mesas disponibles)";
							}else{
								mejorMesa = n.getIdentificador();
								mensaje ="La mejor mesa respecto al numero de comensales para "+c.getNombre()+" es "+mejorMesa;
							}
						}

						if((i>0) && (mensaje.equals("RESERVACIÓN CANCELADA (no hay suficientes sillas para sentar a los comensales con nuestras mesas disponibles)"))){
							if(cupoMesa<numComen){
								return mensaje;
							}else{
								mejorMesa = n.getIdentificador();
								mensaje ="La mejor mesa respecto al numero de comensales para "+c.getNombre()+" es "+mejorMesa;
								return mensaje;								
							}
						}

						if((i>0) && (mensaje.contains("La mejor mesa respecto"))){
							if(cupoMesa<numComen){
								return mensaje;
							}else{
								dActual=cupoMesa-numComen;
								if(dMinimo>=dActual){
									if(dActual>=0){
										dMinimo=dActual;
										mejorMesa=n.getIdentificador();
										mensaje ="La mejor mesa respecto al numero de comensales para "+c.getNombre()+" es "+mejorMesa;
									}else{
								       	mensaje="RESERVACIÓN CANCELADA (no hay suficientes sillas para sentar a los comensales con nuestras mesas disponibles)";
									}
								}
							}
						}					
				}
					if((i==0) && (colaM.size() !=2)) {
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

			if((i>0) && (colaM.size()!=2)){
				dActual=cupoMesa-numComen;
				if(dMinimo>=dActual){
					if(dActual>=0){
						dMinimo=dActual;
						mejorMesa=n.getIdentificador();
						mensaje =c.getNombre()+" está ocupando la mesa "+mejorMesa;
						n.setEstado(true);
					}else{
				       	mensaje="RESERVACIÓN CANCELADA (no hay suficientes sillas para sentar a los comensales con nuestras mesas disponibles)";
					}
				}
			}
		}
		contenidoB+="\n"+mensaje;		
		return mensaje;
	}	

	/**
	 * Método que despacha a los clientes en un restaurante.
	 * @param colaC una cola de clientes.	 
	 * @param n2 el numero máximo a ingresar.
	 */	
	public static void despacho( Cola<Cliente> colaC, Cola<Mesa> todasM){
		Random rndm = new Random();	
		Thread t = new Thread();
		do{
			Cliente c1 = colaC.first();
			String mensaje = mensajeAsignaMejor(todasM,colaC);
			if(mensaje.contains("RESERVACIÓN")){
				contenidoB+="\nEl cliente "+"\""+c1.getNombre()+"\" pide mesa para "+c1.getComensales(); //+"\n"+c1.getNombre()+" ocupa MESA "+ indice+"\nComen por "+tiempo+" minuto(s)\n";
				contenidoB+="\nRESERVACIÓN CANCELADA para "+c1.getNombre()+" (no hay suficientes sillas para sentar a los comensales con nuestras mesas disponibles)";
				if(colaC.isEmpty()){
					break;
				}else{
					colaC.dequeue();							
				}
			}else{
				int inicio = mensaje.indexOf("M");
				String soloMesa = mensaje.substring(inicio);
				char num = soloMesa.charAt(5);
				int indice = Integer.parseInt(String.valueOf(num));
				Mesa n = todasM.regresa(indice-1);
				n.setEstado(true);
				int tiempo = rndm.nextInt(6)+1;
				try{
					contenidoB+="\nEl cliente "+"\""+c1.getNombre()+"\" pide mesa para "+c1.getComensales()+"\n"+c1.getNombre()+" OCUPA MESA "+ indice+"\n\n"+n.getIdentificador() +"\n"+"Capacidad de la mesa: "+n.getCapacidadComen()+"\nOcupada: "+n.getEstado()+"\n       (Comen por "+tiempo+" minuto(s)       \n";
					t.sleep(tiempo*1000);
					n.setEstado(false);
					contenidoB+="\nEl cliente "+c1.getNombre()+" terminó de comer en "+tiempo +" minuto(s)";
					contenidoB+="\n"+c1.getNombre()+" DESALOJÓ MESA "+indice+"\n-----------------------------------------------------------\n";
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				colaC.dequeue();							
			}
		}while(!colaC.isEmpty());
	}	

	//MÉTODO MAIN
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cola<Mesa> colaMesas = new Cola<>();
		Cola<Cliente> colaClientes = new Cola<>();

		System.out.println("Ingrese la cantidad de mesas para el restaurante");
		int cant = verificaMenu(sc,1);
		colaMesas = creaMesas(cant);
		colaMesas.muestra();

		System.out.println("\nCuántos clientes están a la espera");
		int clientes = verificaMenu(sc,1);
		colaClientes = creaClientes(clientes);

		contenidoB+="(En cola hay "+clientes+" clientes esperando a ser antendidos)\n";
		String aviso = "PERFECTO !! (En cola hay "+colaClientes.size()+" clientes esperando a ser antendidos)\n";
		System.out.println(aviso);
		System.out.println("Mesas no ocupadas: ");
		noOcupadas(colaMesas);

		System.out.println("Atendiendo clientes . . .");
		despacho(colaClientes,colaMesas);
		contenidoB+="\nFIN DEL REGISTRO";
		escribirBitacora(contenidoB,1);
		System.out.println("\nYUJU !! No hay más clientes en la cola \nRegistro del día guardado en \""+"Bitácora del día.txt"+"\"");		
	}
}



