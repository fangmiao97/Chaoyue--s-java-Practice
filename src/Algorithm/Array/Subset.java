package Algorithm.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/2 12:26
 * @Description：子集
 */
public class Subset {


    public static void FindSubSet(List<List<Integer>> res, List<Integer> temp,
                                  int[] arr, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            FindSubSet(res, temp, arr, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void showRes(List<List<Integer>> res) {
        for (List<Integer> l: res
             ) {
            for (Integer integer : l
            ) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    /**
     * @Description: arr中有重复元素
     * @Param:  [res, temp, arr, start]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 2020/1/4 23:02
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static void findSubSetWithDup(List<List<Integer>> res, List<Integer> temp,
                                         int[] arr, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {//排序过的数组，跳过重复
                continue;
            }
            temp.add(arr[i]);
            findSubSetWithDup(res, temp, arr, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<List<Integer>> res = new ArrayList<>();
        FindSubSet(res, new ArrayList<>(), arr, 0);
        showRes(res);
        System.out.println();

        int[] arr2 = {1, 2,2};
        List<List<Integer>> res2 = new ArrayList<>();
        findSubSetWithDup(res2, new ArrayList<>(), arr2, 0);
        showRes(res2);
    }
}
