package Review;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.*;

public class AtomicTest {
    private AtomicInteger atomicInteger = new AtomicInteger();
    private int i = 0;

    //原子++操作
    private void safeCount() {
        while (true) {
            int i = atomicInteger.get();
            boolean success = atomicInteger.compareAndSet(i, ++i);
            if (success)
                break;
        }
    }

    //不加锁的操作
    private void NormalCount() {
        i++;
    }

    public static void main(String[] args) {
        AtomicTest atomicTest = new AtomicTest();
        List<Thread> ts = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            ts.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        atomicTest.safeCount();
                        atomicTest.NormalCount();
                    }
                }
            }));
        }

        for (Thread t: ts) {
            t.start();
        }

        //等所有线程执行完
        for (Thread t: ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("线程安全safeCount操作结果：" + atomicTest.atomicInteger);
        System.out.println("不安全操作结果：" + atomicTest.i);
    }
}
