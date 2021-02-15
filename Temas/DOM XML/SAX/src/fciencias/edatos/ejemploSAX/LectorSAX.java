package fciencias.edatos.ejemploSAX;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.IOException;

/**
 * Ejemplo de lectura de XML usando SAX.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 2020
 * @since Estructuras de datos 2021-1
 */
public class LectorSAX extends DefaultHandler{

	/** Recuerda si se está parseando la etiqueta <i>Libro</i> */
	boolean parseandoLibro;

	/** Recuerda el numero de un seccion. */
	int noSeccion;

	@Override
	public void startElement(String uri, String nombreLocal,
    	String nombreEtiqueta, Attributes attrs){

        // Caso de etiqueta Biblioteca
		if(nombreEtiqueta.equalsIgnoreCase("Biblioteca")){

            // Aún faltan los libros, por lo que no es posible realizar el parse.
			parseandoLibro = false;
			/* La etiqueta Biblioteca es la raíz, por lo que sólo 
            * se define el inicio de la lectura del archivo xml. */
            System.out.println("Los libros de la biblioteca son: ");

            // Caso de la etiqueta Libro
		} else if(nombreEtiqueta.equalsIgnoreCase("Libro")){
			
            // Aún faltan las secciones, por lo que no es posible realizar el parse.
            parseandoLibro = false;

			/* Se acceden a los valores de los atributos almacenados en 
            * la etiqueta perteneciente a un libro. */
            System.out.println("Libro: "+attrs.getValue("titulo")+
            	"\nAutor: "+attrs.getValue("autor"));

            // No todos los libros cuentan con tomo. En caso de tener se imprime.
            String tomo = attrs.getValue("tomo");
            if(tomo != null){
            	System.out.println("Tomo: "+tomo);
            }
            // No todos los libros cuentan con anio. En caso de tener se imprime.
            String anio = attrs.getValue("anio");
            if(anio != null){
            	System.out.println("Anio: "+anio);
            }

            // Caso de la etiqueta Seccion
		} else if (nombreEtiqueta.equalsIgnoreCase("Seccion")) {
			
            // Ya es posible hacer el parse, porque ya se tienen todos los elementos.
            parseandoLibro = true;

            // Se guarda el numero de la seccion en la variable.
			noSeccion = Integer.parseInt(attrs.getValue("numero"));
		}
	}

	@Override
	public void characters(char texto[], int inicio, int longitud)
    	throws SAXException {
    	
        /* Ya que se tienen todos los elementos de un libro. Se obtiene
        * la información de cada sección. */
        if(parseandoLibro){
    		System.out.println("    - Sección "+noSeccion
    			+": "+new String(texto, inicio, longitud));
    		parseandoLibro = false;
    	}
    }

    @Override
    public void endElement(String uri, String nombreLocal,
    	String nombreEtiqueta) throws SAXException {

        // Se define el final de las etiquetas especificadas.
    	if(nombreEtiqueta.equalsIgnoreCase("Libro")){
    		System.out.println("Fin de libro.\n");
    	} else if(nombreEtiqueta.equalsIgnoreCase("Biblioteca")){
    		System.out.println("Fin de biblioteca");
    	}
    }

    /**
    * Realiza el parse del archivo xml.
    * @param nombre el nombre del archivo.
    * @throws ParserConfigurationException si hay algún problema al
    * instanciar el parser.
    * @throws SAXException si ocurre un problema con la lectura del archivo.
    * @throws IOException si ocurre un problema al abrir el archivo
    * o en la busqueda de este.
    */
    public void parse(String nombre) throws ParserConfigurationException, SAXException,
    	IOException{

        // Se construyen las fábricas y se realiza el parse.
    	SAXParserFactory fabricaSAX = SAXParserFactory.newInstance();
    	SAXParser parserSAX = fabricaSAX.newSAXParser();
    	parserSAX.parse(nombre, this);
    }

    public static void main(String[] args) throws ParserConfigurationException,
    	SAXException, IOException {
    	LectorSAX lector = new LectorSAX();
        lector.parse("biblioteca.xml");
    }

}
