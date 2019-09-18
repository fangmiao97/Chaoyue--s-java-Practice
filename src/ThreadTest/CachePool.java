package ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachePool {//缓存
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();//ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 100; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        es.shutdown();

    }
}
