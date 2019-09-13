package TreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//单例
public class SinglePool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
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
