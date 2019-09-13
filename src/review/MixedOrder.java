package review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 指令重排的影响
 * 原本我想要read i = 1；但是可能出现i == 0/ i == 555
 *
 * 原因指令重排序使得执行顺序可能变成
 * thread writer：
 * flag = true
 * a = 1
 *
 * thread read:
 * flag = true;
 * a = 0;
 * i = a = 0;
 *
 * 解决，使用volatile-->变量操作的原子性（禁止指令重排序）， synchronized方法执行的原子性
 */
public class MixedOrder {

    public static int a = 0;
    public static boolean flag = false;

    public static void writer() {
        a = 1;
        flag = true;
    }

    public static int read() {
        int i = 555;
        if (flag) {
            i = a;
        }
        return i;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("write..");
                writer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("read...");
                System.out.println(read());
            }
        }).start();
    }
}
