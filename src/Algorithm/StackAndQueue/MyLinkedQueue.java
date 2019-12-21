package Algorithm.StackAndQueue;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/21 20:11
 * @Description：链表实现队列
 */

public class MyLinkedQueue<T> {
    private Node<T> head;//头指针
    private Node<T> end;

    public MyLinkedQueue() {
        head = null;
        end = null;
    }

    boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    int size(){
        int size = 0;
        Node cur = head;
        while (cur != end.next) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    //入队
    void enQueue(T item) {
        Node p = new Node(item);
        p.next = null;
        if (head == null) {
            head = end = p;
        }else {
            end.next = p;
            end = p;
        }
    }

    //出队
    T deQueue() {
        if (head == null) {
            System.out.println("队列空");
            return null;
        }
        Node res = head;
        head = head.next;
        if (head == null)
            end = null;
        return (T) res.data;
    }

    //得队列首元素
    T getFront() {
        if (head == null) {
            System.out.println("队列空");
            return null;
        }
        return head.data;
    }

    T getEnd() {
        if (end == null) {
            System.out.println("队列空");
            return null;
        }
        return end.data;
    }

    void showQueue() {
        System.out.println("队列元素：");
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MyLinkedQueue<Integer> myLinkedQueue = new MyLinkedQueue<>();
        myLinkedQueue.enQueue(1);
        myLinkedQueue.enQueue(2);
        myLinkedQueue.enQueue(3);
        myLinkedQueue.enQueue(4);
        myLinkedQueue.showQueue();
        System.out.println(myLinkedQueue.getFront());
        System.out.println(myLinkedQueue.getEnd());
        System.out.println(myLinkedQueue.isEmpty());
        System.out.println(myLinkedQueue.deQueue());
        myLinkedQueue.showQueue();
    }
 }
