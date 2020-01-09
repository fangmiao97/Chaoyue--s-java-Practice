package LeetCode.huawei;

import java.util.Arrays;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/8 16:28
 * @Description：
 */
public class er {
    //小明 n个气球 【1~200】，【4,9】最少 输入n 输出最少 没有-1

    public static int findMinSolu(int n) {

        if (n < 4) {
            return -1;
        }

        //min array
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[4] = 1;
        if (n >= 8) {
            dp[8] = 2;
            dp[9] = 1;
        }

        for (int i = 10; i <= n; i++) {
            if (i - 4 > 0 && dp[i - 4] != -1) {
                dp[i] = dp[i - 4] + 1;
            }
            else if (i - 9 > 0 && dp[i - 9] != -1) {
                dp[i] = dp[i - 9] + 1;
            } 
        }

        return dp[n];
    }


    public static void main(String[] args) {
        int n = 16;
        System.out.println(findMinSolu(n));
    }
}
