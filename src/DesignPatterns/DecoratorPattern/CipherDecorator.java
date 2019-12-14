package DesignPatterns.DecoratorPattern;

/**
 * 抽象装饰类
 */
public class CipherDecorator implements Cipher {

    private Cipher cipher;

    //构造方法传入具体构件
    public CipherDecorator(Cipher cipher) {
        this.cipher = cipher;
    }

    public String encrypt(String s) {
        return cipher.encrypt(s);
    }
}
