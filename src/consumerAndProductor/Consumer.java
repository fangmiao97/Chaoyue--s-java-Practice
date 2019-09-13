package consumerAndProductor;

public class Consumer extends Thread{

    private Pool pool;

    public Consumer(Pool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            Product product = this.pool.pop();
            System.out.println("消费了：" + product.getName());
        }
    }
}
