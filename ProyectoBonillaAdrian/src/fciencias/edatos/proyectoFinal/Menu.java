package fciencias.edatos.proyectoFinal;

import java.util.Scanner;

/**
 * Proyecto Final: Comunicaciones telefónicas
 * Estructura de Datos 2021-1.
 * @author Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * @version 1.0
 */

public class Menu{
  	public static final String FONDOROJO     = "\u001B[41m";
  	public static final String BLANCO        = "\u001B[37m";
  	public static final String RESETEAR      = "\u001B[0m";
  	public static final String FONDOAZUL     = "\u001B[44m";
  	public static final String FONODVERDE    = "\u001B[42m";
  	public static final String FONDOAMARILLO = "\u001B[43m";
  	public static final String FONDOMORADO   = "\u001B[45m";
  	public static final String FONDOCYAN     = "\u001B[46m";
	
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
	 * Regresa en una lista, todos los vecinos de un vertice.
	 * @param graph la grafica donde vamos a iterar 
	 * @param inicial el vertice al cual le vamos a buscar sus vecinos.
	 * @return la lista con todos los vecinos de ese vertice.
	 */
	public static ListaLigada<Estacion> vecinos(GraficaMatriz<Estacion,Integer> graph, Estacion inicial){
		TDALista<Estacion> estaciones = new ListaLigada<>();
		ListaLigada<Estacion> listaV  = new ListaLigada<>();
		estaciones = graph.getVertex();

		for (int i=0;i<estaciones.size();i++){
			Estacion aux = estaciones.get(i);
			if(graph.getEdge(inicial,aux)){
				listaV.add(0,aux);
			}
		}
		return listaV;
	} 

	/**
	 * Método que ejecuta el camino más corto de
	 * una grafica y regresa su ruta
	 * @param graph la grafica donde vamos a iterar 	 
	 * @param inicial el verticie inicial
	 * @param llegada el vertice al cual queremos llegar
	 * @return la ruta del verticie inicial al de llegada, null en caso de que no exista.
	 */
	public static ListaLigada<Integer> ruta(GraficaMatriz<Estacion,Integer> graph, Estacion inicial, Estacion llegada){
		ColaLista<Estacion> cola  = new ColaLista<>();
		ListaLigada<Integer> ruta = new ListaLigada<>();
		boolean [] visitados      = new boolean [graph.numVertex()+1];
		int [] padres             = new int [graph.numVertex()+1];
		int [] distancia          = new int [graph.numVertex()+1];
		
		cola.insert(inicial);

		visitados[inicial.getId()] = true;
		padres[inicial.getId()]    = -1;
		while(!cola.isEmpty()){
			Estacion u = cola.delete();
			int id     = u.getId();
			ListaLigada <Estacion> vec = vecinos(graph,u); 
			for(int i = 0;i< vec.size();i++){
				Estacion r = vec.get(i);
				int idR    = r.getId();
				if(visitados[idR]==false){
					visitados [idR] = true;
					cola.insert(r);
					distancia [idR] = distancia[id]+1;
					padres [idR]    = id;
				}
			}
		}
		
		int idLlegada = llegada.getId();
		if(!visitados[idLlegada]){
			System.out.println("No existe conexión a la estación donde se encuentra (No se puede realizar tu llamada)");
			return null;
		}

		for (int j=idLlegada;j!=-1;j=padres[j]){
			ruta.add(0,j);
		}
		return ruta;
	}


	/**
	 * Verifica que el numero ingresados este asociado en la grafica.
	 * @param telefono el numero a verificar.
	 * @param graph la grafica donde buscaremos.
	 * @return true en caso de que el numero este, false en caso contrario
	 */
	public static boolean verificaTel(int telefono, GraficaMatriz<Estacion,Integer> graph){
		TDALista<Estacion> verticesLista = new ListaLigada<>();
		verticesLista                    = graph.getVertex();
		for (int i=0;i<verticesLista.size();i++){
			Estacion e = new Estacion();
			e = verticesLista.get(i);
			ListaLigada<Cliente> listadoC = e.getListaC();
			for (int j=0;j<listadoC.size();j++){
				Cliente c = new Cliente();
				c = listadoC.get(j);
				if(telefono == c.getTelefono()){
					return true;
				}				
			}
		}
		return false;
	}

	/**
	 * Muestra de manera estética la gráfica en la terminal 
	 * @param prueba la lista con los verices de la grafica.	 
	 * @param conta el numero a iniciar la lista.
	 */
	public static void graficaEstetica(TDALista<Estacion> prueba, int conta){
		System.out.println("LOS IDENTIFICADORES ASI COMO LOS NOMBRES DE CADA ESTACIÓN, SON LOS SIGUIENTES:\n");
		for (int i=prueba.size();i>0;i--){
			System.out.println("\t"+conta+ " .- "+prueba.get(i-1).getNombre()+"\n");
			conta++;										
		}
	}

