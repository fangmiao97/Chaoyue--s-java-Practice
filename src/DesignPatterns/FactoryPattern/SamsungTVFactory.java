package DesignPatterns.FactoryPattern;

public class SamsungTVFactory implements TVFactory{

    @Override
    public TV produceTV() {
        System.out.println("SamSungTV Factory produce SamsungTV");
        return new SamsungTV();
    }
}
