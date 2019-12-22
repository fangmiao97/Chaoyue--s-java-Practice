package Algorithm.StackAndQueue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/22 18:52
 * @Description：LRU
 */
public class LRU {
    private int cacheSize;
    private ArrayDeque<Integer> queue = new ArrayDeque<>();
    private HashSet<Integer> hashSet = new HashSet<>();

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    //判断队列是否已满
    private boolean isQueueFull() {
        return queue.size() == cacheSize;
    }

    //将pageNum的内容加入缓存（queue和HashSet）
    private void enCache(int pageNum) {
        //缓存满了，把最后一个删掉
        if (isQueueFull()) {
            hashSet.remove(queue.getLast());
            queue.pollLast();
        }
        queue.addFirst(pageNum);
        hashSet.add(pageNum);
    }

    //访问pageNum，即更新其在缓存中的位置
    //不在缓存中，就添加到缓存中
    public void accessPage(int pageNum) {
        //不在缓存中
        if (!hashSet.contains(pageNum)) {
            enCache(pageNum);
        }
        else {
            queue.remove(pageNum);
            queue.addFirst(pageNum);
        }
    }

    public void printQueue() {
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.enCache(3);
        lru.enCache(5);
        lru.enCache(6);
        System.out.println(lru.isQueueFull());
        lru.accessPage(3);
        lru.printQueue();
        lru.accessPage(8);
        System.out.println(lru.isQueueFull());
        lru.printQueue();
    }
}
