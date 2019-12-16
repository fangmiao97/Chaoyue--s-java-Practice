package DesignPatterns.FlyweightPattern;

/**
 * 具体享元类 图片
 */
public class Picture implements InsertItem {

    public String content;

    public Picture(String content) {
        this.content = content;
    }

    @Override
    public void display(ItemProperty property) {
        System.out.println("图片 " + content + " 显示大小 " + property.size + " 显示位置 " + property.location);
    }
}
