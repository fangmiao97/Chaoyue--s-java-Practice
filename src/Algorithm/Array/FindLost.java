package Algorithm.Array;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/30 15:46
 * @Description：在N-1个数据中找到缺少的
 * 给定一个由n-1个整数组成的未排序的数组序列，
 * 其元素都是1到n中的不同的整数。
 * 请写出一个寻找数组序列中缺失整数的线性时间算法。
 */
public class FindLost {

    /**
     * @Description: 异或法
     * @Param:  [arr]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2019/12/30 15:47
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static int findLost(int[] arr) {
        int res = 0;
        for (int i = 1; i <= arr.length + 1; i++) {
            res ^= i;
        }

        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }
    //b=1^2^3^…（m-1）^（m+1）^…^n。
    // 由此可知，
    // a^b=（1^1）^（2^2）^…（m-1）^（m-1）^m^（m+1）^（m+1）^…^（n^n）=m。


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9};
        System.out.println(findLost(arr));
    }
}
