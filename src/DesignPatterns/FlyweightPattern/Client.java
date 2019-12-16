package DesignPatterns.FlyweightPattern;

/**
 * flyweight pattern 享元模式、轻量级模式
 * 结合简单工厂与单例模式一起实现
 * Sunny软件公司欲开发一个多功能文档编辑器，在文本文档中可以插入图片、动画、视频
 * 等多媒体资料，为了节约系统资源，相同的图片、动画和视频在同一个文档中只需保存
 * 一份，但是可以多次重复出现，而且它们每次出现时位置和大小均可不同。试使用享元
 * 模式设计该文档编辑器。
 * Flyweight 抽象享元类：InsertItem
 * ConcreteFlyweight 具体享元类：图片、动画、视频
 * 相同的图片，内部状态（intrinsic state）是一样的，外部状态（extrinsic state）是不一样的（位置大小）
 * FlyweightFactory 享元工厂类：创建管理InsertItem
 */
public class Client {
    public static void main(String[] args) {
        InsertItemFactory insertItemFactory;
        insertItemFactory = InsertItemFactory.getInstance();
        InsertItem pic1, pic2, video, gif, pic3;

        pic1 = insertItemFactory.getInsertItem("pic", "under armour");
        pic2 = insertItemFactory.getInsertItem("pic", "adidas");
        pic3 = insertItemFactory.getInsertItem("pic", "adidas");
        gif = insertItemFactory.getInsertItem("gif", "memes");
        video = insertItemFactory.getInsertItem("video", "formation-Beyonce");

        pic1.display(new ItemProperty("16px", 1));
        pic1.display(new ItemProperty("34px", 2));
        pic2.display(new ItemProperty("45px", 5));
        System.out.println("pic2 与 pic3 是否相同 " + (pic2 == pic3));
        pic3.display(new ItemProperty("55px", 4));

        gif.display(new ItemProperty("34px", 7));
        video.display(new ItemProperty("78px", 9));
    }
}
