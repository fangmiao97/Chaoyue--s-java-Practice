package ThreadTest;

import java.util.concurrent.*;

/**
 * 30个任务，每10个任务累加一次结果的和
 *
 */
public class completionServiceTest {

    private static Object Task;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<Integer> integerExecutorCompletionService = new ExecutorCompletionService<>(executorService);

        for (int i = 0; i < 30; i++) {
            integerExecutorCompletionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 1;
                }
            });
        }

        int n = 0;
        while (n < 30) {
            int m = 0;
            int sum = 0;
            while (m < 10) {
                Future<Integer> take = integerExecutorCompletionService.take();
                sum += take.get();
                n++;
                m++;
            }
            System.out.println(n + " tasks sum = " + sum);
        }

        executorService.shutdown();
    }
}
