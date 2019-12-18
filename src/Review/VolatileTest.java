package Review;

/**
 * Volatile没有原子性
 * 自增操作在底层分为好几步，
 * volatile只是多加了最后一步（lock load……），所以中间的几部都是不安全的
 */
public class VolatileTest {
    private static volatile long _longVal = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long val = 0;
                while (val < 10000000l) {
                    _longVal++;
                    val++;
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long val = 0;
                while (val < 10000000l) {
                    _longVal++;
                    val++;
                }
            }
        });
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {

        }

        System.out.println(_longVal);
    }
}
