package Algorithm.BinaryTree;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/23 19:29
 * @Description：判断树相同
 */
public class SameTree {

    /**
     * @Description: isEqual
     * @Param:  [a, b]
     * @Return: boolean
     * @Author: FANG MIAO
     * @Date: 2019/12/25 16:38
     * @Time Complexity: O(n)
     * @Space ComplexityL O()
     */
    public static boolean isEqual(BTNode a, BTNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.data == b.data) {
            return isEqual(a.left, b.left) && isEqual(a.right, b.right);
        }
        return false;
    }

    public static void main(String[] args) {
        BTNode a = BinaryTree.getDefaultTree();
        BTNode b = BinaryTree.getDefaultTree();
        System.out.println(isEqual(a, b));
    }
}
