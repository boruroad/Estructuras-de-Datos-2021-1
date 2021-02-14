package fciencias.edatos.serializados;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

/**
* Clase que permite leer y escribir objetos serializados
* en archivos de texto.
* @author Emmanuel Cruz Hernández.
* @version 1.0 Septiembre 2020.
* @since Estructuras de datos 2021-1.
*/
public class Serializador{

	/**
	* Crea un archivo serializado con la representación de una transacción.
	* @param nombre el nombre con el cual guardar el archivo.
	* @param t la transacción a serializar en un archivo.
	* @throws IOException si ocurre un error durante la escritura del archivo.
	*/
	public void serializa(String nombre, Transaction t) throws IOException{
		FileOutputStream file = new FileOutputStream(nombre);
		ObjectOutputStream output = new ObjectOutputStream(file);

		output.writeObject(t);

		output.close();
	}

	/**
	* Crea una transación a partir de un archivo serializado.
	* @param nombre el nombre del archivo del cual obtener la representación.
	* @return la transacción obtenida del archivo serializado.
	* @throws IOException si ocurre un error durante la lectura del archivo.
	* @throws ClassNotFoundException si no se encuentra la clase a la cual convertir
	* el archivo serializado a un objeto.
	*/
	public Transaction deserializa(String nombre) throws IOException, ClassNotFoundException{
		FileInputStream file = new FileInputStream(nombre);
		ObjectInputStream input = new ObjectInputStream(file);

		Transaction t;
		t = (Transaction) input.readObject();

		input.close();

		return t;

	}

	public static void main(String[] args) {
		Serializador s = new Serializador();

		Date fecha = new Date(9, 26, 2020);

		Transaction transaccion = new Transaction("Emmanuel", fecha, 200);

		// Serialización de una transacción.
		try{
			s.serializa("Transaccion1", transaccion);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}

		// Deserialización de una transacción.

		try{
			Transaction tr = s.deserializa("Transaccion1");

			System.out.println(tr);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}

		
	}
}