package DesignPatterns.FlyweightPattern;

public class Gif implements InsertItem {

    public String content;

    public Gif(String content) {
        this.content = content;
    }

    @Override
    public void display(ItemProperty property) {
        System.out.println("GIF " + content + " 显示大小 " + property.size + " 显示位置 " + property.location);
    }
}
