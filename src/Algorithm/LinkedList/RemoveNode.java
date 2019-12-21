package Algorithm.LinkedList;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/21 15:02
 * @Description：假设给定链表1→2→3→4→5→6→7中指向第5个元素的指针，
 * 要求把结点5删掉，删除后链表变为1→2→3→4→6→7。
 * 注意无法获取到结点p的前驱结点，只给当前节点
 *
 * 解法：
 * 1）如果这个结点是链表的最后一个结点，那么无法删除这个结点。
 * 2）如果这个结点不是链表的最后一个结点，可以通过把其后继结点的数据复制到当前结点中，
 * 然后用删除后继结点的方法来实现。
 */
public class RemoveNode {
    public static void main(String[] args) {
        ListNode head = ListNode.getLinkedList();
        //随机找一个要删除的点，3
        ListNode rp = head.next.next;
        ListNode.showLinkedList(head);

        removeNode(rp);
        ListNode.showLinkedList(head);

        addNodeBefore(head, 56);
        ListNode.showLinkedList(head);

    }

    /**
     * @Description: 移除node节点，无法得到前驱节点
     * @Param:  [node]
     * @Return: boolean
     * @Author: FANG MIAO
     * @Date: 15:07
     * @Time Complexity: O(1)
     * @Space ComplexityL O(1)
     */
    public static boolean removeNode(ListNode node) {
        //如果是最后一个节点，则不成功
        if (node == null || node.next == null)
            return false;

        node.val = node.next.val;
        node.next = node.next.next;
        return true;
    }

    /**
     * @Description: 在给定node前添加节点
     * @Param:  [node]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 15:19
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static void addNodeBefore(ListNode node, int value) {
        //先在node后添加新节点，其与node值相同
        //再将node值替换成要添加的值
        ListNode post = new ListNode(node.val);
        post.next = node.next;
        node.next = post;
        node.val = value;
    }


}
