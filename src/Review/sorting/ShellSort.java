package Review.sorting;

/**
 * 希尔排序
 * 将待排序列先处理成基本有序的（小的在前面，大的在后面）
 * 比如：2,1,3，6,4,7,5,8,9,这样的
 * 然后再进行一次插入排序，这时直接插入排序的效率就很高了
 * 那么怎么先处理呢？需要将待排序列进行 跳跃分割 ，也就是 并不是连续在一块的分一组，
 * 而是将整个序列每个一定长度的分在一组，进行预处理
 */
public class ShellSort {

    public static void sort(int[] arr) {

        int gap = 1;
        while (gap < arr.length / 3) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for(int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
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
