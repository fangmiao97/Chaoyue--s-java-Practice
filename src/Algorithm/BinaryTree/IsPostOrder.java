package Algorithm.BinaryTree;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/25 19:36
 * @Description：判断是否是后续遍历
 * 对于任意一个结点，它的左子树上所有结点的值都小于这个结点的值，
 * 它的右子树上所有结点的值都大于这个结点的值。
 * 根据这个特点及二元查找树后序遍历的特点可以看出，
 * 这个序列的最后一个元素一定是树的根结点（上图中的结点4），然后在数组中找到第一个大于根结点4的值5，
 * 那么结点5之前的序列（1,3,2）对应的结点一定位于结点4的左子树上，
 * 结点5（包含这个结点）后面的序列一定位于结点4的右子树上
 * （也就是说，结点5后面的所有值都应该大于或等于4）。
 * 对于结点4的左子树遍历的序列{1,3,2}，以及右子树的遍历序列{5,7,6}可以采用同样的方法来分析，
 * 因此，可以通过递归方法来实现。
 */
public class IsPostOrder {

    /**
     * @Description: 判断arr是否是二叉树后续遍历的结果
     * @Param:  [arr, statr, end]
     * @Return: boolean
     * @Author: FANG MIAO
     * @Date: 2019/12/25 19:37
     * @Time Complexity: O(N)
     * @Space ComplexityL O()
     */
    public static boolean isPostOrder(int[] arr, int start, int end) {
        if (arr == null) {
            return false;
        }
        //数组最后一个数一定是根节点
        int root = arr[end];
        int i,j;
        for (i = 0; i < end; i++) {
            if (arr[i] > root)
                break;
        }//找到左子树最后一点（左子树都比root小）

        for (j = i; j < end; j++) {
            if (arr[j] < root) {
                return false;//右边有大于root就是false
            }
        }

        boolean leftIsPostOrder = true;
        boolean rightIsPostOrder = true;
        if (i > start) {
            leftIsPostOrder = isPostOrder(arr, start, i - 1);
        }
        if (j < end) {
            rightIsPostOrder = isPostOrder(arr, i, end);
        }
        return leftIsPostOrder & rightIsPostOrder;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 7, 6, 4};
        System.out.println(isPostOrder(arr, 0, arr.length - 1));
    }
}
