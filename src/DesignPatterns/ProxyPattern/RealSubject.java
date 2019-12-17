package DesignPatterns.ProxyPattern;

public class RealSubject implements AbstrctSubject {
    @Override
    public void request() {
        System.out.println("Real Subject Request!!");
    }
}
