package review;

import com.sun.org.apache.xerces.internal.util.SymbolHash;

public class SynchronizedTest {
    public synchronized void method1() throws InterruptedException {
        System.out.println("Method 1 started");
        System.out.println("Method 1 executing");
        Thread.sleep(3000);
        System.out.println("Method 1 ended");
    }

    public synchronized void method2() throws InterruptedException {
        System.out.println("Method 2 started");
        System.out.println("Method 2 executing");
        Thread.sleep(3000);
        System.out.println("Method 2 ended");
    }

    //静态方法
    public static synchronized void method3() throws InterruptedException {
        System.out.println("static Method 3 started");
        System.out.println("static Method 3 executing");
        Thread.sleep(3000);
        System.out.println("static Method 3 ended");
    }

    public static synchronized void method4() throws InterruptedException {
        System.out.println("static Method 4 started");
        System.out.println("static Method 4 executing");
        Thread.sleep(3000);
        System.out.println("static Method 4 ended");
    }


    public static void main(String[] args) {
        final SynchronizedTest synchronizedTest = new SynchronizedTest();

        new Thread(new Runnable() {//普通方法锁的是当前实例对象，因为method1和2锁的是同一个对象，
            //也就是调用他们的对象实例synchronizedTest，所以他两的执行是有序的
            @Override
            public void run() {
                try {
                    synchronizedTest.method1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizedTest.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //class数据存在永久代
        System.out.println("------------------静态方法 锁是当前类的class对象------------");
        final SynchronizedTest test = new SynchronizedTest();
        final SynchronizedTest test2 = new SynchronizedTest();
        //虽然method3和4被不同的对象实例调用，但是因为他两是静态方法，所以其实他们锁住的是当前类的class对象
        //Class对象是JVM生成用来保存对象的类的信息的
        //也就是他两锁的是相同的，所以3和4执行是有序的

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.method3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test2.method4();//所以正常情况下，调用static synchronized方法就直接调用就可以了，不用创建实例，再调用
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
