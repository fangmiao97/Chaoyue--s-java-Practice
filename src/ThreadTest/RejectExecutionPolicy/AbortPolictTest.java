package ThreadTest.RejectExecutionPolicy;

import java.util.concurrent.*;

public class AbortPolictTest {
    public static void main(String[] args) {
        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepActiveTime = 5;
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>(10);

        //rejectExecutionPolicy

        //1.直接抛出异常
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        //2.在调用execute方法的线程中执行 callerRunsPolicy
        RejectedExecutionHandler handler1 = new ThreadPoolExecutor.CallerRunsPolicy();

        //3.抛出queue中最老的未处理请求，再尝试execute，这样就有任务会没被处理
        RejectedExecutionHandler handler2 = new ThreadPoolExecutor.DiscardOldestPolicy();

        //4.直接拒绝，不处理
        RejectedExecutionHandler handler3 = new ThreadPoolExecutor.DiscardPolicy();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepActiveTime,
                TimeUnit.SECONDS,
                queue,
                handler3);

        for (int i = 0; i < 100; i++) {
            executor.execute(new test());
        }

        executor.shutdown();
    }
}

class test implements Runnable {

    @Override
    public void run() {
        System.out.println("test running method in "+Thread.currentThread().getName());
    }
}
