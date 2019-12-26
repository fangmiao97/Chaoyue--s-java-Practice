package Algorithm.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/23 16:37
 * @Description：层序遍历
 */
public class LayerPrint {
    /**
     * @Description: 层序遍历
     * @Param:  [root]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 2019/12/23 18:24
     * @Time Complexity: O(N)
     * @Space ComplexityL O(N)
     */
    public static void printTreeLayer(BTNode root) {
        if (root == null) {
            return;
        }
        BTNode p;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            p = queue.poll();
            System.out.print(p.data + " ");
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }
    }

    /**
     * @Description: 打印第level层
     * @Param:  [root, level]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2019/12/23 18:56
     * @Time Complexity: O()
     * @Space ComplexityL O(1)
     */
    public static int printAtLevel(BTNode root, int level) {
        if (root == null || level < 0) {
            return 0;
        } else if (level == 0) {
            System.out.print(root.data + " ");
            return 1;
        }
        else//转化成打印子树的level-1层
            return printAtLevel(root.left, level - 1) + printAtLevel(root.right, level - 1);
    }

    public static void main(String[] args) {
        BTNode defaultTree = BinaryTree.getDefaultTree();
        printTreeLayer(defaultTree);

        System.out.println();
        printAtLevel(defaultTree, 0);
        System.out.println();
        printAtLevel(defaultTree, 3);
    }
}
