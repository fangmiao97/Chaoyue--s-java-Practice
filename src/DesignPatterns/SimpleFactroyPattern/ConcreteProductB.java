package DesignPatterns.SimpleFactroyPattern;

//实际的需要实例化的类
public class ConcreteProductB extends Product{
    @Override
    public void bussinessMethod() {
        System.out.println("this is concrete product B business method");
    }
}
