package fciencias.edatos.practica05;

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
 * Práctica 5: Aplicaciones de árboles, XML.
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
    public void lee(String nombre) throws ParserConfigurationException, 
					  SAXException, IOException, DOMException{
		// Archivo que representa el xml
        File archivo = new File(nombre);

        // Se crean las fabricas necesarias para generar un creador de documentos
        DocumentBuilderFactory fabricaDeConstructores = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructor = fabricaDeConstructores.newDocumentBuilder();
        Document documento = constructor.parse(archivo);

        // Se crea la lista de autos
        NodeList autos = documento.getElementsByTagName("Auto");
        Node nodo;

        System.out.println("Los Autos son:\n");

        // Se crean los elementos necesarios. Esto corresponde a las etiquetas.
        Element auto, propietario, opinion;

        // Lista que almacena las secciones de cada auto
        NodeList propietarios, opiniones;

        for(int i = 0; i<autos.getLength(); i++){

            // Se obtiene el nodo con el primer auto
            nodo = autos.item(i);

            // Se convierte el nodo a un elemento.
            auto = (Element) nodo;

            /* Se acceden a los valores de los atributos almacenados en 
             * la etiqueta perteneciente a un auto. */
            System.out.println("Auto: "+auto.getAttribute("marca")+
                "\nModelo: "+auto.getAttribute("modelo"));

            /* No todos los autos cuentan con placas o anio. Así que se verifica
             * si existen esos atributos. */
            if(auto.hasAttribute("placas"))
                System.out.println("Placas: "+auto.getAttribute("placas"));
            if(auto.hasAttribute("anio"))
                System.out.println("Año: "+auto.getAttribute("anio"));

            // Se almacena en secciones una lista con las secciones del auto en cuestión.
            propietarios = auto.getElementsByTagName("Propietario");

            // Se imprimen los atibutos del auto, así como el contenido de las etiquetas.
            for(int j = 0; j<propietarios.getLength(); j++){
                propietario = (Element) propietarios.item(j);
                System.out.println("    - Propietario:  "+propietario.getAttribute("nombre")+" "+
                    propietario.getAttribute("materno")+" "+propietario.getAttribute("paterno"));
            }

            opiniones = auto.getElementsByTagName("Opinion");

            for(int k = 0; k<opiniones.getLength(); k++){
                opinion = (Element) opiniones.item(k);
                System.out.println("    - Opinion:  "+opinion.getTextContent());
            }

            System.out.println();
            
        } 
    }

}