package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] work_years = new int[n];
        for (int i = 0; i < n; i++) {
            work_years[i] = sc.nextInt();
        }

        int[] bonus = new int[n];
        Arrays.fill(bonus, 100);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (work_years[i] > work_years[1]) {
                    bonus[i] += 100;
                }
                continue;
            }

            if (i == n - 1) {
                if (work_years[i] > work_years[i - 1]) {
                    bonus[i] = bonus[i - 1] + 100;
                }
                continue;
            }

            int l = i - 1;
            int r = i + 1;
            if (work_years[i] <= work_years[l] && work_years[i] <= work_years[r])
                continue;
            int bigger_one = work_years[l] > work_years[r] ? l : r;//左右更大的那个
            int small_one = work_years[l] < work_years[r] ? l : r;//左右更小的那个

            if(work_years[i] > work_years[bigger_one])
                bonus[i] = bonus[bigger_one] + 100;
            if (work_years[i] < work_years[bigger_one]) {
                bonus[i] = bonus[small_one] + 100;
                bonus[bigger_one] += 100;
            }
        }

        int ans = 0;
        for (int b : bonus) {
            ans += b;
        }
        System.out.println(ans);
    }
}
