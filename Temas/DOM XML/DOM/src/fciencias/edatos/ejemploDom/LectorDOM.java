package fciencias.edatos.ejemploDom;

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

/**
 * Ejemplo de lectura de XML usando DOM.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 2020
 * @since Estructuras de datos 2021-1
 */
public class LectorDOM{

    /**
     * Realiza la lectura de un archivo XML.
     * @param nombre el nombre del archivo a leer.
     * @throws ParserConfigurationException si ocurre algún problema
     * al instanciar el parser.
     * @throws SAXException si ocurre un problema durante la lectura
     * del archivo.
     * @throws IOException si ocurre un problema al abrir el archivo
     * o en la busqueda de este.
     * @throws DOMException si se solicitara información que no existe o
     * no está disponible en las etiquetas del archivo.
     */
    public void lee(String nombre) throws ParserConfigurationException, 
					  SAXException, IOException, DOMException{
		// Archivo que representa el xml
        File archivo = new File(nombre);

        // Se crean las fabricas necesarias para generar un creador de documentos
        DocumentBuilderFactory fabricaDeConstructores = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructor = fabricaDeConstructores.newDocumentBuilder();
        Document documento = constructor.parse(archivo);

        // Se crea la lista de libros
        NodeList libros = documento.getElementsByTagName("Libro");
        Node nodo;

        System.out.println("Los libros de la biblioteca son:");

        // Se crean los elementos necesarios. Esto corresponde a las etiquetas.
        Element libro, seccion;

        // Lista que almacena las secciones de cada libro
        NodeList secciones;

        for(int i = 0; i<libros.getLength(); i++){

            // Se obtiene el nodo con el primer libro
            nodo = libros.item(i);

            // Se convierte el nodo a un elemento.
            libro = (Element) nodo;

            /* Se acceden a los valores de los atributos almacenados en 
            * la etiqueta perteneciente a un libro. */
            System.out.println("Libro: "+libro.getAttribute("titulo")+
                "\nAutor: "+libro.getAttribute("autor"));

            /* No todos los libros cuentan con tomo o anio. Así que se verifica
            * si existen esos atributos. */
            if(libro.hasAttribute("tomo"))
                System.out.println("Tomo: "+libro.getAttribute("tomo"));
            if(libro.hasAttribute("anio"))
                System.out.println("Año: "+libro.getAttribute("anio"));

            // Se almacena en secciones una lista con las secciones del libro en cuestión.
            secciones = libro.getElementsByTagName("Seccion");

            // Se imprimen los atibutos del libro, así como el contenido de las etiquetas.
            for(int j = 0; j<secciones.getLength(); j++){
                seccion = (Element) secciones.item(j);
                System.out.println("    - Sección "+seccion.getAttribute("numero")
                    +": "+seccion.getTextContent());
            } // Termina for

            System.out.println();
            
        } // Termina el recorrido de libros
    }

    public static void main(String[] args) throws ParserConfigurationException,
    SAXException, IOException, DOMException{
        LectorDOM lector = new LectorDOM();
        lector.lee("biblioteca.xml");
    }
}
