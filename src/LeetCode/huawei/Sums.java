package LeetCode.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/13 15:12
 * @Description：3Sum
 */
public class Sums {

    /**
     * @Description: sum
     * @Param:  [arr]
     * @Return: java.util.ArrayList<java.util.List<java.lang.Integer>>
     * @Author: FANG MIAO
     * @Date: 2020/1/13 15:13
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static ArrayList<List<Integer>> sum(int[] arr, int sum) {
        Arrays.sort(arr);
        //把重复的数字去掉
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), arr, 0, sum);
        return res;
    }

    public static void backtrack(ArrayList<List<Integer>> res, ArrayList<Integer> temp,
            int[] arr, int index, int remain) {
        if (remain == 0 && temp.size() == 3) {
            res.add(new ArrayList(temp));
        }
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            backtrack(res, temp, arr, index + 1, remain - arr[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};//1 1 2 2 3
        ArrayList<List<Integer>> res = sum(arr, 4);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
