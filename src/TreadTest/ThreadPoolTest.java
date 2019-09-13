package TreadTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor
                = new ThreadPoolExecutor(1, 3, 3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(3));

        poolExecutor.execute(new TestThread());
        poolExecutor.execute(new TestThread());
        poolExecutor.execute(new TestThread());
        poolExecutor.execute(new TestThread());
        poolExecutor.execute(new TestThread());
        poolExecutor.execute(new TestThread());

        poolExecutor.shutdown();

    }
}

class TestThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}