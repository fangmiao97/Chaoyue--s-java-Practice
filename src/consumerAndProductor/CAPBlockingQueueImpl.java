package consumerAndProductor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CAPBlockingQueueImpl {
    public static class Producer implements Runnable {

        //blocking queue of products
        private final BlockingQueue<Integer> blockingQueue;
        //signal of process
        private volatile boolean flag;

        private Random random;

        public Producer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
            flag = false;
            random = new Random();
        }

        @Override
        public void run() {
            while (!flag) {
                int info = random.nextInt(100);
                try {
                    blockingQueue.put(info);
                    System.out.println(Thread.currentThread().getName() + " produce " + info);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutDown() {
            flag = true;
        }
    }

    public static class Consumer implements Runnable {

        private final BlockingQueue<Integer> blockingQueue;
        private volatile boolean flag;

        public Consumer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
            flag = false;
        }

        @Override
        public void run() {
            while (!flag) {
                int info;
                try {
                    info = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + " consume " + info);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutDown() {
            flag = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(3);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                new Thread(producer, "producer"+i).start();
            }else
                new Thread(consumer, "consimer"+(i - 5)).start();
        }

        Thread.sleep(3000);
        producer.shutDown();
        consumer.shutDown();
        return;
    }
}
