package LeetCode.shangtang;

import java.util.Scanner;

/**
 * 循环数组中最大子数组之和
 * https://blog.csdn.net/acdreamers/article/details/38760805
 * 过了83.3%
 */
public class MaxInCircle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] posNums = new int[n];
        int[] negNums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            sum += num;
            posNums[i] = num;
            negNums[i] = -num;
        }
        //System.out.println(sum);

        long maxSoFar1 = posNums[0], maxEndingHere1 = posNums[0];
        for (int i = 1; i < posNums.length; i++) {
            maxEndingHere1 = Math.max(maxEndingHere1 + posNums[i], posNums[i]);
            maxSoFar1 = Math.max(maxSoFar1, maxEndingHere1);
        }
//        System.out.println(maxSoFar1);

        long maxSoFar2 = negNums[0], maxEndingHere2 = negNums[0];
        for (int i = 1; i < negNums.length; i++) {
            maxEndingHere2 = Math.max(maxEndingHere2 + negNums[i], negNums[i]);
            maxSoFar2 = Math.max(maxSoFar2, maxEndingHere2);
        }
//        System.out.println(maxSoFar2);

        System.out.println(Math.max(maxSoFar1, sum + maxSoFar2));


    }
}
