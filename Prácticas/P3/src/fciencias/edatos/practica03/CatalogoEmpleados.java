package fciencias.edatos.practica03;

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
 * Práctica 3: Listas //  Estructura de Datos 2021-1.
 * @author Bonilla Ruíz Roberto Adrián // Num. Cta. 31721903-8
 * @version 1.0
 */

public class CatalogoEmpleados{

	/**
	 * Método que nos permite escribir un fichero por empleado .
	 * @param nuevo un objeto de tipo Alebrije.
	 */
	public static void escribirEmpleado(Empleado e){
		try{
			File f = new File(e.getNombreCompleto()+".txt");
			FileWriter fw;
			BufferedWriter bw;

			if(f.exists()){
				f.delete();
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);
				bw.write(e.getNombreCompleto() + "," + e.getFechaNacimiento() + "," + Double.toString(e.getSueldoMensual())+ "," + e.getPuesto());
			} else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write(e.getNombreCompleto() + "," + e.getFechaNacimiento() + "," + Double.toString(e.getSueldoMensual())+ "," + e.getPuesto());
			}
			bw.close();
			fw.close();
		} catch(FileNotFoundException fnfe){
			System.out.println("   Lo sentimos, tu archivo no fue encontrado ");
		} catch (Exception ex){
			System.out.println("   Lo sentimos, algo imprevisto sucedió");
		}
	}

	/**
	 * Crea un catalogo a partir de una lista ligada.
	 * @param l la lista con la cual crearemos el catalogo.	 
	 */
	public static void escribirCatalogo(ListaLigada<Empleado> l, String nombreA){
		try{
			File f = new File(nombreA+".txt");
			FileWriter fw;
			BufferedWriter bw;

			if(f.exists()){
				f.delete();
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);	
				for (int i = 0;i<l.size(); i++){
					Empleado es = l.get(i);
					escribirEmpleado(es);
					es.setNumEmpleado(i);
					bw.write(es.getNumEmpleado()+ "," +es.getNombreCompleto() + "," + es.getFechaNacimiento() /*+ "," + calculaRFC(es.nombreCompleto,es.fechaNacimiento)*/ + "," + Double.toString(es.getSueldoMensual())+ "," + es.getPuesto()+"\n");
				}				
			} else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				for (int i = 0;i<l.size(); i++){
					Empleado es = l.get(i);
					bw.write(es.getNumEmpleado()+ "," +es.getNombreCompleto() + "," + es.getFechaNacimiento() /*+ "," + calculaRFC(es.nombreCompleto,es.fechaNacimiento)*/ + "," + Double.toString(es.getSueldoMensual())+ "," + es.getPuesto()+"\n");
				}
			}
				bw.close();
				fw.close();
			//}
		} catch(FileNotFoundException fnfe){
			System.out.println("   Lo sentimos, tu archivo no fue encontrado");
		} catch (Exception ex){
			//System.out.println(ex.getMessage());
			System.out.println("   Lo sentimos, algo imprevisto sucedió");
		}
	}

	/** Lee el catalogo de todos los empleados. */	
	public static void leerCatalogo(String name){
		try{
			File f = new File(name+".txt");
			if(f.exists()){
				int contador =1;
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea = br.readLine()) != null ){

					String [] c= linea.split(",");	
					double d = Double.parseDouble(c[3]); 				
					Empleado a = new Empleado(c[1],c[2],d,c[4]);
					String d1 = Double.toString(d);
					int a2 = Integer.parseInt(c[0]);
					a.setNumEmpleado(contador++);
					a.ensenia();
					System.out.println( "****************************");
				}
			} else {
				System.out.println("\n   El Archivo con las personas dadas de baja antes, aun no ha sido creado porque nadie se ha dado de baja ");
			}
		} catch(FileNotFoundException fnfe){
			System.out.println("\n   Lo sentimos, tu archivo no fue encontrado ");
		} catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("\n   Lo sentimos, algo imprevisto sucedió ");
		}
	}

