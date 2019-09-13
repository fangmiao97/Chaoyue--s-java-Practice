package consumerAndProductor;

public class Productor extends Thread{

    private Pool pool;

    public Productor(Pool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            String name = (int) (Math.random() * 100) + "号产品";
            Product product = new Product(name);
            System.out.println("生产了一件产品：" + name);
            this.pool.push(product);
        }
    }
}
