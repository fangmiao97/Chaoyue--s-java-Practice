package Algorithm.BinaryTree;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/23 19:15
 * @Description：找和最大的子树
 */
public class MaxSumSubTree {

    /**
     * @Description: findMaxSumSubTree
     * @Param:  [root]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2019/12/23 19:24
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static int findMaxSumSubTree(BTNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;

        int lMax = findMaxSumSubTree(root.left);
        int rMax = findMaxSumSubTree(root.right);

        int sum = lMax + rMax + root.data;
        if (sum > max) {
            max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        BTNode defaultTree = BinaryTree.getDefaultTree();
        System.out.println(findMaxSumSubTree(defaultTree));
    }
}
