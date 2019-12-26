package Algorithm.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/26 15:11
 * @Description：从树的根结点开始往下访问一直到叶子结点经过的所有结点形成一条路径。
 * 找出所有的这些路径，使其满足这条路径上所有结点数据的和等于给定的整数。
 */
public class FindSumRoad {
    /**
     * @Description: findSumRoad
     * @Param:  [root, sum, remain, lists, tmpList]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 2019/12/26 15:15
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static void findSumRoad(BTNode root, int sum, int remain, List<List<Integer>> lists,
                                   List<Integer> tmpList) {
        if (remain < 0 || root == null)
            return;
        else if (remain == 0) {
            lists.add(new ArrayList<>(tmpList));
        } else {
            tmpList.add(root.data);
            findSumRoad(root.left, sum, remain - root.data, lists, tmpList);
            findSumRoad(root.right, sum, remain - root.data, lists, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        BTNode tree = BinaryTree.getDefaultTree();
        List<List<Integer>> res = new ArrayList<>();
        findSumRoad(tree, 5,3, res, new ArrayList<>());
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
