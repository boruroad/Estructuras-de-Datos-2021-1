package fciencias.edatos.practica07;

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
 * Práctica 7: Tablas de dispersión.
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación incluye material brindado por:
 * Emmanuel Cruz Hernández 
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
    public ChainHashMap lee() throws ParserConfigurationException, SAXException, IOException, DOMException{
        ChainHashMap<String,Double> chm = new ChainHashMap<>();
		// Archivo que representa el xml
        File archivo = new File("tabla-periodica.xml");

        // Se crean las fabricas necesarias para generar un creador de documentos
        DocumentBuilderFactory fabricaDeConstructores = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructor = fabricaDeConstructores.newDocumentBuilder();
        Document documento = constructor.parse(archivo);

        NodeList elementos = documento.getElementsByTagName("elemento");
        Node nodo;

        // Se crean los elementos necesarios. Esto corresponde a las etiquetas.
        Element elemento;
        Elemento aux;
        
        String nombre;
        double masa;
        String simbolo;
        int    numero;        

        for(int i = 0; i<elementos.getLength(); i++){
            aux = new Elemento();
            // Se obtiene el nodo con el primer elemento
            nodo = elementos.item(i);
            // Se convierte el nodo a un elemento.
            elemento = (Element) nodo;

            /* Se acceden a los valores de los atributos almacenados */
            nombre  = elemento.getAttribute("nombre");
            masa    = Double.parseDouble(elemento.getAttribute("masa"));
            simbolo = elemento.getAttribute("simbolo");
            aux.setNombre(nombre);
            aux.setSimbolo(simbolo);
            aux.setMasa(masa);
            chm.put(simbolo,masa);            
        } 
        return chm;
    }

}