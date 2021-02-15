package fciencias.edatos.practica06;

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
 * Práctica 6: Aplicaciones de árboles, XML.
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación no es mia en su totalidad 
 * Créditos: Emmanuel Cruz Hernández
 * @version 1.0
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
    public  void lee() throws ParserConfigurationException,SAXException, IOException, DOMException{
		// Archivo que representa el xml
        File archivo = new File("Directorio.xml");

        // Se crean las fabricas necesarias para generar un creador de documentos
        DocumentBuilderFactory fabricaDeConstructores = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructor = fabricaDeConstructores.newDocumentBuilder();
        Document documento = constructor.parse(archivo);
        //System.out.println(documento);
        //System.out.println(archivo);
        // Se crea la lista de ciudades
        NodeList ciudades = documento.getElementsByTagName("Ciudad");
        Node nodo;

        System.out.println("Las ciudades son: \n");

        // Se crean los elementos necesarios. Esto corresponde a las etiquetas.
        Element ciudad;


        for(int i = 0; i<ciudades.getLength(); i++){

            // Se obtiene el nodo con el primer auto
            nodo = ciudades.item(i);

            // Se convierte el nodo a un elemento.
            ciudad = (Element) nodo;

            /* Se acceden a los valores de los atributos almacenados en 
             * la etiqueta perteneciente a un auto. */
            System.out.println("Ciudad: "+ciudad.getAttribute("nombre")+
                "\nEstado: "+ciudad.getAttribute("estado")+"\nLatitud: "+ciudad.getAttribute("latitud")+"\nLongitud: "+ciudad.getAttribute("longitud"));



            System.out.println();
            
        } 
    }

}