package DesignPatterns.DecoratorPattern;

/**
 * 装饰模式 decorator pattern
 * Sunny软件公司欲开发了一个数据加密模块，可以对字符串进行加密。最简单的加密算法
 * 通过对字母进行移位来实现，同时还提供了稍复杂的逆向输出加密，还提供了更为高级
 * 的求模加密。用户先使用最简单的加密算法对字符串进行加密，如果觉得还不够可以对
 * 加密之后的结果使用其他加密算法进行二次加密，当然也可以进行第三次加密。试使用
 * 装饰模式设计该多重加密系统。
 *
 * component - 抽象构件 - 加密模块
 * concretecomponent - 具体构件 - 基本加密器（基本算法）
 * decorator - 抽象装饰器 - 加密算法装饰器
 * concretedecorator - 具体装饰器 - 复杂算法、高级算法
 */
public class Client {
    public static void main(String[] args) {
        String orgWord = "fangmiao";
        Cipher baseCipher, cipherWithReverse, cipherWithRevMod;
        String enWord;

        baseCipher = new BaseCipher();
        enWord = baseCipher.encrypt(orgWord);
        System.out.printf("base:");
        System.out.println(enWord);

        cipherWithReverse = new ComplexCipher(baseCipher);
        enWord = cipherWithReverse.encrypt(orgWord);
        System.out.printf("with reverse:");
        System.out.println(enWord);

        cipherWithRevMod = new AdvancedCipher(cipherWithReverse);
        enWord = cipherWithRevMod.encrypt(orgWord);
        System.out.printf("with mod:");
        System.out.println(enWord);
    }
}
