package Algorithm.Hash;

import java.util.HashMap;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/22 19:48
 * @Description：给定一个数组，找出数组中是否有两个数对（a, b）和（c, d），
 * 使得a+b=c+d，其中a、b、c和d是不同的元素。
 * 如果有多个答案，打印任意一个即可。
 * 例如，给定数组：{3, 4, 7, 10, 20, 9, 8}，可以找到两个数对（3, 8）和（4, 7），使得3+8=4+7
 */
public class FindPairs {
    public static void main(String[] args) {
        int arr[] = {3,4,6,7,8,1,2,5,9,10,11,13};
        findPairs(arr);
    }

    static class pair {
        int first, second;
        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    /**
     * @Description: findPairs
     * @Param:  [arr]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 19:50
     * @Time Complexity: O(N^2)
     * @Space ComplexityL O()
     */
    public static void findPairs(int arr[]) {
        HashMap<Integer, pair> sumPair = new HashMap<>();
        int n = arr.length;

        //将两两键值和存储，如果遇到键值和相同的，就说明找到了
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (!sumPair.containsKey(sum)) {
                    sumPair.put(sum, new pair(arr[i], arr[j]));
                }
                else {
                    pair p = sumPair.get(sum);
                    System.out.println(arr[i]+"+"+arr[j]+"="+p.first + "+" + p.second);
                }
            }
        }
    }
}
