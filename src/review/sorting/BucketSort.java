package review.sorting;

import java.util.Arrays;

/**
 * 桶排序
 * 将待排序列分到不同的桶中
 * 分桶的策略是，在一定范围内的数放在一起
 * 然后将一个桶内的数据进行排序
 * 最后将所有桶内的数据汇总
 */

public class BucketSort {
    private static final InsertionSort insertSort = new InsertionSort();

    public static void sort(int[] arr) {
        bucketSort(arr, 3);
    }

    private static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0)
            return;

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int v: arr) {
            if(v < minValue)
                minValue = v;
            else if(v > maxValue)
                maxValue = v;
        }

        int bucketCount = (int) (Math.floor((maxValue - minValue) / bucketSize) + 1);
        int[][] bucket = new int[bucketCount][0];

        //映射到每个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            bucket[index] = arrAppend(bucket[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] b: bucket) {
            if(bucket.length == 0)
                continue;

            //桶内使用插入排序
            insertSort.sort(b);
            for (int v: b) {
                arr[arrIndex++] = v;
            }
        }
    }

    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,34,54,678,23,2,6,78,234,34,26,83,25,57,33,32,32};
        sort(arr);
        for (int i:arr){
            System.out.print(i + " ");
        }
    }
}
