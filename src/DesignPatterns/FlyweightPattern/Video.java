package DesignPatterns.FlyweightPattern;

/**
 * 具体享元类 - 视频
 */
public class Video implements InsertItem {

    public String content;

    public Video(String content) {
        this.content = content;
    }

    @Override
    public void display(ItemProperty property) {
        System.out.println("视频 " + content + " 显示大小 " + property.size + " 显示位置 " + property.location);
    }
}
