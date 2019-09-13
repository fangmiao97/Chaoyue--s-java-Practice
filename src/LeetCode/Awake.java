package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Awake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//闹钟数
        List<Integer> clocks = new ArrayList<>();
        int[] cmin = new int[n];//转成分钟
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int m = sc.nextInt();
            int mins = h * 60 + m;
            cmin[i] = mins;
            clocks.add(h);
            clocks.add(m);
        }

        int ptime = sc.nextInt();
        int ltime_h = sc.nextInt();
        int ltime_m = sc.nextInt();

        int last_atime = ltime_h * 60 + ltime_m - ptime;

        //2binery
//        int index = binarySearch(cmin, last_atime);

        int index = 0;
        for (int i = 0; i < n; i++) {
            if(cmin[i] == last_atime) {
                index = i;
                break;
            }
            if(i != n - 1 && cmin[i] < last_atime && cmin[i + 1] > last_atime) {
                index = i;
                break;
            }
        }
        System.out.println(clocks.get(index * 2) + " " + clocks.get(index * 2 + 1));
    }

    private static int binarySearch(int[] cmin, int last_atime) {
        int left = 0;
        int right = cmin.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(cmin[mid] == last_atime)
                return mid;
            else {
                if (cmin[mid] < last_atime)
                    left = mid;
                else
                    right = mid;
            }
        }
        if(cmin[right] < last_atime)
            return left + 1;
        else if (cmin[left] >= last_atime)
            return left;
        else return right;
    }
}
