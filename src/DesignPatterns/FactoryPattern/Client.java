package DesignPatterns.FactoryPattern;

public class Client {
    public static void main(String[] args) {
        TV tv;
        TVFactory tvFactory;
        tvFactory = (TVFactory) XMLUtil.getBean();//在这里得到具体的工厂
        tv = tvFactory.produceTV();
        tv.play();
    }
}
