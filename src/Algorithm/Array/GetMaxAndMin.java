package Algorithm.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/30 13:53
 * @Description：找到数组中的最大值和最小值
 */
public class GetMaxAndMin {

    /**
     * @Description: getMaxAndMin
     * @Param:  [arr]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: FANG MIAO
     * @Date: 2019/12/30 13:58
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static List<Integer> getMaxAndMin(int[] arr) {
        //分治法
        //两两分组，大的放左边，小的放右边
        //再分别在每组左边找最大的，右边找最小的
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i += 2) {
            if (i + 1 < arr.length) {
                if (arr[i] < arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        res.add(max);
        res.add(min);
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 5, 2, 7, 4, 5, 6, 7, 8, 8, 2};
        List<Integer> list = getMaxAndMin(arr);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
