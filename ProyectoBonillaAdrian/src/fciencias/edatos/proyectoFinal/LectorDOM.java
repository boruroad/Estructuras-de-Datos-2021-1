package fciencias.edatos.proyectoFinal;

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
 * Proyecto Final: Comunicaciones telefónicas
 * Estructura de Datos 2021-1.
 * Bonilla Ruiz Roberto Adrián 
 * Num. Cta. 31721903-8
 * La implementación a continuación incluye material brindado por:
 * Emmanuel Cruz Hernández 
 * @version 1.0
 */

public class LectorDOM {

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
    public GraficaMatriz<Estacion,Integer>  lee(String nameArchivo) throws ParserConfigurationException, SAXException, IOException, DOMException{

        ListaLigada<Object> listaEstaciones = new ListaLigada<>();
        ListaLigada<Cliente> listaClientes  = new ListaLigada<>();

        // Archivo que representa el xml
        File archivo = new File(nameArchivo+".xml");

        // Se crean las fabricas necesarias para generar un creador de documentos
        DocumentBuilderFactory fabricaDeConstructores = DocumentBuilderFactory.newInstance();
        DocumentBuilder        constructor            = fabricaDeConstructores.newDocumentBuilder();
        Document               documento              = constructor.parse(archivo);

        NodeList redes      = documento.getElementsByTagName("Red");
        NodeList estaciones = documento.getElementsByTagName("Estacion");
        NodeList clientes;
        NodeList enlaces    = documento.getElementsByTagName("Enlace");

        Node nodo,r1;

        // Se crean los elementos necesarios. Esto corresponde a las etiquetas.
        Element estacion,cliente, enlace,red;
        
        Estacion/**Elemento*/ eAux;
        String nombreE;
        int id;
    
        String nombreC;
        int telefono;

        r1 = redes.item(0);
        red = (Element) r1;
        int numE  = Integer.parseInt(red.getAttribute("numEstaciones"));
        int numEn = Integer.parseInt(red.getAttribute("numEnlaces"));

        //System.out.println("\nNúmero de Estaciones: " +numE+"\nNúmero de enlaces: "+numEn+"\n");

        GraficaMatriz<Estacion,Integer> grafica = new GraficaMatriz<>();           
        for(int i = 0; i<estaciones.getLength(); i++){
            eAux = new Estacion();

            // Se obtiene el nodo con el primer elemento
            nodo = estaciones.item(i);

            // Se convierte el nodo a un elemento.
            estacion = (Element) nodo;

            /* Se acceden a los valores de los atributos almacenados */
            nombreE  = estacion.getAttribute("nombreEstacion");
            id = Integer.parseInt(estacion.getAttribute("codigo"));

            eAux.setNombre(nombreE);
            eAux.setId(id);

            clientes = estacion.getElementsByTagName("Cliente");
            ListaLigada<Cliente> listaClientesAux = new ListaLigada<>();
            
            for (int j=0;j<clientes.getLength();j++){
                Cliente cAux = new Cliente();
                cliente = (Element) clientes.item(j);
                nombreC = cliente.getAttribute("nombreCliente");
                telefono = Integer.parseInt(cliente.getAttribute("telefono"));
                cAux.setNombre(nombreC);
                cAux.setTelefono(telefono);
                listaClientesAux.add(j,cAux);
            }
            eAux.setListaC(listaClientesAux);
            grafica.insertVertex(eAux);
        } 

        Integer e1,e2;        
        for (int k =0;k<enlaces.getLength();k++){
            enlace = (Element) enlaces.item(k);
            e1 = Integer.parseInt( enlace.getAttribute("primeraEstacion"));
            e2 = Integer.parseInt(enlace.getAttribute("segundaEstacion"));
            //System.out.println(e1+"-"+e2);

            grafica.addEdge(e1-1,e2-1);

        }
        //System.out.println("Tenemos: "+enlaces.getLength()+" enlaces");

        return grafica;
    }

}