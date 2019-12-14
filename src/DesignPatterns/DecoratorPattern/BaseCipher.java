package DesignPatterns.DecoratorPattern;

/**
 * concrete component
 * 具体构件 一个基本的类，需要其他功能就要借助装饰类
 */
public class BaseCipher implements Cipher {
    @Override
    public String encrypt(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += 6;
                if (c > 'z')
                    c -= 26;
            }

            if (c >= 'A' && c <= 'Z') {
                c += 6;
                if(c > 'Z')
                    c -= 26;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
