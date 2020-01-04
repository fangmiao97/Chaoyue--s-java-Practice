package Algorithm.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/2 16:49
 * @Description：最大覆盖子数组
 *
 * 坐标轴上从左到右依次的点为a[0]、a[1]、a[2]、…、a[n-1]，
 * 设一根木棒的长度为L，求L最多能覆盖坐标轴的几个点？
 * 覆盖的意思是末尾的坐标减去开始的坐能够cover木棒的长度
 * 注意区分不是坐标的累加！不是炒股题
 */
public class MaxCover {

    /**
     * @Description: 返回最长cover的头结点和节点数
     * @Param: [arr, length]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2020/1/2 17:58
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static Map<Integer, Integer> findMaxCover(int[] arr, int length) {
        int start = 0;
        int end = 1;
        int coverPoints = 2;//最长cover的点数
        int coverLen = arr[end] - arr[start];
        int resIndex = start;//结果头结点

        while (end < arr.length) {
            while (arr[end] - arr[start] < length) {
                end++;
            }
            if (arr[end] - arr[start] == length) {//是否大于当前最大的
                if (end - start + 1 > coverPoints) {
                    coverPoints = end - start + 1;
                    resIndex = start;
                }
            } else {//大于length
                end--;
            }
            start++;
            end++;
        }

        Map<Integer, Integer> res = new HashMap<>();
        res.put(resIndex, coverPoints);
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 8, 10, 11, 12, 13, 15, 16, 17, 19, 25};
        Map<Integer, Integer> res = findMaxCover(arr, 8);
        for (Map.Entry entry : res.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
