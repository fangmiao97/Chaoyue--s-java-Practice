package ThreadTest;

/**
 * join function
 * 让“主线程”等待被开启的“子线程”执行完之后，再继续执行
 * t.join()//使调用线程t在此之前执行完毕，若果之前没有start()是没有用的，跳过这个继续往下走
 * t.join(1000)//等待t线程执行1000ms
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
