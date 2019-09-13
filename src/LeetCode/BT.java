package LeetCode;

import java.util.Scanner;

public class BT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//>=3
        int d = sc.nextInt();
        int[] building = new int[n];
        for(int i = 0; i < n; i++) {
            building[i] = sc.nextInt();
        }

        long res = 0;
        for(int i = 0, j = 0; i < n; i++) {
            while(i >= 2 && (building[i] - building[j]) > d)
                j++;
            res += c(i - j);
        }
        res = res % 99997867;
        System.out.println(res);

    }

    public static long c(long n) {
        long res = n * (n - 1) / 2;
        return res;
    }
}
