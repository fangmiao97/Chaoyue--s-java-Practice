package DesignPatterns.FlyweightPattern;

/**
 * 抽象享元类
 */
public interface  InsertItem {

    //内部状态
    public String itemContent = null;

    //传入外部状态
    public void display(ItemProperty property);

}
