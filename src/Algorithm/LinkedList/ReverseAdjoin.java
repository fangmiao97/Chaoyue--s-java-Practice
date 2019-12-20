package Algorithm.LinkedList;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/20 22:15
 * @Description：
 * 把链表相邻元素翻转，如给定链表为1→2→3→4→5→6→7，
 * 则翻转后的链表变为2→1→4→3→6→5→7。
 */
public class ReverseAdjoin {
    public static void main(String[] args) {
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

        ListNode cur = null;
        System.out.println("原链表：");
        for (cur = one; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }

        ListNode res = reverseAdjoin(one);
        System.out.println("");
        System.out.println("结果链表：");
        for (cur = res; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
    }

    /**
     * @Description: ReverseAdjoin
     * @Param:  [head]
     * @Return: Algorithm.LinkedList.ListNode
     * @Author: FANG MIAO
     * @Date: 2019/12/20
     * @Time Complexity: O(N)
     * @Space ComplexityL O(1)
     */
    public static ListNode reverseAdjoin(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //当前交换对的第一个
        ListNode cur = head;
        //交换对前面的一个
        ListNode pre = dummy;
        //交换对的下一对第一个
        ListNode next = null;

        while (cur != null && cur.next != null) {//如果是奇数个节点
            // 最后一个单独出来就不会交换，因为cur.next == null
            next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;

            pre = cur;
            cur = next;
        }

        return dummy.next;
    }
}
