package DesignPatterns.SimpleFactroyPattern;

//工厂方法，根据传入参数的不同，返回不同的实例
public class Factory {
    public static Product getProduct(String arg) {
        Product product = null;
        if (arg.equalsIgnoreCase("A")) {
            product = new ConcreteProductA();
        } else if (arg.equalsIgnoreCase("B")) {
            product = new ConcreteProductB();
        }
        return product;
    }
}
