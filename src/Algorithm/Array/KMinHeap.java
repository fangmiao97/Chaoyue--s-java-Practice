package Algorithm.Array;

import java.util.Arrays;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/30 16:48
 * @Description：寻找前k个最小元素
 */
public class KMinHeap {

    /**
     * @Description: 构造K最小堆
     * @Param:  [arr, k]
     * @Return: int[]
     * @Author: FANG MIAO
     * @Date: 2019/12/30 16:59
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static int[] kMinHeap(int[] arr, int k) {
        int[] res = Arrays.copyOfRange(arr, 0, k);//k个元素（0~k-1)
        //从最后一个非叶子节点开始调整
        for (int i = (int) Math.floor(arr.length / 2); i >= 0; i--) {
            heapify(res, i, res.length);
        }
        //构造好由前k个元素组成的最小堆
        //如果后面的元素比堆顶大，则与堆顶交换
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > res[0]) {
                res[0] = arr[i];
                heapify(res, 0, res.length);
            }
        }
        return res;
    }

    /**
     * @Description: 最小堆化，以i为顶点
     * @Param:  [arr, i, len]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 2019/12/30 17:03
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int samllest = i;

        //把当前节点和左右子树的最小值找到
        if (left < len && arr[left] < arr[samllest]) {
            samllest = left;
        }
        if (right < len && arr[right] < arr[samllest]) {
            samllest = right;
        }

        if (samllest != i) {//确实要交换，把最小的元素换上来
            swap(arr, i, samllest);
            heapify(arr, samllest, len);//交换之后，下面的结构也要最小堆化
        }
    }

    //数组数据交换
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 5, 6, 7, 7, 22, 34, 45, 4, 32, 46, 56, 345, 34, 534,};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println("");
        int[] res = kMinHeap(arr, 7);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
