package Algorithm.BinaryTree;

import java.util.Stack;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/26 13:44
 * @Description：对于一棵给定的排序二叉树，求两个结点的共同父结点
 */
public class FindParentNode {
    /**
     * @Description: 从root得到node的节点
     * @Param:  [root, node, stack]
     * @Return: boolean
     * @Author: FANG MIAO
     * @Date: 2019/12/26 13:53
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    private static boolean getPathFromRoot(BTNode root, BTNode node, Stack<BTNode> stack) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            stack.push(root);//如果当前节点是node就push进路径stack
            return true;
        }
        //如果左右子树里面也有node的话，当前节点也是node的parent
        if (getPathFromRoot(root.left, node, stack) || getPathFromRoot(root.right, node, stack)) {
            stack.push(root);
            return true;
        }
        return false;
    }

    /**
     * @Description: findParentNode
     * @Param:  [root, node]
     * @Return: Algorithm.BinaryTree.BTNode
     * @Author: FANG MIAO
     * @Date: 2019/12/26 13:58
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static BTNode findParentNode(BTNode root, BTNode a, BTNode b) {
        Stack<BTNode> ap = new Stack<>();
        Stack<BTNode> bp = new Stack<>();

        getPathFromRoot(root, a, ap);
        getPathFromRoot(root, b, bp);

        BTNode commonParent = null;

        while (ap.peek() == bp.peek()) {
            commonParent = ap.peek();
            ap.pop();
            bp.pop();
        }

        return commonParent;
    }

    /**
     * @Description: 查找结点node1 与结点node2的最近共同父结点可以转换为找到一个结点node，
     * 使得node1与node2分别位于结点node的左子树或右子树中。(后序遍历）
     * @Param:  [root, a, btNode]
     * @Return: Algorithm.BinaryTree.BTNode
     * @Author: FANG MIAO
     * @Date: 2019/12/26 14:32
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static BTNode findParentNodeWithPostOrder(BTNode root, BTNode a, BTNode b) {
        if (root == null || a == root || b == root) {
            return root;
        }
        BTNode left = findParentNodeWithPostOrder(root.left, a, b);
        BTNode right = findParentNodeWithPostOrder(root.right, a, b);
        if (left == null) {//左子树没有a b父节点
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;//左右子树都有返回值 root为父节点
        }
    }

    public static void main(String[] args) {
        BTNode tree = BinaryTree.getDefaultTree();
        BTNode a = tree.right.left.left;
        BTNode b = tree.right.right;
        System.out.println(findParentNode(tree, a, b).data);
        System.out.println(findParentNodeWithPostOrder(tree, a, b).data);
    }
}
