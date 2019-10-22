package ThreadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 运行多个任务并处理所有结果
 */
public class ExeInvokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<task> tasks = new ArrayList<task>();

        for (int i = 0; i < 15; i++) {
            tasks.add(new task());
        }

        List<Future<Integer>> futures = executorService.invokeAll(tasks);

        executorService.shutdown();

        int sum = 0;
        for (Future<Integer> future: futures) {
            sum += future.get();
        }

        System.out.println("Sum of tasks result is " + sum);
    }
}

class task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1;
    }
}
