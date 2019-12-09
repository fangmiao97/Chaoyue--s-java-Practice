package DesignPatterns.Prototype.WithPrototypeManager;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 使用原型管理器，其提供各种原型的实例对象，使用映射保存各个原型
 */

//抽象原型
interface OfficialDocument extends Cloneable {
    public OfficialDocument clone();
    public void display();
}

//具体原型1
class Doc1 implements OfficialDocument {

    @Override
    public OfficialDocument clone() {
        Object doc = null;
        try {
            doc = super.clone();
            return (OfficialDocument) doc;
        } catch (CloneNotSupportedException e) {
            System.out.println("doc1 can not clone");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println("this is doc1");
    }
}

//具体原型2
class Doc2 implements OfficialDocument {

    @Override
    public OfficialDocument clone() {
        Object doc = null;
        try {
            doc = super.clone();
            return (OfficialDocument) doc;
        } catch (CloneNotSupportedException e) {
            System.out.println("doc2 can not clone");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println("this is doc2");
    }
}

//原型管理器（饿汗）
class PrototypeManager {
    private Hashtable<String, OfficialDocument> hashtable = new Hashtable();
    private static PrototypeManager pm = new PrototypeManager();

    private PrototypeManager() {
        hashtable.put("doc1", new Doc1());
        hashtable.put("doc2", new Doc2());
    }

    //增加新的doc原型
    public void addOfficialDoc(String name, OfficialDocument doc) {
        hashtable.put(name, doc);
    }

    //得到浅克隆的某具体原型对象
    public OfficialDocument getOfficialDocByName(String name) {
        return hashtable.get(name).clone();
    }

    public static PrototypeManager getPm() {
        return pm;
    }
}

//client
public class WithPrototypeManager {
    public static void main(String[] args) {
        PrototypeManager prototypeManager = PrototypeManager.getPm();
        OfficialDocument one, two, three, four;

        one = prototypeManager.getOfficialDocByName("doc1");
        one.display();
        two = prototypeManager.getOfficialDocByName("doc1");
        two.display();
        System.out.println(one == two);

        three = prototypeManager.getOfficialDocByName("doc2");
        three.display();
        four = prototypeManager.getOfficialDocByName("doc2");
        four.display();
        System.out.println(three == four);
    }
}
