package review.sorting;

/**
 * 快速排序
 *
 * 从数列中挑出一个元素，称为 “基准”（pivot）;
 *
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 *
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 */
public class QuickSort {
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        //设定基准值
        int piovt = left;
        int index = piovt + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[piovt]) {
                swap(arr, i, index);
                index++;
            }
        }
        //每一轮会将piovt放到它最终的位置
        swap(arr, piovt, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,34,54,678,23,2,6,78,234,34,26,83,25,57,33,32,32};
        sort(arr);
        for (int i:arr){
            System.out.print(i + " ");
        }
    }
}
