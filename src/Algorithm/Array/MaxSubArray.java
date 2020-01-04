package Algorithm.Array;

import java.awt.*;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/2 9:39
 * @Description：最大子数组（连续）
 */
public class MaxSubArray {

    /**
     * @Description: 动态规划找和最大子数组，注意数组是连续的
     * @Param:  [arr]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2020/1/2 9:43
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static int maxSubArray(int[] arr) {
        int maxSoFar = arr[0];
        int maxSubArr = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar + arr[i], arr[i]);//要么是当前子数组加当前数据，要么重新开始
            maxSubArr = Math.max(maxSubArr, maxSoFar);
        }

        return maxSubArr;
    }


    public static void main(String[] args) {
        int[] arr = {1, -2, 4, 8, -4, 7, -1, -5};
        System.out.println(maxSubArray(arr));
    }
}
