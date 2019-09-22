package LeetCode.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 7 5
 * 5 8 10 3 6 10 8
 *
 * 5轮，每轮找到最小非零整数，打印，然后每个都减它
 */
public class MinNoZeros {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();//轮数
        int[] nums = new int[n];
        for (int i = 0;i < n; i++) {
            nums[i] = in.nextInt();
        }

        int index = 0;
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            if (index == 0) {
                System.out.println(nums[index++]);
                continue;
            }
            if (nums[index] - nums[index - 1] != 0) {
                System.out.println(nums[index] - nums[index - 1]);
                index++;
                continue;
            }
            i--;
            index++;
        }
    }
}
