package Algorithm.LinkedList;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/20 23:46
 * @Description：K链表翻转是指把每K个相邻的结点看成一组进行翻转，
 * 如果剩余结点不足K个，则保持不变。
 * 假设给定链表1→2→3→4→5→6→7和一个数K，
 * 如果K的值为2，那么翻转后的链表为2→1→4→3→6→5→7。
 * 如果K的值为3，那么翻转后的链表为3→2→1→6→5→4→7。
 */
public class ReverseK {
    public static void main(String[] args) {
        ListNode head = ListNode.getLinkedList();
        System.out.println("原链表");
        ListNode.showLinkedList(head);
        System.out.println("k翻转后链表");
        ListNode.showLinkedList(reverseK(head, 3));
    }

    /**
     * @Description: ReverseK 每k个一组进行翻转，然后组合在一起
     * @Param:  [head, k]
     * @Return: Algorithm.LinkedList.ListNode
     * @Author: FANG MIAO
     * @Date: 0:04
     * @Time Complexity: O(n) 这种方法只需要对链表进行一次遍历
     * @Space ComplexityL O(1)
     */
    public static ListNode reverseK(ListNode head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //计数，计k个
        int i = 1;
        ListNode pre = dummy;
        ListNode begin = head;
        ListNode end = null;
        ListNode next = null;
        while (begin != null) {
            end = begin;
            //找到一组中的最后一个
            for (;i < k; i++) {
                if (end.next != null)
                    end = end.next;
                else
                    break;
            }
            next = end.next;
            end.next = null;
            pre.next =ReverseLinkedList.reverseListRecursive(begin);
            begin.next = next;//翻转之后begin已经是最后一个了
            pre = begin;
            begin = next;
            i = 1;
        }
        return dummy.next;
    }
}

