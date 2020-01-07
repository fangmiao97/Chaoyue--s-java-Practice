package ThreadTest;


import java.util.concurrent.*;

/**
 * Future提供的三个功能（对于具体的Runnable或Callable任务的执行）：
 * 判断任务是否完成；
 * 能够中断任务；
 * 能够获取任务执行结果
 * Future是接口，FutureTask是其实现类
 */
public class FutureTaskTEst {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTask callableTask = new CallableTask();
        //方式一，结合ExecutorService
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<Integer> submitTask = executorService.submit(callableTask);
//        executorService.shutdown();

        //方式二
        FutureTask<Integer> submitTask = new FutureTask<>(callableTask);
        Thread thread = new Thread(submitTask, "submitTask(FutureTask)");//注意这一句
        thread.start();

        System.out.println(Thread.currentThread().getName());
        System.out.println("main is working...");

        while (!submitTask.isDone()){
//            System.out.println("submitTask is not done");
        }

        System.out.println(submitTask.isDone());

        System.out.println("submitTask is done and result is " + submitTask.get());
    }
}

class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" is working...");
        Thread.sleep(1000);
        int sum = 0;
        for (int i = 0; i < 2019; i++) {
            sum++;
        }
        return sum;
    }
}
