package Algorithm.Array;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/30 14:22
 * @Description：在旋转有序数组中找到最小值想
 * 二分查找变体
 * {6，7，8，9，1，2，3，4，5} ：1
 * {1,2,3,4,5,6} ： 1
 * {1,1,1,1,1,1}：1
 * {1,0,1,1,1,1}：0
 */
public class FindMinInRotationArray {
    /**
     * @Description: 从index开始将有序数组arr旋转
     * @Param:  [arr, index]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 2019/12/30 14:34
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static void rotateArray(int[] arr, int index) {

        swap(arr, 0, index);
        swap(arr, index, arr.length);
        swap(arr,0,arr.length);

    }

    public static void swap(int[] arr, int start, int end) {
        end--;
        for (; start < end; start++, end--) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    /**
     * @Description: 从旋转数组中得最小值
     * @Param: [arr]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2019/12/30 14:48
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static int getMin(int[] arr, int low, int high) {
        if (high < low) {//无旋转，返回头
            return arr[0];
        }

        if (high == low) {
            return arr[low];
        }

        int mid = low + ((high - low) >> 1);
        if (arr[mid] < arr[mid - 1]) {
            return arr[mid];//最小值
        }
        else if (arr[mid] > arr[mid + 1]) {
            return arr[mid + 1];
        } else if (arr[high] > arr[mid]) {
            return getMin(arr, low, mid - 1);
        } else if (arr[mid] > arr[high]) {
            return getMin(arr, mid + 1, high);
        }
        //arr[low]==arr[mid]==arr[high]
        else {
            return Math.min(getMin(arr, low, mid - 1),
                    getMin(arr, mid + 1, high));
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotateArray(arr, 5);
        System.out.println(getMin(arr, 0, arr.length - 1));
    }
}
