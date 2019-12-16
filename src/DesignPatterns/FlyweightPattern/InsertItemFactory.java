package DesignPatterns.FlyweightPattern;

import java.util.HashMap;

/**
 * 享元工厂类
 */
public class InsertItemFactory {

    private static InsertItemFactory instance = new InsertItemFactory();
    private static HashMap insertItems;

    //返回享元工厂唯一实例
    public static InsertItemFactory getInstance() {
        return instance;
    }

    private InsertItemFactory() {
        insertItems = new HashMap();
    }

    public InsertItem getInsertItem(String type, String content) {

        String key = type+content;
        if (insertItems.containsKey(key)) {
            return (InsertItem) insertItems.get(key);
        }else {
            if (type.equals("pic")) {
                Picture picture = new Picture(content);
                insertItems.put(key, picture);
                return picture;
            }
            else if (type.equals("gif")) {
                Gif gif = new Gif(content);
                insertItems.put(key, gif);
                return gif;
            }
            else if (type.equals("video")) {
                Video video = new Video(content);
                insertItems.put(key, video);
                return video;
            }else {
                System.out.println("no such type item can insert, please check the type");
                return null;
            }
        }
    }
}
