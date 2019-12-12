package DesignPatterns.BridgePattern;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLUtil {
    public static Object getBean(String arg) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document d = documentBuilder.parse(new File("D:\\MyProject\\javaPractice\\src\\DesignPatterns\\BridgePattern\\config.xml"));

        NodeList nl = null;
        Node classNode = null;
        String cName = null;
        nl = d.getElementsByTagName("className");

        if (arg.equals("database")) {
            classNode = nl.item(0).getFirstChild();
        }else if (arg.equals("format")){
            classNode = nl.item(1).getFirstChild();
        }

        cName = classNode.getNodeValue();
        Class c = Class.forName(cName);
        Object obj = c.newInstance();
        return obj;
    }
}
