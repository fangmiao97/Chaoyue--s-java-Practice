package DesignPatterns.FactoryPattern;

public class Client {
    public static void main(String[] args) {
        TV tv;
        TVFactory tvFactory;
        tvFactory = (TVFactory) XMLUtil.getBean();
        tv = tvFactory.produceTV();
        tv.play();
    }
}
