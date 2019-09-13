package DesignPatterns;

/**
 * 二次检查锁定
 * 比直接用synchronized效率更高
 * DoubleCheckLock
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;//添加volatile！！

    private SingletonDemo() {}

    public static SingletonDemo getInstance() {
        if(instance == null) {
            synchronized (SingletonDemo.class) {
                if(instance == null) {
                    instance = new SingletonDemo();//添加了volatile，保证对象初始化时不被优化指令重排序
                    //如果没有加volatile，可能被指令重排，这会使得初始化一半/未完成的instance被return，给外界使用，程序会崩溃
                }
            }
        }
        return instance;
    }
}
