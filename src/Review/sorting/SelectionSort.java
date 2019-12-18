package Review.sorting;

/**
 * 选择排序
 *
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 *
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *
 * 重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        //总共经过N-1轮比较
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            //每轮需要比较N-i次
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min])
                    min = j;//找到这一轮中最小的
            }

            //将这个最小值放到已经排序过数列的末尾
            if(min != i) {
                int temp = arr[i];//额外
                arr[i] = arr[min];
                arr[min] = temp;
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
