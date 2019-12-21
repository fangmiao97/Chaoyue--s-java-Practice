package Algorithm.StackAndQueue;

import Algorithm.LinkedList.ListNode;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/21 19:18
 * @Description：链栈
 */

class Node<T> {
    T data;
    Node<T> next;

    Node (T data) {
        this.data = data;
    }

    public Node() {
        this.data = null;
    }
}

public class MyLinkedStack<T> {
    private Node<T> head;//head不存数据

    //栈顶在head后面
    public MyLinkedStack() {
        head = new Node<T>();
        head.data = null;
        head.next = null;
    }

    boolean isEmpty() {
        return head.next == null;
    }

    int size() {
        int size = 0;
        Node cur = head;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    void push(T item) {
        Node<T> p = new Node<>(item);
        p.next = head.next;
        head.next = p;
    }

    T pop() {
        Node<T> tmp = head.next;
        if (tmp != null) {
            head.next = tmp.next;
            return (T) tmp.data;
        }
        System.out.println("栈空");
        return null;
    }

    T top() {
        if (head.next != null) {
            return head.next.data;
        }
        System.out.println("栈空，无top");
        return null;
    }

    void showStack() {
        System.out.println("栈顶到栈底");
        for (Node cur = head.next; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MyLinkedStack<Integer> myLinkedStack = new MyLinkedStack<>();
        myLinkedStack.push(3);
        myLinkedStack.push(5);
        myLinkedStack.push(67);
        System.out.println(myLinkedStack.isEmpty());
        System.out.println(myLinkedStack.pop());
        System.out.println(myLinkedStack.size());
        System.out.println(myLinkedStack.top());
        myLinkedStack.showStack();
    }
}
