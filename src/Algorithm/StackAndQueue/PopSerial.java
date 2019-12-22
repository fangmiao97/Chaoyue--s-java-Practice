package Algorithm.StackAndQueue;

import java.util.Stack;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/22 15:28
 * @Description：判断可能出栈顺序
 */
public class PopSerial {
    public static void main(String[] args) {
        String push = "12345";//push顺序
        String pop = "32541";//要判断的pop顺序
        System.out.println(isPopSerial(push, pop));

    }

    /**
     * @Description: isPopSerial
     * @Param:  [stack]
     * @Return: boolean
     * @Author: FANG MIAO
     * @Date: 15:31
     * @Time Complexity: O(N)
     * @Space ComplexityL O(N)
     */
    public static boolean isPopSerial(String push, String pop) {
        if (push.length() != pop.length()) {
            return false;
        }

        int pushLen = push.length();
        int popLen = pop.length();

        int pushIndex = 0;
        int popIndex = 0;
        Stack<Character> stack = new Stack<>();
        while (pushIndex < pushLen) {
            //把push按顺序依次入栈，直到栈顶的元素等于pop序列的第一个元素
            stack.push(push.charAt(pushIndex));
            pushIndex++;
            //栈顶出栈，pop移到下一位再判断
            while (!stack.empty() && stack.peek() == pop.charAt(popIndex)) {
                stack.pop();
                popIndex++;
            }
        }
        //栈为空，pop序列都遍历完
        return stack.empty() && popIndex == popIndex;
    }
}
