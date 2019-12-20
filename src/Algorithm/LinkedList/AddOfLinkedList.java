package Algorithm.LinkedList;

import DesignPatterns.DecoratorPattern.ListNode;

/**
 * 计算链表相加值
 * 给定两个单链表，链表的每个结点代表一位数，计算两个数的和。
 * 例如，输入链表（3→1→5）和链表（5→9→2），
 * 输出：8→0→8，即513+295=808，注意个位数在链表头
 */
public class AddOfLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(5);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(9);
        ListNode six = new ListNode(2);
        ListNode seven = new ListNode(9);

        //3→1→5
        one.next = two;
        two.next = three;

        //5→9→2
        four.next = five;
        five.next = six;
        six.next = seven;

        System.out.println(add(one, four));

        System.out.println(addInLinkedList(one, four));
    }

    /**
     * 方法一 将链表转成数值
     * 问题：数字长度问题
     * @param a
     * @param b
     * @return
     */
    public static int add(ListNode a, ListNode b) {
        int av = 0;
        int bv = 0;

        int base = 1;
        while (a != null) {
            av += a.val * base;
            base *= 10;
            a = a.next;
        }

        base = 1;
        while (b != null) {
            bv += b.val * base;
            base *= 10;
            b = b.next;
        }

        return av + bv;

    }

    public static int addInLinkedList(ListNode a, ListNode b) {
        int res = 0;
        int carry = 0;
        int tmp = 0;
        int base = 1;
        while (a != null && b != null) {
            tmp = a.val + b.val + carry;
            carry = tmp / 10;
            tmp %= 10;
            res += tmp * base;
            a = a.next;
            b = b.next;
            base *= 10;
        }

        while (a != null) {
            tmp = a.val + carry;
            carry = tmp / 10;
            tmp %= 10;
            res += tmp * base;
            a = a.next;
            base *= 10;
        }

        while (b != null) {
            tmp = b.val + carry;
            carry = tmp / 10;
            tmp %= 10;
            res += tmp * base;
            b = b.next;
            base *= 10;
        }

        return res;
    }
}
