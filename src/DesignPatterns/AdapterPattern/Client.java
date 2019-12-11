package DesignPatterns.AdapterPattern;

/**
 * 适配器模式
 * Client调用target中的方法
 * adapter适配adaptee中实现的方法，转换成target可用的
 */
public class Client {
    public static void main(String[] args) {
        DataOperation dataOperation = new CipherAdapter();
        System.out.println(dataOperation.encrypy(2, "fangmiao"));
    }
}
