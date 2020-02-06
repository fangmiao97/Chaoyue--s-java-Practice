package LeetCode.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/2/5 15:26
 * @Description：寻找前k个递增序列
 * 输入：[2,1,4,5,8,3,7,10,2,5] k=2
 * 输出：[1,4,5,8],[3,7,10]
 */
public class TopKLenArray {

    public static List<List<Integer>> topKArray(int[] arr, int k) {
        if (k == 0)
            return new ArrayList<>();

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                dp[i] = dp[i - 1] + 1;
        }

        List<List<Integer>> res = new ArrayList<>();

        //找最大的前k个子数组
        for (int i = 0; i < k; i++) {
            //找当前最大值
            int maxIndex = 0;
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] > dp[maxIndex]) {
                    maxIndex = j;
                }
            }

            int len = dp[maxIndex];//最长数组的长度
            List<Integer> curArr = new ArrayList<>();
            for (int j = maxIndex - len + 1; j <= maxIndex ; j++) {
                curArr.add(arr[j]);
                dp[j] = 1;//将这里重置，要不然后面的循环会有问题
            }
            res.add(new ArrayList<>(curArr));

        }
        return res;
        
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,5,8,3,7,10,2,5};
        List<List<Integer>> res = topKArray(arr, 2);
        for (List<Integer> l:
             res) {
            for (int num:
                 l) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
