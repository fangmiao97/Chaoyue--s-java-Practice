package review.sorting;

/**
 * 插入排序
 *
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 *
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 * （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertionSort {
    public static void sort(int[] arr) {
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];//记录要插入的数字

            //从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            //存在比temp小的数
            if(j != i) {
                arr[j] = temp;
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
