import java.util.Scanner;

public class ComparaElementos<T extends Comparable<T>>{

	private T elemento1;
	private T elemento2;

	private static String mensaje;
	private static String mensajeC;

	public  int compareTo(T elemento,  T elemento2){
		int r =  elemento.compareTo(elemento2);
				if(r>0){
					mensaje = "El primer elemento es mayor";
				}		
				if(r<0){
					mensaje = "El segundo elemento es mayor";
				}
				if(r==0){
					mensaje = "Los elementos son iguales";
				}
			return r;
	}

	public static void menu(){
		System.out.println("\nSeleccione una opción:");
		System.out.println("[1]---> Comparar elementos");
		System.out.println("[2]---> Salir");

	}

	public static int revisa(Scanner sc) throws IndexOutOfBoundsException{
		int n;
		while(true){
			try {
				System.out.print( "\nOpción: ");
				n = Integer.parseInt(sc.nextLine());
				if(n < 1 || n > 2){
					throw new IndexOutOfBoundsException();
				}
				break;
			}catch(NumberFormatException nfe){
				System.out.println("\n  Lo sentimos, los caracteres no son válidos  ");
			}catch(IndexOutOfBoundsException ine){
				System.out.println("\n  Ingresaste una opcion fuera de rango ");
			} catch(Exception e){
				System.out.println("\n  Algo espontáneo sucedio");
			}
		}
		return n;
	}

	public static void main(String[] args) {
		ComparaElementos<String> p = new ComparaElementos<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("<<-----------BIENVENIDO------------>>\n");
		System.out.println("El objetivo de este programa es comparar elementos ingresados por usted");
		menu();
		int choose = revisa(sc); 
		do{ 
			switch(choose){
				case 1:
					System.out.println("\nIngresa primer elemento a comparar");
					String primerElem = sc.nextLine();
					int l1 = primerElem.length();
					boolean esCadena1 = false;
					boolean esCadena2 = false;

					try{ 
					    double d= Double.valueOf(primerElem); 
					    if (d==(int)d){ 
					     System.out.println("Ingresaste un tipo entero\n"); 
					     double i = Double.parseDouble(primerElem);
					    }else{ 
					     System.out.println("Ingresaste un tipo double\n");
					     d=Double.parseDouble(primerElem);
					    } 
					}catch(Exception e){ 
						esCadena1 =true;
					    mensaje = "Ingresaste una Cadena\n"; 
						System.out.println("Ingresaste una Cadena\n");
					} 		
			
					System.out.println("********** Ingresa segundo elemento a comparar **********");
					String segundoElem = sc.nextLine();
					int l2=segundoElem.length();
					try{ 
					    double d1= Double.valueOf(segundoElem); 
					    if (d1==(int)d1){ 
			   		       System.out.println("Ingresaste un tipo entero\n"); 
					       double i1 = Double.parseDouble(segundoElem);
					    }else{ 
					       System.out.println("Ingresaste un tipo double\n");	
						   d1=Double.parseDouble(segundoElem);
					    } 
					}catch(Exception ex){ 
					    mensaje = "Ingresaste una Cadena\n";
					    esCadena2 = true;
					    System.out.println("Ingresaste una Cadena\n");
					} 		
					
					p.compareTo(primerElem, segundoElem);
					if(esCadena1 != esCadena2){
						mensaje = "No se pudieron comparar los elementos";
					}else{
						if( (primerElem.matches(".*[a-z].*"))  || (segundoElem.matches(".*[a-z].*"))  ){
							if(mensaje.equals("Los elementos son iguales")){
								mensajeC = "\nNo pasa nada ----> Devolvemos ambas cadenas \n"+primerElem+"\n"+segundoElem;
								mensaje+=mensajeC;
							}else{
								mensajeC = "\nNo pasa nada ----> Devolvemos ambas cadenas \n"+primerElem+"\n"+segundoElem;
								mensaje=mensajeC;
							}
						}  
					}
				System.out.println(mensaje);
				menu();
				choose = revisa(sc);
				break;
			}
		}while(choose !=2);
	}
}