///////////// METODOS AUXILIARES /////////////////////

	/** Método que muestra el menú */
	public static void menu(){
		System.out.println("\n  #### ¿Qué deseas hacer? #### " );
		System.out.println("  [1] --> Dar de alta a un empleado.");
		System.out.println("  [2] --> Dar de baja a un empleado.");
		System.out.println("  [3] --> Dado un sueldo y un puesto, encontrar los empleados que ocupan ese puesto y perciban un sueldo que no sobrepase el sueldo solicitado.");
		System.out.println("  [4] --> Dado un año de nacimiento, aumentar el sueldo mensual en 1000 pesos a usuarios con año de nacimiento mayor al dado..");
		System.out.println("  [5] --> Salir del programa.");
		System.out.print("\nOpción: ");
		System.out.println();
	}

	/**
	 * Verifica lo que ingrese el usuario como opción en el menú.
	 * @param sc lo que el usuario ingrese.	 
	 * @param n1 el numero minimo a ingresar.
	 * @param n2 el numero máximo a ingresar.
	 * @return una opción válida dentro de los rangos establecidos.
	 */
	public static int verificaMenu (Scanner sc, int n1, int n2){
		int n;
		while(true){
			try{
				n = Integer.parseInt(sc.nextLine());
				if(n < n1 || n > n2){
					throw new IndexOutOfBoundsException("Ingresaste un número fuera de rango");
				}
				break;
			}catch(NumberFormatException nfe){
				System.out.print("\n Asegurate de ingresar solo números\n");
				n=n2+1;
				continue;
			}catch(IndexOutOfBoundsException ioobe){
				System.out.println(ioobe.getMessage());
				n=n2+1;
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
	    while (inicio < termina){
	      inicio++;
	      if(c == cadena.charAt(inicio-1)){
	        conta++;
	      }
	    }
	    return conta;
	  }	

	/**
	 * Verifica si una cadena contiene numeros.
	 * @param cadena la cadena a revisar.	 
	 * @return saber si la cadena tinee o no numeros.
	 */
	private static boolean tieneNumeros(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

	/**
	 * Verifica lo que ingrese el usuario como opción en el menú.
	 * @param l la lista donde esta el catálogo.	 
	 * @param sueldo el numero máximo a percibir.
	 * @param puesto el puesto a buscar en relacion con el sueldo.
	 */
	public static void sueldoPuesto(ListaLigada<Empleado> l, double sueldo, String puesto){
		String comunes="";
		for (int i=0;i<l.size();i++){
			Empleado e1 = l.get(i);
			String lugar =e1.getPuesto();
			double salario = e1.getSueldoMensual();
			if(puesto.equals(lugar)){
				if(sueldo>=salario){
					comunes+= "\nNombre: "+e1.getNombreCompleto()+"\n"+"Sueldo: "+e1.getSueldoMensual()+"\n\n";
				}
			}
		}
			System.out.println(comunes);
	}	

	/**
	 * Aumenta el sueldo de un empleado dependiendo su año de nacimiento.
	 * @param l la lista donde estan los empleados.	 
	 * @param anio el año a comparar con el del empleado y definir si se realiza el aumento.
	 */
	public static void aumentaSueldo(ListaLigada<Empleado> l, double anio){
		String c ="";
		for (int i=0;i<l.size();i++){
			Empleado e1 = l.get(i);
			String fecha = e1.getFechaNacimiento();
			double sueldoAntes = e1.getSueldoMensual();
			String soloAnio = fecha.substring(6);
			double fech = Double.parseDouble(soloAnio);
			if(anio<fech){
				e1.setSueldoMensual(sueldoAntes+1000);
				escribirEmpleado(e1);
				escribirCatalogo(l,"Catálogo");
				c+="\n"+"Nombre: "+e1.getNombreCompleto()+"\nAño de Nacimiento: "+soloAnio+"\nSueldo anterior: "+sueldoAntes+"\nSueldo actual: "+e1.getSueldoMensual()+"\n";
			}
		}
			System.out.println(c);
	}		

/////////// METODO MAIN //////////////////

	public static void main(String[] args) {
    	ListaLigada<Empleado> listaCatalogo = new ListaLigada<>();
    	ListaLigada<Empleado> listaBorrados = new ListaLigada<>();
    	Scanner sc = new Scanner(System.in);

		Empleado ejecutivo1 = new Empleado ("Pablo López Morales","15/11/1980",5000,"Supervisor de vendedores");
		Empleado ejecutivo2 = new Empleado ("Francisco Aguirre Lara","01/12/1984",5000,"Supervisor de vendedores");
		Empleado ejecutivo3 = new Empleado ("Zia López López","06/05/1989",5000,"Supervisor de vendedores");

		Empleado gerente1 = new Empleado ("Nahomi Veláz Guitierrez","20/05/2001",3000,"Gerente");
		
		Empleado ventas1 = new Empleado ("Miguel Camino Naranjo","17/03/1974",3000,"Vendedor");
		Empleado ventas2 = new Empleado ("Felipe Quintanar Ferrer","15/02/1990",3000,"Vendedor");

		Empleado asistente1 = new Empleado ("Susana Amat Mena","18/01/1969",2500,"Intendente");
		Empleado asistente2 = new Empleado ("Irene Garrido Amate","28/11/1995",2500,"Intendente");

		Empleado sac1 = new Empleado ("María Campos Vique","25/02/1986",1500,"Servicio al cliente");
		Empleado sac2 = new Empleado ("Melanie Casas Garza","19/03/1999",1500,"Servicio al cliente");

    	System.out.println("\n              -------- BIENVENIDO -------- " );
		listaCatalogo.add(0,ejecutivo1);
		listaCatalogo.add(1,ejecutivo2);		
		listaCatalogo.add(2,ejecutivo3);
		listaCatalogo.add(3,gerente1);
		listaCatalogo.add(4,ventas1);
		listaCatalogo.add(5,ventas2);
		listaCatalogo.add(6,asistente1);
		listaCatalogo.add(7,asistente2);
		listaCatalogo.add(8,sac1);
		listaCatalogo.add(9,sac2);

		escribirCatalogo(listaCatalogo,"Catálogo");
		leerCatalogo("Catálogo");
    	menu();

    	int choose = verificaMenu(sc,1,5);
    	do{
    		switch(choose){
    			case 1:
    				System.out.println("Seleccione una opción\n 1 --> Crear un nuevo empleado para darlo de alta \n 2 --> Añadir un empleado que antes fue dado de baja");
    				int select=verificaMenu(sc,1,2);
    				switch(select){
    					case 1:
		    				System.out.println("Ingrese el nombre del Empleado");
		    				String nombre = sc.nextLine().trim();
		    				  
		    				while( tieneNumeros(nombre)!= false){
		    					System.out.println("Un nombre no puede ser solo una serie de números");
		    					nombre=sc.nextLine().trim();
		    					tieneNumeros(nombre);
		    				} 

		    				System.out.println("Apellido Paterno");
		    				String aPaterno = sc.nextLine();
		    				while( tieneNumeros(aPaterno)!= false){
		    					System.out.println("Un nombre no puede ser solo una serie de números");
		    					aPaterno=sc.nextLine();
		    					tieneNumeros(aPaterno);
		    				} 	

		    				System.out.println("Apellido Materno");
		    				String aMaterno = sc.nextLine();
		    				while( tieneNumeros(aMaterno)!= false){
		    					System.out.println("Un nombre no puede ser solo una serie de números");
		    					aMaterno=sc.nextLine();
		    					tieneNumeros(aMaterno);
		    				}  				
		    				
		    				String nombreCompleto =nombre+" "+aPaterno+" "+aMaterno; 
		    				String aux = nombreCompleto.replaceAll(" ","");
		    				if(aux.matches(".*[^a-z].*")){
		    					System.out.println(aux);
		    					nombreCompleto = nombreCompleto;
		    				}


		    				if(nombre.equals("") || aPaterno.equals("") ||aMaterno.equals("")||aux.contains("/")||aux.contains("$")||aux.contains("@")||aux.contains(".")||aux.contains(",") ){
		    					System.out.println("TU NOMBRE CONTIENE CARACTERES ESPECIALES O CADENA VACIA EN ALGUNO DE LOS CAMPOS, SERÁS AÑADIDO AL CATÁLOGO PERO SIN NOMBRE Y SIN RFC ");
		    					nombreCompleto = "SIN NOMBRE";
		    				}
		    						    		
		    				System.out.println("Ingrese fecha de nacimiento en formato dd/mm/aaaa");
		    				System.out.println("\n¿Naciste en Febrero? \n 1 --> Sí \n 2 --> No");
		    				int feb = verificaMenu(sc,1,2);
		    				int dia, mes, anio;
		    				String diaC,mesC,anioC,fechaN,auxD,auxM;
		    				if(feb ==1){
		    					mes=2;
		    					mesC="0"+String.valueOf(mes);

			    				System.out.println("Día: ");
			    				dia = verificaMenu(sc,1,28);
			    				if(dia<10 || dia<0){
			    					auxD ="0";
			    				diaC =auxD+ String.valueOf(dia);
			    				}else{
				    				diaC = String.valueOf(dia);
			    				}

			    				System.out.println("Año: "+"(Mínimo 1930 - Máximo 2001)");
			    				anio = verificaMenu(sc,1930,2001);
			    				anioC = String.valueOf(anio);
			    				fechaN = diaC+"/"+mesC+"/"+anioC;
		    				}else{
			    				System.out.println("Día: ");
			    				dia = verificaMenu(sc,1,31);
			    				if(dia<10 || dia<0){
			    					auxD ="0";
			    				diaC=auxD+ String.valueOf(dia);
			    				}else{
				    				diaC = String.valueOf(dia);
			    				}

			    				System.out.println("Mes:");
		    					mes = verificaMenu(sc,1,12);
		    					while(mes == 2){
		    						System.out.println("Dijiste que NO habias nacido en Febrero -_- Ingresa otro mes");
		    						mes = verificaMenu(sc,1,12);
		    					}
			    				if(mes<10 || mes<0){
			    					auxM ="0";
			    				mesC=auxM+ String.valueOf(mes);
			    				}else{
				    				mesC = String.valueOf(mes);
			    				}    					
			    				System.out.println("Año: "+"(Mínimo 1930 - Máximo 2001)");
			    				anio = verificaMenu(sc,1930,2001);
			    				anioC = String.valueOf(anio);
			    				fechaN = diaC+"/"+mesC+"/"+anioC;
		    				}

		    				String s;
		    				double sueldo;
		    				while(true){
								try {
				    				System.out.println("Ingrese sueldo del empleado (entero ó con centavos, si ingresas datos negativos el sueldo por default será de 128 pesos - Salario mínimo)");
					    			 s = sc.nextLine().replaceAll(",","");
					    			if(s.equals(".") || (cuentaCaracter(s,'.')>1) || s.equals("..")){
					    				s="cadena";
					    			}

					    			while((s.matches(".*[a-z].*")) || (cuentaCaracter(s,'.')>1) ){
					    				System.out.println("Sueldo no válido");
					    				s=sc.nextLine().replaceAll(",","");
						    			if(s.equals(".") || (cuentaCaracter(s,'.')>1) || s.equals("..")){
						    				s="cadena";
						    			}	    				
					    			}
									sueldo = Double.parseDouble(s);
									if(sueldo<0){
										sueldo =128;
									}
									break;
								} catch(NumberFormatException nfe){
									System.out.print("\nAsegurate de ingresar solo números\n");
								} catch(Exception e){
									System.out.println("\n Lo sentimos, algo imprevisto sucedió" );
								}
							}
		    				System.out.println("Ingrese el puesto del empleado");
		    				String puesto = sc.nextLine();
		    				while(tieneNumeros(puesto)!= false){
		    					System.out.println("Ningun puesto puede llevar números");
		    					puesto=sc.nextLine();
		    					tieneNumeros(puesto);
		    				}
		    				if(puesto.equals("")){
		    					puesto = "SIN PUESTO";
		    				}     				

		    				Empleado nuevoE = new Empleado(nombreCompleto,fechaN,sueldo,puesto);
		    				System.out.println("Se creo un archivo llamado "+nombreCompleto+".txt con los datos del empleado");
		    				escribirEmpleado(nuevoE);
		    				listaCatalogo.add(listaCatalogo.size(),nuevoE);
		    				escribirCatalogo(listaCatalogo,"Catálogo");
							leerCatalogo("Catálogo");
    					break;

    					case 2:
    						if(listaBorrados.isEmpty()){
    							System.out.println("No hay empleados dados de baja ");
    						}else{
	    						System.out.println("Catálogo de personas dadas de baja\n");
	    						leerCatalogo("Borrados");
				    			System.out.println("Selecciona el numero de empleado a dar de alta (otra vez)");
			    				int a = verificaMenu(sc,1,listaBorrados.size());
			    				Empleado reincorp = listaBorrados.get(a-1);
			    				listaBorrados.remove(a-1);
			    				escribirCatalogo(listaBorrados,"Borrados");
			    				listaCatalogo.add(listaCatalogo.size()-1,reincorp);
			    				escribirCatalogo(listaCatalogo,"Catálogo");
			    				leerCatalogo("Catálogo");
			    				System.out.println(reincorp.getNombreCompleto()+" fue reincoporad@ al catálogo\n");
    						}
    					break;
    				}
	    				menu();
	    				choose= verificaMenu(sc,1,5);
    			break;

    			case 2:
	    			System.out.println("########## EL CATÁLOGO ACTUAL ES EL SIGUIENTE ##########\n");
	    			leerCatalogo("Catálogo");
	    			System.out.println("Selecciona el numero de empleado a dar de baja");
	    			int baja = verificaMenu(sc,1,listaCatalogo.size());
	    			
	    			if(listaCatalogo.size()==1){
	    				System.out.println("EL CATÁLOGO DEBE TENER AL MENOS UN EMPLEADO");
	    			}else{
		    			Empleado elim  = listaCatalogo.get(baja-1);
		    			listaCatalogo.remove(baja-1);
		    			System.out.println("%%%  (CATALOGO ACTUALIZADO) %%%");
		    			escribirCatalogo(listaCatalogo,"Catálogo");
		    			leerCatalogo("Catálogo");
			    		System.out.println("\n"+elim.getNombreCompleto().toUpperCase()+" fue dad@ de baja \n(Se le borro del catálogo pero su archivo "+elim.getNombreCompleto().trim()+".txt permanece por si se requiere recuperar)");
	    				listaBorrados.add(listaBorrados.size(),elim);
	    				escribirCatalogo(listaBorrados,"Borrados");
	    			}

    				menu();
    				choose = verificaMenu(sc,1,5);
    			break;

    			case 3:
	    			String s;
	    			double sueldo;
	    				while(true){
							try {
								System.out.println("A continuación usted ingresara un sueldo y un puesto para hayar a los empleados que ocupan ese puesto y perciban un sueldo que no pase al ingresado.\nSI EL SISTEMA NO ENCUENTRA EMPLEADOS RESPECTO A LOS DATOS INGRESADOS, LO REGRESARA AL MENÚ");
						    	System.out.println("Ingrese sueldo máximo a percibir del empleado (entero ó con centavos, si ingresas datos negativos el sueldo por default será de 10,000 pesos)");
				    			s = sc.nextLine().replaceAll(",","");
				    			if(s.equals(".") || (cuentaCaracter(s,'.')>1) || s.equals("..")){
				    				s="cadena";
				    			}
				    			while((s.matches(".*[a-z].*")) || (cuentaCaracter(s,'.')>1) ){
				    				System.out.println("Sueldo no válido");
				    				s=sc.nextLine().replaceAll(",","");
					    			if(s.equals(".") || (cuentaCaracter(s,'.')>1) || s.equals("..")){
					    				s="cadena";
					    			}	    				
				    			}
								sueldo = Double.parseDouble(s);
								break;
							} catch(NumberFormatException nfe){
								System.out.print("\nAsegurate de ingresar solo números\n");
							} catch(Exception e){
								System.out.println("\n Lo sentimos, algo imprevisto sucedió" );
							}
						}

				    	if(sueldo<0){
				    		sueldo=10000;
				    	}
				    	System.out.println("Ingrese puesto (favor de escribirlo como está en el catálogo, de otra manera no apareceran los empleados)");
		    			String p = sc.nextLine();
		    			while(tieneNumeros(p)!= false){
		    				System.out.println("Ningun puesto puede llevar números");
		    				p=sc.nextLine();
		    				tieneNumeros(p);
		    			}

		    			if(p.equals("")){
		    				System.out.println("Ingresaste una cadena vacia, tu puesto será \"SIN PUESTO\" \n");
		    				p = "SIN PUESTO";
		    			} 
						sueldoPuesto(listaCatalogo,sueldo,p);
	  				menu();
    				choose=verificaMenu(sc,1,5);
    			break;

    			case 4:
    				System.out.println("Ingrese Año (Mínimo 1930 - Máximo 2001)");
			    	int auxYear = verificaMenu(sc,1930,2001);
			    	double year= auxYear;
			    	aumentaSueldo(listaCatalogo,year);

	  				menu();
    				choose=verificaMenu(sc,1,5);    			
    			break;

    			case 5:
    			choose = 5;
    			sc.close();
    			break;
    		}
    	}while(choose !=5);
	}	
}