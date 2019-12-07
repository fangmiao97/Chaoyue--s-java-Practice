package DesignPatterns.FactoryPattern;

public class HuaweiTVFactory implements TVFactory{

    @Override
    public TV produceTV() {
        System.out.println("HuaweiTV Factory produce HuaweiTV");
        return new HuaweiTV();
    }
}
