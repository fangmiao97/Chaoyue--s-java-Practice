package Algorithm.BinaryTree;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/26 16:25
 * @Description：给定一棵二叉树，求各个路径的最大和，路径可以以任意结点作为起点和终点
 */
public class FindMaxSumRoad {
    /**
     * @Description: findMaxSumRoad后序遍历的基础上修改
     * @Param:  [root, max]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2019/12/26 16:35
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static int findMaxSumRoad(BTNode root, int max) {
        if (root == null) {
            return 0;
        } else {
            int leftSum = findMaxSumRoad(root.left, max);
            int rightSum = findMaxSumRoad(root.right, max);

            int allMax = root.data + leftSum + rightSum;
            int leftMax = root.data + leftSum;
            int rightMax = root.data + rightSum;
            int tmpMax = max(allMax, leftMax, rightMax);

            if (tmpMax > max) {
                max = tmpMax;
            }

            int subMax = leftSum > rightSum ? leftSum : rightSum;
            return root.data + subMax;
        }
    }

    private static int max(int a, int b, int c) {
        int max = a > b ? a : b;
        max = max > c ? max : c;
        return max;
    }

    public static void main(String[] args) {
        BTNode tree = BinaryTree.getDefaultTree();
        System.out.println(findMaxSumRoad(tree, Integer.MIN_VALUE));
    }
}
