package Review.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static List<Integer> list = new ArrayList<>();
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            @Override
            public void run() {
                insert(Thread.currentThread());
            };
        }.start();

    }

    public static void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName() + "获得了锁");
            System.out.println("get hold count: " + lock.getHoldCount());
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
