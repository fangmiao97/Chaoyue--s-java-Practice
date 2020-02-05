package DesignPatterns.SingletonPattern;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/2/4 18:30
 * @Description：initial holder singleton
 */
public class InitialHolderSingleton {


    public InitialHolderSingleton() {
        System.out.println("Singleton constructor");
    }

    static class LazyHolder {
        static final InitialHolderSingleton instance = new InitialHolderSingleton();
    }

    public static InitialHolderSingleton getInstance() {
        return LazyHolder.instance;
    }

    public static void main(String[] args) {
        InitialHolderSingleton instance1 = InitialHolderSingleton.getInstance();
        InitialHolderSingleton instance2 = InitialHolderSingleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}
