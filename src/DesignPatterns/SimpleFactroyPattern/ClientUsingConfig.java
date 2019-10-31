package DesignPatterns.SimpleFactroyPattern;

//使用配置文件的客户端
public class ClientUsingConfig {
    public static void main(String[] args) {
        Product product;
        String type = XMLUtil.getProductType();
        product = Factory.getProduct(type);
        product.bussinessMethod();
    }
}
