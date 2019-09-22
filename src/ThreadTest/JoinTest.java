package ThreadTest;

/**
 * join function
 * 让“主线程”等待被开启的“子线程”执行完之后，再继续执行
 * t.join()//使调用线程t在此之前执行完毕，若果之前没有start()是没有用的，跳过这个继续往下走
 * t.join(1000)//等待t线程执行1000ms
 *
 * 当主线程调用t1.join()方法时，主线程先获得了t1对象的锁，
 * 随后进入方法，
 * 调用了t1对象的wait()方法，使主线程进入了t1对象的等待池
 *
 *  join源码中，只会调用wait方法，并没有在结束时调用notify，
 *  这是因为线程在die的时候会自动调用自身的notifyAll方法，来释放所有的资源和锁
 */
public class JoinTest implements Runnable{

    public static int a = 0;

    @Override
    public void run() {
        System.out.println("run() is starting");
        for (int i = 0; i < 5; i++) {
            a++;
        }
        System.out.println("run() end");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new JoinTest());
        t.start();
        t.join();//main等待t执行完成，才会往下走
        System.out.println(a);//如果没有上面的join，打印出来的a可能就不是5
        System.out.println("main() end");
    }
}
