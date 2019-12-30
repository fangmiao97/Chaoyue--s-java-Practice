package Review.sorting;

/**
 * 堆排序
 * 该数组从逻辑上讲就是一个堆结构，我们用简单的公式来描述一下堆的定义就是：
 *
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 *
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 *
 * 思路：
 *
 * a.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * c.重新调整结构，使其满足堆定义，
 * 然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 */
public class HeapSort {

    public static void sort(int[] arr) {
        int len = arr.length;
        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);//调整余下的，使成为有效的堆结构
        }
    }

    private static void buildMaxHeap(int[] arr, int len) {
        //从最后一个非叶子节点开始调整
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    //以i为顶点的树。进行（大）堆化
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if(left < len && arr[left] > arr[largest])
            largest = left;

        if(right < len && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);//如果上面调整了，
            // 换下来的小元素，会导致下面的不是堆结构，所以下面还要继续调整
        }
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
