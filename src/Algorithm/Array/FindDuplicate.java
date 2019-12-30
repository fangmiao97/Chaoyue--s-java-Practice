package Algorithm.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/30 12:44
 * @Description：找到数组中的重复元素
 * 数字1～1000放在含有1001个元素的数组中，
 * 其中只有唯一的一个元素值重复，
 * 其他数字均只出现一次。设计一个算法，将重复元素找出来，要求每个数组元素只能访问一次。
 */
public class FindDuplicate {

    /**
     * @Description: 数学方法找到重复数字
     * @Param:  [arr]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2019/12/30 12:47
     * @Time Complexity: O(N)
     * @Space ComplexityL O(1)
     */
    public static int findDupMath(int[] arr) {
        int len = arr.length;

        //累加求1-1000的和
        int sum = (1 + len - 1) * (len - 1) / 2;

        int arrSum = 0;
        //累加数组中的所有数字
        for (int i = 0; i < len; i++) {
            arrSum += arr[i];
        }

        return arrSum - sum;//差就是
    }

    /**
     * @Description: 使用异或
     * @Param:  [arr]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2019/12/30 12:54
     * @Time Complexity: O(N)
     * @Space ComplexityL O(1)
     * 根据异或运算的性质可知，当相同元素异或时，
     * 其运算结果为0；当相异元素异或时，其运算结果为非0；
     * 任何数与数字0进行异或运算，其运算结果为该数。
     */
    public static int findDupXOR(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            res ^= i;
        }
        return res;
        //以数组{1, 3, 4, 2, 5, 3}为例。
        // （1^3^4^2^5^3）^（1^2^3^4^5）
        // =（1^1）^（2^2）^（3^3^3）^（4^4）^（5^5）
        // =0^0^3^0^0=3。
    }

    /**
     * @Description: 将数组内的数据当成索引，重复数字的位置会被访问两次，第一次访问时，将数据标成负的
     * @Param:  [arr]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2019/12/30 12:59
     * @Time Complexity: O(N)
     * @Space ComplexityL O(0)
     */
    public static int findDupIndex(int[] arr) {

        int res = 0;

        int index = 0;
        while (true) {
            if (arr[index] > 0) {
                arr[index] *= -1;//数据标成负的
                index = -arr[index];
                continue;
            } else {//如果访问到的位置是负的，则说明这个索引值是重复的
                break;
            }
        }
        return index;
    }

    /**
     * @Description: 将数组看成单链表，数据当成next指针，重复的数字说明有环
     * @Param:  [arr]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2019/12/30 13:09
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static int findDupLoop(int[] arr) {
        int slow = 0, fast = 0;

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        fast = 0;
        while (fast != slow) {
            fast = arr[fast];
            slow = arr[slow];
        }
        return fast;
    }

    /**
     * @Description: 在N+M中，有1-N的数字，找出重复的
     * @Param:  [arr]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: FANG MIAO
     * @Date: 2019/12/30 13:28
     * @Time Complexity: O(N)
     * @Space ComplexityL O()
     * 因为总共有N+M个数字，N+1到N+M的数字不能通过“索引”找到，所以要有一定的机制能够访问到后面的数据
     */
    public static Set<Integer> findDups(int[] arr, int n) {//1-n个数字
        Set<Integer> res = new HashSet<>();
        int len = arr.length;
        int dup = len - n;
        int index = 0;
        while (true) {
            if (arr[index] < 0) {
                res.add(index);
                dup--;
                arr[index] = len - dup;
            }
            if (dup == 0) {
                return res;
            }
            arr[index] *= -1;
            index = -arr[index];
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        System.out.println(findDupMath(arr));
        System.out.println(findDupXOR(arr));
        System.out.println(findDupIndex(arr));
        int arr2[] = {1, 2, 3, 4, 5, 6, 7, 8, 2};
        System.out.println(findDupLoop(arr2));

        int arr3[] = {1, 2, 3, 5, 5, 2, 7, 4, 5, 6, 7, 8,8, 2};
        Set<Integer> set = findDups(arr3, 8);
        for (Integer i : set) {
            System.out.print(i + " ");
        }
    }

}
