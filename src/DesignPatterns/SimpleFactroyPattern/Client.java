package DesignPatterns.SimpleFactroyPattern;

//简单工厂模式的缺点：每次更换都需要修改工厂方法的参数
//也就是客户端代码需要重新编译
//解决方法引入配置文件，通过配置文件来修改需要创建的具体类型
//客户端中直接读取配置文件即可（不用修改了）
public class Client {
    public static void main(String[] args) {
        Product product;
        product = Factory.getProduct("A");
        product.methodSame();
        product.bussinessMethod();
    }
}
