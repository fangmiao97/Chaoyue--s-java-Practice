package Algorithm.LinkedList;

import DesignPatterns.DecoratorPattern.ListNode;

/**
 * 翻转链表
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode tmp = null;
        ListNode cur = head;
        for (int i = 0; i < 8; i++) {
            tmp = new ListNode(i);
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        System.out.println("原链表：");
        for (cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val+ " ");
        }
        System.out.println("");

        ListNode rev = reverseList(head);
        System.out.println("翻转链表：");
        for (cur = rev; cur != null; cur = cur.next) {
            System.out.print(cur.val+ " ");
        }

    }

    /**
     * 法一
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
