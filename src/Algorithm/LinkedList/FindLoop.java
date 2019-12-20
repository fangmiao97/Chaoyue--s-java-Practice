package Algorithm.LinkedList;

/**
 * 如果链表存在环，那么如何找出环的入口点？
 * 从链表头与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇的第一点为环入口点
 */
public class FindLoop {
    public static void main(String[] args) {
        //1→2→3→4→5→6→7→3（3实际代表链表第三个结点）
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = three;

        System.out.println(findLoopNode(one).val);
    }

    /**
     * 判断是否有环，有的话返回slow和fast的相遇点
     * @param head
     * @return
     */
    public static ListNode isLoop(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)//相遇就是有环
                return slow;
        }
        return null;
    }

    /**
     * 找环点
     * 从链表头与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇的第一点为环入口点
     * @param head
     * @return
     */
    public static ListNode findLoopNode(ListNode head) {
        ListNode first = head;
        ListNode meet = isLoop(head);

        while (first != meet) {
            first = first.next;
            meet = meet.next;
        }

        return first;
    }
}

