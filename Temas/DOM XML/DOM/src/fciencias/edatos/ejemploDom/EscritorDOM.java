package fciencias.edatos.ejemploDom;

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
 * Ejemplo de escritura de XML usando DOM.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0, 2020
 * @since Estructuras de datos 2021-1
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
    public void escribe(String nombre, ArrayList<Cumpleanios> lista) throws 
    ParserConfigurationException, TransformerConfigurationException, TransformerException{
    	// Se construyen las fabricas que permiten la interacción con documentos XML.
        DocumentBuilderFactory fabricaDeConstructores = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructor = fabricaDeConstructores.newDocumentBuilder();
        Document documento = constructor.newDocument();

        // Creación de la raíz.
	    Element raiz = documento.createElement("Fechas");
	    // Se agrega la raíz al documento.
	    documento.appendChild(raiz);

	    // Se crean elementos. Cada uno corresponde a una etiqueta del XML.
	    Element elemento, fecha, mensaje;

	    // Se crea una instancia auxiliar del objeto que contiene la estructura.
	    Cumpleanios actual;

	    for(int i = 0; i<lista.size(); i++){
	    	// Se obtiene el elemento en la posición i se la lista.
	    	actual = lista.get(i);

	    	// Se crea una etiqueta para el objeto.
	    	elemento = documento.createElement("Cumple");
	    	// Se agrega la etiqueta como hijo de la raíz.
	    	raiz.appendChild(elemento);

	    	// Se agrega un atributo al atributo.
	    	Attr atributo = documento.createAttribute("nombre");
	    	atributo.setValue(actual.nombre);
	    	elemento.setAttributeNode(atributo);

	    	// Se crea una nueva etiqueta.
	    	fecha = documento.createElement("Fecha");
	    	// Se agrega la etiqueta como hijo de la etiqueta elemento.
	    	elemento.appendChild(fecha);
	    	// Se agregan atributos nuevos.
	    	Attr dia = documento.createAttribute("dia");
	    	dia.setValue(""+actual.dia);
	    	fecha.setAttributeNode(dia);
	    	Attr mes = documento.createAttribute("mes");
	    	mes.setValue(""+actual.mes);
	    	fecha.setAttributeNode(mes);
	    	Attr anio = documento.createAttribute("anio");
	    	anio.setValue(""+actual.anio);
	    	fecha.setAttributeNode(anio);

	    	// Se crea una nueva etiqueta.
	    	mensaje = documento.createElement("Mensaje");
	    	// Se agrega texto dentro de la etiqueta.
	    	mensaje.appendChild(documento.createTextNode(actual.daMensaje()));
	    	// Se configura la etiqueta como hijo de elemento.
	    	elemento.appendChild(mensaje);

	    }

	    // Se crean las fábricas para dar formato al archivo.
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(documento);
	    StreamResult result = new StreamResult(new File(nombre));

	    // Se asigna un DTD asociado al archivo XML.
	    try{
	    	transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "cumpleanios.dtd");
	    	// Permite indentar el archivo XML
	    	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    	transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	    	transformer.transform(source, result);
	    }catch(TransformerConfigurationException tce){
	    }catch(TransformerException te){}
    }
}
