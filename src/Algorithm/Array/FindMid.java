package Algorithm.Array;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/2 10:45
 * @Description：找中位数
 * 所谓中位数就是一组数据从小到大排列后中间的那个数字。
 * 如果数组长度为偶数，那么中位数的值就是中间两个数字相加除以2，如果数组长度为奇数，
 * 那么中位数的值就是中间那个数字。
 *
 * 根据快速排序的方法，可以采用一种类似快速排序的方法，
 * 找出这个中位数来。具体而言，首先把问题转化为求一列数中第i小的数的问题，
 * 求中位数就是求一列数的第（length/2+1）小的数的问题（其中length表示的是数组序列的长度）。
 */
public class FindMid {

    /**
     * @Description: 类快速排序，按arr[low]为基准进行划分，最后返回arr[low]的位置index
     * @Param:  [arr, low, high]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2020/1/2 10:48
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    private static int partition(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] > key) {
                high--;
            }//退出时high在的位置数据小于key
            arr[low] = arr[high];
            while (low < high && arr[low] < key) {
                low++;
            }
            arr[high] = arr[low];//将比key大的值换到high位置，使得过程能够继续

        }//退出时说明 low >= high
        arr[low] = key;
        return low;
    }

    public static int getMid(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = low + (high - low) / 2;//中位数是中间大小的数字

        //如果快速排序找到的index是mid就说明找到了
        int pIndex = 0;
        while (true) {
            pIndex = partition(arr, low, high);
            if (pIndex == mid) {
                return arr[pIndex];
            } else if (pIndex < mid) {
                low = pIndex + 1;
            } else {
                high = pIndex - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 1, 11, 9};
        System.out.println(getMid(arr));
    }
}
