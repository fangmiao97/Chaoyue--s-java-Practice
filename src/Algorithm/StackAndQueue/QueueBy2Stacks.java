package Algorithm.StackAndQueue;

import java.util.Stack;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/22 16:11
 * @Description：用2个栈模拟队列
 */
public class QueueBy2Stacks<T> {
    private Stack<T> A = new Stack<>();//入队的栈，入队的数据都到这个栈里面
    private Stack<T> B = new Stack<>();//出队的栈，这个栈由A栈pop得到，这样B的栈顶就是A的栈底
    //B为空，就将Apop过来，不为空，就取栈顶

    public void push(T item) {
        A.push(item);
    }

    public T pop() {
        if (B.empty()) {
            if (!A.empty()) {
                while (!A.empty()) {
                    B.push(A.pop());
                }
            }
            else {
                System.out.println("队列空");
                return null;
            }
        }
        return B.pop();
    }

    public static void main(String[] args) {
        QueueBy2Stacks<Integer> myQueue = new QueueBy2Stacks<>();
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(8);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

}
