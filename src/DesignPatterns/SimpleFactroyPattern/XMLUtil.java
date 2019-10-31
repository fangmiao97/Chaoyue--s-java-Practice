package DesignPatterns.SimpleFactroyPattern;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class XMLUtil {

    public static String getProductType() {

        try {
            //创建文件对象
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc;
            doc = documentBuilder.parse(new File("D:\\MyProject\\javaPractice\\src\\DesignPatterns\\SimpleFactroyPattern\\config.xml"));

            //获取包含产品类型的文本节点
            NodeList nl = doc.getElementsByTagName("productType");
            Node classNode = nl.item(0).getFirstChild();
            String productType = classNode.getNodeValue().trim();
            return productType;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
