package Review.sorting;

/*
 计数排序
 */
public class CountingSort {
    public static void sort(int[] arr) {
        int max = getMaxValue(arr);
        countingSort(arr, max);
    }

    private static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int value: arr) {
            if(value > max)
                max = value;
        }
        return max;
    }

    private static void countingSort(int[] arr, int max) {
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];

        for (int value: arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0 ; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,34,54,678,23,2,6,78,234,34,26,83,25,57,33,32,32};
        sort(arr);
        for (int i:arr){
            System.out.print(i + " ");
        }
    }
}
