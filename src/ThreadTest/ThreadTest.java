package ThreadTest;

public class ThreadTest {

    public void go() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("FOO");
            }
        };
        Thread t = new Thread(run);
        t.start();
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        test test = new test();
        Thread thread = new Thread(test);//和普通方法一样，还是在main线程中执行
        thread.run();
        thread.start();//这里用start才新开一个线程
        new ThreadTest().go();
    }
}

class test implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("test.run running");
    }
}
