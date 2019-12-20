package Algorithm.LinkedList;

/**
 * 翻转链表
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode tmp = null;
        ListNode cur = head;
        for (int i = 1; i < 8; i++) {
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

        System.out.println("");
        ListNode rev2 = reverseList(rev);
        System.out.println("翻转链表：");
        for (cur = rev2; cur != null; cur = cur.next) {
            System.out.print(cur.val+ " ");
        }

        System.out.println("");
        ListNode rev3 = reverseList(rev2);
        System.out.println("翻转链表：");
        for (cur = rev3; cur != null; cur = cur.next) {
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

    /**
     * 迭代法
     * @param head
     * @return
     */
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 插入法
     * @param head
     * @return
     * O(N)
     */
    public static ListNode reverseListInsert(ListNode head) {
        if (head == null || head.next == null)
            return head;


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next.next = next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }


}