	/**
	 * Método que dado una grafica y un telefono
	 * Regresa un arreglo de tamanio 2, el cual guarda en la casilla [0] una estacion
	 * y en la casilla [1] el nombre del cliente asociado a esa linea.
	 * @param graph la grafica como tal.	 
	 * @param telefono1 el numero a asociar con la estación y el cliente.
	 * @return el arreglo con nuestros datos.
	 */
	public static Object [] estacionIoF(GraficaMatriz<Estacion,Integer> graph, int telefono1){
		Object [] datosE = new Object[2];
		TDALista<Estacion> prueba = new ListaLigada<>();
		prueba = graph.getVertex();
		for(int i=prueba.size();i>0;i--){
			Estacion estacion = new Estacion();
			estacion = prueba.get(i-1);
			ListaLigada<Cliente> lAux = estacion.getListaC();

			for(int j = 0;j<lAux.size();j++){
				Cliente c = new Cliente();
				c = lAux.get(j);
				int check = c.getTelefono();
				
				if(telefono1 ==check){
					datosE [0] = estacion; 
					datosE [1] = c.getNombre();
					return datosE;
				}
			}
		}
		return null;
	}

	/**
	 * Método que verifica la llamada entre dos telefonos
	 * @param graph la grafica como tal.	 
	 * @param telefono1 el primer numero a asociar con la estación y el cliente.
	 * @param telefono2 el segundo numero a asociar con la estación y el cliente
	 * @param opcion la opcion que haya escogido el usuario
	 */	
	public static void verificaLlamada(GraficaMatriz<Estacion,Integer> graph, int telefono1, int telefono2, int opcion){
		TDALista<Estacion> prueba = new ListaLigada<>();
		ListaLigada<Integer>  camino = new ListaLigada<>();
		prueba         = graph.getVertex();
		String ruta    = "";
		String mensaje = "";		
		String caso    = "";
		String s1      = "";
		int clientes=0;
		Object [] datosInicial = estacionIoF(graph,telefono1);
		Estacion inicio        = (Estacion)datosInicial[0];

		Object [] datosLlegada = estacionIoF(graph,telefono2);
		Estacion llegada       = (Estacion)datosLlegada[0];

		String n1    = inicio.getNombre().toUpperCase();
		System.out.println("El numero "+telefono1+" viene de la estación \""+n1+"\"");
		String llama = (String)datosInicial[1];
		System.out.println("Llama: \""+llama.toUpperCase()+"\"\n");					

		String n2       = llegada.getNombre().toUpperCase();
		System.out.println("El numero "+telefono2+" está en la estación \""+n2+"\"");
		String contesta = (String)datosLlegada[1];
		System.out.println("Debe contestar: \""+contesta.toUpperCase()+"\"\n");					

		for(int i=prueba.size();i>0;i--){
			Estacion estacion = new Estacion();
			estacion = prueba.get(i-1);
			ListaLigada<Cliente> lAux = estacion.getListaC();
			for(int j = 0;j<lAux.size();j++){
				Cliente c = new Cliente();
				c = lAux.get(j);
				if((telefono1 ==c.getTelefono()) || (telefono2 == c.getTelefono()) ){
					clientes++;
					if(clientes>2){
						mensaje="LO SENTIMOS, DOS PERSONAS TIENEN UN MISMO NÚMERO"+"\nSolo pueden realizar llamadas entre dos personas con distintos números";				
						System.out.println(FONDOMORADO+"***** ¡¡¡ CLIENTE CON NÚMERO REPETIDO !!! *****"+RESETEAR+"\n"+FONDOMORADO+"Nombre: "+c.getNombre()+RESETEAR+"\n"+FONDOMORADO+"Teléfono: "+c.getTelefono()+RESETEAR);
					}
				}
			}
		}
		camino= ruta(graph,inicio,llegada);
		int distancia =camino.size()-1;
		if(clientes<3){

			graficaEstetica(prueba,1);
			int veces=0;
			for(int k=0; k<prueba.size();k++){
				Estacion acepta = new Estacion();
				acepta = prueba.get(k);
				if(acepta.getNombre().equals(llegada.getNombre())){
					llegada =acepta;
				}
				if(n1 != n2){
					if(graph.getEdge(inicio,llegada)){
						caso = "A UNA ARISTA DE DISTANCIA (DISTANCIA 1)\n";
						s1="Esta es una llamada entre clientes que están a 1 estación de distancia\nDe: " +inicio.getNombre()+"\nA : "+llegada.getNombre();
						mensaje = FONODVERDE+"\t\t\t**** "+llama.toUpperCase()+" hablando por"+((opcion==1)?" VIDEO-FONO con ":" LLAMADA TRADICIONAL con ") +contesta.toUpperCase()+" ****"+RESETEAR+"\n";
						ruta = "RUTA: "+inicio.getId()+" => "+llegada.getId()+"\n";
						break;
					}
				}

				if( (!graph.getEdge(inicio,inicio)) && (n1.equals(n2))){
					caso= "MISMA ESTACION (LAZO)\n";
					s1="Esta es una llamada entre clientes de una misma estación\nDe: " +inicio.getNombre()+"\nA : "+inicio.getNombre();
					mensaje = FONODVERDE+"\t\t\t**** "+llama.toUpperCase()+" hablando por"+((opcion==1)?" VIDEO-FONO con ":" LLAMADA TRADICIONAL con ")+contesta.toUpperCase()+" ****"+RESETEAR+"\n";
					ruta = "RUTA: "+inicio.getId()+" => "+inicio.getId()+"\n";
					break;
				}

				if(camino ==null) {
					System.out.println(FONDOROJO+"NO HAY FORMA DE LLEGAR DE LA ESTACIÓN DE UN CLIENTE A LA OTRA"+RESETEAR);
					break;
				}

				if((distancia>5) &&(opcion==1)) {
					System.out.println(FONDOROJO+"DISTANCIA SUPERIOR A 5 ESTACIONES (INTERFERENCIA)"+RESETEAR);
					System.out.println("Longitud de la ruta: "+distancia+"\nIMPOSIBLE CONECTAR");
					camino =null;
				}else{
					caso= "\nLLAMADA A "+distancia+" ESTACIONES DE DISTANCIA\n";
					s1="\nDe: " +inicio.getNombre()+"\nA : "+llegada.getNombre();
					mensaje = FONODVERDE+"\t\t\t**** "+llama.toUpperCase()+" hablando por"+((opcion==1)?" VIDEO-FONO con ":" LLAMADA TRADICIONAL con ")+contesta.toUpperCase()+" ****"+RESETEAR+"\n";
					camino.muestra();	
					break;
				}
				break;
			}
		}
		System.out.println(caso+s1+"\n"+ruta+""+mensaje);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		LectorDOM lector = new LectorDOM();
		GraficaMatriz<Estacion,Integer> graph = new GraficaMatriz<>(); 

		try{
			System.out.println("Con qué xml desea trabajar: ");
			System.out.println("1.- XML de Ejemplo (Brindado por el profesor)");
			System.out.println("2.- XML de Adrián Bonilla");
			int selectArch = verificaMenuAux(sc,1,2); 
			if(selectArch==1){
				graph = lector.lee("datos");			
			}else{
				graph = lector.lee("ProyectoFInal");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		int seleccion;
			System.out.println("Bienvenido nuestras opciones son las siguientes");
		do{
			System.out.println("\n¿Qué desea hacer?");
			System.out.println("1.- Realizar llamada");
			System.out.println("2.- Salir");
			seleccion = verificaMenuAux(sc,1,2);
	
			switch(seleccion){
				case 1:
					try{ 
						System.out.println("Ingrese su número porfavor: ");
						String numero1 = sc.next();
						int conversion = Integer.parseInt(numero1);

						System.out.println("Ingrese el número al cual desea llamar: ");
						String numero2  = sc.next();
						int conversion2 = Integer.parseInt(numero2);

						if(verificaTel(conversion,graph) && verificaTel(conversion2,graph)){
							if(conversion == conversion2){
								System.out.println(FONDOROJO+"LO SENTIMOS, NO PUEDES LLAMARTE A TI MISMO :c"+RESETEAR);
							}else{
								System.out.println(FONDOCYAN+"LA GRÁFICA DE ESTACIONES TIENE "+graph.numVertex()+" VERTICES Y "+graph.numEdges() +" ARISTAS"+RESETEAR+"\n");

								System.out.println("Seleccione una opción de llamada: \n1.-Video-fono \n2.-Llamada Tradicional");
								int selectCall = verificaMenuAux(sc,1,2);

								switch(selectCall){
									case 1:
										System.out.println(FONDOAMARILLO+"\t\t**** VIDEO-FONO ****"+RESETEAR);
										verificaLlamada(graph,conversion,conversion2,1);
									break;

									case 2:
										System.out.println(FONDOAZUL+"\t\t**** LLAMADA TRADICIONAL ****"+RESETEAR);
										verificaLlamada(graph,conversion,conversion2,2);	
									break;
								}
							}
						}else{
							System.out.println(FONDOROJO+"LO SENTIMOS, UNO O AMBOS NUMEROS TELEFÓNICOS NO ESTÁN EN NINGUNA ESTACIÓN"+RESETEAR);
						}
					}catch(Exception e){
						System.out.println("\n"+FONDOROJO+"**** LO SENTIMOS"+RESETEAR+"\n"+FONDOROJO+"NO ENCONTRAMOS COINCIDENCIAS CON TU NUMERO :c "+RESETEAR+"\n" );
					}
				break;
			}
		}while(seleccion!=2);
	}
}