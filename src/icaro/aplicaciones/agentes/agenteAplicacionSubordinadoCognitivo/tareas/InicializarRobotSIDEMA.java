package icaro.aplicaciones.agentes.agenteAplicacionSubordinadoCognitivo.tareas;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import icaro.aplicaciones.Rosace.utils.AccesoPropiedadesGlobalesRosace;
import icaro.aplicaciones.SIDEMA.informacion.Celda;
import icaro.aplicaciones.SIDEMA.informacion.Robot;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;

public class InicializarRobotSIDEMA extends TareaSincrona {

	@Override
	public void ejecutar(Object... params) {
		String miIdentAgte = this.getIdentAgente();
        
        //Lectura del fichero de robots. Aprovechamos para tener en memoria la configuracion de robots.
             
        String rutaFicheroRobotsTest = AccesoPropiedadesGlobalesRosace.getRutaFicheroRobotsTest();
        try {
        	File inputFile = new File(rutaFicheroRobotsTest);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("robot");
            boolean found = false;
            for (int i = 0; i < nList.getLength() && !found; i++) {
            	Node nNode = nList.item(i);
            	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            		Element eElement = (Element) nNode;
            		String id = eElement.getElementsByTagName("id").item(0).toString();
            		if (id.equals(miIdentAgte)) {
            			found = true;
	            		String type = eElement.getAttribute("type");
	            		int energy = Integer.parseInt(eElement.getElementsByTagName("energy").item(0).toString());
	            		Element celda = (Element)eElement.getElementsByTagName("celdaActual").item(0);
	            		int x = Integer.parseInt(celda.getElementsByTagName("x").item(0).toString());
	            		int y = Integer.parseInt(celda.getElementsByTagName("y").item(0).toString());
	            		Robot robot = new Robot(id, type, new Celda(x,y, true, false), energy);
	            		this.getEnvioHechos().insertarHecho(robot);
	            		System.out.println(robot.toString());
            		}
            	}
            }
            if (!found)
            	this.trazas.trazar(miIdentAgte, "No se ha encontrado el fichero de inicializacion de Estatus", InfoTraza.NivelTraza.error);
        } catch(Exception e) {
        	e.printStackTrace();
        }
		
	}

}
