package review.sorting;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 *
 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 *
 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 *
 * 重复步骤 3 直到某一指针达到序列尾；
 *
 * 将另一序列剩下的所有元素直接复制到合并序列尾。
 */
public class MergeSort {

    public static int[] sort(int[] arr) {
        if(arr.length < 2) {
            return arr;
        }

        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    protected static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];

        int index = 0, leftIndex = 0, rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if(left[leftIndex] <= right[rightIndex]) {
                res[index++] = left[leftIndex++];
            }else {
                res[index++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            res[index++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            res[index++] = right[rightIndex++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,34,54,678,23,2,6,78,234,34,26,83,25,57,33,32,32};
        arr = sort(arr);
        for (int i:arr){
            System.out.print(i + " ");
        }
    }
}
