package Algorithm.BinaryTree;

import java.util.Stack;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/23 13:36
 * @Description：二叉树
 */

class BTNode {
    int data;
    BTNode left, right;
}

public class BinaryTree {

    /**
     * @Description: 有序数组转换成二叉树
     * @Param:  [arr, start, end]
     * @Return: Algorithm.BinaryTree.BTNode
     * @Author: FANG MIAO
     * @Date: 13:42
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static BTNode arrayToTree(int[] arr, int start, int end) {
        BTNode root = null;
        if (end >= start) {
            root = new BTNode();
            int mid = (start + end + 1) / 2;
            //树的根节点为数组中间元素
            root.data = arr[mid];
            //递归构造左右子树
            root.left = arrayToTree(arr, start, mid - 1);
            root.right = arrayToTree(arr, mid + 1, end);
        }
        else {
            root = null;
        }
        return root;
    }

    /**
     * @Description: printTreeMidOrder中序遍历
     * @Param:  [root]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 13:46
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static void printTreeMidOrder(BTNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            printTreeMidOrder(root.left);
        }

        System.out.print(root.data + " ");

        if (root.right != null) {
            printTreeMidOrder(root.right);
        }
    }

    /**
     * @Description: 中序遍历 非递归 使用栈Stack
     * @Param:  [root]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 14:08
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static void printTreeMidOrderNonRecur(BTNode root) {
        Stack<BTNode> treeNodeStack = new Stack<>();
        BTNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }

    /**
     * @Description: 后续非递归
     * @Param:  [root]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 2019/12/23 14:36
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
//    public static void printPostOrderNonRecur(BTNode root) {
//        BTNode lastVisit = null;
//        Stack<BTNode> treeNodesStack = new Stack<>();
//        BTNode p = root;
//        while (p != null || !treeNodesStack.isEmpty()) {
//            if (p != null) {
//                treeNodesStack.push(p);
//                p = p.left;
//            } else {
//                p = treeNodesStack.peek();
//                if (p != null || p.right == lastVisit) {
//                    treeNodesStack.pop();
//                    System.out.print(p.data + " ");
//                    lastVisit = p;
//                    p = null;
//                    continue;
//                }
//                p = p.right;
//            }
//        }
//    }
    
    /**
     * @Description: 返回一个二叉树
     * @Param:  []
     * @Return: Algorithm.BinaryTree.BTNode
     * @Author: FANG MIAO
     * @Date: 2019/12/23 18:26
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static BTNode getDefaultTree() {
        int arr[] = {1, 2, -3, 4, 5, -6, 7, 8, 9,-10};
        BTNode root = arrayToTree(arr, 0, arr.length - 1);
        return root;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("原数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("中序遍历二叉树:");
        BTNode btroot = arrayToTree(arr, 0, arr.length - 1);
        printTreeMidOrder(btroot);
        System.out.println();

        System.out.println("中序非递归遍历");
        printTreeMidOrderNonRecur(btroot);
        System.out.println();

        printTreeMidOrder(getDefaultTree());

    }


}
