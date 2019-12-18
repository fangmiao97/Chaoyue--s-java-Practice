package Review;

public class MoniterTest {

    private MoniterTest(){
        System.out.println("private constructor");
    }

    private static Object object = new Object();
    private static int number = 30;
    public static void main(String[] args) {

        synchronized (object) {
            number ++;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (number > 0) {
                    countDown();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (number > 0) {
                    countDown();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (number > 0) {
                    countDownSyn();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //加这两条语句相当于jvm隐式加锁，synchronized底层原理
    public static void countDown() {
        //monitorEnter
        UnsafeInstance.reflectGetUnsafe().monitorEnter(object);
        number--;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        //monitorExit
        UnsafeInstance.reflectGetUnsafe().monitorExit(object);
    }

    public synchronized static void countDownSyn() {
        number--;
        System.out.println(Thread.currentThread().getName() + ":" + number);
    }
}
