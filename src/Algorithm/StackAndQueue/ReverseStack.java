package Algorithm.StackAndQueue;

import java.util.Stack;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/22 13:11
 * @Description：翻转栈，递归
 * 最容易想到的办法是，申请一个额外的队列，
 * 先把栈中的元素依次出栈放到队列里，然后把队列里的元素按照出队列顺序入栈，
 * 这样就可以实现栈的翻转，
 * 这种方法的缺点是需要申请额外的空间存储队列，因此，空间复杂度较高
 */
public class ReverseStack {

    /**
     * @Description: 将栈底元素移到栈顶，其他元素顺序不变
     * @Param:  [s]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 14:43
     * @Time Complexity: O(N)
     * @Space ComplexityL O()
     */
    public static void moveBottomToTop(Stack<Integer> s) {
        if (s.empty())
            return;

        int top1 = s.peek();//栈顶元素
        s.pop();
        if(!s.empty()) {
            //递归处理不包含栈顶的子栈
            moveBottomToTop(s);//现在子栈的栈顶就是子栈之前的栈底了
            int top2 = s.peek();
            s.pop();
            //交换子栈的栈顶（原栈底）和栈顶元素
            s.push(top1);
            s.push(top2);
        }
        else
            s.push(top1);
    }

    /**
     * @Description: 翻转栈
     * @Param:  [s]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 14:49
     * @Time Complexity: O(N^2)
     * @Space ComplexityL O()
     */
    public static void reverseStack(Stack<Integer> s) {
        if (s.empty())
            return;

        moveBottomToTop(s);
        int top = s.peek();
        s.pop();
        reverseStack(s);//递归处理子栈
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverseStack(stack);
        while (!stack.empty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }
}
