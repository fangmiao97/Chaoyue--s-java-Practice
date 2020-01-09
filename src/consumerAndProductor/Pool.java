package consumerAndProductor;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品池
 */
public class Pool {

    //生产出来的商品列表
    private List<Product> productList;
    //产品池最大容量
    private int maxSize = 0;

    public Pool(int maxSize) {
        this.maxSize = maxSize;
        this.productList = new ArrayList<Product>();
    }


    /**
     * 生产者将生产出来的东西，放到产品池
     * @param product
     */
    public synchronized void push(Product product) {

        if(this.productList.size() == maxSize) {
            try {
                this.wait();//如果产品池满了，就挂起
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.productList.add(product);

        //通知其他人，有产品可以消费了
        this.notifyAll();
    }

    public synchronized Product pop() {

        if (this.productList.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Product product = this.productList.remove(0);

        this.notifyAll();

        return product;
    }

}
