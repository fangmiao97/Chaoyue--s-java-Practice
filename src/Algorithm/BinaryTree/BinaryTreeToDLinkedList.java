package Algorithm.BinaryTree;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/25 16:50
 * @Description：二叉树转换成双向链表
 */
public class BinaryTreeToDLinkedList {
    private static BTNode pHead = null;//双向链表头结点
    private static BTNode pEnd = null;//双向链表尾节点

    /**
     * @Description: 修改中序遍历
     * @Param:  [root]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 2019/12/25 16:56
     * @Time Complexity: O(N)
     * @Space ComplexityL O(1)
     */
    public static void transferToDLinkedList(BTNode root) {
        if (root == null) {
            return;
        }

        transferToDLinkedList(root.left);//处理左子树

        root.left = pEnd;//当前节点指向左子树链表的最后一个节点
        if (pEnd == null) {//双向链表为空 当前节点为头结点
            pHead = root;
        } else {
            pEnd.right = root;
        }
        pEnd = root;

        transferToDLinkedList(root.right);
    }

    public static void main(String[] args) {
        BTNode tree = BinaryTree.getDefaultTree();
        transferToDLinkedList(tree);
        for (BTNode cur = pHead; cur != null; cur = cur.right) {
            System.out.print(cur.data + " ");
        }
    }
}
