package Algorithm.StackAndQueue;

import java.util.Stack;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/22 15:02
 * @Description：栈排序，递归
 */
public class SortStack {
    /**
     * @Description: 递归将栈中最小元素移动到栈顶
     * @Param:  [stack]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 15:05
     * @Time Complexity: O(N)
     * @Space ComplexityL O()
     */
    public static void moveMinToTop(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }

        int top1 = stack.peek();
        stack.pop();
        if (!stack.empty()) {
            moveMinToTop(stack);//很重要！！！！！
            int top2 = stack.peek();
            if (top1 > top2) {//top1大于top2才交换
                stack.pop();
                stack.push(top1);
                stack.push(top2);
                return;
            }
        }
        stack.push(top1);
    }

    /**
     * @Description: sortStack
     * @Param:  [stack]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 15:13
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static void sortStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }

        moveMinToTop(stack);
        int top = stack.peek();
        stack.pop();

        sortStack(stack);//递归

        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(7);
        stack.push(2);
        stack.push(3);
        stack.push(78);
        stack.push(54);
        sortStack(stack);
        while (!stack.empty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }
}
