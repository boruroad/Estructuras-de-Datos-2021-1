package fciencias.edatos.ejemploDom;

import java.util.ArrayList;

/**
* Clase que representa fechas de cumpleaños.
* @author Emmanuel Cruz Hernández.
* @version 1.0, 2020.
* @since Estructuras de datos 2021-1
*/
public class Cumpleanios{
	
	/** Nombre del cumpleañero. */
	public String nombre;

	/** Dia del cumpleaños. */
	public int dia;

	/** Mes del cumpleaños. */
	public int mes;

	/** Año del cumpleaños. */
	public int anio;

	/**
	* Crea una nueva fecha de cumpleaños.
	* @param nombre el nombre del cumpleañero.
	* @param dia el día del cumpleaños.
	* @param mes el mes del cumpleaños.
	* @param anio el año del cumpleaños.
	*/
	public Cumpleanios(String nombre, int dia, int mes, int anio){
		this.nombre = nombre;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	/**
	* Regresa el formato de cumpleaños.
	* @return un mensaje con el formato de cumpleaños.
	*/
	public String daMensaje(){
		return nombre+" cumple años el "+dia+" de "+daMes(mes)+" de "+anio;
	}

	/**
	* Regresa el mes asociado a su representación numérica.
	* @param mes en representación numérica.
	* @return el mes asociado al parámetro.
	*/
	public String daMes(int mes){
		switch(mes){
			case 1:
				return "Enero";
			case 2:
				return "Febrero";
			case 3:
				return "Marzo";
			case 4:
				return "Abril";
			case 5:
				return "Mayo";
			case 6:
				return "Junio";
			case 7:
				return "Julio";
			case 8:
				return "Agosto";
			case 9:
				return "Septiembre";
			case 10:
				return "Octubre";
			case 11:
				return "Noviembre";
			case 12:
				return "Diciembre";
			default:
				return "MES INVÁLIDO";
		}
	}

	public static void main(String[] args) {
		Cumpleanios c1 = new Cumpleanios("Pepe", 2, 3, 2000);
		Cumpleanios c2 = new Cumpleanios("Josh", 1, 11, 1997);
		Cumpleanios c3 = new Cumpleanios("José", 15, 12, 1995);
		Cumpleanios c4 = new Cumpleanios("Emma", 15, 12, 1997);

		ArrayList<Cumpleanios> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);

		EscritorDOM escritor = new EscritorDOM();

		try{
			escritor.escribe("EjemploDOM.xml", lista);
		} catch(Exception e){
			System.out.println("Ocurrió un error en la escritura del archivo XML");
		}
	}
}