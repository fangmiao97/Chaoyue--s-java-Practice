package Algorithm.LinkedList;

/**
 * 题目描述：给定单链表1→2→3→4→5→6→7，k=3，
 * 那么旋转后的单链表变为5→6→7→1→2→3→4
 */
public class RotateLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < 9; i++) {
            ListNode tmp = new ListNode(i);
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }

        System.out.println("原链表：");
        for (cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }

        System.out.println("");
        ListNode res = rotateLinkedList(head, 3);
        System.out.println("结果链表：");
        for (cur = res; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }

    }


    /**
     * ①首先找到链表倒数第k+1个结点slow和尾结点fast；
     * ②把链表断开为两个子链表，其中后半部分子链表结点的个数为k；
     * ③使原链表的尾结点指向链表的第一个结点；
     * ④使链表的头结点指向原链表倒数第k个结点
     * @param head
     * @param k
     * @return
     * 时间复杂度为O（n）
     * 空间复杂度为O（1）
     */
    public static ListNode rotateLinkedList(ListNode head, int k) {
        ListNode slow, fast;
        slow = head;
        fast = head;

        int fastStep = k;
        while (fastStep > 0 && fast != null) {
            fast = fast.next;
            fastStep--;
        }

        if(fastStep > 0) {
            System.out.println("K值不符合要求");
            return null;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode postSlow = slow.next;

        slow.next = null;
        fast.next = head;

        return postSlow;
    }
}
