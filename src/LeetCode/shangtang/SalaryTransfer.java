package LeetCode.shangtang;

import java.util.Scanner;

/**
 * input: 19 13 实际数字(10进制）n 与转换后的最低值 x (10>=x<=n)
 * output: 16进制 最大的可转换的进制
 * ac: 5%
 */
public class SalaryTransfer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();

        for (int i = n - 1; i >= 10; i--) {
            if (transfer(n, i) >= x) {
                System.out.println(i);
                break;
            }
        }
    }

    public static int transfer(int n, int i) {
        int res = 0;
        while (n > i) {
            res = res * 10 + n / i;
            n = n - i;
        }
        res = res * 10 + n;
        return res;
    }
}
