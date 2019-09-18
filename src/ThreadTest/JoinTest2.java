package ThreadTest;


class RunnableImple implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread()+"Begin sleep");
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread()+"sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestThread2 extends Thread {
    Thread thread;

    public TestThread2(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        synchronized (thread) {
            System.out.println(Thread.currentThread()+"getObjectLock");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"releaseObjectLock");
        }
    }
}
public class JoinTest2 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread());
        Thread t = new Thread(new RunnableImple());
        new TestThread2(t).start();

        t.start();
        t.join();
        System.out.println(Thread.currentThread()+"join Finish");
    }

}
