package DesignPatterns.DecoratorPattern;

/**
 * 具体装饰类
 */
public class AdvancedCipher extends CipherDecorator {
    public AdvancedCipher(Cipher cipher) {
        super(cipher);
    }

    @Override
    public String encrypt(String s) {
        return mod(super.encrypt(s));
    }

    public String mod(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = (char) (s.charAt(i) % 6);
            sb.append(c);
        }
        return sb.toString();
    }
}
