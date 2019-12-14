package DesignPatterns.DecoratorPattern;

/**
 * 具体装饰类
 * 提供其他的算法 装饰原加密构件
 */
public class ComplexCipher extends CipherDecorator {
    public ComplexCipher(Cipher cipher) {
        super(cipher);
    }

    @Override
    public String encrypt(String s) {
        return revese(super.encrypt(s));
    }

    //added behavior
    public String revese(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >=0 ;i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
