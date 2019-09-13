package review;

public class ThreadTest {



    public void go() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("FOO");
            }
        };
        Thread t = new Thread(run);
        t.start();
    }

    public static void main(String[] args) {
        new ThreadTest().go();
    }
}

