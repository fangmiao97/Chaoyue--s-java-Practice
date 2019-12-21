package Algorithm.StackAndQueue;

import java.util.ArrayList;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/21 18:47
 * @Description：栈
 */
public class MyArrayStack<T> {
    //数组的首元素当作栈底
    private ArrayList<T> arr;
    private int stackSize;

    public MyArrayStack() {
        arr = new ArrayList<T>();
        stackSize = 0;
    }

    boolean isEmpty() {
        return stackSize == 0;
    }

    int size() {
        return stackSize;
    }

    //返回栈顶元素
    T top() {
        if (isEmpty())
            return null;
        return arr.get(stackSize - 1);
    }

    //弹栈
    T pop() {
        if (stackSize > 0) {
            return arr.get(--stackSize);
        }
        else {
            System.out.println("栈已空");
            return null;
        }
    }

    void push(T item) {
        arr.add(item);
        stackSize++;
    }

    void showStack() {
        System.out.println("栈底到栈顶：");
        for (int i = 0; i < arr.size() - 1; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MyArrayStack<Integer> myArrayStack = new MyArrayStack<>();
        System.out.println("isEmpty: " + myArrayStack.isEmpty());
        myArrayStack.push(3);
        myArrayStack.push(5);
        myArrayStack.push(34);
        System.out.println(myArrayStack.pop());
        System.out.println(myArrayStack.top());
        myArrayStack.showStack();
        System.out.println(myArrayStack.size());
    }
}
