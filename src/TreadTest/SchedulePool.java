package TreadTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//定时
public class SchedulePool {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 100; i++) {
            ses.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }, 3, TimeUnit.SECONDS);
        }
        ses.shutdown();
    }
}
