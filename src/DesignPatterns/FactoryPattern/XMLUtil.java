package DesignPatterns.FactoryPattern;

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
    public static Object getBean() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc;
            doc = documentBuilder.parse(new File("D:\\MyProject\\javaPractice\\src\\DesignPatterns\\FactoryPattern\\config.xml"));

            NodeList nl = doc.getElementsByTagName("className");
            Node classNameNode = nl.item(0).getFirstChild();
            String className = classNameNode.getNodeValue();

            //注意这里要把包名写全！！！！！
            Class TV = Class.forName("DesignPatterns.FactoryPattern."+className);
            Object o = TV.newInstance();
            return o;
        } catch (ParserConfigurationException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        }
    }
}
