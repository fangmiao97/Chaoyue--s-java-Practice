package DesignPatterns.BridgePattern;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * 桥接模式 - bridge pattern
 * Sunny软件公司欲开发一个数据转换工具，可以将数据库中的数据转换成多种文件格式，
 * 例如txt、xml、pdf等格式，同时该工具需要支持多种不同的数据库。试使用桥接模式对
 * 其进行设计。
 *
 * abstraction - database
 * refinedAbstraction - MysqlData/MongoDBData
 * Implmentor - format
 * concreteImp - txt/xml/pdf
 */
public class Client {
    public static void main(String[] args) throws SAXException, IllegalAccessException, IOException, InstantiationException, ParserConfigurationException, ClassNotFoundException {
        DatabaseData databaseData;
        FormatImp formatImp;
        databaseData = (DatabaseData) XMLUtil.getBean("database");
        formatImp = (FormatImp) XMLUtil.getBean("format");

        databaseData.setFormatImp(formatImp);
        databaseData.parseDataInDB(" merry christmas ");
    }
}
