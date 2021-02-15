package fciencias.edatos.practica05;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import java.util.ArrayList;
import javax.xml.transform.OutputKeys;

/**
 * Práctica 5: Aplicaciones de árboles, XML.
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación no es mia en su totalidad 
 * Créditos: Emmanuel Cruz Hernández
 * @version 1.0
 */

public class EscritorDOM{

    /**
     * Permite escribir un archivo XML.
     * @param nombre el nombre del archivo a escribir.
     * @param estructura la estructura que contiene los elementos a escribir.
     * @throws ParserConfigurationException si ocurre un problema en la configuración
     * del parser.
     * @throws TransformerConfigurationException si ocurre un problema en la configuración
     * del transformador al parser.
     * @throws TransformerException si ocurre un error en el transformador.
     */
    public void escribe(String nombreArchivo, Cola<Automovil> cola) throws 
    ParserConfigurationException, TransformerConfigurationException, TransformerException{
    	// Se construyen las fabricas que permiten la interacción con documentos XML.
        DocumentBuilderFactory fabricaDeConstructores = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructor = fabricaDeConstructores.newDocumentBuilder();
        Document documento = constructor.newDocument();

        // Creación de la raíz.
	    Element raiz = documento.createElement("Automoviles");
	    // Se agrega la raíz al documento.
	    documento.appendChild(raiz);

	    // Se crean elementos. Cada uno corresponde a una etiqueta del XML.
	    Element auto, propietario, opinion;

	    // Se crea una instancia auxiliar del objeto que contiene la estructura.
	    Automovil actual;

	    for(int i = 0; i<cola.size(); i++){
		    	// Se obtiene el elemento en la posición i se la cola.
	    	actual = cola.get(i);

	    	// Se crea una etiqueta para el objeto.
	    	auto = documento.createElement("Auto");

	    	// Se agrega la etiqueta como hijo de la raíz.
	    	raiz.appendChild(auto);

	    	// Se agrega un atributo al atributo.
	    	Attr atributo = documento.createAttribute("marca");
	    	atributo.setValue(actual.marca);
	    	auto.setAttributeNode(atributo);

	    	Attr atributo2 = documento.createAttribute("modelo");
	    	atributo2.setValue(actual.modelo);
	    	auto.setAttributeNode(atributo2);

	    	if(actual.existPlacas){
		    	Attr atributo3 = documento.createAttribute("placas");
		    	atributo3.setValue(actual.placas);
		    	auto.setAttributeNode(atributo3);
	    	}

	    	if(actual.existAnio){
		    	Attr atributo4 = documento.createAttribute("anio");
		    	atributo4.setValue(""+actual.anio);
		    	auto.setAttributeNode(atributo4);
	    	}

	    	// Se crea una nueva etiqueta.
	    	propietario = documento.createElement("Propietario");

	    	// Se agrega la etiqueta como hijo de la etiqueta auto.
	    	auto.appendChild(propietario);

	    	// Se agregan atributos nuevos.
	    	Attr nombre = documento.createAttribute("nombre");
	    	nombre.setValue(actual.nombre);
	    	propietario.setAttributeNode(nombre);
	    	
	    	Attr materno = documento.createAttribute("materno");
	    	materno.setValue(actual.materno);
	    	propietario.setAttributeNode(materno);
	    	
	    	Attr paterno = documento.createAttribute("paterno");
	    	paterno.setValue(actual.paterno);
	    	propietario.setAttributeNode(paterno);

	    	// Se crea una nueva etiqueta.
	    	opinion = documento.createElement("Opinion");
	    	// Se agrega texto dentro de la etiqueta.
	    	opinion.appendChild(documento.createTextNode(actual.getOpinion()));
	    	// Se configura la etiqueta como hijo de auto.
	    	auto.appendChild(opinion);

	    }

	    // Se crean las fábricas para dar formato al archivo.
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(documento);
	    StreamResult result = new StreamResult(new File(nombreArchivo));

	    // Se asigna un DTD asociado al archivo XML.
	    try{
	    	transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Automoviles.dtd");
	    	// Permite indentar el archivo XML
	    	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    	transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	    	transformer.transform(source, result);
	    }catch(TransformerConfigurationException tce){
	    }catch(TransformerException te){}
    }
}
