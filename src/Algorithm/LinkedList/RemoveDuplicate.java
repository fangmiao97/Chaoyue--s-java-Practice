package Algorithm.LinkedList;

import DesignPatterns.DecoratorPattern.ListNode;

import java.util.HashSet;

/**
 * 移除链表中重复的元素
 * 1 3 1 5 5 7
 * after 1 3 5 7
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(1);
        ListNode four =  new ListNode(5);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(7);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        System.out.println("原链表：");
        for (ListNode cur = one; cur != null; cur = cur.next) {
            System.out.print(cur.val+ " ");
        }
        System.out.println("");

//        ListNode res = removeDup1(one);
//        for (ListNode cur = res; cur != null; cur = cur.next) {
//            System.out.print(cur.val+ " ");
//        }
//        System.out.println("");

        ListNode res = removeDup1(one);
        for (ListNode cur = res; cur != null; cur = cur.next) {
            System.out.print(cur.val+ " ");
        }
        System.out.println("");

    }

    /**
     * 循环遍历链表，找到重复的元素删除
     * @param head
     * @return
     * 时间O(n^2)
     * 空间O(1)
     */
    public static ListNode removeDup1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode cur = null;
        for (cur = head; cur != null; cur = cur.next) {
            ListNode pre = cur;
            ListNode p = cur.next;
            while (p != null) {
                if (p.val == cur.val) {
                    ListNode next = p.next;
                    pre.next = next;
                    p = next;
                }else {
                    p = p.next;
                    pre = pre.next;
                }
            }
        }
        return head;
    }

    /**
     * 空间换时间，使用hashset存储已存在的键值
     * @param head
     * @return
     */
    public static ListNode removeDup2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        HashSet<Integer> seen = new HashSet<>();
        seen.add(head.val);
        ListNode cur = head.next;
        ListNode pre = head;
        for (; cur != null; cur = cur.next){
            if (seen.contains(cur.val)) {
                pre.next = cur.next;
            }else {
                seen.add(cur.val);
                pre = pre.next;
            }
        }
        return head;
    }
}
