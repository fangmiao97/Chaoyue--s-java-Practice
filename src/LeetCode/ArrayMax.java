package LeetCode;

import java.util.Scanner;

public class ArrayMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int mtemp = arr[i] * arr[i];
            int l = i - 1, r = i + 1;
            while (l >= 0 && arr[l] >= arr[i]){
                mtemp += arr[i] * arr[l--];
            }
            while(r < n && arr[r] >= arr[i]) {
                mtemp += arr[i] * arr[r++];
            }
            ans = Math.max(ans, mtemp);
        }

        System.out.println(ans);
    }
}
