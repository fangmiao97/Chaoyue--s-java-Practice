package DesignPatterns.ProxyPattern;

public class RealSubjectB implements AbstrctSubject {
    @Override
    public void request() {
        System.out.println("Real Subject BBBB");
    }
}
