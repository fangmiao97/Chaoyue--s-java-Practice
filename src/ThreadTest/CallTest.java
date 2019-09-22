package ThreadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * callable一般搭配ExecutorService来使用
 */
public class CallTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = newFixedThreadPool(3);
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future f = es.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(2000);
                    return Thread.currentThread().getName();
                }
            });//callable要用这个
            list.add(f);
        }

        for (Future future : list) {
            String s = (String) future.get();
            System.out.println(s);
        }

        es.shutdown();

    }
}
