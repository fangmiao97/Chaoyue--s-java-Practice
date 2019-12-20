package Algorithm.LinkedList;

/**
 * 单项链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }
    
    /**
     * @Description: 返回模板链表 1 2 3 4 5 6 7
     * @Param:  []
     * @Return: Algorithm.LinkedList.ListNode
     * @Author: FANG MIAO
     * @Date: 2019/12/20
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static ListNode getLinkedList() {
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
        
        return one;
    }

    /**
     * @Description: 显示链表
     * @Param:  [head]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 2019/12/20
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static void showLinkedList(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val + " ");
        }
    }
}


