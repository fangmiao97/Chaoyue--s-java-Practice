package review;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private List<Integer> list = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        final LockTest test = new LockTest();

        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

    }

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName() + "获得了锁");
            for (int i = 0; i < 5000; i++) {
                list.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }
}
